package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dto.OwnerDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface OwnerBO extends SuperBO {
    ArrayList<OwnerDto> getAllOwners() throws SQLException, ClassNotFoundException ;
    boolean saveOwner(OwnerDto ownerDto) throws SQLException, ClassNotFoundException ;
    boolean updateOwner(OwnerDto ownerDto) throws SQLException, ClassNotFoundException ;
    boolean deleteOwner(String billId) throws SQLException, ClassNotFoundException ;
    ArrayList<OwnerDto> searchOwner(String billVariant) throws SQLException, ClassNotFoundException ;
    String getNextOwnerId() throws SQLException, ClassNotFoundException ;
    String ownerUsername() throws SQLException, ClassNotFoundException ;
    String ownerPassword() throws SQLException, ClassNotFoundException ;
    OwnerDto getOwner() throws SQLException, ClassNotFoundException ;
    boolean hasOwner() throws SQLException, ClassNotFoundException ;
    String getEmail() throws SQLException, ClassNotFoundException ;
    boolean changePassword(String password) throws SQLException, ClassNotFoundException ;
}
