package org.sid.prestationservices.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collaborateur {
    @Id
    private String id;
    private String name;
    private String adresse;
    private int phoneNumber;
    private Boolean available;
    private Boolean promotion;
    private String photoname;
    @DBRef
    private Service service;

}
