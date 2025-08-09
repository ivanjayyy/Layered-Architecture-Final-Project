package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dto.DailyAttendanceDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DailyAttendanceBO extends SuperBO {
    boolean saveAttendance(DailyAttendanceDto dailyAttendanceDto) throws SQLException, ClassNotFoundException ;
    int countAttendance(String employeeId, String batchId) throws SQLException, ClassNotFoundException ;
    ArrayList<DailyAttendanceDto> searchAttendance(String date) throws SQLException, ClassNotFoundException ;
    ArrayList<DailyAttendanceDto> getAllAttendance() throws SQLException, ClassNotFoundException ;
    String getNextAttendanceId() throws SQLException, ClassNotFoundException ;
    int checkAttendance(String date, String employeeId) throws SQLException, ClassNotFoundException ;
    boolean deleteAttendance(String id) throws SQLException, ClassNotFoundException ;
}
