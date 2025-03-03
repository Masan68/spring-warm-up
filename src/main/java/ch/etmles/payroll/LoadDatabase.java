package ch.etmles.payroll;

import ch.etmles.payroll.Departement.DepartementRepository;
import ch.etmles.payroll.Departement.DepartementEntity;
import ch.etmles.payroll.Employee.EmployeeEntity;
import ch.etmles.payroll.Employee.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(DepartementRepository departementRepository, EmployeeRepository employeeRepository) {
        return args->{
            DepartementEntity itDepartement = new DepartementEntity("IT");
            log.info("Preloading " + departementRepository.save(itDepartement));
            /*********************/
            //Departement itDepartement1 = new Departement("IT");
            //log.info("Preloading " + departementRepository.save(itDepartement1)); // Le nom doit être unique donc ici aussi un problème
            /*********************/

            DepartementEntity secretariat = new DepartementEntity("secretariat");
            log.info("Preloading " + departementRepository.save(secretariat));

            log.info("Preloading " + employeeRepository.save(new EmployeeEntity("Bilbo Baggins", "burglar", "biblo@test")));
            /*********************/
            log.info("Preloading " + employeeRepository.save(new EmployeeEntity("Frodo Baggins", "thief", "Frodo@test")));
            //log.info("Preloading " + employeeRepository.save(new Employee("Jjo Baggins", "thief", "Frodo@test")));// Email doit être unique donc ici aussi un problème
            /*********************/

        };
    }
}
