package buyerdemo.application.Buyerapp.service;

import buyerdemo.application.Buyerapp.dto.ProductDto;

public interface ProductService {

    Object saveProduct(ProductDto productDto);

    Object fetchProductList();

    Object fetchProductById(Long id);

    Object updateProduct(Long id, ProductDto productDto) throws Exception;

    Object statusUpdate(Long id) throws Exception;

    Object deleteProductById(Long id) throws Exception;

}
