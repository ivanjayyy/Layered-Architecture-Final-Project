package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dto.OwnerDto;

import java.sql.SQLException;

public interface OwnerBO extends SuperBO {
    boolean saveOwner(OwnerDto ownerDto) throws SQLException, ClassNotFoundException ;
    boolean updateOwner(OwnerDto ownerDto) throws SQLException, ClassNotFoundException ;
    String ownerUsername() throws SQLException, ClassNotFoundException ;
    String ownerPassword() throws SQLException, ClassNotFoundException ;
    OwnerDto getOwner() throws SQLException, ClassNotFoundException ;
    boolean hasOwner() throws SQLException, ClassNotFoundException ;
    String getEmail() throws SQLException, ClassNotFoundException;
    boolean changePassword(String password) throws SQLException, ClassNotFoundException ;
}
