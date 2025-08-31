package br.devdeloop.arthur.services;

import br.devdeloop.arthur.database.MyDataBaseSingleton;
import br.devdeloop.arthur.models.entities.Professor;
import br.devdeloop.arthur.models.entities.Student;
import br.devdeloop.arthur.models.entities.Test;

public class RegisterService {
    private MyDataBaseSingleton myDataBaseSingleton;

    public RegisterService(MyDataBaseSingleton myDataBaseSingleton) {
        this.myDataBaseSingleton = myDataBaseSingleton;
    }

    public Professor registerProfessor(Professor professor) {
        return this.myDataBaseSingleton.getProfessorRepository().save(professor);
    }

    public Student registerStudent(Student student) {
        return this.myDataBaseSingleton.getStudentRepository().save(student);
    }

    public Test registerTest(Test test) {
        if(test.getFrom().getClass() == Professor.class) {
            this.myDataBaseSingleton.getProfessorRepository().findById(test.getFrom().getId()).getTest().add(test);
        }
        return test;
    }

    public Professor removeProfessor(String id) {
        if(this.myDataBaseSingleton.getProfessorRepository().findById(id).getAtClass() == null) {
            return this.myDataBaseSingleton.getProfessorRepository().removeById(id);
        }
        return null;
    }
}
