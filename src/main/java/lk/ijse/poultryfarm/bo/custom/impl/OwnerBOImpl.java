package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.OwnerBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.custom.OwnerDAO;
import lk.ijse.poultryfarm.dto.OwnerDto;
import lk.ijse.poultryfarm.entity.Owner;

import java.sql.SQLException;
import java.util.ArrayList;

public class OwnerBOImpl implements OwnerBO {
    OwnerDAO ownerDAO = (OwnerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.OWNER);

    @Override
    public boolean saveOwner(OwnerDto ownerDto) throws SQLException, ClassNotFoundException {
        return ownerDAO.save(new Owner(ownerDto.getOwnerId(),ownerDto.getName(),ownerDto.getUsername(),ownerDto.getPassword(),ownerDto.getEmail()));
    }

    @Override
    public boolean updateOwner(OwnerDto ownerDto) throws SQLException, ClassNotFoundException {
        return ownerDAO.update(new Owner(ownerDto.getOwnerId(),ownerDto.getName(),ownerDto.getUsername(),ownerDto.getPassword(),ownerDto.getEmail()));
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
    public boolean changePassword(String password) throws SQLException, ClassNotFoundException {
        return ownerDAO.changePassword(password);
    }
}
