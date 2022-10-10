package com.example.demo.dto.dtoResponse;

import com.example.demo.dto.dtoEntities.FamilyMember;

import java.util.ArrayList;
import java.util.List;

public class FamilyResponse {
    private String familyName;
    private int nrOfAdults;
    private int nrOfChildren;
    private int nrOfInfants;
    private List<FamilyMember> familyMember = new ArrayList<>();

    public String getFamilyName() { return familyName; }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getNrOfAdults() {
        return nrOfAdults;
    }

    public void setNrOfAdults(int nrOfAdults) {
        this.nrOfAdults = nrOfAdults;
    }

    public int getNrOfChildren() {
        return nrOfChildren;
    }

    public void setNrOfChildren(int nrOfChildren) {
        this.nrOfChildren = nrOfChildren;
    }

    public int getNrOfInfants() {
        return nrOfInfants;
    }

    public void setNrOfInfants(int nrOfInfants) {
        this.nrOfInfants = nrOfInfants;
    }

    public List<FamilyMember> getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(List<FamilyMember> familyMember) {
        this.familyMember = familyMember;
    }
}