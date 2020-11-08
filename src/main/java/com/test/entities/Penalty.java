package com.test.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "penalties")
public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_penalty", length = 255)
    private String typePenalty;

    @Column(name = "tarrif")
    private Float tarrif;

    public Penalty(){}

    public Penalty(String typePenalty, Float tarrif){
        this.typePenalty = typePenalty;
        this.tarrif = tarrif;
    }

    public Long getId() {
        return id;
    }

    public Float getTarrif() {
        return tarrif;
    }

    public void setTarrif(Float tarrif) {
        this.tarrif = tarrif;
    }

    public String getTypePenalty() {
        return typePenalty;
    }

    public void setTypePenalty(String typePenalty) {
        this.typePenalty = typePenalty;
    }
}
