package com.angkasa.dao;

import com.angkasa.dao.BaseDaoTestCase;
import com.angkasa.model.Coop;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CoopDaoTest extends BaseDaoTestCase {
    @Autowired
    private CoopDao coopDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveCoop() {
        Coop coop = new Coop();

        // enter all required fields
        coop.setCoopId("WzL");
        coop.setName("CuTaCbQoFdReFeOdKlHjJfUoAsJgRzRhKcFjIzWoUiKgVxDgWi");
        coop.setPhoneNo("NgUiVaBbDoBg");

        log.debug("adding coop...");
        coop = coopDao.save(coop);

        coop = coopDao.get(coop.getId());

        assertNotNull(coop.getId());

        log.debug("removing coop...");

        coopDao.remove(coop.getId());

        // should throw DataAccessException 
        coopDao.get(coop.getId());
    }
}