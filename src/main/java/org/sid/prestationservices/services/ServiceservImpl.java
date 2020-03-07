package org.sid.prestationservices.services;

import org.sid.prestationservices.dao.CollaborateurRepository;
import org.sid.prestationservices.dao.ServiceRepository;
import org.sid.prestationservices.entities.Collaborateur;
import org.sid.prestationservices.entities.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@org.springframework.stereotype.Service
public class ServiceservImpl implements Serviceserv {
    @Autowired
    private CollaborateurRepository collaborateurRepository;
    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public Collaborateur loadCollaborateurByName(String name) {
        return collaborateurRepository.findByName(name);
    }

    @Override
    public Service findService(String name) {
        return serviceRepository.findByName(name);
    }

    @Override
    public Service addcoltoservice(String sername, String colname) {
        Service ser = serviceRepository.findByName(sername);
        Collaborateur col = collaborateurRepository.findByName(colname);
        ser.getCollaborateurs().add(col);
        serviceRepository.save(ser);
        return ser;
    }
}
