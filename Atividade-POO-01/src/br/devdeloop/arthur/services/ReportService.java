package br.devdeloop.arthur.services;

import br.devdeloop.arthur.database.MyDataBaseSingleton;
import br.devdeloop.arthur.models.entities.Professor;
import br.devdeloop.arthur.models.entities.Student;
import br.devdeloop.arthur.models.entities.Test;
import br.devdeloop.arthur.models.enums.UniversityClass;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ReportService {
    private MyDataBaseSingleton myDataBaseSingleton;

    public ReportService(MyDataBaseSingleton myDataBaseSingleton) {
        this.myDataBaseSingleton = myDataBaseSingleton;
    }

    public Map<String, Student> getStudentList() {
        return this.myDataBaseSingleton.getStudentRepository().findAll();
    }

    public List<Test> getStudentTestResumeById(String id) {
        return this.myDataBaseSingleton.getStudentRepository().findById(id).getTest();
    }

    public BigDecimal getStudentTestScoreResumeByIdAndClass(String id, UniversityClass universityClass) {
        Student student = this.myDataBaseSingleton.getStudentRepository().findById(id);
        BigDecimal result = new BigDecimal(0);
        for(Test t : student.getTest()) {
            if(t.getUniversityClass().equals(universityClass)) {
                result = result.add(t.getScore());
            }
        }
        return result.divide(new BigDecimal(student.getClasses().size()));
    }

    public Integer getStudentsQuantityByUniversityClass(UniversityClass universityClasses) {
        return this.myDataBaseSingleton.getStudentRepository().findByUniversityClass(universityClasses).size();
    }

    public Map<String, Professor> getProfessorList() {
        return this.myDataBaseSingleton.getProfessorRepository().findAll();
    }

    public Map<String, Professor> getProfessorByUniversityClass(UniversityClass universityClass) {
        return this.myDataBaseSingleton.getProfessorRepository().findByUniversityClass(universityClass);
    }

}
