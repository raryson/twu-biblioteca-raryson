package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.ProductStatus;

public abstract class Product {
    ProductStatus status;

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}
