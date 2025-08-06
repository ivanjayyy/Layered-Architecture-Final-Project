package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dto.SaleDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SaleBO extends SuperBO {
    boolean saveSale(SaleDto saleDto) throws SQLException, ClassNotFoundException ;
    boolean updateSale(SaleDto saleDto) throws SQLException, ClassNotFoundException ;
    boolean deleteSale(String saleId) throws SQLException, ClassNotFoundException ;
    ArrayList<SaleDto> searchSale(String batchId) throws SQLException, ClassNotFoundException ;
    ArrayList<SaleDto> getAllSale() throws SQLException, ClassNotFoundException ;
    String getNextSaleId() throws SQLException, ClassNotFoundException ;
    int selectedBatchTotalSold(String batchId) throws SQLException, ClassNotFoundException ;
}
