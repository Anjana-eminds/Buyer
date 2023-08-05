package buyerdemo.application.Buyerapp.service.impl;

import buyerdemo.application.Buyerapp.dto.ProductDto;
import buyerdemo.application.Buyerapp.entities.Product;
import buyerdemo.application.Buyerapp.entities.Status;
import buyerdemo.application.Buyerapp.repository.ProductRepository;
import buyerdemo.application.Buyerapp.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Object saveProduct(ProductDto productDto) {
        Date currentDate = new java.util.Date();
        Product product = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .status(Status.ACTIVE)
                .discount(productDto.getDiscount())
                .discountPrice(productDto.getDiscountPrice())
                .stock(productDto.getStock())
                .createdAt(currentDate)
                .build();
        productRepository.save(product);
        return HttpStatus.OK;
    }

    @Override
    public Object fetchProductList() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Object fetchProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException();
        }
        Product product = optionalProduct.get();
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public Object updateProduct(Long id, ProductDto productDto) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new Exception("Not found");
        }
        Product product = optionalProduct.get();
        if (Objects.nonNull(productDto.getName()) && !"".equalsIgnoreCase(productDto.getName())) {
            product.setName(productDto.getName());
        }
        if (Objects.nonNull(productDto.getPrice()) && !"".equalsIgnoreCase(String.valueOf(productDto.getPrice()))) {
            product.setPrice(productDto.getPrice());
        }
        if (Objects.nonNull(productDto.getDiscount()) && !"".equalsIgnoreCase(productDto.getDiscount())) {
            product.setPrice(productDto.getPrice());
        }
        if (Objects.nonNull(productDto.getDiscountPrice()) && !"".equalsIgnoreCase(String.valueOf(productDto.getDiscountPrice()))) {
            product.setDiscountPrice(productDto.getDiscountPrice());
        }
        productRepository.save(product);
        return ResponseEntity.ok("Profile updated successfully ");
    }

    @Override
    public Object statusUpdate(Long id) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new Exception("Product Not Found!!");
        }
        Product product = optionalProduct.get();
        productRepository.updateStatusForProduct(id, product.getStatus());
        return "Product status updated successfully";
    }

    @Override
    public Object deleteProductById(Long id) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new Exception("Product Not Found!!");
        }
        productRepository.deleteProduct(id);
        return "Product deleted successfully";
    }

}
