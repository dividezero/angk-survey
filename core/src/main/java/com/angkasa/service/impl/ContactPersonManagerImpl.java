package com.angkasa.service.impl;

import com.angkasa.dao.ContactPersonDao;
import com.angkasa.model.ContactPerson;
import com.angkasa.service.ContactPersonManager;
import com.angkasa.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("contactPersonManager")
@WebService(serviceName = "ContactPersonService", endpointInterface = "com.angkasa.service.ContactPersonManager")
public class ContactPersonManagerImpl extends GenericManagerImpl<ContactPerson, Long> implements ContactPersonManager {
    ContactPersonDao contactPersonDao;

    @Autowired
    public ContactPersonManagerImpl(ContactPersonDao contactPersonDao) {
        super(contactPersonDao);
        this.contactPersonDao = contactPersonDao;
    }
}