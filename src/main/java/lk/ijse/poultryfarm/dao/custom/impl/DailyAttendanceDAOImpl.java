package lk.ijse.poultryfarm.dao.custom.impl;

import lk.ijse.poultryfarm.dao.custom.DailyAttendanceDAO;
import lk.ijse.poultryfarm.dto.DailyAttendanceDto;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.entity.DailyAttendance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DailyAttendanceDAOImpl implements DailyAttendanceDAO {

    @Override
    public ArrayList<DailyAttendance> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(DailyAttendance dailyAttendanceDto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO daily_attendance VALUES (?,?,?,?,?)", dailyAttendanceDto.getBatchId(),dailyAttendanceDto.getAttendanceId(),dailyAttendanceDto.getDate(),dailyAttendanceDto.getEmployeeId(),dailyAttendanceDto.isAttendance());
    }

    @Override
    public boolean update(DailyAttendance dailyAttendance) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public int countAttendance(String employeeId, String batchId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(date) from daily_attendance WHERE batch_id = ? AND employee_id = ? AND attendance = true GROUP BY attendance", batchId,employeeId);
        if(resultSet.next()){
            return resultSet.getInt(1);
        }
        return 0;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT attendance_id FROM daily_attendance ORDER BY attendance_id DESC LIMIT 1");

        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            String lastIdNumberString = lastId.substring(1);
            int lastIdNumber = Integer.parseInt(lastIdNumberString);
            int nextIdNumber = lastIdNumber + 1;
            String nextIdString = String.format("A%03d", nextIdNumber);
            return nextIdString;
        }

        return "A001";
    }

    @Override
    public int checkAttendance(String date, String employeeId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(attendance_id) FROM daily_attendance WHERE date = ? AND employee_id = ? GROUP BY employee_id", date,employeeId);
        if(resultSet.next()){
            return resultSet.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM daily_attendance WHERE attendance_id = ?", id);
    }

    @Override
    public ArrayList<DailyAttendance> search(String billVariant) throws SQLException, ClassNotFoundException {
        return null;
    }
}
