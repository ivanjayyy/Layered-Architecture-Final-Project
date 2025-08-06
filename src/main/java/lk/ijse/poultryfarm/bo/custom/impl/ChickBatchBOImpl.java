package lk.ijse.poultryfarm.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.poultryfarm.bo.custom.ChickBatchBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.custom.ChickBatchDAO;
import lk.ijse.poultryfarm.dto.ChickBatchDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ChickBatchBOImpl implements ChickBatchBO {
    ChickBatchDAO chickBatchDAO = (ChickBatchDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CHICK_BATCH);

    @Override
    public boolean saveChickBatch(ChickBatchDto chickBatchDto) throws SQLException, ClassNotFoundException {
        return chickBatchDAO.save(chickBatchDto);
    }

    @Override
    public boolean updateChickBatch(ChickBatchDto employeeDto) throws SQLException, ClassNotFoundException {
        return chickBatchDAO.update(employeeDto);
    }

    @Override
    public boolean deleteChickBatch(String billId) throws SQLException, ClassNotFoundException {
        return chickBatchDAO.delete(billId);
    }

    @Override
    public ArrayList<ChickBatchDto> searchChickBatch(String batchId) throws SQLException, ClassNotFoundException {
        return chickBatchDAO.search(batchId);
    }

    @Override
    public ArrayList<ChickBatchDto> getAllChickBatches() throws SQLException, ClassNotFoundException {
        return chickBatchDAO.getAll();
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
