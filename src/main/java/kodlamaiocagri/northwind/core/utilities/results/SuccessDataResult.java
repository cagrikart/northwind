package kodlamaiocagri.northwind.core.utilities.results;

public class SuccessDataResult <T> extends DataResults{

    public SuccessDataResult(T data, String message) {
        super(data, true,message);
    }
    public SuccessDataResult(T data) {
        super(data, true);
    }
    public SuccessDataResult( String message) {
        super(null, true,message);
    }
}
