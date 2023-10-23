package com.example.vente.Service;

import com.example.vente.Entity.CategoryEntity;
import com.example.vente.Repository.categorieRepo;
import com.example.vente.request.category.createCategoryReq;
import com.example.vente.request.category.updateCategoryReq;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryImpl implements ICategory {
    @Autowired
   private categorieRepo CR;
    @Override
    public CategoryEntity save(createCategoryReq cat) {

        CategoryEntity newCategory = new CategoryEntity();
        newCategory.setName(cat.getName());
        newCategory.setDescription(cat.getDescription());
        newCategory.setGrimage(cat.getGrimage());
        newCategory.setPtimage(cat.getPtimage());


        return CR.save(newCategory);
    }

    @Override
    public CategoryEntity update(updateCategoryReq req) {

        Optional<CategoryEntity> categoryOptional= CR.findById(req.getId());

        if (categoryOptional.isPresent()){
            CategoryEntity category = categoryOptional.get();
            category.setName(req.getName());
            category.setDescription(req.getDescription());
            category.setGrimage(req.getGrimage());
            category.setPtimage(req.getPtimage());
            return CR.save(category);
        }else {
            throw new EntityNotFoundException("Category not found for id: " + req.getId());
        }
    }

    @Override
    public void delete(int id) {
        CR.deleteById(id);
    }

    @Override
    public Optional<CategoryEntity> getcategorie(int id) {
        return CR.findById(id);
    }
}
