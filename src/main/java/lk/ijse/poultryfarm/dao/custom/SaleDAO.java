package lk.ijse.poultryfarm.dao.custom;

import lk.ijse.poultryfarm.dao.CrudDAO;
import lk.ijse.poultryfarm.dto.SaleDto;

import java.sql.SQLException;

public interface SaleDAO extends CrudDAO<SaleDto> {
    int selectedBatchTotalSold(String batchId) throws SQLException, ClassNotFoundException;
}
