package jonathanpavam.rest_spring_boot_and_java.service;

import jonathanpavam.rest_spring_boot_and_java.exceptions.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;

public class MathService {

    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public Double mult(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    public Double div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsuportedMathOperationException("Please set a numeric value");
        String number = strNumber.replaceAll(",",".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }
}
