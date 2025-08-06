package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.OwnerBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.OwnerDAO;
import lk.ijse.poultryfarm.dto.OwnerDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OwnerBOImpl implements OwnerBO {
    OwnerDAO ownerDAO = (OwnerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.OWNER);

    @Override
    public ArrayList<OwnerDto> getAllOwners() throws SQLException, ClassNotFoundException {
        return ownerDAO.getAll();
    }

    @Override
    public boolean saveOwner(OwnerDto ownerDto) throws SQLException, ClassNotFoundException {
        return ownerDAO.save(ownerDto);
    }

    @Override
    public boolean updateOwner(OwnerDto ownerDto) throws SQLException, ClassNotFoundException {
        return ownerDAO.update(ownerDto);
    }

    @Override
    public boolean deleteOwner(String billId) throws SQLException, ClassNotFoundException {
        return ownerDAO.delete(billId);
    }

    @Override
    public ArrayList<OwnerDto> searchOwner(String billVariant) throws SQLException, ClassNotFoundException {
        return ownerDAO.search(billVariant);
    }

    @Override
    public String getNextOwnerId() throws SQLException, ClassNotFoundException {
        return ownerDAO.getNextId();
    }

    @Override
    public String ownerUsername() throws SQLException, ClassNotFoundException {
        return ownerDAO.ownerUsername();
    }

    @Override
    public String ownerPassword() throws SQLException, ClassNotFoundException {
        return ownerDAO.ownerPassword();
    }

    @Override
    public OwnerDto getOwner() throws SQLException, ClassNotFoundException {
        return ownerDAO.getOwner();
    }

    @Override
    public boolean hasOwner() throws SQLException, ClassNotFoundException {
        return ownerDAO.hasOwner();
    }

    @Override
    public String getEmail() throws SQLException, ClassNotFoundException {
        return ownerDAO.getEmail();
    }

    @Override
    public boolean changePassword(String password) throws SQLException, ClassNotFoundException {
        return ownerDAO.changePassword(password);
    }
}
