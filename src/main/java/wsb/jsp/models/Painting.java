package wsb.jsp.models;

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

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    public String getUrl() {
        return url;
    }
}
