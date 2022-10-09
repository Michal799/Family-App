package com.example.demo.services;

import com.example.demo.dto.requestdto.FamilyMemberRequest;
import com.example.demo.errorhandling.InvalidAgeException;
import com.example.demo.errorhandling.InvalidNrOfInfantsException;
import com.example.demo.errorhandling.InvalidNrOfMembersException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ValidationService {

    void validateAge(int age) {
        if(age<0 || age>130) {
            throw new InvalidAgeException("Invalid age");
        }
    }

    void validateNrOfInfants(int nrOfInfants, List<FamilyMemberRequest> familyMemberRequest) {
        AtomicInteger infants = new AtomicInteger();
        familyMemberRequest.forEach(member -> {
            if (member.getAge()<=4) {
                infants.set(infants.get() + 1);
            }
        });
        if (infants.get() != nrOfInfants) {
            throw new InvalidNrOfInfantsException("Invalid number of infants");
        }
    }

    void validateNrOfChildren(int nrOfChildren, List<FamilyMemberRequest> familyMemberRequest) {
        AtomicInteger children = new AtomicInteger();
        familyMemberRequest.forEach(member -> {
            if (member.getAge()>4 && member.getAge()<=16) {
                children.set(children.get() + 1);
            }
        });
        if (children.get() != nrOfChildren) {
            throw new InvalidNrOfInfantsException("Invalid number of children");
        }
    }

    void validateNrOfAdults(int nrOfAdults, List<FamilyMemberRequest> familyMemberRequest) {
        AtomicInteger adults = new AtomicInteger();
        familyMemberRequest.forEach(member -> {
            if (member.getAge()>16) {
                adults.set(adults.get() + 1);
            }
        });
        if (adults.get() != nrOfAdults) {
            throw new InvalidNrOfInfantsException("Invalid number of adults");
        }
    }

    void validateNrOfMembers(int nrOfInfants, int nrOfChildren, int nrOfAdults) {
        if(nrOfInfants == 0 && nrOfChildren == 0 && nrOfAdults == 0) {
            throw new InvalidNrOfMembersException("Family requires any member");
        }
    }
}