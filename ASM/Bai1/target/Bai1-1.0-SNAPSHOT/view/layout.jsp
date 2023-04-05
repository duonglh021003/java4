<%--
  Created by IntelliJ IDEA.
  User: BXT
  Date: 21/03/2023
  Time: 2:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Bai1_war_exploded/css/bootstrap.min.css" />

</head>
<body>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href=""></a>
        <a class="navbar-brand" href=""></a>
        <a class="navbar-brand" href="#"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav" aria-controls="navbarNav"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/Bai1_war_exploded/khach-hang/index">khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/Bai1_war_exploded/san-pham/index">sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/Bai1_war_exploded/Nsx/index">Nsx</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/Bai1_war_exploded/nhan-vien/index">nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/Bai1_war_exploded/mau-sac/index">màu sắc</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/Bai1_war_exploded/DongSP/index">DongSP</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/Bai1_war_exploded/cua-hang/index">cửa hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/Bai1_war_exploded/chuc-vu/index">chức vụ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/Bai1_war_exploded/chi-tiet-sp/index">chi tiết sp</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="row mt-10" style="min-height: 500px;">
    <div class="col-2 " style="background: #a2a2a2">
<%--        <div class="list-group">--%>
<%--            <a href="/Bai1_war_exploded/ban-hang/index" class="list-group-item list-group-item-action" >Bán Hàng</a>--%>
<%--        </div>--%>
        <div class="list-group">
            <a href="/Bai1_war_exploded/chi-tiet-sp/index" class="list-group-item list-group-item-action">Sản phẩm</a>
        </div>
        <div class="list-group">
            <a href="/Bai1_war_exploded/nhan-vien/index" class="list-group-item list-group-item-action">Nhân Viên</a>
        </div>
        <div class="list-group">
            <a href="/Bai1_war_exploded/khach-hang/index" class="list-group-item list-group-item-action">Khách hàng</a>
        </div>
<%--        <div class="list-group">--%>
<%--            <a href="/Bai1_war_exploded/khach-hang/index" class="list-group-item list-group-item-action">Thống Kê</a>--%>
<%--        </div>--%>
        <div class="list-group">
            <a href="/Bai1_war_exploded" class="list-group-item list-group-item-action">Đăng xuất</a>
        </div>
    </div>
    <div class="col-10">
        <jsp:include page="${ view }" />
    </div>
</div>

<div class="row m-0 mt-10 bg-dark text-white">
    <div class="row">
        <div class="col-3" style="margin-top: 25px">
            <h6>Danh mục</h6> <br>
            Giày <br>
            Quần Áo <br>
            Phụ Kiện <br>
            Nam <br>
            Nữ <br>
            SALE <br>
        </div>
        <div class="col-3" style="margin-top: 25px">
            <h6>Hỗ trợ khách hàng</h6>  <br>
            FAQs & Help <br>
            Về Fundiin <br>
            Hướng dẫn thanh toán trả <br>
            sau qua Fundiin <br>
            Chính sách đổi trả/Hoàn <br>
            tiền <br>
            Chính sách giao hàng/Kiểm <br>
            hàng <br>
            Chính sách bảo hành <br>
            Chính sách thanh toán <br>
            Điều khoản dịch vụ <br>
            Chính sách bảo mật <br>
            Kiểm tra tình trạng đơn <br>
            hàng <br>
        </div>
        <div class="col-3" style="margin-top: 25px">
            <h6>Về SNEAKER DAILY</h6> <br>
            Giới thiệu Sneaker Daily <br>
            Cam kết mua sắm <br>
            <h6 style="margin-top: 25px">Tài liệu - Tuyển dụng</h6> <br>
            <div>
                Đăng ký bản quyền <br>
                Tuyển dụng <br>
                Đăng ký CTV Bán Hàng <br>
                Hợp tác NCC <br>
                Chính sách đại lý <br>
            </div>
            <h6>Dịch vụ</h6> <br>
            <div>
                Tạp chí <br>
                Dịch vụ ký gửi <br>
            </div>
        </div>
        <div class="col-3" style="margin-top: 25px">
            <h6>Hệ thống cửa hàng</h6> <br>
            <div>
                <a href="" style="color: white">Cửa hàng Hà Nội:</a> <br>
                48 Hoàng Sâm, Cầu Giấy, Hà <br>
                Nội - 089.887.5522
            </div>

            <div style="margin-top: 25px">
                <a href="" style="color: white">Cửa hàng Bắc Ninh:</a> <br>
                173 Nguyễn Trãi, Thành phố <br>
                Bắc Ninh - 089.997.5522
            </div>

            Đối tác dịch vụ bảo hành
        </div>
    </div>
    <hr style="margin-top: 25px">
    <div class="row mt-3">
        <div class="col-6">
            @ CÔNG TY TNHH SNEAKER DAILY <br>
            Mã số doanh nghiệp: 0109902052. Giấy chứng nhận đăng ký doanh nghiệp do Sở Kế hoạch và Đầu tư TP Hà Nội cấp lần đầu ngày 07/02/2022
            <input type="image" src="img/2.png">

        </div>
        <div class="col-6">

        </div>
    </div>

</div>
<script src="/Bai1_war_exploded/js/bootstrap.min.js"></script>


</body>
</html>
