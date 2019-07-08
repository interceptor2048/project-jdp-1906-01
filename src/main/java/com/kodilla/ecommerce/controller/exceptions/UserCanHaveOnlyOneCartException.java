package com.kodilla.ecommerce.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK, reason = "Every user can have only one cart!")
public class UserCanHaveOnlyOneCartException extends RuntimeException {
}
