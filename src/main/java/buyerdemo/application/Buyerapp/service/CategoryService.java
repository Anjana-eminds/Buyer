package buyerdemo.application.Buyerapp.service;

import buyerdemo.application.Buyerapp.dto.CategoryDto;

public interface CategoryService {

    Object saveCategory(CategoryDto categoryDto);

    Object getAllCategoryList();

    Object getCategoryById(Long id);

    Object categoryStatusUpdate(Long id) throws Exception;

    Object deleteCategoryById(Long id);
}
