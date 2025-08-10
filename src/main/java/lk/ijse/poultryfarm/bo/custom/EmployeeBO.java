package lk.ijse.poultryfarm.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
    boolean saveEmployee(EmployeeDto employeeDto) throws SQLException, ClassNotFoundException ;
    boolean updateEmployee(EmployeeDto employeeDto) throws SQLException, ClassNotFoundException ;
    double getDailyWage(String employeeId) throws SQLException, ClassNotFoundException ;
    ArrayList<EmployeeDto> searchEmployee(String fullTime) throws SQLException, ClassNotFoundException ;
    ArrayList<EmployeeDto> getAllEmployees() throws SQLException, ClassNotFoundException ;
    String getNextEmployeeId() throws SQLException, ClassNotFoundException ;
    String getEmployeeId(String name) throws SQLException, ClassNotFoundException ;
    int checkContactDuplicate(String contact) throws SQLException, ClassNotFoundException ;
    ObservableList<String> getAllEmployeeNames() throws SQLException, ClassNotFoundException ;
    }
