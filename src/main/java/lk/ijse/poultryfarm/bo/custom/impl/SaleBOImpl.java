package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.SaleBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.SQLUtil;
import lk.ijse.poultryfarm.dao.custom.SaleDAO;
import lk.ijse.poultryfarm.dto.SaleDto;
import lk.ijse.poultryfarm.entity.Sale;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleBOImpl implements SaleBO {
    SaleDAO saleDAO = (SaleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SALE);

    @Override
    public boolean saveSale(SaleDto saleDto) throws SQLException, ClassNotFoundException {
        return saleDAO.save(new Sale(saleDto.getBatchId(),saleDto.getSaleId(),saleDto.getTotalSale(),saleDto.getDate(),saleDto.getChicksSold()));
    }

    @Override
    public boolean updateSale(SaleDto saleDto) throws SQLException, ClassNotFoundException {
        return saleDAO.update(new Sale(saleDto.getBatchId(),saleDto.getSaleId(),saleDto.getTotalSale(),saleDto.getDate(),saleDto.getChicksSold()));
    }

    @Override
    public boolean deleteSale(String saleId) throws SQLException, ClassNotFoundException {
        return saleDAO.delete(saleId);
    }

    @Override
    public ArrayList<SaleDto> searchSale(String batchId) throws SQLException, ClassNotFoundException {
        ArrayList<Sale> entity = saleDAO.search(batchId);
        ArrayList<SaleDto> dto = new ArrayList<>();
        for (Sale entity1 : entity) {
            dto.add(new SaleDto(entity1.getBatchId(),entity1.getSaleId(),entity1.getTotalSale(),entity1.getDate(),entity1.getChicksSold()));
        }
        return dto;
    }

    @Override
    public ArrayList<SaleDto> getAllSale() throws SQLException, ClassNotFoundException {
        ArrayList<Sale> entity = saleDAO.getAll();
        ArrayList<SaleDto> dto = new ArrayList<>();
        for (Sale entity1 : entity) {
            dto.add(new SaleDto(entity1.getBatchId(),entity1.getSaleId(),entity1.getTotalSale(),entity1.getDate(),entity1.getChicksSold()));
        }
        return dto;
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
