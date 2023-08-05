package buyerdemo.application.Buyerapp.controller;

import buyerdemo.application.Buyerapp.dto.CategoryDto;
import buyerdemo.application.Buyerapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Object saveCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.saveCategory(categoryDto);
    }

    @GetMapping("category")
    public Object getAllCategory(){
        return categoryService.getAllCategoryList();
    }

    @GetMapping("category/{id}")
    public Object getCategoryById(@PathVariable("id") Long id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/status/{id}")
    public Object statusUpdateForCategory(@PathVariable(value = "id") Long id) throws Exception {
        return categoryService.categoryStatusUpdate(id);
    }

    @DeleteMapping("category/{id}")
    public Object deleteCategoryById(@PathVariable("id") Long id){
        return categoryService.deleteCategoryById(id);
    }

}
