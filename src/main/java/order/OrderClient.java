package order;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class OrderClient {
    public static final String ORDER = "api/v1/orders";
    public static final String CANCEL_ORDER = "/api/v1/orders/cancel";
    @Step("Создание заказа")
    public static Response createOrder(Order order) {
        return given()
                .header("Content-Type", "application/json")
                .body(order)
                .when()
                .post(ORDER);
    }

    @Step("Получение списка заказов")
    public static Response getOrderList() {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(ORDER);
    }

    @Step("Отмена заказа")
    public static Response cancelOrder(int track) {
        return given()
                .header("Content-Type", "application/json")
                .body(track)
                .when()
                .put(CANCEL_ORDER);
    }
}
