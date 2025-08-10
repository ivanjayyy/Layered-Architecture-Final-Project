package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;

import java.sql.SQLException;

public interface FoodBO extends SuperBO {
    String foodInventory(String foodId) throws SQLException, ClassNotFoundException ;
    String getFoodName(String id) throws SQLException, ClassNotFoundException ;
    String getFoodId(String foodName) throws SQLException, ClassNotFoundException;
}
