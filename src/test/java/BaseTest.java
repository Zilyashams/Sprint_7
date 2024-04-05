import courier.CourierClient;
import io.restassured.RestAssured;
import order.OrderClient;
import org.junit.After;
import org.junit.Before;

import static constants.Data.*;


public class BaseTest {
    protected Integer courierId;
    protected Integer track;

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

    @After
    public void clearData() {
        if (courierId != null) {
            CourierClient.deleteCourier(courierId);
        }
        if (track != null) {
            OrderClient.cancelOrder(track);
        }
    }
}
