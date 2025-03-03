package ch.etmles.payroll.Departement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Departement {

    private @Id
    @GeneratedValue Long id;

    @Column(name="DEPARTEMENT_NAME", nullable=false, unique=true)
    private String name;

    public Departement(String name) {
        this.name = name;
    }

    public Departement() {}


    public Long getID(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString(){
        return "Departement{" + "id=" + this.getID() + ", name='" + this.getName()+ '}';
    }


}
