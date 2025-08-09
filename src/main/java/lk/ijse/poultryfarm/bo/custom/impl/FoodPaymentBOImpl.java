package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.FoodPaymentBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.custom.FoodDAO;
import lk.ijse.poultryfarm.dao.custom.FoodPaymentDAO;
import lk.ijse.poultryfarm.dao.custom.QueryDAO;
import lk.ijse.poultryfarm.dao.custom.impl.FoodDAOImpl;
import lk.ijse.poultryfarm.database.DBConnection;
import lk.ijse.poultryfarm.dto.FoodPaymentDto;
import lk.ijse.poultryfarm.entity.FoodPayment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodPaymentBOImpl implements FoodPaymentBO {
    FoodPaymentDAO foodPaymentDAO = (FoodPaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD_PAYMENT);
    FoodDAO foodDAO = (FoodDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public boolean foodPayment(FoodPaymentDto foodPaymentDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            boolean isSaved = foodPaymentDAO.save(new FoodPayment(foodPaymentDto.getFoodPaymentId(),foodPaymentDto.getFoodId(),foodPaymentDto.getQuantity(),foodPaymentDto.getPayAmount(),foodPaymentDto.getDate()));

            if (isSaved) {
                boolean isUpdated = foodDAO.updateAfterFoodOrder(foodPaymentDto);

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
    public ArrayList<FoodPaymentDto> searchFoodPayment(String foodId) throws SQLException, ClassNotFoundException {
        ArrayList<FoodPayment> entity = queryDAO.paymentSearch(foodId);
        ArrayList<FoodPaymentDto> dto = new ArrayList<>();
        for (FoodPayment entity1 : entity) {
            dto.add(new FoodPaymentDto(entity1.getFoodPaymentId(),entity1.getFoodId(),entity1.getQuantity(),entity1.getPayAmount(),entity1.getDate()));
        }
        return dto;
    }

    @Override
    public ArrayList<FoodPaymentDto> getAllFoodPayment() throws SQLException, ClassNotFoundException {
        ArrayList<FoodPayment> entity = queryDAO.paymentGetAll();
        ArrayList<FoodPaymentDto> dto = new ArrayList<>();
        for (FoodPayment entity1 : entity) {
            dto.add(new FoodPaymentDto(entity1.getFoodPaymentId(),entity1.getFoodId(),entity1.getQuantity(),entity1.getPayAmount(),entity1.getDate()));
        }
        return dto;
    }

    @Override
    public String getNextFoodPaymentId() throws SQLException, ClassNotFoundException {
        return foodPaymentDAO.getNextId();
    }
}
