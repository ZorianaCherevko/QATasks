package api.tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import steps.GenStep;
import steps.OrderSteps;
import utils.BaseTests;

import static consts.HttpCodes.OK;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static test.Cred.TestCred.*;

public class OrderTests extends BaseTests {

    private final OrderSteps orderSteps = new OrderSteps();

    @Test
    @Description("CREATE /v2/store/order")
    public void checkThatCreateOrderWithValidDataReturns200(){
        assertEquals(orderSteps.addNewOrderToStore(ORDER_ID, PET_ID, ORDER_QUANTITY, ORDER_SHIP_DATE,
                ORDER_STATUS, true).getStatusCode(), OK);
    }

    @Test
    @Description("GET /v2/store/order/{orderId}")
    public void checkThatGetOrderByIdReturns200(){
        assertEquals(orderSteps.getInfoByOrderId(ORDER_ID).getStatusCode(), OK);
    }

    @Test
    @Description("DELETE /v2/store/order/{orderId}")
    public void checkThatDeleteOrderByIdReturns200(){
        assertEquals(orderSteps.deleteInfoByOrderId(PET_ID).getStatusCode(),OK);
    }

}
