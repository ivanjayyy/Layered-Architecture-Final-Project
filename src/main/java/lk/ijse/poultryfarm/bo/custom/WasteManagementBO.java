package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dto.WasteManagementDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface WasteManagementBO extends SuperBO {
    boolean saveWaste(WasteManagementDto wasteManagementDto) throws SQLException, ClassNotFoundException ;
    boolean updateWaste(WasteManagementDto wasteManagementDto) throws SQLException, ClassNotFoundException ;
    boolean deleteWaste(String wasteId) throws SQLException, ClassNotFoundException ;
    ArrayList<WasteManagementDto> searchWaste(String batchId) throws SQLException, ClassNotFoundException ;
    ArrayList<WasteManagementDto> getAllWaste() throws SQLException, ClassNotFoundException ;
    String getNextWasteId() throws SQLException, ClassNotFoundException ;
}
