package steps;

import builders.Order;
import builders.OrderStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import static utils.ApiUtils.*;
import utils.BuilderUtil;
import static consts.Endpoints.*;

public class OrderSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Step("Add a new order to store")
    public Response addNewOrderToStore(int id, int petId, int quantity, String shipDate,
                                       OrderStatus orderStatus, boolean complete) {
        Order order = builderUtil.buildOrder(id, petId, quantity, shipDate, orderStatus, complete);

        return post(CREATE_AN_ORDER, objectMapper.writeValueAsString(order));
    }

    @SneakyThrows
    @Step("Get an order info")
    public Response getInfoByOrderId(int orderId){
        return getOrder(GET_AN_ORDER, orderId);
    }
}
