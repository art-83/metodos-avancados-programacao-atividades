package br.devdeloop.arthur.services;

import br.devdeloop.arthur.database.MyDataBase;
import br.devdeloop.arthur.models.entities.Professor;
import br.devdeloop.arthur.models.entities.Student;
import br.devdeloop.arthur.models.entities.Test;
import br.devdeloop.arthur.models.enums.UniversityClass;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ReportService {
    private MyDataBase myDataBase;

    public ReportService(MyDataBase myDataBase) {
        this.myDataBase = myDataBase;
    }

    public Map<String, Student> getStudentList() {
        return this.myDataBase.getStudentRepository().findAll();
    }

    public List<Test> getStudentTestResumeById(String id) {
        return this.myDataBase.getStudentRepository().findById(id).getTest();
    }

    public BigDecimal getStudentTestScoreResumeByIdAndClass(String id, UniversityClass universityClass) {
        Student student = this.myDataBase.getStudentRepository().findById(id);
        BigDecimal result = new BigDecimal(0);
        for(Test t : student.getTest()) {
            if(t.getUniversityClass().equals(universityClass)) {
                result = result.add(t.getScore());
            }
        }
        return result.divide(new BigDecimal(student.getClasses().size()));
    }

    public Integer getStudentsQuantityByUniversityClass(UniversityClass universityClasses) {
        return this.myDataBase.getStudentRepository().findByUniversityClass(universityClasses).size();
    }

    public Map<String, Professor> getProfessorList() {
        return this.myDataBase.getProfessorRepository().findAll();
    }

    public Map<String, Professor> getProfessorByUniversityClass(UniversityClass universityClass) {
        return this.myDataBase.getProfessorRepository().findByUniversityClass(universityClass);
    }

}
