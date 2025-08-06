package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dto.ChickStatusDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ChickStatusBO extends SuperBO {
    boolean saveChickStatus(ChickStatusDto chickStatusDto) throws SQLException, ClassNotFoundException ;
    boolean updateChickStatus(ChickStatusDto employeeDto) throws SQLException, ClassNotFoundException ;
    boolean deleteChickStatus(String chickStatusId) throws SQLException, ClassNotFoundException ;
    int selectedBatchChickDeaths(String batchId) throws SQLException, ClassNotFoundException ;
    ArrayList<ChickStatusDto> searchChickStatus(String batchId) throws SQLException, ClassNotFoundException ;
    ArrayList<ChickStatusDto> getAllChickStatus() throws SQLException, ClassNotFoundException ;
    String getNextChickStatusId() throws SQLException, ClassNotFoundException ;
    int checkStatus(String date, String batchId) throws SQLException, ClassNotFoundException ;
}
