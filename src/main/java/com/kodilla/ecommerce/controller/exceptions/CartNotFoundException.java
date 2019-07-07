package com.kodilla.ecommerce.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK, reason = "No such Cart")
public class CartNotFoundException extends RuntimeException{
}
