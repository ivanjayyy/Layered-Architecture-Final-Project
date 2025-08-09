package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.FoodBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.custom.FoodDAO;
import lk.ijse.poultryfarm.dto.FoodConsumptionDto;
import lk.ijse.poultryfarm.dto.FoodDto;
import lk.ijse.poultryfarm.dto.FoodPaymentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class FoodBOImpl implements FoodBO {
    FoodDAO foodDAO = (FoodDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD);

    @Override
    public String foodInventory(String foodId) throws SQLException, ClassNotFoundException {
        return foodDAO.foodInventory(foodId);
    }

    @Override
    public String getFoodName(String id) throws SQLException, ClassNotFoundException {
        return foodDAO.getFoodName(id);
    }
}
