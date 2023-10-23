package com.example.vente.Repository;

import com.example.vente.Entity.ProductEntity;
import com.example.vente.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<UserEntity, Integer> {
}
