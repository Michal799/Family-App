package com.example.demo.dto;

import com.example.demo.dto.dtoentities.FamilyMember;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FamilyMemberRepository extends CrudRepository<FamilyMember, Long> {

    List<FamilyMember> findByFamilyId(int familyId);

    Optional<FamilyMember> findById(Long familyId);
}
