package lk.ijse.poultryfarm.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.poultryfarm.dao.CrudDAO;
import lk.ijse.poultryfarm.entity.ChickBatch;

import java.sql.SQLException;

public interface ChickBatchDAO extends CrudDAO<ChickBatch> {
    String getCurrentBatchId() throws SQLException, ClassNotFoundException;
    int getChickTotal(String batchId) throws SQLException, ClassNotFoundException;
    ObservableList<String> getAllBatchIds() throws SQLException, ClassNotFoundException;
}
