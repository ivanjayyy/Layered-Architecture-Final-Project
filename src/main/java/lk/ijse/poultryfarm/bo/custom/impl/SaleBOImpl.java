package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.SaleBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.SaleDAO;
import lk.ijse.poultryfarm.dto.SaleDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleBOImpl implements SaleBO {
    SaleDAO saleDAO = (SaleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SALE);

    @Override
    public boolean saveSale(SaleDto saleDto) throws SQLException, ClassNotFoundException {
        return saleDAO.save(saleDto);
    }

    @Override
    public boolean updateSale(SaleDto saleDto) throws SQLException, ClassNotFoundException {
        return saleDAO.update(saleDto);
    }

    @Override
    public boolean deleteSale(String saleId) throws SQLException, ClassNotFoundException {
        return saleDAO.delete(saleId);
    }

    @Override
    public ArrayList<SaleDto> searchSale(String batchId) throws SQLException, ClassNotFoundException {
        return saleDAO.search(batchId);
    }

    @Override
    public ArrayList<SaleDto> getAllSale() throws SQLException, ClassNotFoundException {
        return saleDAO.getAll();
    }

    @Override
    public String getNextSaleId() throws SQLException, ClassNotFoundException {
        return saleDAO.getNextId();
    }

    @Override
    public int selectedBatchTotalSold(String batchId) throws SQLException, ClassNotFoundException {
        return saleDAO.selectedBatchTotalSold(batchId);
    }
}
