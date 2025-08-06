package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.DailyAttendanceBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.DailyAttendanceDAO;
import lk.ijse.poultryfarm.dto.DailyAttendanceDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DailyAttendanceBOImpl implements DailyAttendanceBO {
    DailyAttendanceDAO dailyAttendanceDAO = (DailyAttendanceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DAILY_ATTENDANCE);

    @Override
    public boolean saveAttendance(DailyAttendanceDto dailyAttendanceDto) throws SQLException, ClassNotFoundException {
        return dailyAttendanceDAO.save(dailyAttendanceDto);
    }

    @Override
    public boolean updateAttendance(DailyAttendanceDto employeeDto) throws SQLException, ClassNotFoundException {
        return dailyAttendanceDAO.update(employeeDto);
    }

    @Override
    public int countAttendance(String employeeId, String batchId) throws SQLException, ClassNotFoundException {
        return dailyAttendanceDAO.countAttendance(employeeId, batchId);
    }

    @Override
    public ArrayList<DailyAttendanceDto> searchAttendance(String date) throws SQLException, ClassNotFoundException {
        return dailyAttendanceDAO.search(date);
    }

    @Override
    public ArrayList<DailyAttendanceDto> getAllAttendance() throws SQLException, ClassNotFoundException {
        return dailyAttendanceDAO.getAll();
    }

    @Override
    public String getNextAttendanceId() throws SQLException, ClassNotFoundException {
        return dailyAttendanceDAO.getNextId();
    }

    @Override
    public int checkAttendance(String date, String employeeId) throws SQLException, ClassNotFoundException {
        return dailyAttendanceDAO.checkAttendance(date, employeeId);
    }

    @Override
    public boolean deleteAttendance(String id) throws SQLException, ClassNotFoundException {
        return dailyAttendanceDAO.delete(id);
    }
}
