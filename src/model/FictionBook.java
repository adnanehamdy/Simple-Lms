package model;

public class FictionBook extends Book {
    String plotSummary;

    public FictionBook()
    {
        super();
        plotSummary = "";
    }
    public void setDescription(String plot)
    {
        this.bookDescription = "THIS IS A PLOT : " + plot;
    }

    @Override
    public void DisplayInfo() {
        System.out.println("<------BookINFO------->");
        System.out.println("  availability : " + this.isAvailable());
        System.out.println("  author : " + this.getAuthor());
        System.out.println("  book Title : " + this.getTitle());
        System.out.println("  Summary : " + this.plotSummary);
    }
}
