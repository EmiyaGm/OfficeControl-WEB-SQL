<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基于Arduino的办公室节能控制系统</title>
<link href="<%=request.getContextPath()%>/templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/jquery.ennui.contentslider.css" rel="stylesheet" type="text/css" media="screen,projection" />

</head>
<body>

<div id="templatemo_header_wrapper">
	<div id="templatemo_header">
    	<div id="site_title">
            <h1><a>
                基于Arduino的办公室节能控制系统
            </a></h1>
        </div>
        <div id="login_register" >
			<h4><a href="<%=request.getContextPath()%>/login.jsp">>>用户登录</a></h4>
		</div>

        <div class="cleaner"></div>
	</div><!-- end of header -->

    	<div id="templatemo_menu">
            <ul>
                <li><a href="<%=request.getContextPath()%>/index.jsp" class="current">主页</a></li>
                <li><a href="products.jsp">产品</a></li>
                <li><a href="contact.jsp">联系方式</a></li>
            </ul>    	
    	</div><!-- end of templatemo_menu -->
        
        <div id="templatemo_banner">
            
                <div id="one" class="contentslider">
                    <div class="cs_wrapper">
                        <div class="cs_slider">
                        
                            <div class="cs_article">
                            	
                                <div class="left">
                                    <h2>节能办公室</h2>
                                    <p>基于Arduino的办公室节能控制系统，传输部分采用无线方式，无需布线，可以满足同时控制室内多台用电器的需要。不需要对现有供电系统进行改进，只需安装此套装置控制的电插座即可工作，应用范围很广，使用限制小。此系统能达到节约电能的目的，减少浪费，减少火力发电带来的污染，为建设节约型社会做贡献。其次，产品成型并推向市场之后，能够解决办公室用电器长时间工作浪费电能的问题，将会产生良好的经济效益。</p>
                                    
                               	</div>
                                <div class="right">
                               <a href="#" target="_parent"><img src="<%=request.getContextPath()%>/images/office/office1-1.jpg" alt="Template 1" /></a>
								</div>
                                                                
                            </div><!-- End cs_article -->
                            
                            <div class="cs_article">
                                <div class="left">
                                    <h2>办公室电耗</h2>
                                    <p>来自国家有关部门的调查数字显示，我国办公楼年电力消耗总量占全国总消耗量的10%，能源费用超过800亿元，主要包括政府机关、企事业单位、商业写字楼等办公楼，大部分的办公楼的全年用电量在100KWH以上，其中空调用电在45%-50%；用户室内用电35%-40%；公用电费支出10%-15%。 </p>
                                    
                           
                               	</div>
                                <div class="right">
                                <a href="#" target="_parent"><img src="<%=request.getContextPath()%>/images/office/office1-2.jpg" alt="Template 2" /></a>
                                </div>
                            </div><!-- End cs_article -->
                            
                            <div class="cs_article">
                                <div class="left">
                                    <h2>Arduino</h2>
                                    <p>Arduino是一款便捷灵活、方便上手的开源电子原型平台。包含硬件（各种型号的Arduino板）和软件（Arduino IDE)。由一个欧洲开发团队于2005年冬季开发。Arduino能通过各种各样的传感器来感知环境，通过控制灯光、马达和其他的装置来反馈、影响环境。板子上的微控制器可以通过Arduino的编程语言来编写程序，编译成二进制文件，烧录进微控制器。对Arduino的编程是利用 Arduino编程语言 (基于 Wiring)和Arduino开发环境(基于 Processing)来实现的。基于Arduino的项目，可以只包含Arduino，也可以包含Arduino和其他一些在PC上运行的软件，他们之间进行通信来实现。</p>
                                    
                                  
                               	</div>
                                <div class="right">
                                <a href="#" target="_parent"><img src="<%=request.getContextPath()%>/images/office/office1-3.jpg" alt="Template 3" /></a>
                                </div>
                            </div><!-- End cs_article -->
                          
                      
                        </div><!-- End cs_slider -->
                    </div><!-- End cs_wrapper -->
                </div><!-- End contentslider -->
                
                <!-- Site JavaScript -->
                <script type="text/javascript" src="js/jquery-1.3.1.min.js"></script>
                <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
                <script type="text/javascript" src="js/jquery.ennui.contentslider.js"></script>
                <script type="text/javascript">
                    $(function() {
                    $('#one').ContentSlider({
                    width : '920px',
                    height : '200px',
                    speed : 800,
                    easing : 'easeInOutBack'
                    });
                    });
                </script>
                <div class="cleaner"></div>
        </div>

</div> <!-- end of header_wrapper -->

<div id="templatemo_content_wrapper_outer">
<div id="templatemo_content_wrapper_inner">
<div id="templatemo_content_wrapper">

	<div id="templatemo_content">

        <h2><b>办公楼用电现状</b></h2>
            
            <p style="text-indent:2em; ">来自国家有关部门的调查数字显示，我国办公楼年电力消耗总量占全国总消耗量的10%，能源费用超过800亿元，主要包括政府机关、企事业单位、商业写字楼等办公楼，大部分的办公楼的全年用电量在100KWH以上，其中空调用电在45%-50%；用户室内用电35%-40%；公用电费支出10%-15%。</p>
			<p style="text-indent:2em; ">学校、医院作为培养人才、传播知识或公共服务的重要场所，所涉及的人数众多，在我国社会和经济发展中占有相当重要的位置。随着我国教育和卫生事业的快速发展，目前全国共有各类学校尽12万家，各级各类学校在校学生有2.6亿多人；各级别医院、卫生院数量也高达6.04万个。据有关部门统计，全国学校和医院系统年总用电量超过600亿kwh，是公共事业单位中能耗最多的两个行业之一。</p>
       	<div class="cleaner_h40"></div>
            
            <h2><b>办公楼用电分析</b></h2>
            
            <blockquote>
            <p>（一）、供电系统效率低、系统电能使用效率低</p>
			<p>（二）、用电设备能耗利用率不高</p>
			<p>（三）、用电设备复杂，电力品质差，用电设备数量与种类众多</p>
            </blockquote>
            
            
            <div class="cleaner_h40"></div>
            
            <h2><b>节能办公室</b></h2>
			<p style="text-indent:2em; ">基于Arduino的办公室节能控制系统，传输部分采用无线方式，无需布线，可以满足同时控制室内多台用电器的需要。不需要对现有供电系统进行改进，只需安装此套装置控制的电插座即可工作，应用范围很广，使用限制小。此系统能达到节约电能的目的，减少浪费，减少火力发电带来的污染，为建设节约型社会做贡献。其次，产品成型并推向市场之后，能够解决办公室用电器长时间工作浪费电能的问题，将会产生良好的经济效益。</p>
            <div id="recent_project">
                <ul>
                    <li>
                        <a href="#" title="Pro"><img src="images/office/office1.jpg" alt="web template 1" /></a>
                    </li>
                    <li>
                        <a href="#" title="Motor"><img src="images/office/office2.jpg" alt="web template 2" /></a>
                    </li>
					 <li>
                        <a href="#" title="Motor"><img src="images/office/office3.jpg" alt="web template 2" /></a>
                    </li>
                </ul>
                
                <div class="cleaner"></div>
               
        	</div>
            

            
            
        </div> <!-- end of templatemo_content -->
        
       

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