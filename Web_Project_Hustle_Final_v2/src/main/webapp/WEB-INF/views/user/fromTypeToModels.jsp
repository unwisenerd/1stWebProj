<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
    
    <h2>Category: ${type.type}</h2>

<div class="row">
	<div class="col-md-3 col-xs-12">
	
		
		
	</div>
	<div class="col-md-7 col-xs-12">
		<c:forEach items="${models}" var="goodModel">
			<div>

				<div class="row">

					<div class="col-md-12 col-xs-12">

						<c:choose>
							<c:when test="${goodModel.id=='118'}">
								<img
									src="https://s5.postimg.org/6d1nu19on/alienware_17_left.png">
							</c:when>

							<c:when test="${goodModel.id=='123'}">
							<img src="https://s5.postimg.org/pv0wnpw07/Alienware_Steam_Machine.jpg">
						</c:when>
						
							<c:when test="${goodModel.id=='119'}">
							<img src="https://s5.postimg.org/mdyukqwxz/alienware_laptop_category_premigration_day01_Mod.jpg">
						</c:when>
						
							<c:when test="${goodModel.id=='121'}">
							<img src="https://s5.postimg.org/nmmq6dow7/Dell_AAR4_1428_BK_Aurora_AAR4_1428_BK_Desktop_Comp.jpg">
						</c:when>
						
						<c:when test="${goodModel.id=='122'}">
							<img src="https://s5.postimg.org/igg692zif/playstation_4_slim_vertical_product_shot_01_us_0.png">
						</c:when>

						

						<c:when test="${goodModel.id=='120'}">
							<img src="https://s5.postimg.org/r7ilpltfr/Area_51_lsy_00075lf_gy_bl.png">
						</c:when>
						
					
						
							<c:otherwise>
								<img src="https://s5.postimg.org/8xer4csw7/No_image_found.jpg">
							</c:otherwise>
						</c:choose>

					</div>
				</div>

				<div class="row">
					<div class="col-md-12 col-xs-12">
<%-- 						<a href="/model/${goodModel.id}"> ${goodModel.modelName} --%>
<!-- 							$${goodModel.price} </a> <br> -->
							<div class="row">		
								<div class="col-md-4 col-xs-12" style="margin-left:-50px;">
									<a href="/model/${goodModel.id}" class="modClick"><h3>${goodModel.modelName}</h3></a>
								</div>
								<div class="col-md-4 col-xs-12"></div>
								<div class="col-md-4 col-xs-12" style="margin-bottom:35px;">
									<h3 style="margin-left:40px;">$${goodModel.price}</h3>
								</div>
							</div>	
							<hr>
					</div>
				</div>




				<%-- 	${model.goodType.type} <br> --%>
				<%-- 	${model.gpuType.type}	<br> --%>
				<%-- 	${model.memoryType.type}	<br> --%>
				<%-- 	${model.proccType.type} <br> --%>
				<%-- 	${model.ramType.ramType} <br> --%>
			</div>


		</c:forEach>
	</div>
	
	<div class="col-md-2 col-xs-12">
	
		
		
	</div>
	
</div>



<c:if test="${empty models}">
	<h3>Category is empty</h3>
</c:if>