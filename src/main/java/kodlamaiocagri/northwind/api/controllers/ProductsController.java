package kodlamaiocagri.northwind.api.controllers;

import kodlamaiocagri.northwind.business.abstracts.ProductService;
import kodlamaiocagri.northwind.core.utilities.results.DataResults;
import kodlamaiocagri.northwind.core.utilities.results.Results;
import kodlamaiocagri.northwind.entities.concretes.Product;
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

    @GetMapping("/getByProduct")
    public DataResults<Product> getgetByProductName (@RequestParam String productName) {
        return this.productService.getByProductName(productName);
    }
}
