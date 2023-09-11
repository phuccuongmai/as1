package org.example.controller;

import org.example.dao.AccountDAO;
import org.example.dao.impl.AccountDAOImpl;
import org.example.model.entity.Account;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String usernameError = null, passwordError = null, showError = null;

        if (username == null || username.equalsIgnoreCase("")) {
            usernameError = "Please enter Username!";
        }

        if (password == null || password.equalsIgnoreCase("")) {
            passwordError = "Please enter Password!";
        }

        request.setAttribute("username", username);
        request.setAttribute("password", "");

        if (usernameError != null || passwordError != null) {
            request.setAttribute("usernameError", usernameError);
            request.setAttribute("passwordError", passwordError);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        } else {
            Account account  = accountDAO.findByUserName(username);

            if (account == null) {
                showError = "The Username or Password is Incorrect!";
            } else {
//                boolean isValid = BCrypt.checkpw(password, user.getPassword());
                boolean isValid = password.equalsIgnoreCase(account.getPassword());
                if (!isValid) {
                    showError = "The Username or Password is Incorrect!";
                }
            }

            if (showError == null) {
                HttpSession session = request.getSession();
                session.setAttribute("userLogin", account);
                session.setAttribute("user", username);

                session.setMaxInactiveInterval(300); // Thời gian timeout là 300 giây

                response.sendRedirect("/list");

                // when the browser has disabled cookies
//                response.sendRedirect(response.encodeRedirectURL("/product/list"));
            } else {
                request.setAttribute("showError", showError);
                request.setAttribute("usernameError", null);
                request.setAttribute("passwordError", null);

                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }

}
