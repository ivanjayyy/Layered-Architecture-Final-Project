package lk.ijse.poultryfarm.dao.custom;

import lk.ijse.poultryfarm.dao.CrudDAO;
import lk.ijse.poultryfarm.dto.DailyAttendanceDto;
import lk.ijse.poultryfarm.entity.DailyAttendance;

import java.sql.SQLException;

public interface DailyAttendanceDAO extends CrudDAO<DailyAttendance> {
    int checkAttendance(String date, String employeeId) throws SQLException, ClassNotFoundException;
    int countAttendance(String employeeId, String batchId) throws SQLException, ClassNotFoundException;
}
