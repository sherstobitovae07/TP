import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XMLParser {
    public library parse(String filePath) {
        library library = new library();
        Book book = null;
        Publisher publisher = null;
        Address address = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("<book")) {
                    book = new Book();
                    book.setId(extractAttribute(line, "id"));
                } else if (line.startsWith("<title>")) {
                    book.setTitle(extractValue(line, "title"));
                } else if (line.startsWith("<author>")) {
                    book.setAuthor(extractValue(line, "author"));
                } else if (line.startsWith("<year>")) {
                    book.setYear(Integer.parseInt(extractValue(line, "year")));
                } else if (line.startsWith("<genre>")) {
                    book.setGenre(extractValue(line, "genre"));
                } else if (line.startsWith("<price")) {
                    book.setCurrency(extractAttribute(line, "currency"));

                    // Получаем значение между тегами <price> и </price>
                    String priceValue = line.substring(line.indexOf(">") + 1, line.lastIndexOf("</price>")).trim();
                    book.setPrice(Double.parseDouble(priceValue));
                } else if (line.startsWith("<isbn>")) {
                    book.setIsbn(extractValue(line, "isbn"));
                } else if (line.startsWith("<publisher>")) {
                    publisher = new Publisher();
                } else if (line.startsWith("<name>")) {
                    publisher.setName(extractValue(line, "name"));
                } else if (line.startsWith("<address>")) {
                    address = new Address();
                } else if (line.startsWith("<city>")) {
                    address.setCity(extractValue(line, "city"));
                } else if (line.startsWith("<country>")) {
                    address.setCountry(extractValue(line, "country"));
                } else if (line.startsWith("</address>")) {
                    publisher.setAddress(address);
                } else if (line.startsWith("</publisher>")) {
                    book.setPublisher(publisher);
                } else if (line.startsWith("<language>")) {
                    book.setLanguage(extractValue(line, "language"));
                } else if (line.startsWith("<translator>")) {
                    book.setTranslator(extractValue(line, "translator"));
                } else if (line.startsWith("</book>")) {
                    library.addBook(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return library;
    }

    private String extractAttribute(String line, String attribute) {
        String pattern = attribute + "=\"";
        int start = line.indexOf(pattern) + pattern.length();
        int end = line.indexOf("\"", start);
        return line.substring(start, end);
    }

    private String extractValue(String line, String tag) {
        return line.replace("<" + tag + ">", "").replace("</" + tag + ">", "");
    }
}
