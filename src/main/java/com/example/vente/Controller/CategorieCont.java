package com.example.vente.Controller;

import com.example.vente.Entity.CategoryEntity;
import com.example.vente.Service.CategoryImpl;
import com.example.vente.Exceptions.CategoryException;
import com.example.vente.request.category.createCategoryReq;
import com.example.vente.request.category.updateCategoryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategorieCont {

    @Autowired
    private CategoryImpl categoryService;

    @PostMapping
    public CategoryEntity createCategory(@RequestBody createCategoryReq category) {
        return categoryService.save(category);
    }

    @GetMapping("/{id}")
    public Optional<CategoryEntity> getCategory(@PathVariable int id) {
        return categoryService.getcategorie(id);
    }

    @PutMapping("/update")
    public CategoryEntity updateCategory(@RequestBody updateCategoryReq req) {

        return categoryService.update(req);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id) {
        try {
            categoryService.delete(id);
        } catch (Exception e) {
            throw new CategoryException("Erreur lors de la suppression de la catégorie.");
        }
    }
}
