package lk.ijse.poultryfarm.dao.custom;

import lk.ijse.poultryfarm.dao.CrudDAO;
import lk.ijse.poultryfarm.dto.SaleDto;
import lk.ijse.poultryfarm.entity.Sale;

import java.sql.SQLException;

public interface SaleDAO extends CrudDAO<Sale> {
    int selectedBatchTotalSold(String batchId) throws SQLException, ClassNotFoundException;
}
