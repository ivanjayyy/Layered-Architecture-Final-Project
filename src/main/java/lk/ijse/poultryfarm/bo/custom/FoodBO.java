package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dto.FoodConsumptionDto;
import lk.ijse.poultryfarm.dto.FoodDto;
import lk.ijse.poultryfarm.dto.FoodPaymentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FoodBO extends SuperBO {
    boolean updateAfterFoodConsumption(FoodConsumptionDto foodConsumptionDto) throws SQLException, ClassNotFoundException ;
    boolean updateAfterFoodOrder(FoodPaymentDto foodPaymentDto) throws SQLException, ClassNotFoundException ;
    String foodInventory(String foodId) throws SQLException, ClassNotFoundException ;
    String getFoodId(String foodName) throws SQLException, ClassNotFoundException ;
    String getFoodName(String id) throws SQLException, ClassNotFoundException ;
    ArrayList<FoodDto> getAllFood() throws SQLException, ClassNotFoundException ;
    boolean saveFood(FoodDto billDto) throws SQLException, ClassNotFoundException ;
    boolean updateFood(FoodDto employeeDto) throws SQLException, ClassNotFoundException ;
    boolean deleteFood(String billId) throws SQLException, ClassNotFoundException ;
    ArrayList<FoodDto> searchFood(String billVariant) throws SQLException, ClassNotFoundException ;
    String getNextFoodId() throws SQLException, ClassNotFoundException ;
}
