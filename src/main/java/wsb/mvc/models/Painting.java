package wsb.mvc.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Painting {

    @Id
    @GeneratedValue
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
