package com.example.demo.services;

import com.example.demo.dto.dtoRequest.FamilyMemberRequest;
import com.example.demo.dto.dtoRequest.FamilyRequest;
import com.example.demo.dto.dtoResponse.FamilyResponse;
import com.example.demo.dto.dtoEntities.Family;
import com.example.demo.dto.dtoEntities.FamilyMember;
import com.example.demo.dto.dtoRepositories.FamilyMemberRepository;
import com.example.demo.dto.dtoRepositories.FamilyRepository;
import com.example.demo.errorHandling.FamilyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.errorHandling.ErrorMessages.messageNoFamily;

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

    public FamilyResponse getFamily(int id) {
        Family family = familyRepository.findById(id).orElseThrow(() -> new FamilyNotFoundException(messageNoFamily));
        List<FamilyMember> familyMembers = familyMemberRepository.findByFamilyId(id);
        FamilyResponse familyResponse = new FamilyResponse();
        familyResponse.setFamilyName(family.getFamilyName());
        familyResponse.setNrOfAdults(family.getNrOfAdults());
        familyResponse.setNrOfInfants(family.getNrOfInfants());
        familyResponse.setNrOfChildren(family.getNrOfChildren());
        familyResponse.setFamilyMember(familyMembers);
        return familyResponse;
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
            validateFamilyData(familyRequest, member);
            FamilyMember familyMember = new FamilyMember();
            familyMember.setFamilyName(member.getFamilyName());
            familyMember.setGivenName(member.getGivenName());
            familyMember.setAge(member.getAge());
            familyMember.setFamilyId(createdFamilyId);
            familyMemberRepository.save(familyMember);
            });
    }

    private void validateFamilyData(FamilyRequest familyRequest, FamilyMemberRequest member) {
        validationService.validateNrOfMembers(familyRequest.getNrOfInfants(), familyRequest.getNrOfChildren(), familyRequest.getNrOfAdults());
        validationService.validateNrOfInfants(familyRequest.getNrOfInfants(), familyRequest.getFamilyMemberRequest());
        validationService.validateNrOfChildren(familyRequest.getNrOfChildren(), familyRequest.getFamilyMemberRequest());
        validationService.validateNrOfAdults(familyRequest.getNrOfAdults(), familyRequest.getFamilyMemberRequest());
        validationService.validateAge(member.getAge());
    }
}