package com.pores.resource;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ProfileResource {

    private String ref;
    private String Ethnicity;
    private String skinType;
    private String climate;
    private String location;
    private List<RoutineResource> routines;


}
