package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.WasteManagementBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.WasteManagementDAO;
import lk.ijse.poultryfarm.dto.WasteManagementDto;
import lk.ijse.poultryfarm.entity.WasteManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WasteManagementBOImpl implements WasteManagementBO {
    WasteManagementDAO wasteManagementDAO = (WasteManagementDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.WASTE_MANAGEMENT);

    @Override
    public boolean saveWaste(WasteManagementDto wasteManagementDto) throws SQLException, ClassNotFoundException {
        return wasteManagementDAO.save(new WasteManagement(wasteManagementDto.getBatchId(),wasteManagementDto.getWasteId(),wasteManagementDto.getTotalSale(),wasteManagementDto.getDate()));
    }

    @Override
    public boolean updateWaste(WasteManagementDto wasteManagementDto) throws SQLException, ClassNotFoundException {
        return wasteManagementDAO.update(new WasteManagement(wasteManagementDto.getBatchId(),wasteManagementDto.getWasteId(),wasteManagementDto.getTotalSale(),wasteManagementDto.getDate()));
    }

    @Override
    public boolean deleteWaste(String wasteId) throws SQLException, ClassNotFoundException {
        return wasteManagementDAO.delete(wasteId);
    }

    @Override
    public ArrayList<WasteManagementDto> searchWaste(String batchId) throws SQLException, ClassNotFoundException {
        ArrayList<WasteManagement> entity = wasteManagementDAO.search(batchId);
        ArrayList<WasteManagementDto> dto = new ArrayList<>();
        for (WasteManagement entity1 : entity) {
            dto.add(new WasteManagementDto(entity1.getBatchId(),entity1.getWasteId(),entity1.getTotalSale(),entity1.getDate()));
        }
        return dto;
    }

    @Override
    public ArrayList<WasteManagementDto> getAllWaste() throws SQLException, ClassNotFoundException {
        ArrayList<WasteManagement> entity = wasteManagementDAO.getAll();
        ArrayList<WasteManagementDto> dto = new ArrayList<>();
        for (WasteManagement entity1 : entity) {
            dto.add(new WasteManagementDto(entity1.getBatchId(),entity1.getWasteId(),entity1.getTotalSale(),entity1.getDate()));
        }
        return dto;
    }

    @Override
    public String getNextWasteId() throws SQLException, ClassNotFoundException {
        return wasteManagementDAO.getNextId();
    }
}
