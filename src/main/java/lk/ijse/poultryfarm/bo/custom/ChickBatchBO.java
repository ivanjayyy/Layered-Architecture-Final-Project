package lk.ijse.poultryfarm.bo.custom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dto.ChickBatchDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ChickBatchBO extends SuperBO {

    boolean saveChickBatch(ChickBatchDto chickBatchDto) throws SQLException, ClassNotFoundException ;
    boolean updateChickBatch(ChickBatchDto employeeDto) throws SQLException, ClassNotFoundException ;
    boolean deleteChickBatch(String billId) throws SQLException, ClassNotFoundException ;
    ArrayList<ChickBatchDto> searchChickBatch(String batchId) throws SQLException, ClassNotFoundException ;
    ArrayList<ChickBatchDto> getAllChickBatches() throws SQLException, ClassNotFoundException ;
    String getNextChickBatchId() throws SQLException, ClassNotFoundException ;
    String getCurrentBatchId() throws SQLException, ClassNotFoundException ;
    int getChickTotal(String batchId) throws SQLException, ClassNotFoundException ;
    ObservableList<String> getAllBatchIds() throws SQLException, ClassNotFoundException ;
}
