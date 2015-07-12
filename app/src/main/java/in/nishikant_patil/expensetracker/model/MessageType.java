package in.nishikant_patil.expensetracker.model;

/**
 * Created by Nishikant on 7/12/2015.
 */
public enum MessageType {
    SENT("sent"),
    RECEIVED("inbox"),
    DRAFT("draft");

    private String name;
    MessageType(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
