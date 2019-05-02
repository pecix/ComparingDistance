package com.servocode.ComparingDistance.repository;

import com.servocode.ComparingDistance.model.Localization;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Builder
@Repository
public class LocalizationRepository {

    private List<Localization> localizations;

    public void addFromList(List<Localization> localizations){
        this.localizations.addAll(localizations);
    }

    public List<Localization> getAll() {
        return localizations;
    }

}
