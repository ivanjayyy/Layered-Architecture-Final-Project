package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.impl.FoodDAOImpl;
import lk.ijse.poultryfarm.database.DBConnection;
import lk.ijse.poultryfarm.dto.FoodPaymentDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FoodPaymentBO extends SuperBO {
    ArrayList<FoodPaymentDto> searchFoodPayment(String foodId) throws SQLException, ClassNotFoundException ;
    ArrayList<FoodPaymentDto> getAllFoodPayment() throws SQLException, ClassNotFoundException ;
    String getNextFoodPaymentId() throws SQLException, ClassNotFoundException ;
    boolean foodPayment(FoodPaymentDto foodPaymentDto) throws SQLException, ClassNotFoundException;
}
