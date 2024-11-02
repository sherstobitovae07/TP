public class Book {
    private String id;
    private String title;
    private String author;
    private int year;
    private String genre;
    private double price;
    private String currency;
    private String isbn;
    private Publisher publisher;
    private String language;
    private String translator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher=" + publisher +
                ", language='" + language + '\'' +
                ", translator='" + translator + '\'' +
                '}';
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("    <book id=\"").append(id).append("\">\n");
        xmlBuilder.append("        <title>").append(title).append("</title>\n");
        xmlBuilder.append("        <author>").append(author).append("</author>\n");
        xmlBuilder.append("        <year>").append(year).append("</year>\n");
        xmlBuilder.append("        <genre>").append(genre).append("</genre>\n");
        xmlBuilder.append("        <price currency=\"").append(currency).append("\">").append(price).append("</price>\n");
        xmlBuilder.append("        <isbn>").append(isbn).append("</isbn>\n");
        xmlBuilder.append("        ").append(publisher.toXML()).append("\n");
        xmlBuilder.append("        <language>").append(language).append("</language>\n");
        if (translator != null) {
            xmlBuilder.append("        <translator>").append(translator).append("</translator>\n");
        }
        xmlBuilder.append("    </book>\n");
        return xmlBuilder.toString();
    }

}
