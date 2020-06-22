package org.sid.prestationservices;

import org.sid.prestationservices.dao.CollaborateurRepository;
import org.sid.prestationservices.dao.ServiceRepository;
import org.sid.prestationservices.entities.Collaborateur;
import org.sid.prestationservices.entities.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class PrestationServicesApplication {
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(PrestationServicesApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ServiceRepository serviceRepository, CollaborateurRepository collaborateurRepository) {

        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Collaborateur.class, Service.class);
            Stream.of("S1 Service1", "S2 Service2").forEach(s -> {
                // repositoryRestConfiguration.exposeIdsFor(Collaborateur.class,Service.class);
                serviceRepository.save(new Service(s.split(" ")[0], s.split(" ")[1], new ArrayList<>()));
            });
            serviceRepository.findAll().forEach(System.out::println);

            collaborateurRepository.deleteAll();
            Service s1 = serviceRepository.findById("S1").get();
            Stream.of("C1", "C2", "C3", "C4").forEach(name -> {
                Collaborateur c = collaborateurRepository.save(new Collaborateur(null, name, "adresse1", 50000000, true, true, "Unknown.png", s1));
                s1.getCollaborateurs().add(c);
                serviceRepository.save(s1);
            });
            Service s2 = serviceRepository.findById("S2").get();
            Stream.of("C5", "C6").forEach(name -> {
                Collaborateur c = collaborateurRepository.save(new Collaborateur(null, name, "adresse2", 98000000, true, true, "Unknown.png", s2));
                s2.getCollaborateurs().add(c);
                serviceRepository.save(s2);
            });
            collaborateurRepository.findAll().forEach(p -> {
                System.out.println(p.toString());
            });
        };

    }
}
