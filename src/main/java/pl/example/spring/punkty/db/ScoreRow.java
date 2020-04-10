package pl.example.spring.punkty.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ScoreRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; private int score; private String comment;
}
