package com.example.vente.Service;

import com.example.vente.Entity.PannierEntity;
import com.example.vente.request.pannier.createPannierReq;
import com.example.vente.request.pannier.updatePannierReq;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IPannier {
    PannierEntity save(createPannierReq pannier);
    PannierEntity update(updatePannierReq pannier);
    ResponseEntity<String> delete(int id);
    Optional<PannierEntity> getpannier(int id);
}
