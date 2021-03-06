package org.sid.prestationservices.dao;

import org.sid.prestationservices.entities.Collaborateur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource
public interface CollaborateurRepository extends MongoRepository<Collaborateur, String> {
    @RestResource(path = "/collaborateursByKeyword")
    List<Collaborateur> findByNameContains(@Param("mc") String mc);

    @RestResource(path = "/dispoCollaborateurs")
    List<Collaborateur> findByAvailableIsTrue();

    @RestResource(path = "/colByName")
    Collaborateur findByName(@Param("cm") String name);
}
