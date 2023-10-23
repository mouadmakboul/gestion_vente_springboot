package com.example.vente.Service;
import com.example.vente.Entity.PannierEntity;
import com.example.vente.Repository.pannierRepo;
import com.example.vente.request.pannier.createPannierReq;
import com.example.vente.request.pannier.updatePannierReq;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PannierImpl implements IPannier {
    @Autowired
    private pannierRepo  PR;

    @Override
    public PannierEntity save(createPannierReq cat) {

        PannierEntity newCategory = new PannierEntity();
        newCategory.setId(cat.getId());
        newCategory.setTotalPrice(cat.getTotalPrice());



        return PR.save(newCategory);
    }

    @Override
    public PannierEntity update(updatePannierReq req) {

        Optional<PannierEntity> pannierOptional=PR.findById(req.getId());

        if (pannierOptional.isPresent()){
            PannierEntity pannier = pannierOptional.get();
            pannier.setId(req.getId());
            pannier.setTotalPrice(req.getTotalPrice());
            return PR.save(pannier);
        }else {

            throw new EntityNotFoundException("Category not found for id: " + req.getId());

        }


    }

    @Override
    public ResponseEntity<String> delete(int id) {
        PR.deleteById(id);
        return null;
    }

    @Override
    public Optional<PannierEntity> getpannier(int id) {
        return PR.findById(id);
    }
}
