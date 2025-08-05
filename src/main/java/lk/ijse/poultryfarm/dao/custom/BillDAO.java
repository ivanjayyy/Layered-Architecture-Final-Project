package lk.ijse.poultryfarm.dao.custom;

import lk.ijse.poultryfarm.dao.CrudDAO;
import lk.ijse.poultryfarm.dto.BillDto;

import java.sql.SQLException;

public interface BillDAO extends CrudDAO<BillDto> {
    int billPaidStatus(String batchId, String billType) throws SQLException, ClassNotFoundException;
}
