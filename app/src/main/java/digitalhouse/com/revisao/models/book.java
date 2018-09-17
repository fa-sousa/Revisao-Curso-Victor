package digitalhouse.com.revisao.models;

public class book {

    private String author;
    private String title;

    public book(String autor, String title){
        this.author = autor;
        this.title = title;
    }

    public String getAuthor() {

        return author;
    }

    public void setAutor(String autor) {
        this.author = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
