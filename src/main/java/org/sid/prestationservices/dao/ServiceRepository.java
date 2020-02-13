package org.sid.prestationservices.dao;


import org.sid.prestationservices.entities.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ServiceRepository extends MongoRepository<Service,String> {
}
