package lk.ijse.poultryfarm.dao;

import lk.ijse.poultryfarm.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO{
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    boolean save(T billDto) throws SQLException, ClassNotFoundException;
    boolean update(T employeeDto) throws SQLException, ClassNotFoundException;
    boolean delete(String billId) throws SQLException, ClassNotFoundException;
    ArrayList<T> search(String billVariant) throws SQLException, ClassNotFoundException;
    String getNextId() throws SQLException, ClassNotFoundException;
}
