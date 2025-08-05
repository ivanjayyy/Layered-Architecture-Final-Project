package lk.ijse.poultryfarm.dao.custom;

import lk.ijse.poultryfarm.dao.CrudDAO;
import lk.ijse.poultryfarm.dto.DailyAttendanceDto;

import java.sql.SQLException;

public interface DailyAttendanceDAO extends CrudDAO<DailyAttendanceDto> {
    int checkAttendance(String date, String employeeId) throws SQLException, ClassNotFoundException;
    int countAttendance(String employeeId, String batchId) throws SQLException, ClassNotFoundException;
}
