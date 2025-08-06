package lk.ijse.poultryfarm.dao.custom;

import lk.ijse.poultryfarm.dao.CrudDAO;
import lk.ijse.poultryfarm.dto.FoodConsumptionDto;
import lk.ijse.poultryfarm.dto.FoodDto;
import lk.ijse.poultryfarm.dto.FoodPaymentDto;

import java.sql.SQLException;

public interface FoodDAO extends CrudDAO<FoodDto> {
    boolean updateAfterFoodConsumption(FoodConsumptionDto foodConsumptionDto) throws SQLException, ClassNotFoundException;
    boolean updateAfterFoodOrder(FoodPaymentDto foodPaymentDto) throws SQLException, ClassNotFoundException;
    String foodInventory(String foodId) throws SQLException, ClassNotFoundException;
    String getFoodId(String foodName) throws SQLException, ClassNotFoundException;
    String getFoodName(String id) throws SQLException, ClassNotFoundException;
}
