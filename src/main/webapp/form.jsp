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

        .form-group label {
            font-weight: 600;
            margin-bottom: 10px;
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
                <div class="mt-5 ">
                    <c:if test="${emp == null}">
                    <h2>Add Employee form</h2>
                    </c:if>
                    <c:if test="${emp!= null}">
                    <h2>View details Employee</h2>
                    </c:if>
                    <hr>
                </div>
                <form action="/employee" method="POST" id="addEmployee">
                    <div class="row">
                        <div class="col-md-12">

                            <div class="form-group">
                                <label for="firstName">First Name<span class="text-danger">(*)</span></label>
                                <input type="text" class="form-control" id="firstName" name="firstName" required value="${employee.firstName}">
                            </div>
                            <div class="form-group my-3">
                                <label for="lastName">Last Name<span class="text-danger">(*)</span></label>
                                <input type="text" class="form-control" id="lastName" name="lastName" required value="${employee.lastName}">
                            </div>
                            <div class="form-group my-3">
                                <label for="phoneNumber">Phone Number<span class="text-danger">(*)</span></label>
                                <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" required value="${employee.phone}">
                            </div>
                            <div class="form-group my-3">
                                <label for="dateOfBirth">Date of Birth<span class="text-danger">(*)</span></label>
                                <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" required value="${employee.dateOfBirth}">
                            </div>
                            <div class="form-group my-3">
                                <label>Gender<span class="text-danger">(*)</span></label><br>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" id="optionsRadios1" value="1"
                                        required>
                                    <label class="form-check-label" for="optionsRadios1">Male</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" id="optionsRadios2"
                                        value="0">
                                    <label class="form-check-label" for="optionsRadios2">Female</label>
                                </div>
                            </div>
                            <div class="form-group my-3">
                                <label for="account">Account<span class="text-danger">(*)</span></label>
                                <input type="text" class="form-control" id="account" name="account" value="${employee.account.accountName}" required>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group my-3">
                                <label for="email">Email<span class="text-danger">(*)</span></label>
                                <input type="email" class="form-control" id="email" name="email" value="${employee.account.email}" required>
                            </div>
                            <div class="form-group my-3">
                                <label for="password">Password<span class="text-danger">(*)</span></label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <div class="form-group my-3">
                                <label for="address">Address</label>
                                <textarea class="form-control" id="address" name="address" rows="3" required></textarea>
                            </div>
                            <div class="form-group my-3">
                                <label>Status</label><br>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="status" name="status" checked>
                                    <label class="form-check-label" for="status">Active</label>
                                </div>
                            </div>
                            <div class="form-group my-3">
                                <label for="department">Department<span class="text-danger">(*)</span></label>
                                <select class="form-select" id="department" name="department" required>
                                    <option value="" disabled selected>Select department</option>
                                    <option value="HR">HR</option>
                                    <option value="Finance">Finance</option>
                                    <option value="IT">IT</option>
                                </select>
                            </div>
                            <div class="form-group my-3">
                                <label for="remark">Remark</label>
                                <textarea class="form-control" id="remark" name="remark" rows="3"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="my-3">
                        <button type="button" class="btn btn-info text-white">
                            <a class="fas fa-arrow-left" href="/list"> Back</a>
                        </button>
                        <button type="reset" class="btn btn-warning text-white">
                            <i class="fas fa-sync-alt"></i> Reset
                        </button>
                        <button type="submit" class="btn btn-success">
                            <i class="fas fa-plus"></i> Add
                        </button>
                    </div>
            </div>

            </form>
        </div>
    </div>

</body>

</html>
