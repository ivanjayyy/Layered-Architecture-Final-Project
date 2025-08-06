package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dto.FoodConsumptionDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FoodConsumptionBO extends SuperBO {
    boolean saveFoodConsumption(FoodConsumptionDto foodConsumptionDto) throws SQLException, ClassNotFoundException ;
    boolean updateFoodConsumption(FoodConsumptionDto employeeDto) throws SQLException, ClassNotFoundException ;
    boolean deleteFoodConsumption(String billId) throws SQLException, ClassNotFoundException ;
    ArrayList<FoodConsumptionDto> searchFoodConsumption(String batchId) throws SQLException, ClassNotFoundException ;
    ArrayList<FoodConsumptionDto> getAllFoodConsumption() throws SQLException, ClassNotFoundException ;
    String getNextFoodConsumptionId() throws SQLException, ClassNotFoundException ;
}
