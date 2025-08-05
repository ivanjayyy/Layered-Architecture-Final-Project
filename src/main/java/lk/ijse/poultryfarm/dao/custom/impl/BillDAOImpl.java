package lk.ijse.poultryfarm.dao.custom.impl;

import lk.ijse.poultryfarm.dao.custom.BillDAO;
import lk.ijse.poultryfarm.dto.BillDto;
import lk.ijse.poultryfarm.dao.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BillDAOImpl implements BillDAO {

    @Override
    public boolean save(BillDto billDto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO bill VALUES (?,?,?,?,?)", billDto.getBatchId(),billDto.getBillId(),billDto.getBillVariant(),billDto.getAmount(),billDto.getDate());
    }

    @Override
    public boolean update(BillDto employeeDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String billId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM bill WHERE bill_id = ?", billId);
    }

    @Override
    public ArrayList<BillDto> search(String billVariant) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM bill WHERE bill_variant = ? ORDER BY bill_id DESC", billVariant);

        ArrayList<BillDto> billDtos = new ArrayList<>();

        while (resultSet.next()) {
            BillDto billDto = new BillDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5)
            );
            billDtos.add(billDto);
        }
        return billDtos;
    }

    @Override
    public ArrayList<BillDto> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM bill ORDER BY bill_id DESC");

        ArrayList<BillDto> billDtos = new ArrayList<>();

        while (resultSet.next()) {
            BillDto billDto = new BillDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5)
            );
            billDtos.add(billDto);
        }
        return billDtos;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT bill_id FROM bill ORDER BY bill_id DESC LIMIT 1");

        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            String lastIdNumberString = lastId.substring(1);
            int lastIdNumber = Integer.parseInt(lastIdNumberString);
            int nextIdNumber = lastIdNumber + 1;
            String nextIdString = String.format("X%03d", nextIdNumber);
            return nextIdString;
        }

        return "X001";
    }

    @Override
    public int billPaidStatus(String batchId, String billType) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(bill_id) FROM bill WHERE batch_id = ? AND bill_variant = ?", batchId,billType);

        if(resultSet.next()){
            return resultSet.getInt(1);
        }

        return 0;
    }
}
