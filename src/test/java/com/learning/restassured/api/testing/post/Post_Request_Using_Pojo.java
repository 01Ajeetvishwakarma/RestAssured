package com.learning.restassured.api.testing.post;
import com.learning.restassured.api.testing.get.dto.Books;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Arrays;
import static io.restassured.RestAssured.given;

public class Post_Request_Using_Pojo
{
    public static void main(String[] args)
    {
        Books books = new Books();
        books.setId(12);
        books.setPages(4);
        books.getTitle("POJO in Action");
        books.setList(Arrays.asList("w","r"));

       Response response = given()
               .contentType(ContentType.JSON)
               .body(books)
                .post("http://localhost:8080/bookService/books");

        response.prettyPrint();
        System.out.println("Status code : "+ response.getStatusCode());

    }
}
