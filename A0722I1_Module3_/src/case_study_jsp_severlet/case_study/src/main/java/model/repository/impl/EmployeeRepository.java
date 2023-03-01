package model.repository.impl;

import model.person.Employee;
import model.repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
        private static final String ALL_EMPLOYEE = "select * from furama.employee;";

    @Override
    public List<Employee> showListEmployee() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> employeeList = new ArrayList<>();
        if (connection!=null){
            try {
                statement = connection.prepareStatement(ALL_EMPLOYEE);
                resultSet = statement.executeQuery();
                Employee employee = null;

                while (resultSet!=null){
                    int id = resultSet.getInt("employee_id");
                    String name = resultSet.getString("employee_name");
                    String birthday = resultSet.getString("employee_birthday");
                    String id_card = resultSet.getString("employee_id_card");
                    double salary = resultSet.getDouble("employee_salary");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");

                    employee = new Employee(id,name,birthday,id_card,phone,email,address);

                    employeeList.add(employee);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return employeeList;
    }

}
