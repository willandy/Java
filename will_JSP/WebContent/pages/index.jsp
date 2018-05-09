﻿<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="../css/common.css"/>
</head>

<body>
<!--页面顶部-->
<div id="header">
    <div class="main-top">
        <div class="logo"><a href=""><span>新闻大视野</span></a></div>
        <div class="login-box">
        <%
        //接收doUserCreate.jsp传来的参数
        out.println(request.getParameter("flag"));
          //采用request，index.jsp是获取到message的值的
          //Object object = request.getAttribute("message");
        //采用session
        //Object object = session.getAttribute("message");
        
        //现在循环遍历cookie
        String temp="";
        Cookie[] cookies= request.getCookies();
        for(int i=0;i<cookies.length;i++){
        	if(cookies[i].getName().equals("user")){
        		/* temp = cookies[i].getValue(); */
        		//因为输入上面输入中文会乱码，所以需要转字节码，那么下面就需要解码
        		temp = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
        	}
        }
        
        Object object = session.getAttribute("user");
        if(null==object){
        	%>
        <label>用户名</label><input type="text" name="uname" value="<%=temp %>"/><label>密码</label><input type="text" name="upassword" /><button>登录</button>	
        <%		
        }else{
        	out.println(object.toString());
        
        %>
        <!-- 这个用来测试session的清除和过期 -->
        &nbsp;<a href="Logout.jsp">注销</a>
        <%
        }
        %>
            
        </div>
        <div class="nav">
            <ul class="clearfix">
                <li><a href="#">首页</a></li>
                <li><a href="#">国内</a></li>
                <li><a href="#">国际</a></li>
                <li><a href="#">娱乐</a></li>
                <li><a href="#">军事</a></li>
            </ul>
        </div>
    </div>
    <!--banner-->
    <div class="main-banner">
    <img src="images/banner.png" />
    </div>
    <!--搜索横框-->
    <div class="search-box">
        <div class="sl">
            <div class="sr clearfix">
            
                <span class="left-search clearfix">
                    <label>站内搜索</label><input type="text" name="keyword" value="关键词" /><button class="go-btn"></button>
                </span>
                <span class="right-link">
                    <label>快速链接</label><select><option>-----专题选择-----</option></select><button class="go-btn"></button>
                </span>
                
            </div>
        </div>    
    </div>
</div>
<!--d页面主体-->
<div id="content" class="main-content clearfix">
	<!--主体的的左边部分-->
    <div class="main-content-left">
        <!--新闻专题分类-->
        <div class="class-box">
            <div class="class-box-header">
               <span class="fr"><a href="#">更多...</a></span>
               <h3>新闻专题</h3>
            </div>
            <div class="class-box-content">
                <ul>
                     <li><a href="#">国内</a></li>
                    <li><a href="#">国际</a></li>
                    <li><a href="#">娱乐</a></li>
                    <li><a href="#">军事</a></li>
                    <li><a href="#">财经</a></li>
                    <li><a href="#">天气</a></li>
                    <li class="clear-bottom-line"><a href="#">科技</a></li>
                </ul>
            </div>
        </div>
        <!--最新新闻-->
        <div class="left-box">
            <div class="left-box-tbg">
                <div class="left-box-bbg">
                    <div class="left-box-header"><h3><a href="#">最新新闻</a></h3></div>
                    <div class="left-box-content">
                        <ul>
                            <li><a href="#">詹姆斯26+9+7热火2-1雷霆 詹姆斯快速实战迷踪步2+1</a></li>
                            <li><a href="#">詹姆斯26+9+7热火2-1雷霆 詹姆斯快速实战迷踪步2+1</a></li>
                            <li><a href="#">詹姆斯26+9+7热火2-1雷霆 詹姆斯快速实战迷踪步2+1</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!--最新评论-->
        <div class="left-box">
            <div class="left-box-tbg">
                <div class="left-box-bbg">
                    <div class="left-box-header"><h3>最新评论</h3></div>
                    <div class="left-box-content">
                        <ul>
                            <li><a href="#">詹姆斯26+9+7热火2-1雷霆 詹姆斯快速实战迷踪步2+1</a></li>
                            <li><a href="#">詹姆斯26+9+7热火2-1雷霆 詹姆斯快速实战迷踪步2+1</a></li>
                            <li><a href="#">詹姆斯26+9+7热火2-1雷霆 詹姆斯快速实战迷踪步2+1</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--页面主体的右部，包括新闻的列表和评论内容 -->
    <div class="main-content-right">
        <!--各专题的新闻列表-->
        <div class="main-text-box">
            <div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    
                    <div class="main-text-box-header">
                        <h3>即时新闻</h3>
                    </div>
                    <div class="main-text-box-content">
                      <ul class="news-list-ul clearfix">
                        <li><span>2009-10-28 10:33:33</span><a href="#">深足教练组：说我们买球是侮辱 朱广沪常</a></li>
                        <li><span>2009-10-28 10:33:33</span><a href="#">省政府500万悬赏建业登顶 球员：遗憾主场</a></li>
                        <li><span>2009-10-28 10:33:33</span><a href="#">洪元朔：北京人的脸就看你们了 最后一哆</a></li>
                        <li><span>2009-10-28 10:33:33</span><a href="#">临界冠军京城夺票总动员 球迷夺冠！让所</a></li>
                        <li class="li-line"><span>2009-10-28 10:33:33</span><a href="#">一纸传真暗含申花处理态度 国足征调社</a></li>

                        <li><span>2009-10-28 10:33:33</span><a href="#">深足教练组：说我们买球是侮辱 朱广沪常</a></li>
                        <li><span>2009-10-28 10:33:33</span><a href="#">省政府500万悬赏建业登顶 球员：遗憾主场</a></li>
                        <li><span>2009-10-28 10:33:33</span><a href="#">洪元朔：北京人的脸就看你们了 最后一哆</a></li>
                        <li><span>2009-10-28 10:33:33</span><a href="#">临界冠军京城夺票总动员 球迷夺冠！让所</a></li>
                        <li class="li-line"><span>2009-10-28 10:33:33</span><a href="#">一纸传真暗含申花处理态度 国足征调社</a></li>

                        <li><span>2009-10-28 10:33:33</span><a href="#">深足教练组：说我们买球是侮辱 朱广沪常</a></li>
                        <li><span>2009-10-28 10:33:33</span><a href="#">省政府500万悬赏建业登顶 球员：遗憾主场</a></li>
                        <li><span>2009-10-28 10:33:33</span><a href="#">洪元朔：北京人的脸就看你们了 最后一哆</a></li>
                        <li><span>2009-10-28 10:33:33</span><a href="#">临界冠军京城夺票总动员 球迷夺冠！让所</a></li>
                        <li class="li-line"><span>2009-10-28 10:33:33</span><a href="#">一纸传真暗含申花处理态度 国足征调社</a></li> 

                        <li><span>2009-10-28 10:33:33</span><a href="#">深足教练组：说我们买球是侮辱 朱广沪常</a></li>
                        <li><span>2009-10-28 10:33:33</span><a href="#">省政府500万悬赏建业登顶 球员：遗憾主场</a></li>
                        <li><span>2009-10-28 10:33:33</span><a href="#">洪元朔：北京人的脸就看你们了 最后一哆</a></li>
                        <li><span>2009-10-28 10:33:33</span><a href="#">临界冠军京城夺票总动员 球迷夺冠！让所</a></li>
                        <li><span>2009-10-28 10:33:33</span><a href="#">一纸传真暗含申花处理态度 国足征调社</a></li>                               
                      </ul>
                    </div>
                    <!--图片新闻-->
                    <div class="news-pic">
                        <dl>
                            <dt><img src="images/new-1.png" /></dt>
                            <dd>詹姆斯防守杜兰特</dd>
                        </dl>
                        <dl>
                            <dt><img src="images/new-2.png" /></dt>
                            <dd>麦当劳篮球大篷车</dd>
                        </dl>
                        <dl>
                            <dt><img src="images/new-3.png" /></dt>
                            <dd>遭遇多人包夹</dd>
                        </dl>
                        <dl>
                            <dt><img src="images/new-4.gif" /></dt>
                            <dd>马蒂最新漫画欣赏</dd>
                        </dl>
                    </div>
                    <div class="page-bar">
                        <ul class="page-num-ul clearfix">
                            <li><a href="#">上一页</a><li>
                            <li><a href="#" class="thisclass">1</a><li>
                            <li><a href="#">2</a><li>
                            <li><a href="#">3</a><li>
                            <li><a href="#">4</a><li>
                            <li><a href="#">5</a><li>
                            <li><a href="#">下一页</a><li>
                        </ul>
                        <span class="page-go-form"><label>跳转至</label><input type="text" name="numkey" class="page-key" />页<button type="submit" class="page-btn">GO</button></span>
                    </div>
                </div>
            </div>
        </div>
        <!--合作媒体-->
        <div class="main-text-box">
            <div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <div class="main-text-box-header">
                        <h3>合作媒体</h3>
                    </div>
                    <div class="main-text-box-content">
                      <ul class="link-text-ul clearfix">
                        <li><a href="#">中国政府网</a></li>
                        <li><a href="#">中国政府网</a></li>
                        <li><a href="#">中国政府网</a></li>
                        <li><a href="#">中国政府网</a></li>
                        <li><a href="#">中国政府网</a></li>
                        <li><a href="#">中国政府网</a></li>
                        <li><a href="#">中国政府网</a></li>
                        <li><a href="#">中国政府网</a></li>
                      </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>           
<!--页面底部-->
<div id="footer" class="main-footer-box">
    24小时客户服务热线：010-68988888 常见问题解答 新闻热线：010-627488888<br />
    文明办网文明上网举报电话：010-627488888 举报邮箱：jubao@bj-aptech.com.cn<br />
    Coyright&copy;1999-2007 News China gov,All Right Reserved.<br />
    新闻中心版权所有
    <!-- 使用application进行访问人数的计数 -->
    <%
      Object count = application.getAttribute("count");
      if(count == null){
    	  application.setAttribute("count", new Integer(1));
      }else{
    	  Integer c = (Integer)count;
    	  application.setAttribute("count", c.intValue()+1);
      }
      Integer cc = (Integer)application.getAttribute("count");
      out.println("本页面共被访问："+cc.intValue());
    %>
</div>
</body></html>