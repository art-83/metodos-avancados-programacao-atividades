package br.devdeloop.arthur.services;

import br.devdeloop.arthur.database.MyDataBase;
import br.devdeloop.arthur.models.entities.Professor;
import br.devdeloop.arthur.models.entities.Student;
import br.devdeloop.arthur.models.entities.Test;

public class RegisterService {
    private MyDataBase myDataBase;

    public RegisterService(MyDataBase myDataBase) {
        this.myDataBase = myDataBase;
    }

    public Professor registerProfessor(Professor professor) {
        return this.myDataBase.getProfessorRepository().save(professor);
    }

    public Student registerStudent(Student student) {
        return this.myDataBase.getStudentRepository().save(student);
    }

    public Test registerTest(Test test) {
        if(test.getFrom().getClass() == Professor.class) {
            this.myDataBase.getProfessorRepository().findById(test.getFrom().getId()).getTest().add(test);
        }
        return test;
    }

    public Professor removeProfessor(String id) {
        if(this.myDataBase.getProfessorRepository().findById(id).getAtClass() == null) {
            return this.myDataBase.getProfessorRepository().removeById(id);
        }
        return null;
    }
}
