package org.sid.prestationservices.dao;


import org.sid.prestationservices.entities.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface ServiceRepository extends MongoRepository<Service, String> {
    @RestResource(path = "/serByName")
    Service findByName(@Param("sm") String name);
}
