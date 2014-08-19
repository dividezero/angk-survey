package com.angkasa.dao.hibernate;

import com.angkasa.model.ContactPerson;
import com.angkasa.dao.ContactPersonDao;
import com.angkasa.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("contactPersonDao")
public class ContactPersonDaoHibernate extends GenericDaoHibernate<ContactPerson, Long> implements ContactPersonDao {

    public ContactPersonDaoHibernate() {
        super(ContactPerson.class);
    }
}
