package buyerdemo.application.Buyerapp.service.impl;

import buyerdemo.application.Buyerapp.dto.CategoryDto;
import buyerdemo.application.Buyerapp.entities.Category;
import buyerdemo.application.Buyerapp.entities.Status;
import buyerdemo.application.Buyerapp.repository.CategoryRepository;
import buyerdemo.application.Buyerapp.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public Object saveCategory(CategoryDto categoryDto) {
        Date currentDate = new Date();
        Category category = Category.builder()
                .name(categoryDto.getName())
                .status(Status.ACTIVE)
                .createdAt(currentDate)
                .build();
        categoryRepository.save(category);
        return HttpStatus.OK;
    }

    @Override
    public Object getAllCategoryList() {
        List<Category> category = categoryRepository.findAll();
        return category.stream()
                .map(Category -> modelMapper.map(Category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Object getCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new RuntimeException();
        }
        Category category = optionalCategory.get();
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public Object categoryStatusUpdate(Long id) throws Exception{
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new Exception("Category Not Found!!");
        }
        Category category = optionalCategory.get();
        categoryRepository.updateStatusForCategory(id, category.getStatus());
        return "Category status updated successfully";
    }

    @Override
    public Object deleteCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new RuntimeException();
        }
        categoryRepository.deleteCategory(id);
        return "Category deleted successfully";
    }

}
