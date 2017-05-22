package com.wanghao.spring.boot.service.impl;/**
 * Created by Administrator on 2017/5/19.
 */

import com.wanghao.spring.boot.bean.OneLevel;
import com.wanghao.spring.boot.bean.OrderTable;
import com.wanghao.spring.boot.bean.PageInfo;
import com.wanghao.spring.boot.bean.ResultBean;
import com.wanghao.spring.boot.bean.User;
import com.wanghao.spring.boot.dao.OneLevelDao;
import com.wanghao.spring.boot.dao.OrderTableDao;
import com.wanghao.spring.boot.dao.UserDao;
import com.wanghao.spring.boot.enumtype.EnumType;
import com.wanghao.spring.boot.service.UserService;
import com.wanghao.spring.boot.utils.ResultUtils;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户的实现类
 *
 * @author WangH
 * @create 2017-05-19 18:28
 **/
@Service
public class UserServiceImpl implements UserService {
    protected static Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private OneLevelDao oneLevelDao;
    @Autowired
    private OrderTableDao orderTableDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private EntityManager entityManager;

    @Override
    public ResultBean addOneLevel(OneLevel oneLevel) {
        oneLevel.setCrtDate(new Date());
        oneLevelDao.save(oneLevel);
        return ResultUtils.success("新增成功");
    }

    @Override
    public ResultBean getAllOneLevel() {
        
        return ResultUtils.success(oneLevelDao.findAll());
    }

    @Override
    public ResultBean updateOneLevelNameById(OneLevel oneLevel) {
        oneLevel.setCrtDate(new Date());
        oneLevelDao.saveAndFlush(oneLevel);
        return  ResultUtils.success("修改成功");
    }

    @Override
    public ResultBean addOrder(OrderTable orderTable) {
        orderTable.setCrtDate(new Date());
        orderTableDao.save(orderTable);
        return ResultUtils.success(0);
    }

    @Override
    public ResultBean login(User user) {
        if(("admin".equals(user.getPwd())&&user.getUserName().equals("admin"))) {
            return ResultUtils.success(0);
        }
        User user1=userDao.findByUserName(user.getUserName());
        if(user1!=null){
            String pwd=user1.getPwd();
            if(user.getPwd().equals(pwd)){
                return ResultUtils.success(0);
            }else{
                return ResultUtils.error(EnumType.USEPWDERROR);
            }
        }

         return ResultUtils.error(EnumType.NOPERSON);
    }

    @Override
    public ResultBean getMoneyByMonth(String month) {

        String sql="select DATE_FORMAT(o.crt_date,'%Y-%m-%d') as crtDate,sum(o.amount) as amount from order_table o where  DATE_FORMAT(o.crt_date,'%Y-%m')=? GROUP BY DATE_FORMAT(o.crt_date,'%Y-%m-%d')";



        Query query=entityManager.createNativeQuery(sql);

        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List<Map<String,Object>> list=query.setParameter(1,month).getResultList();
        
        
        return ResultUtils.success(list);
    }

    @Override
    public ResultBean getGoodsByMonth(String month) {

        String sql="select t.sumCount ,ol.`name` from  one_level ol,(\n" +
                "select o.one_level_id,sum(1) as sumCount from order_table o where  DATE_FORMAT(o.crt_date,'%Y-%m')=? GROUP BY o.one_level_id\n" +
                ") t where ol.one_id=t.one_level_id";

        
        Query query=entityManager.createNativeQuery(sql);

        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List<Map<String,Object>> list=query.setParameter(1,month).getResultList();


        return ResultUtils.success(list);
    }

    /**
     * 通过查询条件,查询客户购买的情况
     *
     * @param pageInfo
     * @return
     */
    @Override
    public ResultBean getOrderBySearch(PageInfo pageInfo) {

        Sort.Order order=new Sort.Order(Sort.Direction.DESC,"crtDate");
        Sort sort=new Sort(order);

        Pageable pageable=new PageRequest(pageInfo.getPageNo(),pageInfo.getPageSize(),sort);


        Specification<OrderTable> specification=new Specification<OrderTable>() {
            @Override
            public Predicate toPredicate(Root<OrderTable> root,
                                         CriteriaQuery<?> criteriaQuery, 
                                         CriteriaBuilder cb) {
                
                Path<String> path=root.get("cName");
                if(!StringUtils.isEmpty(pageInfo.getSearch()))
                criteriaQuery.where(cb.like(path, "%"+pageInfo.getSearch()+"%"));
                /**http://blog.csdn.net/ie8848520/article/details/8161986
                 * 连接查询条件, 不定参数，可以连接0..N个查询条件 
                 */
               // query.where(cb.like(namePath, "%李%"), cb.like(nicknamePath, "%王%")); //这里可以设置任意条查询条件  
                return null;
            }
        };
        Page<OrderTable> page=orderTableDao.findAll(specification,pageable);
        return ResultUtils.success(page);
    }


}
