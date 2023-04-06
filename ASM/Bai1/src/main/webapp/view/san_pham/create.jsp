<%--
  Created by IntelliJ IDEA.
  User: BXT
  Date: 12/03/2023
  Time: 11:40 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/Bai1_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<div>
    <h1 style=" text-align: center;">Sản phẩm</h1>
</div>
<div class="col-8 offset-2">
    <form method="POST"
          action="/Bai1_war_exploded/san-pham/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" required/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" required />
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
<script src="/Bai1_war_exploded/js/bootstrap.min.js"></script>


</body>
</html>
