package org.hmo.auarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldGetAllBooks() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .when()
            .get("/api/books")
        .then()
             .statusCode(200)
             .body("size()", is(4));
    }

    @Test
    public void shouldCountAllBooks() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
        .when()
            .get("/api/books/count")
        .then()
            .statusCode(200)
            .body(is("4"));
    }

    @Test
    public void shouldGetABook() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id",1)
        .when()
            .get("/api/books/{id}")
        .then()
            .statusCode(200)
            .body("title", is("Kitap1"))
            .body("author", is("Yazar1"))
            .body("yearOfPublication", is(2020))
            .body("genre", is("IT"));
    }

}