package libraries;

public class Book {
    private  Integer code;
    private  String name;
    private String author;
    private String publishingCompany;
    private String type;
    private Integer price;
    private Integer amount;

    public Book(Integer code, String name, String author, String publishingCompany, String type, Integer price, Integer amount) {
        this.code = code;
        this.name = name;
        this.author = author;
        this.publishingCompany = publishingCompany;
        this.type = type;
        this.price = price;
        this.amount = amount;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return this.getCode()+"----"+this.getName()+"----"+this.getAuthor()+"----"+this.getPublishingCompany()+"----"+this.getType()+"----"+this.getPrice()+"----"+this.getAmount();
    }
}
