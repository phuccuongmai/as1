package org.example.controller;

import org.example.dao.AccountDAO;
import org.example.dao.EmployeeDAO;
import org.example.dao.impl.AccountDAOImpl;
import org.example.dao.impl.EmployeeDAOImpl;
import org.example.model.entity.Account;
import org.example.model.entity.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {

    private EmployeeDAO employeeDao = new EmployeeDAOImpl();
    private AccountDAO accountDao = new AccountDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("view") != null) {
            request.setAttribute("employee", employeeDao.findById(Integer.parseInt(request.getParameter("view"))));
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/form.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
        Account account = new Account();

        String employeeId = request.getParameter("employee-id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phoneNumber");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String gender = "";
        if (request.getParameter("gender") != null) {
            if (request.getParameter("gender").equals("1")) {
                gender = request.getParameter("gender");
            } else if (request.getParameter("gender").equals("0")) {
                gender = request.getParameter("gender");
            } else {
                gender = request.getParameter("gender");
            }
        }
        String address = request.getParameter("address");
        String departmentName = request.getParameter("department");
        String remark = request.getParameter("remark");

        String accountId = request.getParameter("accountId");
        String status = request.getParameter("status");
        String accountName = request.getParameter("account");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

//        if (employeeId != null) {
//            employee = employeeDao.findById(Integer.parseInt(employeeId));
//            account = employee.getAccount();
//        } else {
//            request.setAttribute("Error", "Employee Id cannot be null");
//            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/list.jsp");
//            requestDispatcher.forward(request, response);
//        }

//        boolean condition = !password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$");

//        if (condition) {
//            request.setAttribute("Error", "Some of data is error");
//            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/list.jsp");
//            requestDispatcher.forward(request, response);
//        } else {
            account.setAccountName(accountName);
            account.setStatus(Boolean.parseBoolean(status));
            account.setEmail(email);
            account.setPassword(password);

            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setPhone(phone);
            employee.setDateOfBirth(LocalDate.parse(dateOfBirth));
            employee.setGender(Integer.parseInt(gender));
            employee.setAddress(address);
            employee.setDepartmentName(departmentName);
            employee.setRemark(remark);

            employeeDao.save(employee, account);
            response.sendRedirect("/list");
//        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deletedId = req.getParameter("deletedId");
        if (deletedId != null) {
            employeeDao.deleteEmployeeById(Integer.parseInt(deletedId));
            resp.sendRedirect("/employee");
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/list.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
