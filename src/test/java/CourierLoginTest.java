import courier.Courier;
import courier.CourierClient;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

import static constants.Data.*;


public class CourierLoginTest extends BaseTest {

    @Test
    @DisplayName("Успешная авторизация курьера")
    public void courierLoginAfterRegTest()  {
        Courier courier = new Courier(LOGIN, PASSWORD);
        CourierClient.createCourier(courier);
        Response response = CourierClient.loginCourier(courier);
        courierId = CourierClient.loginCourier(courier).then().extract().path("id");
        response.then().assertThat().statusCode(200)
                .and().
                body("id", notNullValue());
    }
    @Test
    @DisplayName("Авторизация без логина")
    public void courierLoginWithoutLogin() {
        Courier courier = new Courier(EMPTY_LOGIN, PASSWORD);
        Response response = CourierClient.loginCourier(courier);
        response.then().assertThat().statusCode(400)
                .and()
                .assertThat().body("message", equalTo(MESSAGE_FOR_INCOMPLETE_REQUEST_LOGIN_COURIER));
    }
    @Test
    @DisplayName("Авторизация без пароля")
    public void courierLoginWithoutPassword() {
        Courier courier = new Courier(LOGIN, EMPTY_LOGIN);
        Response response = CourierClient.loginCourier(courier);
        response.then().assertThat().statusCode(400)
                .and()
                .assertThat().body("message", equalTo(MESSAGE_FOR_INCOMPLETE_REQUEST_LOGIN_COURIER));
    }
    @Test
    @DisplayName("Авторизация с неверным логином/Несуществующий курьер")
    public void loginCourierWithNonExistLogin() {
        Courier courier = new Courier(NONEXIST_LOGIN, PASSWORD);
        Response response = CourierClient.loginCourier(courier);
        response.then().assertThat().statusCode(404)
                .and()
                .assertThat().body("message", equalTo(MESSAGE_FOR_INCORRECT_REQUEST_LOGIN_COURIER));
    }

    @Test
    @DisplayName("Авторизация с неверным паролем")
    public void loginCourierWithNonExistPassword() {
        Courier courier = new Courier(LOGIN, NONEXIST_PASSWORD);
        Response response = CourierClient.loginCourier(courier);
        response.then().assertThat().statusCode(404)
                .and()
                .assertThat().body("message", equalTo(MESSAGE_FOR_INCORRECT_REQUEST_LOGIN_COURIER));
    }

}
