package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    // Spring creates the ProductService and hands it over.
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return new Product(id, "Laptop", 999.99);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }
    @PostMapping("/products")
    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}