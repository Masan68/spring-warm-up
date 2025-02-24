package ch.etmles.payroll.Controllers;

public class DepartementNotFoundDeleted extends RuntimeException {
  public DepartementNotFoundDeleted(Long id) {
    super("Could not delete employee (not found) " + id);
  }
}
