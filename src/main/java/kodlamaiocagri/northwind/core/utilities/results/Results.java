package kodlamaiocagri.northwind.core.utilities.results;

public class Results {
    private boolean success;
    private String messeage;

    public Results(boolean success) {
        this.success = success;
    }

    public Results(boolean success, String messeage) {
        this(success);
        this.messeage = messeage;
    }
    public  boolean isSuccess(){
        return this.success;
    }
    public String  getMessage(){
        return this.messeage;
    }


}
