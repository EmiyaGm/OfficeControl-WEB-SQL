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
        <div class="cleaner"></div>
	</div><!-- end of header -->
    
    	<div id="templatemo_menu">
            <ul>
                <li><a href="index.jsp">主页</a></li>
                <li><a href="products.jsp" class="current">产品</a></li>
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
                               <a href="http://www.mycodes.net/" target="_parent"><img src="images/office/office1-1.jpg" alt="Template 1" /></a>
								</div>
                                                                
                            </div><!-- End cs_article -->
                            
                            <div class="cs_article">
                                <div class="left">
                                    <h2>办公室电耗</h2>
                                    <p>来自国家有关部门的调查数字显示，我国办公楼年电力消耗总量占全国总消耗量的10%，能源费用超过800亿元，主要包括政府机关、企事业单位、商业写字楼等办公楼，大部分的办公楼的全年用电量在100KWH以上，其中空调用电在45%-50%；用户室内用电35%-40%；公用电费支出10%-15%。 </p>
                                    
                           
                               	</div>
                                <div class="right">
                                <a href="#" target="_parent"><img src="images/office/office1-2.jpg" alt="Template 2" /></a>
                                </div>
                            </div><!-- End cs_article -->
                            
                            <div class="cs_article">
                                <div class="left">
                                    <h2>Arduino</h2>
                                    <p>Arduino是一款便捷灵活、方便上手的开源电子原型平台。包含硬件（各种型号的Arduino板）和软件（Arduino IDE)。由一个欧洲开发团队于2005年冬季开发。Arduino能通过各种各样的传感器来感知环境，通过控制灯光、马达和其他的装置来反馈、影响环境。板子上的微控制器可以通过Arduino的编程语言来编写程序，编译成二进制文件，烧录进微控制器。对Arduino的编程是利用 Arduino编程语言 (基于 Wiring)和Arduino开发环境(基于 Processing)来实现的。基于Arduino的项目，可以只包含Arduino，也可以包含Arduino和其他一些在PC上运行的软件，他们之间进行通信来实现。</p>
                                    
                                  
                               	</div>
                                <div class="right">
                                <a href="#" target="_parent"><img src="images/office/office1-3.jpg" alt="Template 3" /></a>
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
    
    	<h2><b>系统分析和设计</b></h2>
        
        <p style="text-indent:2em; ">在分析设计阶段，详细分析了空调网络控制系统所需要的实现的功能，并确定了技术路线。</p>
		<p style="text-indent:2em; ">其中，空调控制器部分使用集成AVR芯片的Arduino Mega 2560开发板作为下位机，配合各种传感器等实现感知，使用红外编码（NEC协议）对进行空调进行控制，使用C语言进行编程。空调控制器通过WIFI模块和校园网络与上位机（服务器）进行通信。</p>
		<p style="text-indent:2em; ">服务器系统采用J2EE+Mysql的架构。根据系统功能进行了数据库设计。</p>
		<p style="text-indent:2em; ">图1为系统逻辑架构，其中包含了整个系统的构成部分及之间的逻辑关系。</p>
		<p style="text-indent:2em; ">图2为系统物理部署拓扑图，其中的节能控制器（即空调控制器）通过多个无线路由和服务器进行通信，因此在这种模式下，空调控制器的WIFI模块工作在TCP-Client模式，主动向Web服务器提交状态信息，Web服务器随后返回控制信息给空调控制器。</p>
<img src="images/products/图片1.png"  style=" padding-left:200px;"/><br />
<p style="text-align:center;">图1系统逻辑架构</p><br /><br />
<img src="images/products/图片2.png" style=" padding-left:200px;"/><br />
<p style="text-align:center;">图2 系统物理部署拓扑图</p><br /><br />
<img src="images/products/图片3.png" style=" padding-left:200px;"/><br />
<p style="text-align:center;">图3 控制器结构</p><br />
		<p style="text-indent:2em; ">图3为空调控制器的物理结构，由Arduino开发板、温湿度传感器、光敏传感器、热释红外传感器、温度传感器、红外发射管和WIFI模块组成。</p>
		<p style="text-indent:2em; ">其中，两个温度传感器分别安装在空调出风口和空调侧面，通过采集到的温度数据的差值，可判断空调的开关状态和制冷制热状态。所有的状态信息（温度、湿度、光照度、有无人员等）全部提交到Web服务器进行处理。</p>
		<p style="text-indent:2em; ">在系统设计中，还有一个重要的问题是通信协议的制定，由于本系统基于HTTP协议来实现，因此各种状态信息均定时以Query String的方式提交给Web服务器，同时Web服务器返回简单的控制信号。由于系统可同时控制多台空调，因此每个空调控制器需要编号，并记录空调的品牌和型号。</p>
		<p style="text-indent:2em; ">这种架构的优点是，下位机不需要红外编码生成逻辑，这些工作完全由计算能力强大的Web服务器完成，在Web数据库中可存储各个品牌空调的红外编码协议或具体编码，服务器可根据下位机发送的空调编号来决定返回控制信号的协议和编码内容，因此适应性较强。</p>
        
        <div class="cleaner_h30"></div>
    
        <div class="services_section">
        
          <div class="services_content">
            
       	    <div class="right"></div>
                
            <div class="left"></div>
                
            <div class="cleaner"></div>
            
		  </div>                    

        </div>
        
         <div class="services_section">
        
            <h2><b>产品结果</b></h2>
            
	      <div class="services_content">
            
           	  <div class="right" >
                	<img src="images/products/图片7.png" alt="image 2"  width="300px;"/>
                </div>
                
                <div class="left" >
                
                	<img src="images/products/图片8.png" alt="image 2"  width="300px;"/>
            </div>
                
                <div class="cleaner"></div>
            </div>
        </div>

	<div class="cleaner"></div>
</div>
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