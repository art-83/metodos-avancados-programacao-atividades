package br.devdeloop.arthur.models.entities;

import br.devdeloop.arthur.models.enums.Major;
import br.devdeloop.arthur.models.enums.UniversityClass;

import java.util.Date;
import java.util.List;

public class Student extends User {
    private Major atMajor;
    private List<UniversityClass> classes;

    public Student(String name, Date birthday, String id, List<Test> test, Major atMajor, List<UniversityClass> classes) {
        super(name, birthday, id, test);
        this.atMajor = atMajor;
        this.classes = classes;
    }

    public Major getAtMajor() {
        return atMajor;
    }

    public void setAtMajor(Major atMajor) {
        this.atMajor = atMajor;
    }

    public List<UniversityClass> getClasses() {
        return classes;
    }

    public void setClasses(List<UniversityClass> classes) {
        this.classes = classes;
    }
}
