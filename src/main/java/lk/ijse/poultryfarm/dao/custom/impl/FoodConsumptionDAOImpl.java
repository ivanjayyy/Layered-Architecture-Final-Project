package lk.ijse.poultryfarm.dao.custom.impl;

import lk.ijse.poultryfarm.dao.custom.FoodConsumptionDAO;
import lk.ijse.poultryfarm.database.DBConnection;
import lk.ijse.poultryfarm.dto.FoodConsumptionDto;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.entity.FoodConsumption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodConsumptionDAOImpl implements FoodConsumptionDAO {

    @Override
    public ArrayList<FoodConsumption> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(FoodConsumption foodConsumptionDto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO food_consumption VALUES (?,?,?,?,?)", foodConsumptionDto.getBatchId(),foodConsumptionDto.getConsumptionId(),foodConsumptionDto.getDate(),foodConsumptionDto.getFoodId(),foodConsumptionDto.getConsumption());
    }

    @Override
    public boolean update(FoodConsumption foodConsumption) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String billId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<FoodConsumption> search(String billVariant) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT consumption_id FROM food_consumption ORDER BY consumption_id DESC LIMIT 1");

        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            String lastIdNumberString = lastId.substring(1);
            int lastIdNumber = Integer.parseInt(lastIdNumberString);
            int nextIdNumber = lastIdNumber + 1;
            String nextIdString = String.format("C%03d", nextIdNumber);
            return nextIdString;
        }

        return "C001";
    }
}
