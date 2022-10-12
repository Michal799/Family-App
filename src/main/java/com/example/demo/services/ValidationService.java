package com.example.demo.services;

import com.example.demo.dto.dtoRequest.FamilyMemberRequest;
import com.example.demo.errorHandling.InvalidAgeException;
import com.example.demo.errorHandling.InvalidNrOfInfantsException;
import com.example.demo.errorHandling.InvalidNrOfMembersException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.example.demo.errorHandling.ErrorMessages.*;
import static com.example.demo.errorHandling.ValidationAgeLimits.*;

@Service
public class ValidationService {

    void validateAge(int age) {
        if(age<lowerAgeLimit || age>higherAgeLimit) {
            throw new InvalidAgeException(messageAge);
        }
    }

    void validateNrOfInfants(int nrOfInfants, List<FamilyMemberRequest> familyMemberRequest) {
        AtomicInteger infants = new AtomicInteger();
        familyMemberRequest.forEach(member -> {
            if (member.getAge()<= childhoodBoundary) {
                infants.set(infants.get() + 1);
            }
        });
        if (infants.get() != nrOfInfants) {
            throw new InvalidNrOfInfantsException(messageInfants);
        }
    }

    void validateNrOfChildren(int nrOfChildren, List<FamilyMemberRequest> familyMemberRequest) {
        AtomicInteger children = new AtomicInteger();
        familyMemberRequest.forEach(member -> {
            if (member.getAge()> childhoodBoundary && member.getAge()<= adulthoodBoundary) {
                children.set(children.get() + 1);
            }
        });
        if (children.get() != nrOfChildren) {
            throw new InvalidNrOfInfantsException(messageChildren);
        }
    }

    void validateNrOfAdults(int nrOfAdults, List<FamilyMemberRequest> familyMemberRequest) {
        AtomicInteger adults = new AtomicInteger();
        familyMemberRequest.forEach(member -> {
            if (member.getAge()> adulthoodBoundary) {
                adults.set(adults.get() + 1);
            }
        });
        if (adults.get() != nrOfAdults) {
            throw new InvalidNrOfInfantsException(messageAdults);
        }
    }

    void validateNrOfMembers(int nrOfInfants, int nrOfChildren, int nrOfAdults) {
        if(nrOfInfants == 0 && nrOfChildren == 0 && nrOfAdults == 0) {
            throw new InvalidNrOfMembersException(messageNoMembers);
        }
    }
}