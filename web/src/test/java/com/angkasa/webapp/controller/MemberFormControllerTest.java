package com.angkasa.webapp.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.angkasa.Constants;
import com.angkasa.model.Member;

public class MemberFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private MemberFormController form;
    private Member member;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/memberform");
        request.addParameter("id", "-1");

        member = form.showForm(request);
        assertNotNull(member);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/memberform");
        request.addParameter("id", "-1");

        member = form.showForm(request);
        assertNotNull(member);

        request = newPost("/memberform");

        member = form.showForm(request);
        // update required fields
        member.setCoopId(null);
        member.setIcNumber("0294595003");
        member.setMembershipNo("90128390123");
        member.setGender(Constants.GENDER_FEMALE);
        member.setName("DxQqPcRkFwIeSiSrVrZvQcLlPoCeKbTjNoByZvIvQgCfHkMzYu");
        member.setPhoneNo("QeNeMzAfMlDw");

        BindingResult errors = new DataBinder(member).getBindingResult();
        form.onSubmit(member, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/memberform");
        request.addParameter("delete", "");
        member = new Member();
        member.setId(-2L);

        BindingResult errors = new DataBinder(member).getBindingResult();
        form.onSubmit(member, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
