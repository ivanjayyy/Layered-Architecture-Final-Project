package lk.ijse.poultryfarm.bo.custom;

import lk.ijse.poultryfarm.bo.SuperBO;
import lk.ijse.poultryfarm.dto.SalaryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SalaryBO extends SuperBO {
    boolean saveSalary(SalaryDto salaryDto) throws SQLException, ClassNotFoundException ;
    boolean deleteSalary(String salaryId) throws SQLException, ClassNotFoundException ;
    ArrayList<SalaryDto> searchSalary(String employeeId) throws SQLException, ClassNotFoundException ;
    ArrayList<SalaryDto> getAllSalary() throws SQLException, ClassNotFoundException ;
    String getNextSalaryId() throws SQLException, ClassNotFoundException ;
}
