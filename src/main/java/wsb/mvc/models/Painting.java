package wsb.mvc.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class Painting {
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
