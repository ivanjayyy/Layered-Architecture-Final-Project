package lk.ijse.poultryfarm.dao.custom;

import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.SuperDAO;
import lk.ijse.poultryfarm.entity.DailyAttendance;
import lk.ijse.poultryfarm.entity.FoodConsumption;
import lk.ijse.poultryfarm.entity.FoodPayment;
import lk.ijse.poultryfarm.entity.Salary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<DailyAttendance> attendanceSearch(String date) throws SQLException, ClassNotFoundException ;
    ArrayList<DailyAttendance> attendanceGetAll() throws SQLException, ClassNotFoundException ;
    ArrayList<FoodConsumption> consumptionSearch(String batchId) throws SQLException, ClassNotFoundException ;
    ArrayList<FoodConsumption> consumptionGetAll() throws SQLException, ClassNotFoundException ;
    ArrayList<FoodPayment> paymentSearch(String foodId) throws SQLException, ClassNotFoundException ;
    ArrayList<FoodPayment> paymentGetAll() throws SQLException, ClassNotFoundException ;
    ArrayList<Salary> salarySearch(String employeeId) throws SQLException, ClassNotFoundException ;
    ArrayList<Salary> salaryGetAll() throws SQLException, ClassNotFoundException ;
}
