<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>

	<!-- Wrapper for slides -->
	<div class="carousel-inner">

		<div class="item active">
			<img
				src="https://dony.vn/wp-content/uploads/2022/03/chuong-trinh-khuyen-mai-cho-shop-quan-ao-2.jpg"
				alt="Los Angeles" style="width: 100%; height: 20cm;">
			<div class="carousel-caption">
				<h3>Khuyến mãi tưng bừng</h3>
			</div>
		</div>

		<div class="item">
			<img
				src="https://promacprinting.com/wp-content/uploads/2021/03/chuong-trinh-khuyen-mai-quan-ao.jpg"
				alt="Chicago" style="width: 100%; height: 20cm;">
			<div class="carousel-caption">
				<h3>Khuyến mãi tưng bừng</h3>
			</div>
		</div>

		<div class="item">
			<img src="https://eshop.misa.vn/wp-content/uploads/2018/07/chuong-trinh-khuyen-mai-cho-shop-quan-ao.png"
				alt="New York" style="width: 100%; height: 20cm;">
			<div class="carousel-caption">
				<h3>Khuyến mãi tưng bừng</h3>
			</div>
		</div>

	</div>

	<!-- Left and right controls -->
	<a class="left carousel-control" href="#myCarousel" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="right carousel-control" href="#myCarousel" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right"></span> <span
		class="sr-only">Next</span>
	</a>
</div>

<div class="container" align="center">
	<h3>Sản Phẩm Nổi Bật</h3>
	<br>
	<div class="row">
		<c:forEach var="hp" items="${ hotProducts }" end="2">
			<div class="col-sm-4">
				<div class="panel panel-primary text-center">
					<div class="panel-heading">${ hp.name }</div>
					<div class="panel-body">
						<a href="#"> <img
							src="/image/1.jpeg"
							class="img-responsive" style="width: 100%" alt="Image">
						</a>
					</div>
					<div class="panel-footer">
						<h4 class="text-info">
							<b> ${ hp.price.toString().replace(".0", " VNĐ") }</b>
						</h4>
						<a href="/cart/add/${hp.id}">
							<button class="btn btn-primary">Thêm Vào Giỏ Hàng</button>
						</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>


	<hr>
	<a href="/shop">
		<button type="button" class="btn-lg btn-info"
			style="align-content: center;">Xem Thêm</button>
	</a>
	<hr>
</div>

<div class="container" align="center">
	<h3>Sản Phẩm Mới</h3>
	<br>
	<div class="row">
		<c:forEach var="np" items="${ newProducts }" end="2">
			<div class="col-sm-4">
				<div class="panel panel-primary text-center">
					<div class="panel-heading">${ np.name }</div>
					<div class="panel-body">
						<a href="#"> <img
							src="/image/2.jpeg"
							class="img-responsive" style="width: 100%" alt="Image">
						</a>
					</div>
					<div class="panel-footer">
						<h4 class="text-info">
							<b> ${ np.price.toString().replace(".0", " VNĐ") }</b>
						</h4>
						<a href="/cart/add/${np.id}">
							<button class="btn btn-primary">Thêm Vào Giỏ Hàng</button>
						</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<hr>
	<a href="/shop">
		<button type="button" class="btn-lg btn-info"
			style="align-content: center;">Xem Thêm</button>
	</a>
	<hr>
</div>

<div class="container" align="center">
	<h3>Đang Giảm Giá</h3>
	<br>
	<div class="row">
		<c:forEach var="sp" items="${ saleProducts }" end="7">
			<div class="col-sm-3">
				<div class="panel panel-primary text-center">
					<div class="panel-heading">${ sp.name }</div>
					<div class="panel-body">
						<a href="#"> <img
							src="https://babi.vn/images/companies/1/Up%20hinh%20san%20pham/22493/ao-thun-gia-dinh-in-hinh-tha-tim-danh-cho-ba%20(1).jpg?1528776311374"
							class="img-responsive" style="width: 100%" alt="Image">
						</a>
					</div>
					<div class="panel-footer">
						<mark>
							<del>${ sp.price / 0.5 } VNĐ</del>
						</mark>
						<h4 class="text-info">
							<b>${ sp.price.toString().replace(".0", " VNĐ") }</b>
						</h4>
						<a href="/cart/add/${sp.id}">
							<button class="btn btn-primary">Thêm Vào Giỏ Hàng</button>
						</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<hr>
	<a href="/shop">
		<button type="button" class="btn-lg btn-info"
			style="align-content: center;">Xem Thêm</button>
	</a>
	<hr>
</div>
