package br.devdeloop.arthur.repositories;

import br.devdeloop.arthur.models.entities.Professor;
import br.devdeloop.arthur.models.enums.UniversityClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessorRepository implements MyRepository <Professor> {

    private Map<String, Professor> professorTableDatabase;

    public ProfessorRepository() {
        this.professorTableDatabase = new HashMap<>();
    }

    @Override
    public Professor save(Professor professor) {
        return this.professorTableDatabase.put(professor.getId(), professor);
    }

    @Override
    public Professor findById(String id) {
        return this.professorTableDatabase.get(id);
    }

    @Override
    public Map<String, Professor> findAll() {
        return this.professorTableDatabase;
    }

    @Override
    public Map<String, Professor> findByUniversityClass(UniversityClass universityClass) {
        Map<String, Professor> filteredByUniversityClass = new HashMap<>();
        for(String id: this.professorTableDatabase.keySet()) {
            Professor professor = this.professorTableDatabase.get(id);
            if(professor.getAtClass().equals(universityClass)) {
                filteredByUniversityClass.put(professor.getId(), professor);
            }
        }
        return filteredByUniversityClass;
    }

    @Override
    public Professor removeById(String id) {
        Professor professor = this.professorTableDatabase.remove(id);
        return professor;
    }
}