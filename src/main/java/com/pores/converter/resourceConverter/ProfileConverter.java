package com.pores.converter.resourceConverter;

import com.pores.entities.Profile;
import com.pores.resource.ProfileResource;

public class ProfileConverter {

    public static Profile convert(ProfileResource resource){
        return Profile.builder()
                .climate(resource.getClimate())
                .Ethnicity(resource.getEthnicity())
                .ref(resource.getRef())
                .location(resource.getLocation())
                .skinType(resource.getSkinType())
                .routine(RoutineConverter.convert(resource.getRoutines()))
                .build();
    }
}
