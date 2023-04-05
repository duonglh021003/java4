<%--
  Created by IntelliJ IDEA.
  User: BXT
  Date: 13/03/2023
  Time: 8:30 CH
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
    <h1 style="text-align: center;">Nsx</h1>
</div>
<div class="col-8 offset-2">
    <form method="POST"
          action="/Bai1_war_exploded/Nsx/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" />
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" />
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
