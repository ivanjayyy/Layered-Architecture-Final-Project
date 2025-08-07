package lk.ijse.poultryfarm.dao.custom;

import lk.ijse.poultryfarm.dao.CrudDAO;
import lk.ijse.poultryfarm.dto.ChickStatusDto;
import lk.ijse.poultryfarm.entity.ChickStatus;

import java.sql.SQLException;

public interface ChickStatusDAO extends CrudDAO<ChickStatus> {
    int selectedBatchChickDeaths(String batchId) throws SQLException, ClassNotFoundException;
    int checkStatus(String date, String batchId) throws SQLException, ClassNotFoundException;
}
