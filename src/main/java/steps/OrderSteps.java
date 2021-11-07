package steps;

import builders.Order;
import builders.OrderStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import utils.ApiUtils;
import utils.BuilderUtil;
import static consts.Endpoints.*;

public class OrderSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Step("Add a new order to store")
    public Response addNewOrderToStore(int orderId, int petId, int quantity, String shipDate,
                                       OrderStatus orderStatus, boolean complete) {
        Order order = builderUtil.buildOrder(orderId, petId, quantity, shipDate, orderStatus, complete);

        return ApiUtils.post(CREATE_AN_ORDER, objectMapper.writeValueAsString(order));

    }
}
