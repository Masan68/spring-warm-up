package ch.etmles.payroll.Departement;

public class DepartementNotFoundException extends RuntimeException {

  DepartementNotFoundException(Long id){
    super("Could not find employee " + id);
  }
}
