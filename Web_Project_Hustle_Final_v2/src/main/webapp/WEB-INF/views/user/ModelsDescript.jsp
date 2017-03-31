<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    
        <h2>Model: ${model.modelName}</h2>
        
        <div>
        				<c:choose>
        				<c:when test="${model.id=='118'}">
							<img src="https://s5.postimg.org/6d1nu19on/alienware_17_left.png">
						</c:when>
						
						<c:when test="${model.id=='123'}">
							<img src="https://s5.postimg.org/pv0wnpw07/Alienware_Steam_Machine.jpg">
						</c:when>
						
						<c:when test="${model.id=='119'}">
							<img src="https://s5.postimg.org/mdyukqwxz/alienware_laptop_category_premigration_day01_Mod.jpg">
						</c:when>
						
						<c:when test="${model.id=='121'}">
							<img src="https://s5.postimg.org/nmmq6dow7/Dell_AAR4_1428_BK_Aurora_AAR4_1428_BK_Desktop_Comp.jpg">
						</c:when>
						
						<c:when test="${model.id=='122'}">
							<img src="https://s5.postimg.org/igg692zif/playstation_4_slim_vertical_product_shot_01_us_0.png">
						</c:when>
						
						
			
						<c:when test="${model.id=='120'}">
							<img src="https://s5.postimg.org/r7ilpltfr/Area_51_lsy_00075lf_gy_bl.png">
						</c:when>
						
						
							
						<c:otherwise>
							<img src="https://s5.postimg.org/8xer4csw7/No_image_found.jpg">
						</c:otherwise>
					</c:choose>
        </div>
        
 <c:forEach items="${modelTypes}" var="type">
	<div>
	<b>Type: </b>${type.type}

	</div>
</c:forEach>
        
<c:forEach items="${procc_types}" var="procc_type">
	<div>
	<b>Processor: </b>${procc_type.type}
	</div>
</c:forEach>

<c:forEach items="${gpu_types}" var="gpu_type">
	<div>
	<b>GPU: </b>${gpu_type.type}
	</div>
</c:forEach>

<c:forEach items="${ram_types}" var="ram_type">
	<div>
	<b>RAM: </b>${ram_type.ramType}
	</div>
</c:forEach>

<c:forEach items="${memory_types}" var="memory_type">
	<div>
	<b>Memory: </b>${memory_type.type}
	</div>
</c:forEach>


<c:forEach items="${goods}" var="good">
	<div>
	<b>Made in </b>${good.madeCountry}
	</div>
</c:forEach>

<h5><b>Total price = $${model.price}</b></h5>

<%-- <form:form class="form-horizontal" action="/model/{id}" method="POST" modelAttribute="cartAdd"> --%>
<%-- 		<sec:authorize access="isAuthenticated()"> --%>
<!-- 			<div class="col-md-1 col-xs-1" style="margin-top:125px;margin-left:-150px"> -->
<%-- 				<a  class="btn btn-danger" href="/model/{id}/addToCart/${model.id}">ADD TO CART</a> --%>
<!-- 			</div> -->
<%-- 		</sec:authorize> --%>
		
<%-- 			<sec:authorize access="!isAuthenticated()"> --%>
<!-- 				<div class="col-md-1 col-xs-1" style="margin-top:125px;margin-left:-150px"> -->
<!-- 					<a  class="btn btn-danger" href="/login">ADD TO CART</a> -->
<!-- 				</div> -->
<%-- 			</sec:authorize> --%>
<%-- </form:form>			 --%>

<sec:authorize access="isAuthenticated()">
	<a class="btn btn-danger" href="/addToCart/${model.id}" style="margin-bottom:50px;" id="addToCart">ADD TO CART</a>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
	<a class="btn btn-danger" href="/login" style="margin-bottom:50px;" id="logOrReg">ADD TO CART</a>
</sec:authorize>

<c:if test="${empty types}">
	<h3>Model does not exist yet</h3>
</c:if>

<script type="text/javascript"> 
document.getElementById('addToCart').addEventListener('click', function(){ 
alert("Selected item was added to your shopping cart.") 
}); 
</script>

<script type="text/javascript"> 
document.getElementById('logOrReg').addEventListener('click', function(){ 
alert("Please sing in or sing up for purchasing.") 
}); 
</script>