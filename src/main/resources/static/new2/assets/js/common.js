/**
 * Created by Administrator on 2017/5/19.
 */
$(function () {

    var left=
        "<div class=\"am-offcanvas-bar admin-offcanvas-bar\">"
        +"<div class=\"am-offcanvas-bar admin-offcanvas-bar\">"
        +"<div class=\"user-box am-hide-sm-only\">"
        +"<div class=\"user-img\">"
        +"<img src=\"../assets/img/avatar-1.jpg\" alt=\"user-img\" title=\"Administrator\" class=\"img-circle img-thumbnail img-responsive\">"
        +"<div class=\"user-status offline\"><i class=\"am-icon-dot-circle-o\" aria-hidden=\"true\"></i></div>"
        +"</div>"
        +"<h5><a href=\"#\">Administrator</a> </h5>"
        +"<ul class=\"list-inline\">"
        +"<li>"
        +"<a href=\"#\">"
        +"<i class=\"fa fa-cog\" aria-hidden=\"true\"></i>"
        +"</a>"
        +"</li>"
        +"<li>"
        +"<a href=\"#\" class=\"text-custom\">"
        +"<i class=\"fa fa-cog\" aria-hidden=\"true\"></i>"
        +"</a>"
        +"</li>"
        +"</ul>"
        +"</div>"
        +"<ul class=\"am-list admin-sidebar-list\">"
        +"<li><a href=\"index.html\"><span class=\"am-icon-home\"></span> 首页</a></li>"
        +"<li class=\"admin-parent\">"
        +"<a class=\"am-cf\" data-am-collapse=\"{target: '#collapse-nav1'}\"><span class=\"am-icon-table\"></span> 信息查询 <span class=\"am-icon-angle-right am-fr am-margin-right\"></span></a>"
        +"<ul class=\"am-list am-collapse admin-sidebar-sub am-in\" id=\"collapse-nav1\">"
        +"<li style='display: none'><a href=\"table_basic.html\" class=\"am-cf\"> 基本表格</span></a></li>"
        +"<li style='display: none'><a href=\"table_complete.html\">完整表格</a></li>"
        +"<li><a href=\"oneLevelTable.html\">一级商品查询</a></li>"
        +"<li><a href=\"orderTable.html\">订单查询</a></li>"
    
        +"</ul>"
        +"</li>"
        +"<li style='display: none' class=\"admin-parent\">"
        +"<a class=\"am-cf\" data-am-collapse=\"{target: '#collapse-nav2'}\"><i class=\"am-icon-line-chart\" aria-hidden=\"true\"></i> 统计图表 <span class=\"am-icon-angle-right am-fr am-margin-right\"></span></a>"
        +"<ul class=\"am-list am-collapse admin-sidebar-sub am-in\" id=\"collapse-nav2\">"
        +"<li><a href=\"chart_line.html\" class=\"am-cf\"> 折线图</span></a></li>"
        +"<li><a href=\"chart_columnar.html\" class=\"am-cf\"> 柱状图</span></a></li>"
        +"<li><a href=\"chart_pie.html\" class=\"am-cf\"> 饼状图</span></a></li>"
        +"</ul>"
        +"</li>"
        +"<li class=\"admin-parent\">"
        +"<a class=\"am-cf\" data-am-collapse=\"{target: '#collapse-nav5'}\"><span class=\"am-icon-file\"></span> 商品管理 <span class=\"am-icon-angle-right am-fr am-margin-right\"></span></a>"
        +"<ul class=\"am-list am-collapse admin-sidebar-sub am-in\" id=\"collapse-nav5\">"
        +"<li style='display: none'><a href=\"form_basic.html\" class=\"am-cf\"> 基本表单</a></li>"
        +"<li><a href=\"form_validate.html\">购买信息录入</a></li>"
        +"<li><a href=\"oneLevelAdd.html\">新增一级商品</a></li>"
        +"<li><a href=\"oneLevelUpdate.html\">修改一级商品</a></li>"
        +"</ul>"
        +"</li>"
        +"</ul>"
        +"</div>";


    $("#admin-offcanvas").append(left);


});

Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

UrlParm = function() { // url参数
    var data, index;
    (function init() {
        data = [];
        index = {};
        var u = window.location.search.substr(1);
        if (u != '') {
            var parms = decodeURIComponent(u).split('&');
            for (var i = 0, len = parms.length; i < len; i++) {
                if (parms[i] != '') {
                    var p = parms[i].split("=");
                    if (p.length == 1 || (p.length == 2 && p[1] == '')) {// p | p=
                        data.push(['']);
                        index[p[0]] = data.length - 1;
                    } else if (typeof(p[0]) == 'undefined' || p[0] == '') { // =c | =
                        data[0] = [p[1]];
                    } else if (typeof(index[p[0]]) == 'undefined') { // c=aaa
                        data.push([p[1]]);
                        index[p[0]] = data.length - 1;
                    } else {// c=aaa
                        data[index[p[0]]].push(p[1]);
                    }
                }
            }
        }
    })();
    return {
        // 获得参数,类似request.getParameter()
        parm : function(o) { // o: 参数名或者参数次序
            try {
                return (typeof(o) == 'number' ? data[o][0] : data[index[o]][0]);
            } catch (e) {
            }
        },
        //获得参数组, 类似request.getParameterValues()
        parmValues : function(o) { //  o: 参数名或者参数次序
            try {
                return (typeof(o) == 'number' ? data[o] : data[index[o]]);
            } catch (e) {}
        },
        //是否含有parmName参数
        hasParm : function(parmName) {
            return typeof(parmName) == 'string' ? typeof(index[parmName]) != 'undefined' : false;
        },
        // 获得参数Map ,类似request.getParameterMap()
        parmMap : function() {
            var map = {};
            try {
                for (var p in index) {  map[p] = data[index[p]];  }
            } catch (e) {}
            return map;
        }
    }
}();


//设置cookie  失效时间是1分钟
function setCookie(name,value)
{
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}


//读取cookie
function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");

    if(arr=document.cookie.match(reg))

        return unescape(arr[2]);
    else
        return null;
}

function delCookie(name)
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null)
        document.cookie= name + "="+cval+";expires="+exp.toGMTString();
} 
  