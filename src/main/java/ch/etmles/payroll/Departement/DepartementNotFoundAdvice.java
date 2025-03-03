package ch.etmles.payroll.Departement;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DepartementNotFoundAdvice {


    @ResponseBody
    @ExceptionHandler(DepartementNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String departementNotFoundHandler(DepartementNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(DepartementNotFoundDeleted.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String departementNotFoundHandler(DepartementNotFoundDeleted ex){
        return ex.getMessage();
    }

}
