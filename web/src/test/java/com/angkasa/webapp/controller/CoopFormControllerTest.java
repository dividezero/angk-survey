package com.angkasa.webapp.controller;

import com.angkasa.webapp.controller.BaseControllerTestCase;
import com.angkasa.model.Coop;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoopFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private CoopFormController form;
    private Coop coop;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/coopform");
        request.addParameter("id", "-1");

        coop = form.showForm(request);
        assertNotNull(coop);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/coopform");
        request.addParameter("id", "-1");

        coop = form.showForm(request);
        assertNotNull(coop);

        request = newPost("/coopform");

        coop = form.showForm(request);
        // update required fields
        coop.setCoopId("DrX");
        coop.setName("OcTmGdSfGnQyGeBiSfUpVhLxFqGwDkIzToCrHcJvAvAgUaXfCq");
        coop.setPhoneNo("IpPnSgMdYyFq");

        BindingResult errors = new DataBinder(coop).getBindingResult();
        form.onSubmit(coop, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/coopform");
        request.addParameter("delete", "");
        coop = new Coop();
        coop.setId(-2L);

        BindingResult errors = new DataBinder(coop).getBindingResult();
        form.onSubmit(coop, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
