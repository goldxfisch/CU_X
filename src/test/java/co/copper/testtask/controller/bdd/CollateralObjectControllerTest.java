package co.copper.testtask.controller.bdd;

import co.copper.testtask.dto.AssetDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

class CollateralObjectControllerTest {
    @BeforeAll
    public static void setUP() {
        baseURI = "http://localhost:8080";
        port = 8080;
    }


    @Test
    public void whenRequestedPost_thenCreate() {
        with()
                .header("Content-Type","application/json" )
                .header("Accept","application/json" )
                .body(new AssetDto(4L, "TEST ASSET 4", "INR", (short) 2023, new BigDecimal(1100000.99)))
                .when()
                .request("POST", "/collaterals")
                .then()
                .statusCode(200)
        ;
    }
// Input - VALUE DROPS DECIMALS
    @Test
    public void whenRequestedGet_thenRetrive(){

        get("/collaterals/{id}",4)
                .then()
                .statusCode(200)
                .body("name",equalTo("TEST ASSET 4"))
                .body("value",equalTo(1100001.99));

            }


}