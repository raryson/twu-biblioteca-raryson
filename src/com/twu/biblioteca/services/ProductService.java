package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.*;
import com.twu.biblioteca.helpers.ProductStatus;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.Product;
import com.twu.biblioteca.models.User;

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

    public void checkout(Product product, User user) throws CheckoutException, BookCheckoutException,
            ProductNotFoundException {
        if (product instanceof Movie) {
            if (product.getStatus().equals(ProductStatus.RENTED)) {
                throw new CheckoutException();
            }
            product.setStatus(ProductStatus.RENTED);

        } else if (product instanceof Book) {
            if(product.getStatus().equals(ProductStatus.RENTED)) {
                throw new BookCheckoutException();
            }
            user.addBookOnCheckoutdBooks((Book) product);
            product.setStatus(ProductStatus.RENTED);
        }

        else  {
            throw new ProductNotFoundException();
        }
    }

    public void checking(Product product, User user) throws BookCheckinException, BookNotFoundException {
        if(product.getStatus().equals(ProductStatus.AVAILABLE)) {
            throw new BookCheckinException();
        }
        user.removeBookFromCheckoutBooks((Book) product);
        product.setStatus(ProductStatus.AVAILABLE);
    }
}
