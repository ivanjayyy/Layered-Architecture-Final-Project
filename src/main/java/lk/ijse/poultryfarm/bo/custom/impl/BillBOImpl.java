package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.BillBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.custom.BillDAO;
import lk.ijse.poultryfarm.dto.BillDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class BillBOImpl implements BillBO {
    BillDAO billDAO = (BillDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BILL);

    @Override
    public boolean saveBill(BillDto billDto) throws SQLException, ClassNotFoundException {
        return billDAO.save(billDto);
    }

    @Override
    public boolean updateBill(BillDto employeeDto) throws SQLException, ClassNotFoundException {
        return billDAO.update(employeeDto);
    }

    @Override
    public boolean deleteBill(String billId) throws SQLException, ClassNotFoundException {
        return billDAO.delete(billId);
    }

    @Override
    public ArrayList<BillDto> searchBill(String billVariant) throws SQLException, ClassNotFoundException {
        return billDAO.search(billVariant);
    }

    @Override
    public ArrayList<BillDto> getAllBills() throws SQLException, ClassNotFoundException {
        return billDAO.getAll();
    }

    @Override
    public String getNextBillId() throws SQLException, ClassNotFoundException {
        return billDAO.getNextId();
    }

    @Override
    public int billPaidStatus(String batchId, String billType) throws SQLException, ClassNotFoundException {
        return billDAO.billPaidStatus(batchId, billType);
    }
}
