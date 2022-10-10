package com.example.demo.dto.dtoRequest;

import java.util.ArrayList;
import java.util.List;

public class FamilyRequest {

    private int id;

    private String familyName;
    private int nrOfAdults;
    private int nrOfChildren;
    private int nrOfInfants;
    private List<FamilyMemberRequest> familyMemberRequest = new ArrayList<>();

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

    public List<FamilyMemberRequest> getFamilyMemberRequest() { return familyMemberRequest; }

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
