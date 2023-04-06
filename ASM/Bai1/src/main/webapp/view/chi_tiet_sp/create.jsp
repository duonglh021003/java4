<%--
  Created by IntelliJ IDEA.
  User: BXT
  Date: 20/03/2023
  Time: 11:47 CH
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

<h1 style="text-align: center;">Chi tiết sp</h1>

<div class="col-8 offset-2">
    <form method="POST"
          action="/Bai1_war_exploded/chi-tiet-sp/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>id</label>
                <input type="text" name="id" class="form-control" disabled/>
            </div>
            <div class="col-6">
                <label>San pham</label>
                 <select name="sp" class="form-select"  >
                            <c:forEach items="${ danhSachSP }" var="sp">
                                <option value="${ sp.ma }">${ sp.ten }</option>
                            </c:forEach>
                 </select>
            </div>

        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>IdNsx</label>
                <select name="nsx" class="form-select"  >
                        <c:forEach items="${ danhSachNsx }" var="nsx">
                        <option value="${ nsx.ma }">${ nsx.ten }</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>IdMauSac</label>
                <select name="ms" class="form-select"  >
                    <c:forEach items="${ danhSachMS }" var="ms">
                        <option value="${ ms.ma }">${ ms.ten }</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>dongsp</label>
                <select name="sp" class="form-select"  >
                    <c:forEach items="${ danhSachDongSP }" var="dongsp">
                        <option value="${ dongsp.ma }">${ dongsp.ten }</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>NamBH</label>
                <input type="tel" name="namBH" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>MoTa</label>
                <input type="text" name="moTa" class="form-control" />
            </div>
            <div class="col-6">
                <label>SoLuongTon</label>
                <input type="text" name="SoLuongTon" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>GiaNhap</label>
                <input type="text" name="giaNhap" class="form-control" />
            </div>
            <div class="col-6">
                <label>GiaBan</label>
                <input type="text" name="giaBan" class="form-control" />
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
