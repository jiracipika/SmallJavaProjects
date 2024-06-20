public class Book {

    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static void main(String[] args) {
        Book mobyDick = new Book("Moby Dick");
        System.out.println("The title of the book is: " + mobyDick.getTitle());

        mobyDick.setTitle("War and Peace");
        System.out.println("The title of the book is now: " + mobyDick.getTitle());
    }
}
