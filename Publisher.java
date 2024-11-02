public class Publisher {
    private String name;
    private Address address;

    // Constructor, getters, setters, and toString

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<publisher>\n");
        xmlBuilder.append("            <name>").append(name).append("</name>\n");
        xmlBuilder.append("            ").append(address.toXML()).append("\n");
        xmlBuilder.append("        </publisher>");
        return xmlBuilder.toString();
    }

}
