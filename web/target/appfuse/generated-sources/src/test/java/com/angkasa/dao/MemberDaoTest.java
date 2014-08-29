package com.angkasa.dao;

import com.angkasa.dao.BaseDaoTestCase;
import com.angkasa.model.Member;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberDaoTest extends BaseDaoTestCase {
    @Autowired
    private MemberDao memberDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMember() {
        Member member = new Member();

        // enter all required fields
        member.setCoopId("WwF");
        member.setName("LjLwLwCjMzZuFzKkGzLsJqHrFzNuJdEuHnQyBkZsEyDgIuGiKb");
        member.setPhoneNo("PnGlWvStKaVj");

        log.debug("adding member...");
        member = memberDao.save(member);

        member = memberDao.get(member.getId());

        assertNotNull(member.getId());

        log.debug("removing member...");

        memberDao.remove(member.getId());

        // should throw DataAccessException 
        memberDao.get(member.getId());
    }
}