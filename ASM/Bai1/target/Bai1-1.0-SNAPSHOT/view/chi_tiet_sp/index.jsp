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

<div class="col-8 offset-2 mt-5 table-responsive">
    <div class="row">
        <div class="col-6">
            <a href="create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <c:if test="${ f:length(danhSachchiTietSP) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(danhSachchiTietSP) != 0 }">
        <table class="table table-striped mt-3">
            <thead class="table-primary">
            <tr>
                <th>ID</th>
                <th>IdSP</th>
                <th>IdNsx</th>
                <th>IdMauSac</th>
                <th>IdDongSP</th>
                <th>NamBH</th>
                <th>mô tả</th>
                <th>số lượng tồn</th>
                <th>giá nhập</th>
                <th>giá bán</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${ danhSachchiTietSP }" var="ctsp">
                <tr>
                    <td>${ ctsp.id }</td>
                    <td>${ ctsp.sp.ten }</td>
                    <td>${ ctsp.nsx.ten }</td>
                    <td>${ ctsp.ms.ten }</td>
                    <td>${ ctsp.dongsp.ten }</td>
                    <td>${ ctsp.namBH }</td>
                    <td>${ ctsp.moTa }</td>
                    <td>${ ctsp.soLuongTon }</td>
                    <td>${ ctsp.giaNhap }</td>
                    <td>${ ctsp.giaBan }</td>
                    <td>
                        <a class="btn btn-primary"
                           href="/Bai1_war_exploded/chi-tiet-sp/edit?id=${ ctsp.id }">
                            Cập nhật
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/Bai1_war_exploded/chi-tiet-sp/delete?id=${ ctsp.id }">
                            Xóa
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

</div>

<script src="/Bai1_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
