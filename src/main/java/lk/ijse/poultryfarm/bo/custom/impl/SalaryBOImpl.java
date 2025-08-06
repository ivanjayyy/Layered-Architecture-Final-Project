package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.SalaryBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.SalaryDAO;
import lk.ijse.poultryfarm.dto.SalaryDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryBOImpl implements SalaryBO {
    SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SALARY);

    @Override
    public boolean saveSalary(SalaryDto salaryDto) throws SQLException, ClassNotFoundException {
        return salaryDAO.save(salaryDto);
    }

    @Override
    public boolean updateSalary(SalaryDto employeeDto) throws SQLException, ClassNotFoundException {
        return salaryDAO.update(employeeDto);
    }

    @Override
    public boolean deleteSalary(String salaryId) throws SQLException, ClassNotFoundException {
        return salaryDAO.delete(salaryId);
    }

    @Override
    public ArrayList<SalaryDto> searchSalary(String employeeId) throws SQLException, ClassNotFoundException {
        return salaryDAO.search(employeeId);
    }

    @Override
    public ArrayList<SalaryDto> getAllSalary() throws SQLException, ClassNotFoundException {
        return salaryDAO.getAll();
    }

    @Override
    public String getNextSalaryId() throws SQLException, ClassNotFoundException {
        return salaryDAO.getNextId();
    }
}
