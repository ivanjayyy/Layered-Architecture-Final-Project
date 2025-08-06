package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.WasteManagementBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.WasteManagementDAO;
import lk.ijse.poultryfarm.dto.WasteManagementDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WasteManagementBOImpl implements WasteManagementBO {
    WasteManagementDAO wasteManagementDAO = (WasteManagementDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.WASTE_MANAGEMENT);

    @Override
    public boolean saveWaste(WasteManagementDto wasteManagementDto) throws SQLException, ClassNotFoundException {
        return wasteManagementDAO.save(wasteManagementDto);
    }

    @Override
    public boolean updateWaste(WasteManagementDto wasteManagementDto) throws SQLException, ClassNotFoundException {
        return wasteManagementDAO.update(wasteManagementDto);
    }

    @Override
    public boolean deleteWaste(String wasteId) throws SQLException, ClassNotFoundException {
        return wasteManagementDAO.delete(wasteId);
    }

    @Override
    public ArrayList<WasteManagementDto> searchWaste(String batchId) throws SQLException, ClassNotFoundException {
        return wasteManagementDAO.search(batchId);
    }

    @Override
    public ArrayList<WasteManagementDto> getAllWaste() throws SQLException, ClassNotFoundException {
        return wasteManagementDAO.getAll();
    }

    @Override
    public String getNextWasteId() throws SQLException, ClassNotFoundException {
        return wasteManagementDAO.getNextId();
    }
}
