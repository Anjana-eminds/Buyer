package buyerdemo.application.Buyerapp.controller;

import buyerdemo.application.Buyerapp.dto.ProductDto;
import buyerdemo.application.Buyerapp.dto.UserDto;
import buyerdemo.application.Buyerapp.service.ProductService;
import buyerdemo.application.Buyerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Object saveProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct(productDto);
    }

    @GetMapping("/products")
    public Object fetchProductList(){
        return productService.fetchProductList();
    }

    @GetMapping("/products/{id}")
    public Object fetchProductById(@PathVariable("id") Long id){
        return productService.fetchProductById(id);
    }

    @PutMapping("/products/{id}")
    public Object updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) throws Exception{
        return productService.updateProduct(id, productDto);
    }

    @PutMapping("/status/{id}")
    public Object statusUpdateForProduct(@PathVariable(value = "id") Long id) throws Exception {
        return productService.statusUpdate(id);
    }

    @DeleteMapping("/products/{id}")
    public Object deleteProductById(@PathVariable("id") Long id) throws Exception{
        return productService.deleteProductById(id);
    }
}
