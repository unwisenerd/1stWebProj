<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="row mainAdv" style="background-color:black">
				<div class="col-md-5" style="padding-top:230px">
					<div style="padding-left:60px">
						<h2 style="color:white">GET WHAT YOU REALLY WANTED.</h2>
						<div style="padding-left:50px"> 
						<h5 style="color:white">Here’s to guilt-free self-gifting. Save up to $419 on Hustler's PC</h5>
						</div>
							<c:forEach items="${types}" var="type">
								<c:choose>
									<c:when test="${type.id=='2'}">
										<p><a href="/type/${type.id}" class="ShopNow"><b>SHOP NOW</b></a></p>
									</c:when>
								</c:choose>
							</c:forEach>		
					</div>
				</div>
				<div class="col-md-7" style="margin-left:-140px">
					<img src="https://s5.postimg.org/tswg1uzpj/awarea_51_gml_00025lf_gy_u3_0.png">
				</div>
	</div>
			<hr>
			
				<div class="bodyCat" style="background-color:black">
					<div class="row">
						<div class="col-md-4 text-center shadows">
							<c:forEach items="${types}" var="type">
								<c:choose>
									<c:when test="${type.id=='2'}">
										<a href="/type/${type.id}"><img src="https://s5.postimg.org/5szhttmpz/Area_51_lsy_00075lf_gy_bl.png" height="320px"  ></a>
									</c:when>
								</c:choose>
							</c:forEach>
								<h1 style="color:black"><b>EXPLORE DESKTOPS</b></h1>	
						</div>
						<div class="col-md-4 text-center shadows">
							<c:forEach items="${types}" var="type">
								<c:choose>
									<c:when test="${type.id=='1'}">
										<a href="/type/${type.id}"><img src="https://s5.postimg.org/4rz94p5qf/Original_Png.png " height="260px" style="margin-top:60px"></a>
									</c:when>
								</c:choose>
							</c:forEach>		
							<h1 style="color:black"><b>EXPLORE LAPTOPS</b></h1>
						</div>
						<div class="col-md-4 text-center shadows">
							<c:forEach items="${types}" var="type">
								<c:choose>
									<c:when test="${type.id=='3'}">
										<a href="/type/${type.id}"><img src="https://s5.postimg.org/5vjdgnqdj/alienware_steammachine_controller_2015_10_13.png"  height="260px" style="margin-top:60px"></a>
											<h1 style="color:black"><b>EXPLORE CONSOLES</b></h1>
									</c:when>
								</c:choose>
							</c:forEach>		
						</div>
					</div>	
				</div>
			
			<hr>
			
				<div class="row">
					<div class="col-md-12 text-left col-md-offset-2 mainSpace">
						<h3><b>WE DIDN'T PUSH THE ENVELOPE. WE SHREDDED IT.</b>​</h3>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 col-md-offset-2 text-left" style=" border-left: 1px solid #ccc;">
						<h5><b>INNOVATION.</b>​</h5>
						<hr>
						<p>We push gaming limits—rigorously testing technology and partnering with forward-thinking companies like Steam and Oculus—to redefine the boundaries of our reality.</p>
					</div>
					<div class="col-md-3 text-left" style=" border-left: 1px solid #ccc;">
						<h5><b>ONE PASSION UNITES US ALL.</b>​</h5>
						<hr>
						<p>Join the battle at Alienware Arena online. Get tips, free giveaways and a worldwide community of gamers, united by love of competition and passion for immersion.</p>
					</div>
					<div class="col-md-3 text-left" style=" border-left: 1px solid #ccc;">
						<h5><b>WE STARTED A MOVEMENT.</b>​</h5>
						<hr>
						<p>We were first—to implement lightning-fast NVIDIA® graphics, to create mobile gaming machines that truly deliver. Here’s to the past, present and future of gaming.</p>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-12">
						<img src="https://s5.postimg.org/u87puvlmv/alienware_homepage_premigration_day01_Module_5a.jpg" style="width:100%">
					</div>
				</div>
				
				<div class="row " >
					<div class="col-md-3  text-right mainFreedom">
						<h2><b>FREEDOM OF CHOICE.</b>​</h2>
						<p>Bring the benefits of Steam—with over 100 million users to play with, thousands of games across multiple platforms, user modifications and more—to the living room on the Alienware Steam Machine.</p>
					</div>	
					<div class="col-md-9 steamMachine" >
						<img src="https://s5.postimg.org/5qfm6zj2f/steam_machine_slider.png " style="width:95%">
					</div>	
				</div>	