<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOG IN</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />


    <style>
        .main {
            margin: 0 auto;
        }

        .input-container {
            display: flex;
            align-items: center;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .input-container i {
            font-size: 18px;
            margin-right: 20px;
            color: #aaa;
        }

        .input-container .form-control {
            border: none;
            background-color: transparent;
            flex: 1;
            outline: none;
            padding: 0;
        }

        .input-container .form-control:focus {
            box-shadow: none;
            border: none;
        }

        .input-container .btn {
            width: 100%;

        }

        a{
            color: #aaa;
        text-decoration: none;
        }

        a:hover {
        color: blue;
        text-decoration: underline;
    }

    </style>
</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-12 mt-5">
                <h2 class="text-center">Member Login</h2>
            </div>
            <div class="main col-md-6 mt-3">
                <div class="card">
                    <div class="card-body">
                         <c:if test="${showError != null}">
                            <p class="text-danger">${showError}</p>
                        </c:if>

                        <div id="errorMessage" style="color: red;"></div>

                        <form id="loginForm" action="/login" method="POST">
                            <div class="form-group">
                                <div class="input-container mb-3" style="padding: 10px;">
                                    <i class="fas fa-user"></i>
                                    <input type="text" class="form-control ${usernameError != null ? 'is-invalid' : ''}" name="username" placeholder="Username">
                                </div>
                                 <c:if test="${usernameError != null}">
                                    <p class="text-danger">${usernameError}</p>
                                </c:if>
                            </div>

                            <div class="form-group">
                                <div class="input-container mb-3" style="padding: 10px;">
                                    <i class="fas fa-lock"></i>
                                    <input type="password" class="form-control ${passwordError != null ? 'is-invalid' : ''}" name="password" placeholder="Password">
                                </div>
                                 <c:if test="${passwordError != null}">
                                    <p class="text-danger">${passwordError}</p>
                                </c:if>
                            </div>

                            <div class="input-container mb-5">
                                <button type="submit" class="btn btn-success">Login</button>
                            </div>
                            <div class="text-center">
                                <a href="">Forgot Password?</a> <br>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>

<script>
   // JavaScript validation logic here
   document.getElementById("loginForm").onsubmit = function() {
       var username = document.getElementById("username").value;
       var password = document.getElementById("password").value;

      if (username === "" || password === "") {
          errorMessage.innerHTML = "Please enter your username and password!";
          return false; // ngăn form submit
      } else {
         errorMessage.innerHTML = "";
      }
   };
</script>

</body>
</html>
