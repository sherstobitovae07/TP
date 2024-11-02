import java.util.ArrayList;
import java.util.List;

public class library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" + "books=" + books + '}';
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlBuilder.append("<library>\n");

        for (Book book : books) {
            xmlBuilder.append(book.toXML());
        }

        xmlBuilder.append("</library>");
        return xmlBuilder.toString();
    }



}
