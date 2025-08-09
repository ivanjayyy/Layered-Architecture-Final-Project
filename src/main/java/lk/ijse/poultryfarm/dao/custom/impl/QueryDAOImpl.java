package lk.ijse.poultryfarm.dao.custom.impl;

import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.QueryDAO;
import lk.ijse.poultryfarm.entity.DailyAttendance;
import lk.ijse.poultryfarm.entity.FoodConsumption;
import lk.ijse.poultryfarm.entity.FoodPayment;
import lk.ijse.poultryfarm.entity.Salary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<DailyAttendance> attendanceSearch(String date) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT da.batch_id, da.attendance_id, da.date, e.name, da.attendance FROM daily_attendance da JOIN employee e ON da.employee_id = e.employee_id WHERE da.date = ? ORDER BY da.attendance_id DESC", date);
        ArrayList<DailyAttendance> dailyAttendanceDtos = new ArrayList<>();

        while (resultSet.next()) {
            DailyAttendance dailyAttendanceDto = new DailyAttendance(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getBoolean(5)
            );
            dailyAttendanceDtos.add(dailyAttendanceDto);
        }
        return dailyAttendanceDtos;
    }

    @Override
    public ArrayList<DailyAttendance> attendanceGetAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT da.batch_id, da.attendance_id, da.date, e.name, da.attendance FROM daily_attendance da JOIN employee e ON da.employee_id = e.employee_id ORDER BY da.attendance_id DESC");

        ArrayList<DailyAttendance> dailyAttendanceDtos = new ArrayList<>();

        while (resultSet.next()) {
            DailyAttendance dailyAttendanceDto = new DailyAttendance(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getBoolean(5)
            );
            dailyAttendanceDtos.add(dailyAttendanceDto);
        }
        return dailyAttendanceDtos;
    }

    @Override
    public ArrayList<FoodConsumption> consumptionSearch(String batchId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select fc.batch_id,fc.consumption_id,fc.date,f.food_name,fc.consumption from food_consumption fc join food f on fc.food_id = f.food_id WHERE fc.batch_id = ? order by fc.consumption_id desc", batchId);
        ArrayList<FoodConsumption> foodConsumptionDtos = new ArrayList<>();

        while (resultSet.next()) {
            FoodConsumption foodConsumptionDto = new FoodConsumption(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5)
            );
            foodConsumptionDtos.add(foodConsumptionDto);
        }
        return foodConsumptionDtos;
    }

    @Override
    public ArrayList<FoodConsumption> consumptionGetAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select fc.batch_id,fc.consumption_id,fc.date,f.food_name,fc.consumption from food_consumption fc join food f on fc.food_id = f.food_id order by fc.consumption_id desc");

        ArrayList<FoodConsumption> foodConsumptionDtos = new ArrayList<>();

        while (resultSet.next()) {
            FoodConsumption foodConsumptionDto = new FoodConsumption(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5)
            );
            foodConsumptionDtos.add(foodConsumptionDto);
        }
        return foodConsumptionDtos;
    }

    @Override
    public ArrayList<FoodPayment> paymentSearch(String foodId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select fp.food_payment_id,f.food_name,fp.quantity,fp.pay_amount,fp.date from food_payment fp join food f on fp.food_id = f.food_id WHERE fp.food_id = ? order by fp.food_payment_id desc", foodId);
        ArrayList<FoodPayment> foodPaymentDtos = new ArrayList<>();

        while (resultSet.next()) {
            FoodPayment foodPaymentDto = new FoodPayment(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5)
            );
            foodPaymentDtos.add(foodPaymentDto);
        }
        return foodPaymentDtos;
    }

    @Override
    public ArrayList<FoodPayment> paymentGetAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select fp.food_payment_id,f.food_name,fp.quantity,fp.pay_amount,fp.date from food_payment fp join food f on fp.food_id = f.food_id order by fp.food_payment_id desc");

        ArrayList<FoodPayment> foodPaymentDtos = new ArrayList<>();

        while (resultSet.next()) {
            FoodPayment foodPaymentDto = new FoodPayment(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5)
            );
            foodPaymentDtos.add(foodPaymentDto);
        }
        return foodPaymentDtos;
    }

    @Override
    public ArrayList<Salary> salarySearch(String employeeId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT s.salary_id,e.name,s.amount,s.date from salary s join employee e on s.employee_id = e.employee_id WHERE s.employee_id = ? order by s.salary_id desc", employeeId);
        ArrayList<Salary> salaryDtos = new ArrayList<>();

        while (resultSet.next()) {
            Salary salaryDto = new Salary(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4)
            );
            salaryDtos.add(salaryDto);
        }
        return salaryDtos;
    }

    @Override
    public ArrayList<Salary> salaryGetAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT s.salary_id,e.name,s.amount,s.date from salary s join employee e on s.employee_id = e.employee_id order by s.salary_id desc");

        ArrayList<Salary> salaryDtos = new ArrayList<>();

        while (resultSet.next()) {
            Salary salaryDto = new Salary(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4)
            );
            salaryDtos.add(salaryDto);
        }
        return salaryDtos;
    }
}
