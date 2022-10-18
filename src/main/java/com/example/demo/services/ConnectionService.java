package com.example.demo.services;

import com.example.demo.dto.dtoEntities.FamilyMember;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConnectionService {
    RestTemplate restTemplate = new RestTemplate();

    void sendFamilyMember(FamilyMember familyMember) {
        restTemplate.postForObject(
                "http://localhost:8083/createFamilyMember",
                familyMember,
                ResponseEntity.class);
    }

    FamilyMember[] receiveFamilyMember(int id) {
        ResponseEntity<FamilyMember[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8083//getFamilyMember/" + id,
                        FamilyMember[].class);
        FamilyMember[] familyMembers = response.getBody();
        return familyMembers;
    }
}