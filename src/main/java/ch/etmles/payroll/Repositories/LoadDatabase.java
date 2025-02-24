package ch.etmles.payroll.Repositories;

import ch.etmles.payroll.Entities.Departement;
import ch.etmles.payroll.Entities.Employee;
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
            Departement itDepartement = new Departement("IT");
            log.info("Preloading " + departementRepository.save(itDepartement));
            /*********************/
            //Departement itDepartement1 = new Departement("IT");
            //log.info("Preloading " + departementRepository.save(itDepartement1)); // Le nom doit être unique donc ici aussi un problème
            /*********************/

            Departement secretariat = new Departement("secretariat");
            log.info("Preloading " + departementRepository.save(secretariat));

            log.info("Preloading " + employeeRepository.save(new Employee("Bilbo Baggins", "burglar", "biblo@test")));
            /*********************/
            log.info("Preloading " + employeeRepository.save(new Employee("Frodo Baggins", "thief", "Frodo@test")));
            //log.info("Preloading " + employeeRepository.save(new Employee("Jjo Baggins", "thief", "Frodo@test")));// Email doit être unique donc ici aussi un problème
            /*********************/

        };
    }
}
