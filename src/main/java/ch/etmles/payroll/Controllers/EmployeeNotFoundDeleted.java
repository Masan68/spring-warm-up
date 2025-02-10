package ch.etmles.payroll.Controllers;

public class EmployeeNotFoundDeleted extends RuntimeException {
    public EmployeeNotFoundDeleted(Long id) {
        super("Could not delete employee (not found) " + id);
    }
}
