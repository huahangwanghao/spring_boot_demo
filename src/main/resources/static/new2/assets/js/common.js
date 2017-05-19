/**
 * Created by Administrator on 2017/5/19.
 */
$(function () {

    var left=
        "<div class=\"am-offcanvas-bar admin-offcanvas-bar\">"
        +"<div class=\"am-offcanvas-bar admin-offcanvas-bar\">"
        +"<div class=\"user-box am-hide-sm-only\">"
        +"<div class=\"user-img\">"
        +"<img src=\"../assets/img/avatar-1.jpg\" alt=\"user-img\" title=\"Hello World\" class=\"img-circle img-thumbnail img-responsive\">"
        +"<div class=\"user-status offline\"><i class=\"am-icon-dot-circle-o\" aria-hidden=\"true\"></i></div>"
        +"</div>"
        +"<h5><a href=\"#\">Hello World</a> </h5>"
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
        +"<li><a href=\"../index.html\"><span class=\"am-icon-home\"></span> 首页</a></li>"
        +"<li class=\"admin-parent\">"
        +"<a class=\"am-cf\" data-am-collapse=\"{target: '#collapse-nav1'}\"><span class=\"am-icon-table\"></span> 表格 <span class=\"am-icon-angle-right am-fr am-margin-right\"></span></a>"
        +"<ul class=\"am-list am-collapse admin-sidebar-sub am-in\" id=\"collapse-nav1\">"
        +"<li><a href=\"table_basic.html\" class=\"am-cf\"> 基本表格</span></a></li>"
        +"<li><a href=\"table_complete.html\">完整表格</a></li>"
        +"</ul>"
        +"</li>"
        +"<li class=\"admin-parent\">"
        +"<a class=\"am-cf\" data-am-collapse=\"{target: '#collapse-nav2'}\"><i class=\"am-icon-line-chart\" aria-hidden=\"true\"></i> 统计图表 <span class=\"am-icon-angle-right am-fr am-margin-right\"></span></a>"
        +"<ul class=\"am-list am-collapse admin-sidebar-sub am-in\" id=\"collapse-nav2\">"
        +"<li><a href=\"chart_line.html\" class=\"am-cf\"> 折线图</span></a></li>"
        +"<li><a href=\"chart_columnar.html\" class=\"am-cf\"> 柱状图</span></a></li>"
        +"<li><a href=\"chart_pie.html\" class=\"am-cf\"> 饼状图</span></a></li>"
        +"</ul>"
        +"</li>"
        +"<li class=\"admin-parent\">"
        +"<a class=\"am-cf\" data-am-collapse=\"{target: '#collapse-nav5'}\"><span class=\"am-icon-file\"></span> 表单 <span class=\"am-icon-angle-right am-fr am-margin-right\"></span></a>"
        +"<ul class=\"am-list am-collapse admin-sidebar-sub am-in\" id=\"collapse-nav5\">"
        +"<li><a href=\"form_basic.html\" class=\"am-cf\"> 基本表单</a></li>"
        +"<li><a href=\"form_validate.html\">购买信息录入</a></li>"
        +"<li><a href=\"addOneLevel.html\">新增一级商品</a></li>"    
        +"</ul>"
        +"</li>"
        +"</ul>"
        +"</div>";


    $("#admin-offcanvas").append(left);


});