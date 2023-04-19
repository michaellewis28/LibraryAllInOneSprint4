package com.library.steps;

import com.library.utility.ConfigurationReader;
import com.library.utility.LibraryAPI_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class us01_bz_stepdefs {
    RequestSpecification givenPart;
    Response response;
    ValidatableResponse thenPart;
    String acceptContentType;

    @Given("I logged Library api as a {string} BZ")
    public void i_logged_library_api_as_a_bz(String userType) {
        givenPart = given().log().all()
                .header("x-library-token", LibraryAPI_Util.getToken(userType));
    }
    @Given("Accept header is {string} BZ")
    public void accept_header_is_bz(String contentType) {
        givenPart.accept(contentType);
        acceptContentType = contentType;
    }
    @When("I send GET request to {string} endpoint BZ")
    public void i_send_get_request_to_endpoint_bz(String endpoint) {
        response = givenPart.when().get(ConfigurationReader.getProperty("library.baseUri")+endpoint).prettyPeek();
        thenPart = response.then();
    }
    @Then("status code should be {int} BZ")
    public void status_code_should_be_bz(Integer statusCode) {
        thenPart.statusCode(statusCode);
    }
    @Then("Response Content type is {string} BZ")
    public void response_content_type_is_bz(String contentType) {
        thenPart.contentType(contentType);
    }
    @Then("{string} field should not be null BZ")
    public void field_should_not_be_null_bz(String path) {
        thenPart.body(path, is(notNullValue()));
    }
}
