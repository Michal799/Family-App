package com.example.demo.dto;

import com.example.demo.dto.dtoentities.Family;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FamilyRepository extends CrudRepository<Family, Long> {

    List<Family> findByFamilyName(String familyName);

    Optional<Family> findById(int id);
}