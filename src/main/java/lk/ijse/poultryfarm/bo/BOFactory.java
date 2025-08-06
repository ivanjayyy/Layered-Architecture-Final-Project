package lk.ijse.poultryfarm.bo;

import lk.ijse.poultryfarm.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        return (boFactory == null) ? new BOFactory() : boFactory;
    }

    public enum BOTypes {
        BILL,
        CHICK_BATCH,
        CHICK_STATUS,
        DAILY_ATTENDANCE,
        EMPLOYEE,
        OWNER,
        SALARY,
        SALE,
        WASTE_MANAGEMENT,
        FOOD_CONSUMPTION,
        FOOD,
        FOOD_PAYMENT
    }

    public SuperBO getBO(BOFactory.BOTypes boType) {
        return switch (boType) {
            case BILL -> new BillBOImpl();
            case CHICK_BATCH -> new ChickBatchBOImpl();
            case CHICK_STATUS -> new ChickStatusBOImpl();
            case DAILY_ATTENDANCE -> new DailyAttendanceBOImpl();
            case EMPLOYEE -> new EmployeeBOImpl();
            case OWNER -> new OwnerBOImpl();
            case SALARY -> new SalaryBOImpl();
            case SALE -> new SaleBOImpl();
            case WASTE_MANAGEMENT -> new WasteManagementBOImpl();
            case FOOD_CONSUMPTION -> new FoodConsumptionBOImpl();
            case FOOD -> new FoodBOImpl();
            case FOOD_PAYMENT -> new FoodPaymentBOImpl();
        };
    }
}
