package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dto.FoodPaymentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FoodPaymentBO extends SuperBO {
    ArrayList<FoodPaymentDto> searchFoodPayment(String foodId) throws SQLException, ClassNotFoundException ;
    ArrayList<FoodPaymentDto> getAllFoodPayment() throws SQLException, ClassNotFoundException ;
    String getNextFoodPaymentId() throws SQLException, ClassNotFoundException ;
    boolean foodPayment(FoodPaymentDto foodPaymentDto) throws SQLException, ClassNotFoundException;
}
