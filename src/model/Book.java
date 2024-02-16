package model;

public class Book {
    // attribute
    protected String title;
    protected String author;
    protected String bookDescription;
    protected boolean availability;

    public Book()
    {
        title = "";
        author = "";
        availability = false;
    }

    // Getter and setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and setter for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter and setter for availability
    public boolean isAvailable() {
        return availability;
    }

    public void setAvailable(boolean availability) {
        this.availability = availability;
    }
    public void DisplayInfo()
    {}
}
