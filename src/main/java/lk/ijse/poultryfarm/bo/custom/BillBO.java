package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dto.BillDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BillBO extends SuperBO {
    boolean saveBill(BillDto billDto) throws SQLException, ClassNotFoundException ;
    boolean updateBill(BillDto employeeDto) throws SQLException, ClassNotFoundException ;
    boolean deleteBill(String billId) throws SQLException, ClassNotFoundException ;
    ArrayList<BillDto> searchBill(String billVariant) throws SQLException, ClassNotFoundException ;
    ArrayList<BillDto> getAllBills() throws SQLException, ClassNotFoundException ;
    String getNextBillId() throws SQLException, ClassNotFoundException ;
    int billPaidStatus(String batchId, String billType) throws SQLException, ClassNotFoundException ;

}
