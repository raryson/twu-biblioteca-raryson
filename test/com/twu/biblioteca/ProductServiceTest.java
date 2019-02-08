package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.CheckoutException;
import com.twu.biblioteca.exceptions.ProductNotFoundException;
import com.twu.biblioteca.helpers.ProductType;
import com.twu.biblioteca.infra.MovieData;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.services.MovieService;
import com.twu.biblioteca.services.ProductService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class ProductServiceTest {

    @Test
    public void whenUserMakeCheckoutForAProductAssertNotThrowException() {
       MovieData.generateMovies();
       ProductService productService = new ProductService();
       MovieService movieService = new MovieService(MovieData.movies);
       try {
           Movie movie = movieService.findMovieByName("Matrix");
           productService.checkout(movie);
       } catch (ProductNotFoundException ex) {
            assertNull(ex);
       } catch (CheckoutException ex) {
           assertNull(ex);

       }
    }

    @Test
    public void whenUserMakeCheckoutForAProductNotExistAssertThrowException() {
        MovieData.generateMovies();
        ProductService productService = new ProductService();
        MovieService movieService = new MovieService(MovieData.movies);
        try {
            Movie movie = movieService.findMovieByName("The back of with whe don't go");
            productService.checkout(movie);
        } catch (ProductNotFoundException ex) {
            assertNotNull(ex);
        } catch (CheckoutException ex) {
            assertNull(ex);

        }
    }
    @Test
    public void whenUserMakeCheckoutForAProductHasCheckinedAssertThrowException() {
        MovieData.generateMovies();
        ProductService productService = new ProductService();
        MovieService movieService = new MovieService(MovieData.movies);
        try {
            Movie movie = movieService.findMovieByName("Matrix");
            productService.checkout(movie);
            productService.checkout(movie);
        } catch (ProductNotFoundException ex) {
            assertNull(ex);
        } catch (CheckoutException ex) {
            assertNotNull(ex);
        }
    }

}
