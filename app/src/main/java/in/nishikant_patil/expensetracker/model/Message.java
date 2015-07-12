package in.nishikant_patil.expensetracker.model;

/**
 * Created by Nishikant on 7/12/2015.
 */
public class Message {
    private String id;
    private String address;
    private String content;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
