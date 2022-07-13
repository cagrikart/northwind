package kodlamaiocagri.northwind.business.concretes;

import kodlamaiocagri.northwind.business.abstracts.ProductService;
import kodlamaiocagri.northwind.core.utilities.results.DataResults;
import kodlamaiocagri.northwind.core.utilities.results.Results;
import kodlamaiocagri.northwind.core.utilities.results.SuccessDataResult;
import kodlamaiocagri.northwind.core.utilities.results.SuccessResult;
import kodlamaiocagri.northwind.dataAccess.abstracts.ProductDao;
import kodlamaiocagri.northwind.entities.concretes.Product;
import kodlamaiocagri.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public DataResults<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Sıralandı");
    }

    @Override
    public DataResults<List<Product>> getAll(int pageNo, int sizeNo) {
        Pageable pageable = PageRequest.of(pageNo-1 ,sizeNo);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent()); // findall  pageable dan seçtik
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
    public DataResults<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
    }
    @Override
    public DataResults<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Data Listelendi");
    }

    @Override
    public DataResults<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),"Data listelendi");
    }
  /*  @Override
    public DataResults<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data Listelendi");
    }
    @Override
    public DataResults<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories),"Data Listelendi");
    }



    @Override
    public DataResults<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");
    }

    @Override
    public DataResults<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi");

    }*/

}
