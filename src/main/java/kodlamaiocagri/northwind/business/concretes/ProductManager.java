package kodlamaiocagri.northwind.business.concretes;

import kodlamaiocagri.northwind.business.abstracts.ProductService;
import kodlamaiocagri.northwind.core.utilities.results.DataResults;
import kodlamaiocagri.northwind.core.utilities.results.Results;
import kodlamaiocagri.northwind.core.utilities.results.SuccessDataResult;
import kodlamaiocagri.northwind.core.utilities.results.SuccessResult;
import kodlamaiocagri.northwind.dataAccess.abstracts.ProductDao;
import kodlamaiocagri.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }

    @Override
    public DataResults<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listelendi");
    }

    @Override
    public Results add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün eklendi ");
    }

    @Override
    public DataResults<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data Listelendi");

    }

    @Override
    public DataResults<Product> getByProductNameAndAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndAndCategoryId(productName,categoryId),"Data Listelendi");

    }

    @Override
    public DataResults<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategoryId(productName,categoryId),"Data Listelendi");
    }

    @Override
    public DataResults<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIdIn(categories),"Data Listelendi");
    }

    @Override
    public DataResults<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Data Listelendi");

    }

    @Override
    public DataResults<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");
    }

    @Override
    public DataResults<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi");

    }


}
