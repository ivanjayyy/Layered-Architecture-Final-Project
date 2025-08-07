package lk.ijse.poultryfarm.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.poultryfarm.dao.CrudDAO;
import lk.ijse.poultryfarm.dto.EmployeeDto;
import lk.ijse.poultryfarm.entity.Employee;

import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<Employee> {
    double getDailyWage(String employeeId) throws SQLException, ClassNotFoundException;
    ObservableList<String> getAllEmployeeNames() throws SQLException, ClassNotFoundException;
    String getEmployeeId(String name) throws SQLException, ClassNotFoundException;
    int checkContactDuplicate(String contact) throws SQLException, ClassNotFoundException;
}
