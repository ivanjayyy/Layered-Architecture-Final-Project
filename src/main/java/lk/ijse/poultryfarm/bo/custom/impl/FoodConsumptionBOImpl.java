package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.FoodConsumptionBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.custom.FoodConsumptionDAO;
import lk.ijse.poultryfarm.dao.custom.FoodDAO;
import lk.ijse.poultryfarm.dao.custom.QueryDAO;
import lk.ijse.poultryfarm.dao.custom.impl.FoodDAOImpl;
import lk.ijse.poultryfarm.database.DBConnection;
import lk.ijse.poultryfarm.dto.FoodConsumptionDto;
import lk.ijse.poultryfarm.entity.FoodConsumption;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodConsumptionBOImpl implements FoodConsumptionBO {
    FoodConsumptionDAO foodConsumptionDAO = (FoodConsumptionDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD_CONSUMPTION);
    FoodDAO foodDAO = (FoodDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public boolean foodConsumption(FoodConsumptionDto foodConsumptionDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            boolean isSaved = foodConsumptionDAO.save(new FoodConsumption(foodConsumptionDto.getBatchId(),foodConsumptionDto.getConsumptionId(),foodConsumptionDto.getDate(),foodConsumptionDto.getFoodId(),foodConsumptionDto.getConsumption()));

            if (isSaved) {
                boolean isUpdated = foodDAO.updateAfterFoodConsumption(foodConsumptionDto);

                if (isUpdated) {
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;

        } catch (Exception e) {
            connection.rollback();
            return false;

        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<FoodConsumptionDto> searchFoodConsumption(String batchId) throws SQLException, ClassNotFoundException {
        ArrayList<FoodConsumption> entity = queryDAO.consumptionSearch(batchId);
        ArrayList<FoodConsumptionDto> dto = new ArrayList<>();
        for (FoodConsumption entity1 : entity) {
            dto.add(new FoodConsumptionDto(entity1.getBatchId(),entity1.getConsumptionId(),entity1.getDate(),entity1.getFoodId(),entity1.getConsumption()));
        }
        return dto;
    }

    @Override
    public ArrayList<FoodConsumptionDto> getAllFoodConsumption() throws SQLException, ClassNotFoundException {
        ArrayList<FoodConsumption> entity = queryDAO.consumptionGetAll();
        ArrayList<FoodConsumptionDto> dto = new ArrayList<>();
        for (FoodConsumption entity1 : entity) {
            dto.add(new FoodConsumptionDto(entity1.getBatchId(),entity1.getConsumptionId(),entity1.getDate(),entity1.getFoodId(),entity1.getConsumption()));
        }
        return dto;
    }

    @Override
    public String getNextFoodConsumptionId() throws SQLException, ClassNotFoundException {
        return foodConsumptionDAO.getNextId();
    }
}
