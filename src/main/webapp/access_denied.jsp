<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Access Denied</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

    <style>
        .main {
            margin: 0 auto;
        }
    </style>

</head>
<body>

<jsp:include page="/common/header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-md-12 mt-5">
            <h3 class="text-center">Acess Denied</h3>
            <hr>
        </div>

        <div class="col-md-12 mt-3">
            <div class="main col-md-6 mt-3">
                <div class="alert alert-warning" role="alert">
                    You don't have permission to access!
                </div>
            </div>

            <a href="<%=request.getContextPath()%>/home"
               class="btn btn-primary text-left">Back to Home</a>
        </div>
    </div>
</div>

<jsp:include page="/common/footer.jsp"></jsp:include>

</body>
</html>