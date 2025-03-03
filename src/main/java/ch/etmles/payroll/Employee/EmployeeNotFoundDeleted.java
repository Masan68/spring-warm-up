package ch.etmles.payroll.Employee;

public class EmployeeNotFoundDeleted extends RuntimeException {
    public EmployeeNotFoundDeleted(Long id) {
        super("Could not delete employee (not found) " + id);
    }
}
