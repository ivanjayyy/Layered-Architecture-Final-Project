package lk.ijse.poultryfarm.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.poultryfarm.dao.custom.EmployeeDAO;
import lk.ijse.poultryfarm.dto.EmployeeDto;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public boolean save(Employee employeeDto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee VALUES (?,?,?,?,?)", employeeDto.getEmployeeId(),employeeDto.getName(),employeeDto.getFullTime(),employeeDto.getContact(),employeeDto.getDailyWage());
    }

    @Override
    public boolean update(Employee employeeDto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET name = ?, full_time = ?, contact = ?, daily_wage = ? WHERE employee_id = ?", employeeDto.getName(),employeeDto.getFullTime(),employeeDto.getContact(),employeeDto.getDailyWage(),employeeDto.getEmployeeId());
    }

    @Override
    public boolean delete(String billId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public double getDailyWage(String employeeId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT daily_wage from employee WHERE employee_id = ?", employeeId);
        if(resultSet.next()){
            return resultSet.getDouble(1);
        }
        return 0;
    }

    @Override
    public ArrayList<Employee> search(String fullTime) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee WHERE full_time = ?", fullTime);

        ArrayList<Employee> employeeDtos = new ArrayList<>();

        while (resultSet.next()) {
            Employee employeeDto = new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5)
            );
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee");

        ArrayList<Employee> employeeDtos = new ArrayList<>();

        while (resultSet.next()) {
            Employee employeeDto = new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5)
            );
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT employee_id FROM employee ORDER BY employee_id DESC LIMIT 1");

        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            String lastIdNumberString = lastId.substring(1);
            int lastIdNumber = Integer.parseInt(lastIdNumberString);
            int nextIdNumber = lastIdNumber + 1;
            String nextIdString = String.format("E%03d", nextIdNumber);
            return nextIdString;
        }

        return "E001";
    }

    @Override
    public ObservableList<String> getAllEmployeeNames() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT name FROM employee");
        ArrayList<String> list = new ArrayList<>();
        while (rst.next()) {
            String id = rst.getString(1);
            list.add(id);
        }

        ObservableList<String> employeeNames = FXCollections.observableArrayList();
        employeeNames.addAll(list);
        return employeeNames;
    }

    @Override
    public String getEmployeeId(String name) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT employee_id FROM employee WHERE name = ?", name);
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public int checkContactDuplicate(String contact) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(employee_id) FROM employee WHERE contact = ?", contact);
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
}
