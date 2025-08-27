package br.devdeloop.arthur.models.entities;

import br.devdeloop.arthur.models.enums.UniversityClass;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Professor extends User {
    private BigDecimal salary;
    private UniversityClass atClass;

    public Professor(String name, Date birthday, String id, List<Test> test, BigDecimal salary, UniversityClass atClass) {
        super(name, birthday, id, test);
        this.salary = salary;
        this.atClass = atClass;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public UniversityClass getAtClass() {
        return atClass;
    }

    public void setAtClass(UniversityClass atClass) {
        this.atClass = atClass;
    }
}