package com.example.demo.services;

import com.example.demo.dto.dtoresponse.FamilyResponse;
import com.example.demo.dto.requestdto.FamilyRequest;
import com.example.demo.FamilyWithMembers;
import com.example.demo.dto.dtoentities.Family;
import com.example.demo.dto.dtoentities.FamilyMember;
import com.example.demo.dto.FamilyMemberRepository;
import com.example.demo.dto.FamilyRepository;
import com.example.demo.errorhandling.FamilyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    private ValidationService validationService;

    public Integer create(FamilyRequest familyRequest) {
        Family family = prepareFamilyData(familyRequest);
        Integer createdFamilyId = familyRepository.save(family).getId();
        prepareFamilyMemberData(familyRequest,createdFamilyId);
        return createdFamilyId;
    }

    public FamilyWithMembers getFamily(int id) {
        Family family = familyRepository.findById(id).orElseThrow(() -> new FamilyNotFoundException("Family not found"));
        List<FamilyMember> familyMembers = familyMemberRepository.findByFamilyId(id);
        FamilyWithMembers familyWithMembers = new FamilyWithMembers();
        familyWithMembers.setFamilyName(family.getFamilyName());
        familyWithMembers.setNrOfAdults(family.getNrOfAdults());
        familyWithMembers.setNrOfInfants(family.getNrOfInfants());
        familyWithMembers.setNrOfChildren(family.getNrOfChildren());
        familyWithMembers.setFamilyMember(familyMembers);
        return familyWithMembers;
    }





    private Family prepareFamilyData(FamilyRequest familyRequest) {
        Family family = new Family();
        family.setFamilyName(familyRequest.getFamilyName());
        family.setNrOfAdults(familyRequest.getNrOfAdults());
        family.setNrOfChildren(familyRequest.getNrOfChildren());
        family.setNrOfInfants(familyRequest.getNrOfInfants());
        return family;
    }

    private void prepareFamilyMemberData(FamilyRequest familyRequest, Integer createdFamilyId ) {
        familyRequest.getFamilyMemberRequest().forEach(member -> {
            validationService.validateNrOfMembers(familyRequest.getNrOfInfants(), familyRequest.getNrOfChildren(), familyRequest.getNrOfAdults());
            validationService.validateNrOfInfants(familyRequest.getNrOfInfants(), familyRequest.getFamilyMemberRequest());
            validationService.validateNrOfChildren(familyRequest.getNrOfChildren(), familyRequest.getFamilyMemberRequest());
            validationService.validateNrOfAdults(familyRequest.getNrOfAdults(), familyRequest.getFamilyMemberRequest());
            validationService.validateAge(member.getAge());
            FamilyMember familyMember = new FamilyMember();
            familyMember.setFamilyName(member.getFamilyName());
            familyMember.setGivenName(member.getGivenName());
            familyMember.setAge(member.getAge());
            familyMember.setFamilyId(createdFamilyId);
            familyMemberRepository.save(familyMember);
            });
    }
}