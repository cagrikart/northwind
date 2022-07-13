package kodlamaiocagri.northwind.business.abstracts;

import kodlamaiocagri.northwind.core.utilities.results.DataResults;
import kodlamaiocagri.northwind.core.utilities.results.Results;
import kodlamaiocagri.northwind.dataAccess.abstracts.ProductDao;
import kodlamaiocagri.northwind.entities.concretes.Product;
import kodlamaiocagri.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResults<List<Product>> getAll();
    DataResults<List<Product>> getAllSorted();

    DataResults<List<Product>> getAll(int page,int sizeNo);
    //List<Product> getAll();
    Results add(Product product); // jpa dan kullanıyoruz

    DataResults<Product> getByProductName(String productName);

    DataResults<Product> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResults<List<Product>> getByProductNameContains(String productName);

    DataResults<List<ProductWithCategoryDto>> getProductWithCategoryDetails();


   /* DataResults<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResults<List<Product>>  getByCategoryIdIn(List<Integer> categories);


    DataResults<List<Product>>  getByProductNameStartsWith(String productName);

    DataResults<List<Product>>  getByNameAndCategory(String productName, int categoryId);*/
}
