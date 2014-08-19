package com.angkasa.service;

import com.angkasa.service.GenericManager;
import com.angkasa.model.ContactPerson;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface ContactPersonManager extends GenericManager<ContactPerson, Long> {
    
}