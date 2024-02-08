package com.enviro.assessment.grad001.siyathandazamqhamane.service.impl;

import com.enviro.assessment.grad001.siyathandazamqhamane.entity.Investor;
import com.enviro.assessment.grad001.siyathandazamqhamane.entity.Product;
import com.enviro.assessment.grad001.siyathandazamqhamane.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.ProductCreationRequest;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.ProductCreationResponse;
import com.enviro.assessment.grad001.siyathandazamqhamane.repository.InvestorRepository;
import com.enviro.assessment.grad001.siyathandazamqhamane.repository.ProductRepository;
import com.enviro.assessment.grad001.siyathandazamqhamane.service.ProductService;
import com.enviro.assessment.grad001.siyathandazamqhamane.util.ProductType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

    private final InvestorRepository investorRepository;

    public final String successMessage = "Investor product created successfully";
    public final int RETIREMENT_AGE = 65;

    @Override
    public ProductCreationResponse productCreation(ProductCreationRequest productCreationRequest) {

        try {

           Investor investor = investorRepository.findByInvestorId(productCreationRequest.getInvestorId());
            if (investor == null) {

                throw new ResourceNotFoundException("Investor with investor id %s does not exist", productCreationRequest.getInvestorId());
            }
            if(productCreationRequest.getProduct_type().equals(ProductType.RETIREMENT)
                    && investor.getAge() < RETIREMENT_AGE){

                throw new ResourceNotFoundException("Investor's age must be greater than 65");
            }

            Product investorProduct = productRepository.findByInvestorIdAndProductType(productCreationRequest.getInvestorId(),
                    productCreationRequest.getProduct_type().getProduct());

            if(investorProduct != null){
                throw new ResourceNotFoundException("Investor already has account under this product");
            }

            Product product = new Product();
            product.setProductType(productCreationRequest.getProduct_type().getProduct());
            product.setName(productCreationRequest.getName());
            product.setInvestorId(productCreationRequest.getInvestorId());
            product.setBalance(productCreationRequest.getAmount());
            Product productResponse = productRepository.save(product);
            return ProductCreationResponse.createProductCreationResponse(productCreationRequest.getCorrelationId(), successMessage , productResponse.getProductId());
        }catch (Exception ex){
            return ProductCreationResponse.createProductCreationResponse(productCreationRequest.getCorrelationId(), ex.getMessage(),null);
        }
    }

}
