package kodlamaiocagri.northwind.dataAccess.abstracts;

import kodlamaiocagri.northwind.entities.concretes.Product;
import kodlamaiocagri.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName , int categoryId); //  hem product name i hem de category ıd i getir

    List<Product> getByProductNameOrCategory_CategoryId( String productName, int categoryId); // product name i ya da category name i getir

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where  productName=:productName and  category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName,int categoryId);

    @Query("Select new kodlamaiocagri.northwind.entities.dtos.ProductWithCategoryDto"
            + "(p.id, p.productName, c.categoryName) "
            + "From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();


}
