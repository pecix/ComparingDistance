package com.servocode.ComparingDistance.service;

import com.servocode.ComparingDistance.model.Localization;
import com.servocode.ComparingDistance.repository.LocalizationRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LocalizationService {

    private static final double DEG_TO_KM_MULTIPLIER = 111.1;
    private final LocalizationRepository repository;

    public LocalizationService(LocalizationRepository repository) {
        this.repository = repository;
    }

    public void addFromList(List<Localization> localizations) {
        repository.addFromList(localizations);
    }

    public List<Localization> getAll() {
        return repository.getAll();
    }

    private double calculateDistance(Localization pointA, Localization pointB) {
        double result = Math.sin(Math.toRadians(pointA.getLatitude())) * Math.sin(Math.toRadians(pointB.getLatitude()))
                + Math.cos(Math.toRadians(pointA.getLatitude())) * Math.cos(Math.toRadians(pointB.getLatitude()))
                * Math.cos(Math.toRadians(pointA.getLongitude() - pointB.getLongitude()));
        result = Math.acos(result);
        result = Math.toDegrees(result);
        result = result * DEG_TO_KM_MULTIPLIER;

        return result;
    }

    public HashMap<String, Double> getDistanceToAllLocations(Localization actualPosition){
        var localizations = repository.getAll();
        var distanceFromActualPosition = new HashMap<String, Double>();
        for (Localization local: localizations) {
            distanceFromActualPosition.put(local.getName(), calculateDistance(actualPosition, local));
        }
        return distanceFromActualPosition;
    }

    public String getNearestPlace(Localization actualPosition) {
        var distanceToActualPosition = getDistanceToAllLocations(actualPosition);
        var nearestPlaceName = distanceToActualPosition
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue());

        return nearestPlaceName.isPresent() ? nearestPlaceName.get().getKey() : "No data";
    }
}
