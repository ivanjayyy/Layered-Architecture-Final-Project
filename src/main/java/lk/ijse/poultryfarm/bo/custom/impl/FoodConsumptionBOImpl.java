package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.FoodConsumptionBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.FoodConsumptionDAO;
import lk.ijse.poultryfarm.dao.custom.impl.FoodDAOImpl;
import lk.ijse.poultryfarm.database.DBConnection;
import lk.ijse.poultryfarm.dto.FoodConsumptionDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodConsumptionBOImpl implements FoodConsumptionBO {
    FoodConsumptionDAO foodConsumptionDAO = (FoodConsumptionDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD_CONSUMPTION);

    @Override
    public boolean saveFoodConsumption(FoodConsumptionDto foodConsumptionDto) throws SQLException, ClassNotFoundException {
        return foodConsumptionDAO.save(foodConsumptionDto);
    }

    @Override
    public boolean updateFoodConsumption(FoodConsumptionDto employeeDto) throws SQLException, ClassNotFoundException {
        return foodConsumptionDAO.update(employeeDto);
    }

    @Override
    public boolean deleteFoodConsumption(String billId) throws SQLException, ClassNotFoundException {
        return foodConsumptionDAO.delete(billId);
    }

    @Override
    public ArrayList<FoodConsumptionDto> searchFoodConsumption(String batchId) throws SQLException, ClassNotFoundException {
        return foodConsumptionDAO.search(batchId);
    }

    @Override
    public ArrayList<FoodConsumptionDto> getAllFoodConsumption() throws SQLException, ClassNotFoundException {
        return foodConsumptionDAO.getAll();
    }

    @Override
    public String getNextFoodConsumptionId() throws SQLException, ClassNotFoundException {
        return foodConsumptionDAO.getNextId();
    }
}
