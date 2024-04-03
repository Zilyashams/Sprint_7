package constants;

import java.util.List;

public class Data {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final String LOGIN = "qazaqa";
    public static final String PASSWORD = "1234";
    public static final String FIRST_NAME = "qaqaqa";
    public static final String SECOND_PASSWORD = "4321";
    public static final String FIRST_NAME_2 = "zazaza";
    public static final String EMPTY_LOGIN = "";
    public static final String EMPTY_PASSWORD = "";
    public static final String EMPTY_FIRST_NAME = "";

    public static final String NONEXIST_LOGIN = "ups";
    public static final String NONEXIST_PASSWORD = "ups";


    public static final String LAST_NAME = "Uchiha";
    public static final String ADDRESS = "Konoha, 142 apt.";
    public static final int METRO_STATION = 4;
    public static final String PHONE = "+7 800 355 35 35";
    public static final int RENT_TIME = 5;
    public static final String DELIVERY_DATE = "2024-04-15";
    public static final String COMMENT = "Saske, come back to Konoha";
    public static final List<String> BLACK_COLOR = List.of("BLACK");
    public static final List<String> GREY_COLOR = List.of("GREY");
    public static final List<String> BOTH_COLORS = List.of("BLACK","GREY");
    public static final List<String> WITHOUT_COLOR = List.of("");


    public static final String MESSAGE_FOR_INCOMPLETE_REQUEST_CREATE_COURIER = "Недостаточно данных для создания учетной записи";
    public static final String MESSAGE_FOR_INCOMPLETE_REQUEST_LOGIN_COURIER = "Недостаточно данных для входа";
    public static final String MESSAGE_FOR_INCORRECT_REQUEST_LOGIN_COURIER = "Учетная запись не найдена";
    public static final String MESSAGE_FOR_INCORRECT_REQUEST_CREATE_COURIER = "Этот логин уже используется";

}
