package lk.ijse.poultryfarm.dao.custom;

import lk.ijse.poultryfarm.dao.CrudDAO;
import lk.ijse.poultryfarm.dto.OwnerDto;
import lk.ijse.poultryfarm.entity.Owner;

import java.sql.SQLException;

public interface OwnerDAO extends CrudDAO<Owner> {
    String ownerUsername() throws SQLException, ClassNotFoundException;
    String ownerPassword() throws SQLException, ClassNotFoundException;
    OwnerDto getOwner() throws SQLException, ClassNotFoundException;
    boolean hasOwner() throws SQLException, ClassNotFoundException;
    String getEmail() throws SQLException, ClassNotFoundException;
    boolean changePassword(String password) throws SQLException, ClassNotFoundException;
}
