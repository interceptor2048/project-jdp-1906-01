package com.kodilla.ecommerce.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK, reason = "No such Product in Cart")
public class ProductNotFoundInCartExcepton extends RuntimeException {
}
