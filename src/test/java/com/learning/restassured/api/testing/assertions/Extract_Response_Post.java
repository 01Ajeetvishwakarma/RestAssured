package com.learning.restassured.api.testing.assertions;

import com.learning.restassured.api.testing.common.Customer_Base_Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Extract_Response_Post extends Customer_Base_Test {

    @Test
    public void validated_Response_From_Post(){

        JSONArray jsonArray = new JSONArray();
        jsonArray.put("AJEET");
        jsonArray.put("VISHWAKARMA");
        jsonArray.put("XYZ");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id","10");
        jsonObject.put("title","Unknown Title");
        jsonObject.put("pages","10000000000000000000000");
        jsonObject.put("authors","JsonArray");

        Response response= given()
                .contentType(ContentType.JSON)
                .when()
                .body(jsonObject)
                .post("http://localhost:8080/bookService/books")
                .then()
                .log().all()
                .assertThat().statusCode(201)
                .extract()
                .response();

        JsonPath jsonPath = new JsonPath(response.asString());

        System.out.println(jsonPath.getString("title"));
    }

}
