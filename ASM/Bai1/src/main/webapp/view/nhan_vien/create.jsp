<%--
  Created by IntelliJ IDEA.
  User: BXT
  Date: 21/03/2023
  Time: 1:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/Bai1_war_exploded/css/bootstrap.min.css"/>
</head>
<body>

<h1 style="text-align: center;">Nhân viên</h1>
<div class="col-8 offset-2">
    <form method="POST"
          action="/Bai1_war_exploded/nhan-vien/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" />
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="ten_dem" class="form-control" />
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giới tính</label>
                <select name="gioi_tinh" class="form-select">
                    <option value="nam">nam</option>
                    <option value="nu">nữ</option>
                </select>
            </div>
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngay_sinh" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="dia_chi" class="form-control" />
            </div>
            <div class="col-6">
                <label>SDT</label>
                <input type="tel" name="sdt" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="password" name="mat_khau" class="form-control" />
            </div>
            <div class="col-6">
                <label>idCH</label>
                <select name="ch" class="form-select">
                    <c:forEach items="${ danhSachCH }" var="ch">
                        <option value="${ ch.id }">${ ch.ten }</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>idCH</label>
                <select name="cv" class="form-select">
                    <c:forEach items="${ danhSachCV }" var="cv">
                        <option value="${ cv.id }">${ cv.ten }</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>trạng thái</label>
                <input type="text" name="trang_thai" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary" >Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>


</div>
<script src="/Bai1_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
