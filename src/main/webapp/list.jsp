<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

    <style>
        .collapse {
            transition: background-color 0.3s, font-size 0.3s;
        }
    </style>

</head>


<body>
<jsp:include page="/common/header.jsp"></jsp:include>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2 my-3">
                <div>
                    <p class="text-primary" style="margin-left: 10px;"><i class="fas fa-tachometer-alt"></i>
                        &nbsp;Dashboard</p>
                </div>

                <a href="#toggle" class="btn text-primary" data-bs-toggle="collapse"><i class="fas fa-chart-bar"></i>
                    &nbsp;Employee Manager <i class="fas fa-caret-down ms-4"></i>
                </a>
                <div id="toggle" class="collapse">
                    <div class="text-primary my-3 employeeList">
                        <a href="/list" style="margin-left: 50px; text-decoration: none;">
                            <i class="fas fa-list"></i>
                            &nbsp;Employee list
                        </a>
                    </div>

                    <div class="text-primary my-3 addEmployee">
                        <a href="/employee" style="margin-left: 50px; text-decoration: none;">
                            <i class="fas fa-plus"></i>
                            &nbsp;Add Employee
                        </a>
                    </div>
                </div>
            </div>

            <div class="col-md-10 ">
                <div class="mt-5">
                    <h2>Employee List</h2>
                </div>
                <div class="row justify-content-end">
                    <div class="col-md-4 my-3">
                        <form class="input-group">
                            <button class="btn btn-secondary" type="submit">
                                <i class="fas fa-search"></i>
                            </button>
                            <input type="text" class="form-control" id="user" placeholder="Search by First name" name="search">
                        </form>
                    </div>
<%--                     <div class="col-md-3 my-3"> --%>
<%--                         <div class="input-group"> --%>
<%--                             <label class="btn btn-secondary" for="name"> --%>
<%--                                 <i class="fas fa-filter"></i> Filter By --%>
<%--                             </label> --%>
<%--                             <select class="form-select" id="name"> --%>
<%--                              <option selected>Name...</option> --%>
<%--                              <c:forEach items="${employeeList}" var="employee"> --%>
<%--                              <option value="${employee.firstName}">${employee.firstName}</option> --%>
<%--                              </c:forEach> --%>
<%--                             </select> --%>
<%--                         </div> --%>
<%--                     </div> --%>

<%--                     <div class="col-md-2 my-3"> --%>
<%--                         <div class="input-group-append"> --%>
<%--                             <button class="btn btn-primary" type="button">Search</button> --%>
<%--                         </div> --%>
<%--                     </div> --%>

                    <div class="col-md-12 mt-3">
                        <table id="table-view" class="table table-bordered">
                            <thead>
                                <tr class="table">
                                    <th style="background-color: #f5f5f5;">#ID</th>
                                    <th style="background-color: #f5f5f5;">Name</th>
                                    <th style="background-color: #f5f5f5;">Date Of Birth</th>
                                    <th style="background-color: #f5f5f5;">Address</th>
                                    <th style="background-color: #f5f5f5;">Phone Number</th>
                                    <th style="background-color: #f5f5f5;">Department</th>
                                    <th style="background-color: #f5f5f5;">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="employee" items="${employeeList}">
                                    <tr>
                                        <td><c:out value="${employee.employeeId}" /></td>
                                        <td>${employee.lastName} ${employee.firstName}</td>
                                        <td>${employee.dateOfBirth}</td>
                                        <td>${employee.address}</td>
                                        <td>${employee.phone}</td>
                                        <td>${employee.departmentName}</td>
                                        <td>
                                            <a href="/employee?view=${employee.employeeId}"
                                                class="text-decoration-none">
                                                <i class="fas fa-eye"></i>
                                                View</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <ul class="pagination my-3">
                        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">Next</a></li>
                      </ul>
                </div>
            </div>
        </div>

</body>

</html>


