package br.devdeloop.arthur.database;

import br.devdeloop.arthur.repositories.ProfessorRepository;
import br.devdeloop.arthur.repositories.StudentRepository;

public class MyDataBase {
    private ProfessorRepository professorRepository;
    private StudentRepository studentRepository;

    public MyDataBase() {
        this.professorRepository = new ProfessorRepository();
        this.studentRepository = new StudentRepository();
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }
}
