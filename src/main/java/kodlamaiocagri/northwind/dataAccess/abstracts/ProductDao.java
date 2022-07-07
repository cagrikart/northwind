package kodlamaiocagri.northwind.dataAccess.abstracts;

import kodlamaiocagri.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndAndCategoryId(String productName , int categoryId); //  hem product name i hem de category ıd i getir

    List<Product> getByProductNameOrCategoryId(String productName, int categoryId); // product name i ya da category name i getir

    List<Product> getByCategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where  productName=:productName and categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName,int categoryId);

}
