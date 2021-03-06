package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {


    public static Response post(String endpoint, Object body){
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        requestSpec.accept(ContentType.JSON);
        requestSpec.body(body).log().all();

        Response resp = requestSpec.post(endpoint);
        return resp;
    }

    public static Response put(String endpoint, Object body){
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        requestSpec.accept(ContentType.JSON);
        requestSpec.body(body);

        Response resp = requestSpec.put(endpoint);
        return resp;
    }

    public static Response get(String endpoint, Integer id){
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        requestSpec.accept(ContentType.JSON);
        requestSpec.pathParam("id", id );


        Response resp = requestSpec.get(endpoint);
        return resp;
    }

    public static Response delete(String endpoint, Integer id){
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        requestSpec.accept(ContentType.JSON);
        requestSpec.pathParam("id", id );

        Response resp = requestSpec.delete(endpoint);
        return resp;
    }


}
