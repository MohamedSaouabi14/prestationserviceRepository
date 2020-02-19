package org.sid.prestationservices.web;

import org.sid.prestationservices.dao.CollaborateurRepository;
import org.sid.prestationservices.entities.Collaborateur;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class PrestationRestController {
    private CollaborateurRepository collaborateurRepository;

    public  PrestationRestController(CollaborateurRepository collaborateurRepository){
        this.collaborateurRepository = collaborateurRepository;
    }//l'injection des parametres (constructeur avec parametre) on peut utiliser @autowired

    @GetMapping(path="/photoColl/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") String id) throws Exception{
        Collaborateur c=collaborateurRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/collaborateurs/"+c.getPhotoname()));
    }
    @PostMapping(path= "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable String id) throws  Exception{
       Collaborateur c= collaborateurRepository.findById(id).get();
       c.setPhotoname(id+".jpg");
       Files.write(Paths.get(System.getProperty("user.home")+"/collaborateurs/"+c.getPhotoname()),file.getBytes());
       collaborateurRepository.save(c);
    }
}
