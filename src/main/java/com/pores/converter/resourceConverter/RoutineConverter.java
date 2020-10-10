package com.pores.converter.resourceConverter;

import com.pores.entities.Routine;
import com.pores.resource.RoutineResource;

import java.util.List;
import java.util.stream.Collectors;

public class RoutineConverter {

    public static List<Routine> convert(List<RoutineResource> resource){
        return resource.stream().map(RoutineConverter::convert).collect(Collectors.toList());
    }

    public static Routine convert(RoutineResource resource){
        return Routine.builder().ref(resource.getRef()).build();
    }
}
