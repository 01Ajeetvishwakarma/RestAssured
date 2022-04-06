//package com.learning.restassured.api.testing.optimization;
//
//import com.learning.restassured.api.testing.common.Customer_Base_Test;
//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.builder.ResponseSpecBuilder;
//import io.restassured.filter.log.LogDetail;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.testng.annotations.*;
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.MatcherAssert.*;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.is;
//
//public class Validate_Response_Code_From_Get_Request extends Customer_Base_Test
//{
//
//    @BeforeClass
//    private void setUp()
//        {
//            //BDD-Way
//            requestSpecification = given()
//            /*with()*/
//            .auth()
//            .basic(getProperties().getProperty("secretKey"), "")
//            .log().all()
//            .baseUri("https://api.stripe.com")
//            .basePath("/v1");
//            //#################################################################
//
//            //Non-BDD-Way
//            RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//            requestSpecBuilder.setAuth(basic(getProperties().getProperty("secretKey"),""));
//            requestSpecBuilder.setBaseUri("https://api.stripe.com");
//            requestSpecBuilder.setBasePath("/v1");
//            RestAssured.requestSpecification = requestSpecBuilder.build();
//            //####################################################################
//
//            //Non-BDD_Way
//            ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
//            .expectStatusCode(200)
//            .expectContentType(ContentType.JSON)
//            .log(LogDetail.ALL);
//            //################################################################
//
//            //BDD_Way
//            RestAssured.responseSpecification = RestAssured.expect().statusCode(200)
//            .contentType(ContentType.JSON)
//            .log().all();
//        }
//
//    @Test(description = "validate_response_code_from_get_request_for_list_of_user_in_BDD_Style")
//    public void validate_response_code_from_get_request_in_bdd_style()
//        {
//            given(requestSpecification)
//            /*.spec(requestSpecification)*/
//            .when().log().body()
//            .get(getProperties().getProperty("EndPoint"))
//            .then()
//            .log().status()
//            .assertThat().statusCode(200);
//        }
//
//    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
//
//    @Test(description = "validate_response_code_from_get_request_for_list_of_user_in_non_BDD_Style")
//    public void validate_response_code_from_get_request_in_non_bdd_style()
//         {
//            Response response = get("/customers");
//            assertThat(response.statusCode(), is(equalTo(200)));
//            assertThat(response.path("data[0].name"), equalTo("Ajeet22"));
//         }
//
//    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
//
//    @Test(description = "validate_response_code_from_get_request_for_list_of_user_in_BDD_Style_RestAssured")
//    public void validate_response_code_from_get_request_in_bdd_style_RestAssured()
//        {
//           Response response= get("/customers");
//           assertThat(response.statusCode(), is(equalTo(200)));
//        }
//
//    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//
//    @Test
//    public void validate_Response_Status_Code()
//        {
//            get("/customers");
//    //                .then().spec(responseSpecification);
//        }
//
//}
