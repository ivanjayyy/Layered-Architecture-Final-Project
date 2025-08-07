package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.SalaryBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.SalaryDAO;
import lk.ijse.poultryfarm.dto.SalaryDto;
import lk.ijse.poultryfarm.entity.Salary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryBOImpl implements SalaryBO {
    SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SALARY);

    @Override
    public boolean saveSalary(SalaryDto salaryDto) throws SQLException, ClassNotFoundException {
        return salaryDAO.save(new Salary(salaryDto.getSalaryId(),salaryDto.getEmployeeId(),salaryDto.getAmount(),salaryDto.getDate()));
    }

    @Override
    public boolean updateSalary(SalaryDto employeeDto) throws SQLException, ClassNotFoundException {
        return salaryDAO.update(new Salary(employeeDto.getSalaryId(),employeeDto.getEmployeeId(),employeeDto.getAmount(),employeeDto.getDate()));
    }

    @Override
    public boolean deleteSalary(String salaryId) throws SQLException, ClassNotFoundException {
        return salaryDAO.delete(salaryId);
    }

    @Override
    public ArrayList<SalaryDto> searchSalary(String employeeId) throws SQLException, ClassNotFoundException {
        ArrayList<Salary> entity = salaryDAO.search(employeeId);
        ArrayList<SalaryDto> dto = new ArrayList<>();
        for(Salary entity1 : entity){
            dto.add(new SalaryDto(entity1.getSalaryId(),entity1.getEmployeeId(),entity1.getAmount(),entity1.getDate()));
        }
        return dto;
    }

    @Override
    public ArrayList<SalaryDto> getAllSalary() throws SQLException, ClassNotFoundException {
        ArrayList<Salary> entity = salaryDAO.getAll();
        ArrayList<SalaryDto> dto = new ArrayList<>();
        for(Salary entity1 : entity){
            dto.add(new SalaryDto(entity1.getSalaryId(),entity1.getEmployeeId(),entity1.getAmount(),entity1.getDate()));
        }
        return dto;
    }

    @Override
    public String getNextSalaryId() throws SQLException, ClassNotFoundException {
        return salaryDAO.getNextId();
    }
}
