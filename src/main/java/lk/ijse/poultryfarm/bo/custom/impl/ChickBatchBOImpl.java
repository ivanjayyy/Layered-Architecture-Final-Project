package lk.ijse.poultryfarm.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.poultryfarm.bo.custom.ChickBatchBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.custom.ChickBatchDAO;
import lk.ijse.poultryfarm.dto.ChickBatchDto;
import lk.ijse.poultryfarm.entity.ChickBatch;

import java.sql.SQLException;
import java.util.ArrayList;

public class ChickBatchBOImpl implements ChickBatchBO {
    ChickBatchDAO chickBatchDAO = (ChickBatchDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CHICK_BATCH);

    @Override
    public boolean saveChickBatch(ChickBatchDto chickBatchDto) throws SQLException, ClassNotFoundException {
        return chickBatchDAO.save(new ChickBatch(chickBatchDto.getBatchId(),chickBatchDto.getChickTotal(),chickBatchDto.getPayment(),chickBatchDto.getDate()));
    }

    @Override
    public boolean updateChickBatch(ChickBatchDto chickBatchDto) throws SQLException, ClassNotFoundException {
        return chickBatchDAO.update(new ChickBatch(chickBatchDto.getBatchId(),chickBatchDto.getChickTotal(),chickBatchDto.getPayment(),chickBatchDto.getDate()));
    }

    @Override
    public boolean deleteChickBatch(String billId) throws SQLException, ClassNotFoundException {
        return chickBatchDAO.delete(billId);
    }

    @Override
    public ArrayList<ChickBatchDto> searchChickBatch(String batchId) throws SQLException, ClassNotFoundException {
        ArrayList<ChickBatch> entity = chickBatchDAO.search(batchId);
        ArrayList<ChickBatchDto> dto = new ArrayList<>();
        for (ChickBatch entity1 : entity) {
            dto.add(new ChickBatchDto(entity1.getBatchId(),entity1.getChickTotal(),entity1.getPayment(),entity1.getDate()));
        }
        return dto;
    }

    @Override
    public ArrayList<ChickBatchDto> getAllChickBatches() throws SQLException, ClassNotFoundException {
        ArrayList<ChickBatch> entity = chickBatchDAO.getAll();
        ArrayList<ChickBatchDto> dto = new ArrayList<>();
        for (ChickBatch entity1 : entity) {
            dto.add(new ChickBatchDto(entity1.getBatchId(),entity1.getChickTotal(),entity1.getPayment(),entity1.getDate()));
        }
        return dto;
    }

    @Override
    public String getNextChickBatchId() throws SQLException, ClassNotFoundException {
        return chickBatchDAO.getNextId();
    }

    @Override
    public String getCurrentBatchId() throws SQLException, ClassNotFoundException {
        return chickBatchDAO.getCurrentBatchId();
    }

    @Override
    public int getChickTotal(String batchId) throws SQLException, ClassNotFoundException {
        return chickBatchDAO.getChickTotal(batchId);
    }

    @Override
    public ObservableList<String> getAllBatchIds() throws SQLException, ClassNotFoundException {
        return chickBatchDAO.getAllBatchIds();
    }
}
