import courier.Courier;
import courier.CourierClient;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

import static constants.Data.*;


public class CourierCreateTest extends BaseTest {

    @Test
    @DisplayName("Создания курьера со всеми обязательными полями")
    public void createCourierTest() {
        Courier courier = new Courier(LOGIN, PASSWORD, FIRST_NAME);
        Response response = CourierClient.createCourier(courier);
        courierId = CourierClient.loginCourier(courier).then().extract().path("id");;
        response.then().assertThat().statusCode(201).and().body("ok", equalTo(true));
    }
    @Test
    @DisplayName("Создание двух одинаковых курьеров")
    public void createDuplicateCourierTest() {
        Courier courier = new Courier(LOGIN, PASSWORD, FIRST_NAME);
        CourierClient.createCourier(courier);
        Response responseDuplicate = CourierClient.createCourier(courier);
        courierId = CourierClient.loginCourier(courier).then().extract().path("id");
        responseDuplicate.then().assertThat().body("message", equalTo(MESSAGE_FOR_INCORRECT_REQUEST_CREATE_COURIER)).statusCode(409);
    }
    @Test
    @DisplayName("Создание курьера с отсутствием данных в логине")
    public void createCourierWithoutLoginTest() {
        Courier courierWithoutLogin = new Courier(EMPTY_LOGIN, PASSWORD, FIRST_NAME);
        Response response = CourierClient.createCourier(courierWithoutLogin);
        response.then().assertThat().body("message", equalTo(MESSAGE_FOR_INCOMPLETE_REQUEST_CREATE_COURIER)).statusCode(400);
    }
    @Test
    @DisplayName("Создание курьера с отсутствием данных в пароле")
    public void createCourierWithoutPasswordTest() {
        Courier courierWithoutPassword = new Courier(LOGIN, EMPTY_PASSWORD, FIRST_NAME);
        Response response = CourierClient.createCourier(courierWithoutPassword);
        response.then().assertThat().body("message", equalTo(MESSAGE_FOR_INCOMPLETE_REQUEST_CREATE_COURIER)).statusCode(400);
    }
    @Test
    @DisplayName("Создание курьера с отсутствием данных в имени")
    public void createCourierWithoutNameTest() {
        Courier courierWithoutName = new Courier(LOGIN, PASSWORD, EMPTY_FIRST_NAME);
        Response response = CourierClient.createCourier(courierWithoutName);
        courierId = CourierClient.loginCourier(courierWithoutName).then().extract().path("id");
        response.then().assertThat().body("ok", equalTo(true)).and().statusCode(201);
    }
    @Test
    @DisplayName("Создание курьера с логином, который уже зарегестрирован")
    public void createCourierWithDoubleLoginTest() {
        Courier courierWithDoubleLogin = new Courier(LOGIN, SECOND_PASSWORD, FIRST_NAME_2);
        CourierClient.createCourier(courierWithDoubleLogin);
        Response responseDuplicate = CourierClient.createCourier(courierWithDoubleLogin);
        courierId = CourierClient.loginCourier(courierWithDoubleLogin).then().extract().path("id");
        responseDuplicate.then().assertThat().body("message", equalTo(MESSAGE_FOR_INCORRECT_REQUEST_CREATE_COURIER)).statusCode(409);
    }

}
