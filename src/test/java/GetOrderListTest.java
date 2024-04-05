import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import order.OrderClient;
import org.junit.Test;
import static org.hamcrest.Matchers.notNullValue;

public class GetOrderListTest extends BaseTest {
    @Test
    @DisplayName("Получение списка заказов")
    public void getOrderListTest() {
        Response response = OrderClient.getOrderList();
        response.then().assertThat().statusCode(200).and().body("orders", notNullValue());
    }
}
