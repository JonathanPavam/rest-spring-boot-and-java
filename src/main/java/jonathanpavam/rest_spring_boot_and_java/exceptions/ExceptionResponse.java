package jonathanpavam.rest_spring_boot_and_java.exceptions;

import java.util.Date;

public record ExceptionResponse(Date timestemp, String message, String details){ }
