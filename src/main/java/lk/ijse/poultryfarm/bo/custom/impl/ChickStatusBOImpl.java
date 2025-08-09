package lk.ijse.poultryfarm.bo.custom.impl;

import lk.ijse.poultryfarm.bo.custom.ChickStatusBO;
import lk.ijse.poultryfarm.dao.DAOFactory;
import lk.ijse.poultryfarm.dao.custom.ChickStatusDAO;
import lk.ijse.poultryfarm.dto.ChickStatusDto;
import lk.ijse.poultryfarm.entity.ChickStatus;

import java.sql.SQLException;
import java.util.ArrayList;

public class ChickStatusBOImpl implements ChickStatusBO {
    ChickStatusDAO chickStatusDAO = (ChickStatusDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CHICK_STATUS);

    @Override
    public boolean saveChickStatus(ChickStatusDto chickStatusDto) throws SQLException, ClassNotFoundException {
        return chickStatusDAO.save(new ChickStatus(chickStatusDto.getBatchId(),chickStatusDto.getChickStatusId(),chickStatusDto.getDate(),chickStatusDto.getChicksDead()));
    }

    @Override
    public boolean deleteChickStatus(String chickStatusId) throws SQLException, ClassNotFoundException {
        return chickStatusDAO.delete(chickStatusId);
    }

    @Override
    public int selectedBatchChickDeaths(String batchId) throws SQLException, ClassNotFoundException {
        return chickStatusDAO.selectedBatchChickDeaths(batchId);
    }

    @Override
    public ArrayList<ChickStatusDto> searchChickStatus(String batchId) throws SQLException, ClassNotFoundException {
        ArrayList<ChickStatus> entity = chickStatusDAO.search(batchId);
        ArrayList<ChickStatusDto> dto = new ArrayList<>();
        for (ChickStatus entity1 : entity) {
            dto.add(new ChickStatusDto(entity1.getBatchId(),entity1.getChickStatusId(),entity1.getDate(),entity1.getChicksDead()));
        }
        return dto;
    }

    @Override
    public ArrayList<ChickStatusDto> getAllChickStatus() throws SQLException, ClassNotFoundException {
        ArrayList<ChickStatus> entity = chickStatusDAO.getAll();
        ArrayList<ChickStatusDto> dto = new ArrayList<>();
        for (ChickStatus entity1 : entity) {
            dto.add(new ChickStatusDto(entity1.getBatchId(),entity1.getChickStatusId(),entity1.getDate(),entity1.getChicksDead()));
        }
        return dto;
    }

    @Override
    public String getNextChickStatusId() throws SQLException, ClassNotFoundException {
        return chickStatusDAO.getNextId();
    }

    @Override
    public int checkStatus(String date, String batchId) throws SQLException, ClassNotFoundException {
        return chickStatusDAO.checkStatus(date, batchId);
    }
}
