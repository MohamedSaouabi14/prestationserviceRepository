package org.sid.prestationservices.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document
@Data
@AllArgsConstructor @NoArgsConstructor
public class Service {
    @Id
    private String id;
    private String name;
    private String photo;
    @DBRef
    private Collection<Collaborateur> collaborateurs=new ArrayList<>();

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
