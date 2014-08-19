package com.angkasa.dao.hibernate;

import com.angkasa.model.Coop;
import com.angkasa.dao.CoopDao;
import com.angkasa.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("coopDao")
public class CoopDaoHibernate extends GenericDaoHibernate<Coop, Long> implements CoopDao {

    public CoopDaoHibernate() {
        super(Coop.class);
    }
}
