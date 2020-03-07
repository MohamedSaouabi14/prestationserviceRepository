package org.sid.prestationservices.services;

import org.sid.prestationservices.entities.Collaborateur;
import org.sid.prestationservices.entities.Service;

public interface Serviceserv {
    Collaborateur loadCollaborateurByName(String name);

    Service findService(String name);

    Service addcoltoservice(String sername, String colname);
}
