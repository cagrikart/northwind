package kodlamaiocagri.northwind.api.controllers;

import kodlamaiocagri.northwind.business.abstracts.ProductService;
import kodlamaiocagri.northwind.core.utilities.results.DataResults;
import kodlamaiocagri.northwind.core.utilities.results.Results;
import kodlamaiocagri.northwind.core.utilities.results.SuccessDataResult;
import kodlamaiocagri.northwind.entities.concretes.Product;
import kodlamaiocagri.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) { // kim product service implemente etmiş diye bbakıyor ondan sonra ise
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResults<List<Product>> getAll() {
        return this.productService.getAll();
    }
  /*  @GetMapping("/getall")
    public List<Product> getAll(){
        return this.productService.getAll();

    }
    */
    @PostMapping("/add")
    public Results add(@RequestBody  Product product) {
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResults<Product> getByProductName (@RequestParam(required=false,name="productName") String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResults<Product> getByProductNameAndAndCategoryId(@RequestParam(required=false,name="productName") String productName,@RequestParam(required=false,name="categoryId") int categoryId) {
        System.out.println(productName);
        System.out.println(categoryId);
        return this.productService.getByProductNameAndCategoryId(productName,categoryId);
    }
    @GetMapping("/getByProductNameContains")
    public DataResults<List<Product>> getByProductNameContains(@RequestParam(name="productName") String productName) {
        return this.productService.getByProductNameContains(productName);
    }
    @GetMapping("/getAllByPage")
    DataResults<List<Product>> getAll(int page,int sizeNo){
        return this.productService.getAll(page,sizeNo);
    }
    @GetMapping("/getAllSorted")
    public DataResults<List<Product>> getAllSorted() {
        return  this.productService.getAllSorted();
    }

    @GetMapping("/getProductWithCategoryDetails")
    DataResults<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }




    /* @GetMapping("/getByProductNameOrCategoryId")
    public DataResults<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName,@RequestParam int categoryId) {
       System.out.println(productName);
       System.out.println(categoryId);
        return this.productService.getByProductNameOrCategoryId(productName,categoryId);
    }
    @GetMapping("/getByCategoryIdIn")
    public DataResults<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories) {
        return this.productService.getByCategoryIdIn(categories);

    }


    @GetMapping("/getByProductNameStartsWith")
    public DataResults<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
        return this.productService.getByProductNameStartsWith(productName);

    }
    @GetMapping("/getByNameAndCategory")
    public DataResults<List<Product>> getByNameAndCategory(@RequestParam String productName, @RequestParam int categoryId) {
        return this.productService.getByNameAndCategory(productName,categoryId);

    }*/
}
