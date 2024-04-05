package courier;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;



public class CourierClient {
    private static final String CREATE_COURIER = "/api/v1/courier/";
    private static final String COURIER_LOGIN = "/api/v1/courier/login";
    private static final String DELETE_COURIER = "/api/v1/courier/";

    @Step("Создание курьера")
    public static Response createCourier(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .body(courier)
                .when()
                .post(CREATE_COURIER);
    }
    @Step("Авторизация курьера")
    public static Response loginCourier(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .body(courier)
                .when()
                .post(COURIER_LOGIN);
    }
    @Step("Получение id курьера")
    public static String getCourierId(Courier courier) {
        Response response =
                given()
                .header("Content-type", "application/json")
                .body(courier)
                .when()
                .post(COURIER_LOGIN);
        return response.jsonPath().getString("id");

    }

    @Step("Удаление курьера")
    public static Response deleteCourier(int id) {
        return given()
                .header("Content-type", "application/json")
                .when()
                .delete(DELETE_COURIER + id);
    }

}
