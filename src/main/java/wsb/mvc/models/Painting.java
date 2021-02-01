package wsb.mvc.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Painting {

    @Id
    Long id;

    String name;
    String author;

    Integer year;

    String url;

    public Painting(String name, String author, Integer year, String url) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.url = url;
    }
}
