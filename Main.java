public class Main {
    public static void main(String[] args) {
        library library = new library();
        
//        Book book1 = new Book();
//        book1.setId("1");
//        book1.setTitle("Book Title 1");
//        book1.setAuthor("Author 1");
//        book1.setYear(2020);
//        book1.setGenre("Fiction");
//        book1.setPrice(19.99);
//        book1.setCurrency("USD");
//        book1.setIsbn("123-4567890123");
//        Publisher publisher1 = new Publisher();
//        publisher1.setName("Publisher 1");
//        Address address1 = new Address();
//        address1.setCity("City 1");
//        address1.setCountry("Country 1");
//        publisher1.setAddress(address1);
//        book1.setPublisher(publisher1);
//        book1.setLanguage("English");
//        book1.setTranslator("Translator 1");
//
//        library.addBook(book1);

        // Сериализация в XML
        String xmlOutput = library.toXML();
        System.out.println("Generated XML:");
        System.out.println(xmlOutput);

        boolean isValid = XMLValidator.validateXML("src/generated_library.xml", "src/library.xsd");
        System.out.println("XML is valid: " + isValid);
    }
}
