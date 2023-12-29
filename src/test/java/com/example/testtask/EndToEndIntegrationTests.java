package com.example.testtask;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

@SpringBootTest()
public class EndToEndIntegrationTests {
    @Value("${api.base.url}")
    private String baseUrl;

    @Test
    @SqlGroup({
            @Sql(scripts = "classpath:sql/cleanup-test-data-users.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    })
    public void testUserAddEndpoint() {
        RestAssured.baseURI = baseUrl;

        RequestSpecification request = RestAssured.given();

        String payload = "{\n" +
                "    \"username\": \"Bob\",\n" +
                "    \"password\" : \"12345678\"\n" +
                "}";
        request.header("Authorization", "Bearer " + obtainAccessToken())
                .header("Content-Type","application/json");
        Response response = request.body(payload).post("/users/add");
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    @SqlGroup({
            @Sql(scripts = "classpath:sql/cleanup-test-data-products.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    })
    public void testProductAddEndpoint() {
        RestAssured.baseURI = baseUrl;

        RequestSpecification request = RestAssured.given();

        String payload = "{\n" +
                "\"records\" : [\n" +
                "{\n" +
                "\"entryDate\": \"03-01-2023\",\n" +
                "\"itemCode\": \"11111\",\n" +
                "\"itemName\": \"Test Inventory 1\",\n" +
                "\"itemQuantity\": \"20\",\n" +
                "\"status\": \"Paid\"\n" +
                "},\n" +
                "{\n" +
                "\"entryDate\": \"03-01-2023\",\n" +
                "\"itemCode\": \"11111\",\n" +
                "\"itemName\": \"Test Inventory 2\",\n" +
                "\"itemQuantity\": \"20\",\n" +
                "\"status\": \"Paid\"\n" +
                "}] }";

        request.header("Authorization", "Bearer " + obtainAccessToken())
                .header("Content-Type","application/json");
        Response response = request.body(payload).post("/products/add");
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void testGetAllProductsEndpoint() {
        RestAssured.baseURI = baseUrl;

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + obtainAccessToken())
                .header("Content-Type","application/json");
        Response response = request.get("/products/all");
        Assertions.assertEquals(200, response.statusCode());
    }

    private String obtainAccessToken() {
        RestAssured.baseURI = baseUrl;

        RequestSpecification request = RestAssured.given();

        String payload = "{\n" +
                "    \"username\": \"Alice\",\n" +
                "    \"password\" : \"12345678\"\n" +
                "}";
        request.header("Content-Type","application/json");
        Response responseFromGenerateToken = request.body(payload).post("/users/authenticate");
        String jsonString = responseFromGenerateToken.getBody().asString();
        return JsonPath.from(jsonString).get("token");
    }

}
