package ru.qa_scooter.praktikum_services;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import гu.qa_scooter.praktikum_services.CourierClient;
import гu.qa_scooter.praktikum_services.ListOrders;

import java.util.ArrayList;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ListOrdersTest {
    CourierClient courierClient;
    private ListOrders listOrders;

    @Before
    public void setup(){
        courierClient = new CourierClient();
    }

    @Test
    @DisplayName("Getting a list of orders")
    @Description("Service return 200 and orders not empty")
    public void listOrderTest(){
        ValidatableResponse response = CourierClient.listOrder();
        response.statusCode(SC_OK);
        MatcherAssert.assertThat("orders", notNullValue());
    }
}
