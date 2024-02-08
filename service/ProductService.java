package com.enviro.assessment.grad001.siyathandazamqhamane.service;
import com.enviro.assessment.grad001.siyathandazamqhamane.entity.Product;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.*;

public interface ProductService {
    ProductCreationResponse productCreation(ProductCreationRequest productCreationRequest);

}
