package org.example.controller;

import org.example.dao.EmployeeDAO;
import org.example.dao.AccountDAO;
import org.example.dao.impl.EmployeeDAOImpl;
import org.example.dao.impl.AccountDAOImpl;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FormServlet", value = "/form")
public class FormServlet extends HttpServlet {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    private AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/forms.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            List<Integer> employeeIdList = new ArrayList<>();
            List<Integer> accountIdList = new ArrayList<>();

            for (Employee e : employeeDAO.findAll()) {
                employeeIdList.add(e.getEmployeeId());
            }

            for (Account a : accountDAO.findAll()) {
                accountIdList.add(Integer.valueOf(a.getAccountName()));
            }

            Employee employee = new Employee();
            Account account = new Account();


            String employeeId = request.getParameter("employeeId");
            String lastName = request.getParameter("lastName");
            String firstName = request.getParameter("firstName");
            String phone = request.getParameter("phone");
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

            String dateOfBirth = request.getParameter("dateOfBirth");
            String address = request.getParameter("address");
            String departmentName = request.getParameter("departmentName");
            String remark = request.getParameter("remark");

            String accountId = request.getParameter("accountId");
            boolean status = Boolean.parseBoolean(request.getParameter("status"));
            String accountName = request.getParameter("accountName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            boolean condition = !password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$");

            if (condition) {
                request.setAttribute("Error", "Some of data is error");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/tables.jsp");
                requestDispatcher.forward(request, response);
            } else {
                account.setAccountName(accountName);
                account.setEmail(email);
                account.setPassword(password);
                account.setStatus(status);
                account.setEmployee(employee);

                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setPhone(phone);
                employee.setDateOfBirth(LocalDate.parse(dateOfBirth));
                employee.setGender(Integer.parseInt(gender));
                employee.setDepartmentName(departmentName);
                employee.setRemark(remark);
                employee.setAccount(account);

//                accountDAO.save(account);
//                employeeDAO.save(employee);
                response.sendRedirect("/employee-view");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
