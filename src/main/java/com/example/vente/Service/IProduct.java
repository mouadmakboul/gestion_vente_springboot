package com.example.vente.Service;

import com.example.vente.Entity.ProductEntity;
import com.example.vente.request.product.createProductReq;
import com.example.vente.request.product.updateProductReq;

import java.util.Optional;

public interface IProduct {
    ProductEntity save(createProductReq product);
    ProductEntity update(updateProductReq product);
    void delete(int id);
    Optional<ProductEntity> getproduit(int id);


}
