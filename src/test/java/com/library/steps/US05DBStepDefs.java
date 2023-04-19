package com.library.steps;


import com.library.utility.ConfigurationReader;
import com.library.utility.LibraryAPI_Util;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class US05DBStepDefs {

    RequestSpecification givenPart;
    Response response;
    ValidatableResponse thenPart;

    String token;
    @Given("I logged Library api with credentials {string} and {string} DB")
    public void i_logged_library_api_with_credentials_and_db(String email, String password) {

        token = LibraryAPI_Util.getToken(email, password);
        givenPart = given().log().all()
                .header("x-library-token",token);

    }
    @Given("Accept header is {string} DB")
    public void accept_header_is_db(String contentType) {

        givenPart.accept(contentType);

    }
    @Given("Request Content Type header is {string} DB")
    public void request_content_type_header_is_db(String reqContentType) {

        givenPart.request().contentType(reqContentType);

    }
    @Given("I send token information as request body DB")
    public void i_send_token_information_as_request_body_db() {

        Map<String,Object> token5 = new HashMap<>();
        token5.put("token",token);
        givenPart.formParams(token5);

    }


    @When("I send POST request to {string} endpoint DB")
    public void i_send_post_request_to_endpoint_db(String endPoint) {

        response = givenPart.when().post(ConfigurationReader.getProperty("library.baseUri") + endPoint);

    }
    @Then("status code should be {int} DB")
    public void status_code_should_be_db(Integer statusCode) {



        response.then().statusCode(statusCode);

    }
    @Then("Response Content type is {string} DB")
    public void response_content_type_is_db(String respContentType) {

        response.then().contentType(respContentType);
        thenPart = response.then();

    }
    @Then("the field value for {string} path should be equal to {string} DB")
    public void the_field_value_for_path_should_be_equal_to_db(String expectedValue, String actualValue) {

        thenPart.body(expectedValue,is(equalTo(actualValue)));

    }
    @Then("{string} field should not be null DB")
    public void field_should_not_be_null_db(String field) {

        thenPart.body(field, is(notNullValue()));

    }



}
