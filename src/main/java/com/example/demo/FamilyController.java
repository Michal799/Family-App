package com.example.demo;

import com.example.demo.dto.dtoRepositories.FamilyRepository;
import com.example.demo.dto.dtoRequest.FamilyRequest;
import com.example.demo.dto.dtoResponse.FamilyResponse;
import com.example.demo.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Validated
public class FamilyController {

    @Autowired
    private FamilyRepository familyRepository;
    @Autowired
    private FamilyService familyService;

    @GetMapping("/getFamily/{id}")
    public ResponseEntity<FamilyResponse> Family(@RequestBody @PathVariable @Valid int id ) {
        return ResponseEntity.ok(familyService.getFamily(id));
    }

    @PostMapping("/createFamily")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Integer> create(@Valid @RequestBody FamilyRequest family) {return ResponseEntity.ok(familyService.create(family)); }

}