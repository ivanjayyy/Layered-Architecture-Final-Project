package lk.ijse.poultryfarm.dao.custom.impl;

import lk.ijse.poultryfarm.dao.custom.FoodPaymentDAO;
import lk.ijse.poultryfarm.database.DBConnection;
import lk.ijse.poultryfarm.dto.FoodPaymentDto;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.entity.FoodPayment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodPaymentDAOImpl implements FoodPaymentDAO {

    @Override
    public ArrayList<FoodPayment> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(FoodPayment foodPaymentDto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO food_payment VALUES (?,?,?,?,?)", foodPaymentDto.getFoodPaymentId(),foodPaymentDto.getFoodId(),foodPaymentDto.getQuantity(),foodPaymentDto.getPayAmount(),foodPaymentDto.getDate());
    }

    @Override
    public boolean update(FoodPayment foodPayment) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String billId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<FoodPayment> search(String billVariant) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT food_payment_id FROM food_payment ORDER BY food_payment_id DESC LIMIT 1");

        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            String lastIdNumberString = lastId.substring(1);
            int lastIdNumber = Integer.parseInt(lastIdNumberString);
            int nextIdNumber = lastIdNumber + 1;
            String nextIdString = String.format("P%03d", nextIdNumber);
            return nextIdString;
        }

        return "P001";
    }
}
