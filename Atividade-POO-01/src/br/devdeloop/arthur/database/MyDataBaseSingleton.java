package br.devdeloop.arthur.database;

import br.devdeloop.arthur.repositories.ProfessorRepository;
import br.devdeloop.arthur.repositories.StudentRepository;

public class MyDataBaseSingleton {
    private static MyDataBaseSingleton instance;

    private ProfessorRepository professorRepository;
    private StudentRepository studentRepository;

    public MyDataBaseSingleton() {
        this.professorRepository = new ProfessorRepository();
        this.studentRepository = new StudentRepository();
    }

    public static MyDataBaseSingleton getInstance() {
        if(instance == null) {
            return new MyDataBaseSingleton();
        }
        return instance;
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }
}
