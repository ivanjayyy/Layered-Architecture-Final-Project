package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.FoodPaymentBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.FoodPaymentDAO;
import lk.ijse.poultryfarm.dao.custom.impl.FoodDAOImpl;
import lk.ijse.poultryfarm.database.DBConnection;
import lk.ijse.poultryfarm.dto.FoodPaymentDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodPaymentBOImpl implements FoodPaymentBO {
    FoodPaymentDAO foodPaymentDAO = (FoodPaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD_PAYMENT);

    @Override
    public boolean saveFoodPayment(FoodPaymentDto foodPaymentDto) throws SQLException, ClassNotFoundException {
        return foodPaymentDAO.save(foodPaymentDto);
    }

    @Override
    public boolean updateFoodPayment(FoodPaymentDto employeeDto) throws SQLException, ClassNotFoundException {
        return foodPaymentDAO.update(employeeDto);
    }

    @Override
    public boolean deleteFoodPayment(String billId) throws SQLException, ClassNotFoundException {
        return foodPaymentDAO.delete(billId);
    }

    @Override
    public ArrayList<FoodPaymentDto> searchFoodPayment(String foodId) throws SQLException, ClassNotFoundException {
        return foodPaymentDAO.search(foodId);
    }

    @Override
    public ArrayList<FoodPaymentDto> getAllFoodPayment() throws SQLException, ClassNotFoundException {
        return foodPaymentDAO.getAll();
    }

    @Override
    public String getNextFoodPaymentId() throws SQLException, ClassNotFoundException {
        return foodPaymentDAO.getNextId();
    }
}
