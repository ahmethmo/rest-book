package org.hmo.auarkus;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "book.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAllBooks(){
        return List.of(
                new Book(1, "Kitap1", "Yazar1", 2020, genre),
                new Book(2, "Kitap2", "Yazar2", 2021, genre),
                new Book(3, "Kitap3", "Yazar3", 2022, genre),
                new Book(4, "Kitap4", "Yazar4", 2019, genre)
        );
    }

    public Optional<Book> getBook(@PathParam("id") int id){
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}