package pl.example.spring.punkty.db;

import pl.example.spring.punkty.Student;

import javax.persistence.*;
import java.util.Set;

@Entity
public class StudentRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String number;
    private String grupa;

    public Student toStudent(){ return new Student( this.getId(), this.getName(), this.getNumber(), this.getGrupa()); }

    protected StudentRow(){} public StudentRow(String name, String number, String group1) { this.name = name; this.number = number; this.grupa = group1; }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @OneToMany(mappedBy = "student")
    private Set<ScoreRow> scores;

    public Set<ScoreRow> getScores() {
        return scores;
    }

    public void setScores(Set<ScoreRow> scores) {
        this.scores = scores;
    }
}
