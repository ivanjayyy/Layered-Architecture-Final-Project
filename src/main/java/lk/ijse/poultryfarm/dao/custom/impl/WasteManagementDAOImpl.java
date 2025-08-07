package lk.ijse.poultryfarm.dao.custom.impl;

import lk.ijse.poultryfarm.dao.custom.WasteManagementDAO;
import lk.ijse.poultryfarm.dto.WasteManagementDto;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.entity.WasteManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WasteManagementDAOImpl implements WasteManagementDAO {

    @Override
    public boolean save(WasteManagement wasteManagementDto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO waste_management VALUES (?,?,?,?)", wasteManagementDto.getBatchId(),wasteManagementDto.getWasteId(),wasteManagementDto.getTotalSale(),wasteManagementDto.getDate());
    }

    @Override
    public boolean update(WasteManagement wasteManagementDto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE waste_management SET batch_id = ?, total_sale = ?, date = ? WHERE waste_id = ?", wasteManagementDto.getBatchId(),wasteManagementDto.getTotalSale(),wasteManagementDto.getDate(),wasteManagementDto.getWasteId());
    }

    @Override
    public boolean delete(String wasteId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM waste_management WHERE waste_id = ?", wasteId);
    }

    @Override
    public ArrayList<WasteManagement> search(String batchId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM waste_management WHERE batch_id = ?", batchId);
        ArrayList<WasteManagement> wasteManagementDtos = new ArrayList<>();

        while (resultSet.next()) {
            WasteManagement wasteManagementDto = new WasteManagement(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4)
            );
            wasteManagementDtos.add(wasteManagementDto);
        }
        return wasteManagementDtos;
    }

    @Override
    public ArrayList<WasteManagement> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM waste_management ORDER BY waste_id DESC");

        ArrayList<WasteManagement> wasteManagementDtos = new ArrayList<>();

        while (resultSet.next()) {
            WasteManagement wasteManagementDto = new WasteManagement(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4)
            );
            wasteManagementDtos.add(wasteManagementDto);
        }
        return wasteManagementDtos;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT waste_id FROM waste_management ORDER BY waste_id DESC LIMIT 1");

        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            String lastIdNumberString = lastId.substring(1);
            int lastIdNumber = Integer.parseInt(lastIdNumberString);
            int nextIdNumber = lastIdNumber + 1;
            String nextIdString = String.format("W%03d", nextIdNumber);
            return nextIdString;
        }

        return "W001";
    }
}
