package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.FoodBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.FoodDAO;
import lk.ijse.poultryfarm.dto.FoodConsumptionDto;
import lk.ijse.poultryfarm.dto.FoodDto;
import lk.ijse.poultryfarm.dto.FoodPaymentDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodBOImpl implements FoodBO {
    FoodDAO foodDAO = (FoodDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD);

    @Override
    public boolean updateAfterFoodConsumption(FoodConsumptionDto foodConsumptionDto) throws SQLException, ClassNotFoundException {
        return foodDAO.updateAfterFoodConsumption(foodConsumptionDto);
    }

    @Override
    public boolean updateAfterFoodOrder(FoodPaymentDto foodPaymentDto) throws SQLException, ClassNotFoundException {
        return foodDAO.updateAfterFoodOrder(foodPaymentDto);
    }

    @Override
    public String foodInventory(String foodId) throws SQLException, ClassNotFoundException {
        return foodDAO.foodInventory(foodId);
    }

    @Override
    public String getFoodId(String foodName) throws SQLException, ClassNotFoundException {
        return foodDAO.getFoodId(foodName);
    }

    @Override
    public String getFoodName(String id) throws SQLException, ClassNotFoundException {
        return foodDAO.getFoodName(id);
    }

    @Override
    public ArrayList<FoodDto> getAllFood() throws SQLException, ClassNotFoundException {
        return foodDAO.getAll();
    }

    @Override
    public boolean saveFood(FoodDto billDto) throws SQLException, ClassNotFoundException {
        return foodDAO.save(billDto);
    }

    @Override
    public boolean updateFood(FoodDto employeeDto) throws SQLException, ClassNotFoundException {
        return foodDAO.update(employeeDto);
    }

    @Override
    public boolean deleteFood(String billId) throws SQLException, ClassNotFoundException {
        return foodDAO.delete(billId);
    }

    @Override
    public ArrayList<FoodDto> searchFood(String billVariant) throws SQLException, ClassNotFoundException {
        return foodDAO.search(billVariant);
    }

    @Override
    public String getNextFoodId() throws SQLException, ClassNotFoundException {
        return foodDAO.getNextId();
    }
}
