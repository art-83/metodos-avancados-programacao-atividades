package br.devdeloop.arthur.repositories;

import br.devdeloop.arthur.models.entities.Professor;
import br.devdeloop.arthur.models.entities.Student;
import br.devdeloop.arthur.models.enums.UniversityClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository implements MyRepository<Student>{
    Map<String, Student> studentTableDatabase;

    public StudentRepository() {
        this.studentTableDatabase = new HashMap<>();
    }

    @Override
    public Student save(Student user) {
        return this.studentTableDatabase.put(user.getId(), user);
    }

    @Override
    public Student findById(String id) {
        return this.studentTableDatabase.get(id);
    }

    @Override
    public Map<String, Student> findAll() {
        return this.studentTableDatabase;
    }

    @Override
    public Map<String, Student> findByUniversityClass(UniversityClass universityClass) {
        Map<String, Student> filteredByUniversityClass = new HashMap<>();
        for(String id: this.studentTableDatabase.keySet()) {
            Student student = this.studentTableDatabase.get(id);
            if(student.getClasses().contains(universityClass)) {
                filteredByUniversityClass.put(student.getId(), student);
            }
        }
        return filteredByUniversityClass;
    }

    @Override
    public Student removeById(String id) {
        Student professor = this.studentTableDatabase.remove(id);
        return professor;
    }
}
