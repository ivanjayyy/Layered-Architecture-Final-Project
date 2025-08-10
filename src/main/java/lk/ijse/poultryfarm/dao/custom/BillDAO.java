package lk.ijse.poultryfarm.dao.custom;

import lk.ijse.poultryfarm.dao.CrudDAO;
import lk.ijse.poultryfarm.entity.Bill;

import java.sql.SQLException;

public interface BillDAO extends CrudDAO<Bill> {
    int billPaidStatus(String batchId, String billType) throws SQLException, ClassNotFoundException;
}
