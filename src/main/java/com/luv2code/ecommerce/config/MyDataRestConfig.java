package com.luv2code.ecommerce.config;

import com.luv2code.ecommerce.entity.Product;

import com.luv2code.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class MyDataRestConfig  implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[]theUnSupportedAction = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        //disable PUT, DELETE and Post
    config.getExposureConfiguration()
            .forDomainType(Product.class)
            .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnSupportedAction)))
            .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnSupportedAction));


        //disable PUT, DELETE and Post for productCategory
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnSupportedAction)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnSupportedAction));

    }
}
