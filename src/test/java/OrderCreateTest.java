import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import order.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static constants.Data.*;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class OrderCreateTest extends BaseTest {

    private final Order order;
    public OrderCreateTest(Order order) {
        this.order = order;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {new Order(FIRST_NAME, LAST_NAME, ADDRESS, METRO_STATION, PHONE, RENT_TIME, DELIVERY_DATE, COMMENT, BLACK_COLOR)},
                {new Order(FIRST_NAME, LAST_NAME, ADDRESS, METRO_STATION, PHONE, RENT_TIME, DELIVERY_DATE, COMMENT, GREY_COLOR)},
                {new Order(FIRST_NAME, LAST_NAME, ADDRESS, METRO_STATION, PHONE, RENT_TIME, DELIVERY_DATE, COMMENT, BOTH_COLORS)},
                {new Order(FIRST_NAME, LAST_NAME, ADDRESS, METRO_STATION, PHONE, RENT_TIME, DELIVERY_DATE, COMMENT, WITHOUT_COLOR)}
        };
    }

    @Test
    @DisplayName("Создание заказа")
    public void createOrderTest() {
        Response response = OrderClient.createOrder(order);
        track = response.then().extract().path("track");
        response.then().assertThat().statusCode(201).and().body("track", notNullValue());
    }

}
