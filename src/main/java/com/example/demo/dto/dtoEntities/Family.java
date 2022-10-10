package com.example.demo.dto.dtoEntities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Pattern(regexp="^[A-Za-z]*$", message = "nana")
    @NotBlank
    private String familyName;

    @Column(nullable = false)
    private int nrOfAdults;
    private int nrOfChildren;
    private int nrOfInfants;


    public int getId() {
        return id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getNrOfAdults() {
        return nrOfAdults;
    }

    public void setNrOfAdults(int nrOfAdults) {
        this.nrOfAdults = nrOfAdults;
    }

    public int getNrOfChildren() {return nrOfChildren;}

    public void setNrOfChildren(int nrOfChildren) {this.nrOfChildren = nrOfChildren;}

    public int getNrOfInfants() {return nrOfInfants;}

    public void setNrOfInfants(int nrOfInfants) {this.nrOfInfants = nrOfInfants;}

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", nrOfAdults=" + nrOfAdults + '\'' +
                ", nrOfChildren=" + nrOfChildren + '\'' +
                ", nrOfInfants=" + nrOfInfants + '\'' +
                '}';
    }
}