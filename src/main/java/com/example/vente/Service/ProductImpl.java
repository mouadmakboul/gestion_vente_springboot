package com.example.vente.Service;

import com.example.vente.Entity.ProductEntity;
import com.example.vente.Repository.produitRepo;
import com.example.vente.request.product.createProductReq;
import com.example.vente.request.product.updateProductReq;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductImpl implements IProduct{
    @Autowired
    private produitRepo PR;

    @Override
    public ProductEntity save(createProductReq cat) {

        ProductEntity product = new ProductEntity();
        product.setQuantite(cat.getQuantite());
        product.setDescription(cat.getDescription());
        product.setTitle(cat.getTitle());
        product.setProduct_images(cat.getProduct_images());
        return PR.save(product);
    }

    @Override
    public ProductEntity update(updateProductReq req) {

        Optional<ProductEntity> productOptional= PR.findById(req.getId());

        if (productOptional.isPresent()){
            ProductEntity product = productOptional.get();
            product.setQuantite(req.getQuantite());
            product.setDescription(req.getDescription());
            product.setTitle(req.getTitle());
            product.setProduct_images(req.getProduct_images());
            return PR.save(product);
        }else {
            throw new EntityNotFoundException("Category not found for id: " + req.getId());
        }
    }


    @Override
    public void delete(int id) {
        PR.deleteById(id);
    }

    @Override
    public Optional<ProductEntity> getproduit(int id) {
        return PR.findById(id);
    }


    }

