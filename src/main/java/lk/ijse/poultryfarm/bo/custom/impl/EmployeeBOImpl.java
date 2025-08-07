package lk.ijse.poultryfarm.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.poultryfarm.bo.custom.EmployeeBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.EmployeeDAO;
import lk.ijse.poultryfarm.dto.EmployeeDto;
import lk.ijse.poultryfarm.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean saveEmployee(EmployeeDto employeeDto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(employeeDto.getEmployeeId(),employeeDto.getName(),employeeDto.getFullTime(),employeeDto.getContact(),employeeDto.getDailyWage()));
    }

    @Override
    public boolean updateEmployee(EmployeeDto employeeDto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(employeeDto.getEmployeeId(),employeeDto.getName(),employeeDto.getFullTime(),employeeDto.getContact(),employeeDto.getDailyWage()));
    }

    @Override
    public boolean deleteEmployee(String billId) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(billId);
    }

    @Override
    public double getDailyWage(String employeeId) throws SQLException, ClassNotFoundException {
        return employeeDAO.getDailyWage(employeeId);
    }

    @Override
    public ArrayList<EmployeeDto> searchEmployee(String fullTime) throws SQLException, ClassNotFoundException {
        ArrayList<Employee> entity = employeeDAO.search(fullTime);
        ArrayList<EmployeeDto> dto = new ArrayList<>();
        for (Employee entity1 : entity) {
            dto.add(new EmployeeDto(entity1.getEmployeeId(),entity1.getName(),entity1.getFullTime(),entity1.getContact(),entity1.getDailyWage()));
        }
        return dto;
    }

    @Override
    public ArrayList<EmployeeDto> getAllEmployees() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> entity = employeeDAO.getAll();
        ArrayList<EmployeeDto> dto = new ArrayList<>();
        for (Employee entity1 : entity) {
            dto.add(new EmployeeDto(entity1.getEmployeeId(),entity1.getName(),entity1.getFullTime(),entity1.getContact(),entity1.getDailyWage()));
        }
        return dto;
    }

    @Override
    public String getNextEmployeeId() throws SQLException, ClassNotFoundException {
        return employeeDAO.getNextId();
    }

    @Override
    public ObservableList<String> getAllEmployeeNames() throws SQLException, ClassNotFoundException {
        return employeeDAO.getAllEmployeeNames();
    }

    @Override
    public String getEmployeeId(String name) throws SQLException, ClassNotFoundException {
        return employeeDAO.getEmployeeId(name);
    }

    @Override
    public int checkContactDuplicate(String contact) throws SQLException, ClassNotFoundException {
        return employeeDAO.checkContactDuplicate(contact);
    }
}
