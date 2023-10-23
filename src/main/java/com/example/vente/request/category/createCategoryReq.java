package com.example.vente.request.category;

import lombok.Data;


@Data
public class createCategoryReq {

    private Long id;
    private String name;
    private String description;
    private String grimage;
    private String ptimage;
}
