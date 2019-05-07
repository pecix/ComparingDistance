package com.servocode.ComparingDistance.controller;

import com.servocode.ComparingDistance.model.Coordinates;
import com.servocode.ComparingDistance.model.Localization;
import com.servocode.ComparingDistance.model.Message;
import com.servocode.ComparingDistance.service.LocalizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localizations")
public class LocalizationController {

    private final LocalizationService service;

    private LocalizationController(LocalizationService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity addFromList(@RequestBody List<Localization> localizations){
        service.addFromList(localizations);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(service.getAll());
    }

    @GetMapping("/distances")
    public ResponseEntity getDistances(@RequestBody Coordinates actualPosition){
        return ResponseEntity.status(200).body(service.getDistanceToAllLocations(actualPosition));
    }

    @GetMapping("/nearest")
    public ResponseEntity getNearest(@RequestBody Coordinates actualPosition){
        return ResponseEntity.status(200).body(new Message("Nearest place name: " + service.getNearestPlace(actualPosition)));
    }

}
