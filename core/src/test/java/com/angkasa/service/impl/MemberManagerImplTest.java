package com.angkasa.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.angkasa.dao.MemberDao;
import com.angkasa.model.Member;
import com.angkasa.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class MemberManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MemberManagerImpl manager;

    @Mock
    private MemberDao dao;


    @Test
    public void testGetMember() {
        log.debug("testing get...");
        //given
        final Long id = 7L;
        final Member member = new Member();
        given(dao.get(id)).willReturn(member);

        //when
        Member result = manager.get(id);

        //then
        assertSame(member, result);
    }

    @Test
    public void testGetMembers() {
        log.debug("testing getAll...");
        //given
        final List members = new ArrayList();
        given(dao.getAll()).willReturn(members);

        //when
        List result = manager.getAll();

        //then
        assertSame(members, result);
    }

    @Test
    public void testSaveMember() {
        log.debug("testing save...");

        //given
        final Member member = new Member();
        // enter all required fields
        member.setCoopId(new Long("-1"));
        member.setGender("E");
        member.setIcNumber("CsNyFmZmNcIu");
        member.setMembershipNo("NzHdSsHqYg");
        member.setName("MdCfZeJuIhIkJoGeKyYmKfGhZoVzJaGrThExFlBwAbZoTqLaUc");
        member.setPhoneNo("IqAkAxEgFeVr");
        


        given(dao.save(member)).willReturn(member);

        //when
        manager.save(member);

        //then
        verify(dao).save(member);
    }

    @Test
    public void testRemoveMember() {
        log.debug("testing remove...");

        //given
        final Long id = -11L;
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}