<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基于Arduino的办公室节能控制系统</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.ennui.contentslider.css" rel="stylesheet" type="text/css" media="screen,projection" />
</head>
<body>
<div id="templatemo_header_wrapper">
	<div id="templatemo_header">
    
    	<div id="site_title">
            <h1><a href="#" target="_parent" >
                基于Arduino的办公室节能控制系统
            </a></h1>
        </div>
        <div id="login_register" >
			<h4><a href="login.jsp">>>用户登录</a></h4>
		</div>
<!--         <div id="search_box">
            <form action="#" method="get">
                <input type="text" value="" name="q" size="10" id="searchfield" title="searchfield" onfocus="clearText(this)" onblur="clearText(this)" />
                <input type="submit" name="Search" value="Search" alt="Search" id="searchbutton" title="Search" />
            </form>
        </div> -->
        
        <div class="cleaner"></div>
	</div><!-- end of header -->
    
		<div id="templatemo_menu">
           <ul>
                <li><a href="index.jsp">主页</a></li>
                <li><a href="products.jsp">产品</a></li>
                <!--<li><a href="blog.html">论坛</a></li>-->
                <!--<li><a href="gallery.html">Gallery</a></li>-->
                <li><a href="contact.jsp" class="current">联系方式</a></li>
            </ul>    	
    	</div><!-- end of templatemo_menu -->
        
        <div id="templatemo_banner">
        
   			<h3></h3>
			<p>目前的空调设备尤其是非中央空调缺少智能控制手段，基本还是依靠遥控器来进行控制，难以进行集中控制。</p>
			<p>本系统将物联网技术和软件技术结合起来，依托企业内部网络，可以在不改变空调硬件电路的情况下实现空调的智能、集中控制。系统同时可拓展各种统计分析功能。因此从社会和经济价值上说，能够促进节能减排，降低行政办公成本，具有非常重要的现实意义。</p>
            <p>该系统能够实现空调的集中控制，这样在一些大型的公司、一些高校中将具有广阔的市场，在一些普通的家庭里，也能够实现智能控制的功能，将节约资源的额理念深入人心，应用前景广泛。
</p>
            
        </div>

</div> <!-- end of header_wrapper -->

<div id="templatemo_content_wrapper_outer">
<div id="templatemo_content_wrapper_inner">
<div id="templatemo_content_wrapper">

    <div id="templatemo_content">
      
        
        <div class="cleaner_h40"></div>
        
        <h4 style="margin-left:30%;"><b>发送邮件</b></h4>
        <div id="contact_form">
        
            <form method="post" name="contact" action="#">
            
                <input type="hidden" name="post" value=" Send " />
                <label for="author">姓名:</label> <input type="text" id="author" name="author" class="required input_field" />
                <div class="cleaner_h10"></div>
                
                <label for="email">Email:</label> <input type="text" id="email" name="email" class="validate-email required input_field" />
                <div class="cleaner_h10"></div>
                
                <label for="url">电话:</label> <input type="text" name="url" id="url" class="input_field" />
                <div class="cleaner_h10"></div>
                
                <label for="text">信息:</label> <textarea id="text" name="text" rows="0" cols="0" class="required"></textarea>
                <div class="cleaner_h10"></div>
                
                <input style="font-weight: bold;" type="submit" class="submit_btn" name="submit" id="submit" value=" Send " />
                <input style="font-weight: bold;" type="reset" class="submit_btn" name="reset" id="reset" value=" Reset " />
            
            </form>
            
        </div>

	<div class="cleaner"></div>
</div>
<div class="cleaner"></div>
</div>
</div>
 </div>       
<div id="templatemo_footer_wrapper">
    <div id="templatemo_footer">

         <ul class="footer_menu">
            <li><a href="index.jsp">主页</a></li>
            <li><a href="products.jsp">产品</a></li>
            <li class="last_menu"><a href="contact.jsp">联系方式</a></li>
        </ul>
        Copyright (c) 2016 <a href="#" style="text-decoration:none;">cslg</a>
    
</div> <!-- end of footer -->

</div> <!-- end of footer_wrapper -->

</body>
</html>