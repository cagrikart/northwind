package kodlamaiocagri.northwind.core.utilities.results;

public class ErrorDataResult<T> extends DataResults{
    public ErrorDataResult(T data, boolean success, String messeage) {
        super(data, false, messeage);
    }

    public ErrorDataResult(T data, boolean success) {
        super(data, false);
    }
    public ErrorDataResult(T data) {
        super(data, false);
    }
    public ErrorDataResult(String messeage) {
        super( null,false, messeage);
    }
    public ErrorDataResult() {
        super( null,false);
    }
}
