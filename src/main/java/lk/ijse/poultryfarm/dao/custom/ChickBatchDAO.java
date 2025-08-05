package lk.ijse.poultryfarm.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.poultryfarm.dao.CrudDAO;
import lk.ijse.poultryfarm.dto.ChickBatchDto;

import java.sql.SQLException;

public interface ChickBatchDAO extends CrudDAO<ChickBatchDto> {
    String getCurrentBatchId() throws SQLException, ClassNotFoundException;
    int getChickTotal(String batchId) throws SQLException, ClassNotFoundException;
    ObservableList<String> getAllBatchIds() throws SQLException, ClassNotFoundException;
}
