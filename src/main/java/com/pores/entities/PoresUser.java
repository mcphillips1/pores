package com.pores.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "user_table")
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PoresUser {

    @Transient
    private static String seqName = "user_Sequence";

    @Id
    private Long id;
    private String ref;
    private String firstName;
    private String lastName;
    private String email;
    private boolean emailPreference;
    private String contactNumber;
    private LocalDate dateOfBirth;
    private String username;
    private String salt;
    private String saltedPassword;
    private String imageLocation;
    private byte[] imageBtyes;
    private Profile profile;


    public static String getSeqName() {
        return seqName;
    }
}
