package com.pores.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "routine")
public class Routine {

    public static String seqName = "routine_sequence";
    @Id
    Long id;
    String ref;
}
