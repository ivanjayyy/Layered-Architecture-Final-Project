package lk.ijse.poultryfarm.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO{
    boolean save(T billDto) throws SQLException, ClassNotFoundException;
    boolean delete(String billId) throws SQLException, ClassNotFoundException;
    ArrayList<T> search(String billVariant) throws SQLException, ClassNotFoundException;
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    String getNextId() throws SQLException, ClassNotFoundException;
}
