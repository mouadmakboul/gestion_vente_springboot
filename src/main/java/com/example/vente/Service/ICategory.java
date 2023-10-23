package com.example.vente.Service;

import com.example.vente.Entity.CategoryEntity;
import com.example.vente.request.category.createCategoryReq;
import com.example.vente.request.category.updateCategoryReq;

import java.util.Optional;

public interface ICategory {
    CategoryEntity save(createCategoryReq cat);
    CategoryEntity update(updateCategoryReq cat);
    void delete(int id);
    Optional<CategoryEntity> getcategorie(int id);
}
