package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.BillBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.custom.BillDAO;
import lk.ijse.poultryfarm.dto.BillDto;
import lk.ijse.poultryfarm.entity.Bill;

import java.sql.SQLException;
import java.util.ArrayList;

public class BillBOImpl implements BillBO {
    BillDAO billDAO = (BillDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BILL);

    @Override
    public boolean saveBill(BillDto billDto) throws SQLException, ClassNotFoundException {
        return billDAO.save(new Bill(billDto.getBatchId(),billDto.getBillId(),billDto.getBillVariant(),billDto.getAmount(),billDto.getDate()));
    }

    @Override
    public boolean deleteBill(String billId) throws SQLException, ClassNotFoundException {
        return billDAO.delete(billId);
    }

    @Override
    public ArrayList<BillDto> searchBill(String billVariant) throws SQLException, ClassNotFoundException {
        ArrayList<Bill> entity = billDAO.search(billVariant);
        ArrayList<BillDto> dto = new ArrayList<>();
        for (Bill entity1 : entity) {
            dto.add(new BillDto(entity1.getBatchId(),entity1.getBillId(),entity1.getBillVariant(),entity1.getAmount(),entity1.getDate()));
        }
        return dto;
    }

    @Override
    public ArrayList<BillDto> getAllBills() throws SQLException, ClassNotFoundException {
        ArrayList<Bill> entity = billDAO.getAll();
        ArrayList<BillDto> dto = new ArrayList<>();
        for (Bill entity1 : entity) {
            dto.add(new BillDto(entity1.getBatchId(),entity1.getBillId(),entity1.getBillVariant(),entity1.getAmount(),entity1.getDate()));
        }
        return dto;
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
