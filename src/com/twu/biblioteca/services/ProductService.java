package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.CheckoutException;
import com.twu.biblioteca.exceptions.MovieNotFoundException;
import com.twu.biblioteca.helpers.ProductStatus;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.Product;

public class ProductService {
    public void checkout(Product product) throws MovieNotFoundException, CheckoutException {
        if (product instanceof Movie) {
            if (product.getStatus().equals(ProductStatus.RENTED)) {
                throw new CheckoutException();
            }
            product.setStatus(ProductStatus.RENTED);
        } else {
            throw new MovieNotFoundException();
        }
    }
}
