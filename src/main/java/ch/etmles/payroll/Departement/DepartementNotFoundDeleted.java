package ch.etmles.payroll.Departement;

public class DepartementNotFoundDeleted extends RuntimeException {
  public DepartementNotFoundDeleted(Long id) {
    super("Could not delete employee (not found) " + id);
  }
}
