package ch.etmles.payroll.Controllers;

import ch.etmles.payroll.Entities.Departement;
import ch.etmles.payroll.Entities.Employee;
import ch.etmles.payroll.Repositories.DepartementRepository;
import ch.etmles.payroll.Repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartementController {

    private final DepartementRepository repository;

    DepartementController(DepartementRepository repository){
        this.repository = repository;
    }

    /* curl sample :
    curl -i localhost:8080/departements
    */
    @GetMapping("/departements")
    List<Departement> all(){
        return repository.findAll();
    }

    /* curl sample :
    curl -i -X POST localhost:8080/departements ^
        -H "Content-type:application/json" ^
        -d "{\"name\": \"Bureau 1\" }"
    */
    @PostMapping("/departements")
    Departement newDepartement(@RequestBody Departement newDepartement){
        return repository.save(newDepartement);
    }

    /* curl sample :
    curl -i localhost:8080/departements/3
    */
    @GetMapping("/departements/{id}")
    Departement one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new DepartementNotFoundException(id));
    }

    /* curl sample :
    curl -i -X PUT localhost:8080/departements/3 ^
    -H "Content-type:application/json" ^
    -d "{\"name\": \"Bureau 3\"}"
    */
    @PutMapping("/departements/{id}")
    Departement replaceDepartement(@RequestBody Departement newDepartement, @PathVariable Long id) {
        return repository.findById(id)
                .map(departement -> {
                    departement.setName(newDepartement.getName());
                    return repository.save(departement);
                })
                .orElseGet(() -> {
                    newDepartement.setId(id);
                    return repository.save(newDepartement);
                });
    }

    /* curl sample :
    curl -i -X DELETE localhost:8080/departements/3
    */
    @DeleteMapping("/departements/{id}")
    void deleteDepartement(@PathVariable Long id){
        if(!repository.existsById(id)){
            throw new EmployeeNotFoundDeleted(id);
        }else{
            repository.deleteById(id);
        }
    }
}
