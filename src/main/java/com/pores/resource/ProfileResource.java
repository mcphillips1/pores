package com.pores.resource;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProfileResource {

    private String ref;
    private String ethnicity;
    private String skinType;
    private String climate;
    private String location;


}
