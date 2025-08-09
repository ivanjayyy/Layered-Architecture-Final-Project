package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dto.FoodConsumptionDto;
import lk.ijse.poultryfarm.dto.FoodDto;
import lk.ijse.poultryfarm.dto.FoodPaymentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FoodBO extends SuperBO {
    String foodInventory(String foodId) throws SQLException, ClassNotFoundException ;
    String getFoodName(String id) throws SQLException, ClassNotFoundException ;
}
