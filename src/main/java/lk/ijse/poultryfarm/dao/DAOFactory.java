package lk.ijse.poultryfarm.dao;

import lk.ijse.poultryfarm.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return (daoFactory == null) ? new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        BILL,
        CHICK_BATCH,
        CHICK_STATUS,
        DAILY_ATTENDANCE,
        EMPLOYEE,
        OWNER,
        QUERY,
        SALARY,
        SALE,
        WASTE_MANAGEMENT,
        FOOD_CONSUMPTION,
        FOOD,
        FOOD_PAYMENT
    }

    public SuperDAO getDAO(DAOTypes daoType) {
        return switch (daoType) {
            case BILL -> new BillDAOImpl();
            case CHICK_BATCH -> new ChickBatchDAOImpl();
            case CHICK_STATUS -> new ChickStatusDAOImpl();
            case DAILY_ATTENDANCE -> new DailyAttendanceDAOImpl();
            case EMPLOYEE -> new EmployeeDAOImpl();
            case OWNER -> new OwnerDAOImpl();
            case QUERY -> new QueryDAOImpl();
            case SALARY -> new SalaryDAOImpl();
            case SALE -> new SaleDAOImpl();
            case WASTE_MANAGEMENT -> new WasteManagementDAOImpl();
            case FOOD_CONSUMPTION -> new FoodConsumptionDAOImpl();
            case FOOD -> new FoodDAOImpl();
            case FOOD_PAYMENT -> new FoodPaymentDAOImpl();
        };
    }
}
