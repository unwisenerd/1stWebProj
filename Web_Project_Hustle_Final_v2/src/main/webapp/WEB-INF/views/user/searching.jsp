<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
	.filter .control-label{
		text-align: left;
	}
	.textRight{
		text-align: right;
	}
	.margTop{
		margin-top:50px;
	}
	.black-background {background-color:#000000;}
	.white {color:#ffffff;}

</style>
	
<div class="row">
	<div class="col-md-2 col-xs-12">
	
		<form:form class="form-horizontal filter" action="/user/searching" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="min, max, goodTypesId, goodsId, gpuTypesId, memoriesId, proccTypesId, ramTypesId, _goodTypesId, _goodsId, _gpuTypesId, _memoriesId, _proccTypesId, _ramTypesId"/>
			
			<div class="form-group">
				<div class="col-sm-6">
					<form:input path="min" class="form-control" placeholder="Min price"/>
				</div>
				<div class="col-sm-6">
					<form:input path="max" class="form-control" placeholder="Max price"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Type</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${goodTypes}" itemValue="id" itemLabel="type" path="goodTypesId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Country</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${goods}" itemValue="id" itemLabel="madeCountry" path="goodsId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">GPU Type</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${gpuTypes}" itemValue="id" itemLabel="type" path="gpuTypesId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Memory Type</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${memories}" itemValue="id" itemLabel="type" path="memoriesId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Procc Type</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${proccs}" itemValue="id" itemLabel="type" path="proccTypesId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">RAM Type</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${rams}" itemValue="id" itemLabel="ramType" path="ramTypesId"/>
				</div>
			</div>
			
			<button type="submit" class="btn btn-primary black-background white">APPLY</button>
			<a class="btn btn-primary black-background white" href="/user/searching/cancel">CANCEL</a>
			
		</form:form>
	
	</div>
	<div class="col-md-8 col-xs-12 margTop">
	<form:form class="form-horizontal" action="/user/searching" method="POST" modelAttribute="cartAdd">
		<c:forEach items="${page.content}" var="goodModel" >

		
	
		<div class="row">
			<div class="col-md-6 col-xs-6">
			
					<div class="row">
				
						<div class="col-md-12 col-xs-12">
							<c:choose>
						
						<c:when test="${goodModel.id=='118'}">
							<img src="https://s5.postimg.org/6d1nu19on/alienware_17_left.png" style="width:50%;height:50%;margin-left:100px">
						</c:when>
						
						<c:when test="${goodModel.id=='123'}">
							<img src="https://s5.postimg.org/pv0wnpw07/Alienware_Steam_Machine.jpg" style="width:100%;height:100%">
						</c:when>
					
						<c:when test="${goodModel.id=='119'}">
							<img src="https://s5.postimg.org/mdyukqwxz/alienware_laptop_category_premigration_day01_Mod.jpg" style="width:50%;height:50%;margin-left:100px;">
						</c:when>
						
						<c:when test="${goodModel.id=='121'}">
							<img src="https://s5.postimg.org/nmmq6dow7/Dell_AAR4_1428_BK_Aurora_AAR4_1428_BK_Desktop_Comp.jpg" style="width:50%;height:45%;margin-left:100px;">
						</c:when>
						
						<c:when test="${goodModel.id=='122'}">
							<img src="https://s5.postimg.org/igg692zif/playstation_4_slim_vertical_product_shot_01_us_0.png" style="width:50%;height:50%;margin-left:100px;">
						</c:when>
						
						
						<c:when test="${goodModel.id=='120'}">
							<img src="https://s5.postimg.org/r7ilpltfr/Area_51_lsy_00075lf_gy_bl.png" style="width:50%;height:50%;margin-left:100px;">
						</c:when>
						
						
						

						<c:otherwise>
							<img src="https://s27.postimg.org/a2zolamer/No_image_found.jpg" style="width:50%;height:50%">
						</c:otherwise>
					</c:choose>
				</div>	
				</div>
				
				
			</div>
			
		
			<div class="col-md-2 col-xs-2">
				<div class="row">
				<div class="col-md-12 col-xs-12 textRight">
				<b>TYPE:</b><br>
				<b>NAME:</b><br>
				<b>GPU:</b><br>
				<b>MEMORY:</b><br>
				<b>PROCESSOR:</b><br>
				<b>RAM:</b><br>
				<b>MADE IN:</b><br>
				<b>PRICE:</b><br>
				<hr>
				</div>
				</div>
				
			</div>
			
			<div class="col-md-3 col-xs-3">
				
				<div class="row">
				<div class="col-md-12 col-xs-12">
				${goodModel.goodType.type}<br>
				${goodModel.modelName}<br>
				${goodModel.gpuType.type}<br>
				${goodModel.memoryType.type}<br>
				${goodModel.proccType.type}<br>
				${goodModel.ramType.ramType}<br>
				${goodModel.good.madeCountry}<br>
				$${goodModel.price}<br>
				<hr>
			<form:form class="form-horizontal" action="/user/searching" method="POST" modelAttribute="purchaseInfo">
			<div class="form-group">
			
			</div>	
			
			
			
			</form:form>		
				
				</div>
				</div>
			
			</div>
			
			<sec:authorize access="isAuthenticated()">
			<div class="col-md-1 col-xs-1" style="margin-top:125px;margin-left:-150px">
				<a  class="btn btn-danger" href="/user/searching/addToCart/${goodModel.id}" id="addToCart">ADD TO CART</a>
			</div>
			</sec:authorize>
		
			<sec:authorize access="!isAuthenticated()">
				<div class="col-md-1 col-xs-1" style="margin-top:125px;margin-left:-150px">
					<a  class="btn btn-danger" href="/login" id="logOrReg">ADD TO CART</a>
				</div>
			</sec:authorize>
			
		</div>

			</c:forEach>
		</form:form>	
	</div>
	
	<div class="col-md-2 col-xs-12" >
	
		<div class="row">
					<div class="col-md-6 col-xs-6 text-center">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Price asc" paramValue="price" />
								<custom:sort innerHtml="Price desc" paramValue="price,desc" />
							</ul>
						</div>
					</div>
					<div class="col-md-6 col-xs-6 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
					</div>
		</div>
	
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>

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