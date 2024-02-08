package com.enviro.assessment.grad001.siyathandazamqhamane.repository;
import com.enviro.assessment.grad001.siyathandazamqhamane.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByInvestorIdAndProductType(Long investId, String productName);
    List<Product> findByInvestorId(Long investId);
    Product findByProductId(Long productId);
}
