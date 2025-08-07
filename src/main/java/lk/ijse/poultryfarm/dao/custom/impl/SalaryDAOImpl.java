package lk.ijse.poultryfarm.dao.custom.impl;

import lk.ijse.poultryfarm.dao.custom.SalaryDAO;
import lk.ijse.poultryfarm.dto.SalaryDto;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.entity.Salary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryDAOImpl implements SalaryDAO {

    @Override
    public boolean save(Salary salaryDto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO salary VALUES (?,?,?,?)", salaryDto.getSalaryId(),salaryDto.getEmployeeId(),salaryDto.getAmount(),salaryDto.getDate());
    }

    @Override
    public boolean update(Salary employeeDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String salaryId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM salary WHERE salary_id = ?", salaryId);
    }

    @Override
    public ArrayList<Salary> search(String employeeId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT s.salary_id,e.name,s.amount,s.date from salary s join employee e on s.employee_id = e.employee_id WHERE s.employee_id = ? order by s.salary_id desc", employeeId);
        ArrayList<Salary> salaryDtos = new ArrayList<>();

        while (resultSet.next()) {
            Salary salaryDto = new Salary(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4)
            );
            salaryDtos.add(salaryDto);
        }
        return salaryDtos;
    }

    @Override
    public ArrayList<Salary> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT s.salary_id,e.name,s.amount,s.date from salary s join employee e on s.employee_id = e.employee_id order by s.salary_id desc");

        ArrayList<Salary> salaryDtos = new ArrayList<>();

        while (resultSet.next()) {
            Salary salaryDto = new Salary(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4)
            );
            salaryDtos.add(salaryDto);
        }
        return salaryDtos;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT salary_id FROM salary ORDER BY salary_id DESC LIMIT 1");

        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            String lastIdNumberString = lastId.substring(1);
            int lastIdNumber = Integer.parseInt(lastIdNumberString);
            int nextIdNumber = lastIdNumber + 1;
            String nextIdString = String.format("S%03d", nextIdNumber);
            return nextIdString;
        }

        return "S001";
    }
}
