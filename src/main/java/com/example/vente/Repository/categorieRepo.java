package com.example.vente.Repository;

import com.example.vente.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categorieRepo extends JpaRepository<CategoryEntity, Integer> {
}
