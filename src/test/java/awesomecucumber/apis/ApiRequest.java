/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework (https://www.udemy.com/course/cucumber-bdd-masterclass/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package awesomecucumber.apis;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ApiRequest extends SpecBuilder{

    public static Response post(String endPoint, Headers headers,
                                HashMap<String, Object> formParams, Cookies cookies){
        return given(getRequestSpec()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
        when().
                post(endPoint).
        then().
        		spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String endPoint, Cookies cookies){
        return given(getRequestSpec()).
                cookies(cookies).
        when().
                get(endPoint).
        then().
        		spec(getResponseSpec()).
                extract().
                response();
    }
}
