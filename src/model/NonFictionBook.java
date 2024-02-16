package model;

import static java.lang.System.out;

public class NonFictionBook extends Book {
    String bookDescription;

    public NonFictionBook()
    {
        super();
        bookDescription = "";
    }
    public void setDescription(String Description)
    {
        this.bookDescription = "THIS IS A DESCRIPTION : " + Description;
    }
    @Override
    public void DisplayInfo(){
        System.out.println("<------BookINFO------->");
        System.out.println(" availability " + this.availability);
        System.out.println("  author " + this.author);
        System.out.println("  book Title " + this.title);
        System.out.println("Summary " + this.bookDescription);
    }
}
