package org.sid.prestationservices.dao;

import org.sid.prestationservices.entities.Collaborateur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CollaborateurRepository extends MongoRepository <Collaborateur,String> {

}
