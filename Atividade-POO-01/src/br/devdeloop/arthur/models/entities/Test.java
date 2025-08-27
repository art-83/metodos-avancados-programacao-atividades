package br.devdeloop.arthur.models.entities;

import br.devdeloop.arthur.models.enums.UniversityClass;

import java.math.BigDecimal;
import java.util.Date;

public class Test {
    private BigDecimal score;
    private Date date;
    private String observation;
    private User from;
    private User to;
    private UniversityClass universityClass;

    public Test(BigDecimal score, Date date, String observation, User from, User to, UniversityClass universityClass) {
        this.score = score;
        this.date = date;
        this.observation = observation;
        this.from = from;
        this.to = to;
        this.universityClass = universityClass;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public UniversityClass getUniversityClass() {
        return universityClass;
    }

    public void setUniversityClass(UniversityClass universityClass) {
        this.universityClass = universityClass;
    }
}
