package kodlamaiocagri.northwind.core.utilities.results;

public class DataResults<T> extends  Results{
    private  T data;

    public DataResults( T data ,boolean success, String messeage) {
        super(success, messeage);
        this.data = data;
    }

    public DataResults(T data, boolean success) {
        super(success);
        this.data = data;
    }
    public T getData() {
        return this.data;
    }

}
