package com.pores.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Data
@Builder
public class Profile {

    @Transient
    public static String seqName = "profile_sequence";

    @Id
    private Long id;
    private String ref;
    private String Ethnicity;
    private String skinType;
    private String climate;
    private String location;
    private List<Routine> routine;


}
