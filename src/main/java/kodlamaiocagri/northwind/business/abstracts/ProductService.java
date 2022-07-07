package kodlamaiocagri.northwind.business.abstracts;

import kodlamaiocagri.northwind.core.utilities.results.DataResults;
import kodlamaiocagri.northwind.core.utilities.results.Results;
import kodlamaiocagri.northwind.dataAccess.abstracts.ProductDao;
import kodlamaiocagri.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResults<List<Product>> getAll();

    //List<Product> getAll();
    Results add(Product product); // jpa dan kullanıyoruz


    DataResults<Product> getByProductName(String productName);


    DataResults<Product> getByProductNameAndAndCategory(String productName, int categoryId); //  hem product name i hem de category ıd i getir
 /*
    DataResults<List<Product>> getByProductNameOrCategory(String productName, int categoryId); // product name i ya da category name i getir

    DataResults<List<Product>> getByCategoryIn(List<Integer> categories);

    DataResults<List<Product>> getByProductNameContains(String productName);

    DataResults<List<Product>> getByProductNameStartsWith(String productName);

    DataResults<List<Product>> getByNameAndCategory(String productName, int categoryId);
*/
}
