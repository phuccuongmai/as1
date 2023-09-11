package org.example.controller;

import org.example.dao.EmployeeDAO;
import org.example.dao.AccountDAO;
import org.example.dao.impl.EmployeeDAOImpl;
import org.example.dao.impl.AccountDAOImpl;
import org.example.model.entity.Account;
import org.example.model.entity.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListServlet", value = "/list")
public class ListServlet extends HttpServlet {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList;
        if (request.getParameter("search") != null) {
            employeeList = employeeDAO.findEmpByName(request.getParameter("search"));
            request.setAttribute("employeeList", employeeList);
        } else {
            employeeList = employeeDAO.findAll();
            request.setAttribute("employeeList", employeeList);
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
