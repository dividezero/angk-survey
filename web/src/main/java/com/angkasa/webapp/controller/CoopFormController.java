package com.angkasa.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.angkasa.service.CoopManager;
import com.angkasa.model.Coop;
import com.angkasa.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/coopform*")
public class CoopFormController extends BaseFormController {
    private CoopManager coopManager = null;

    @Autowired
    public void setCoopManager(CoopManager coopManager) {
        this.coopManager = coopManager;
    }

    public CoopFormController() {
        setCancelView("redirect:coops");
        setSuccessView("redirect:coops");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Coop showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return coopManager.get(new Long(id));
        }

        return new Coop();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Coop coop, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(coop, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "coopform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (coop.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            coopManager.remove(coop.getId());
            saveMessage(request, getText("coop.deleted", locale));
        } else {
            coopManager.save(coop);
            String key = (isNew) ? "coop.added" : "coop.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:coopform?id=" + coop.getId();
            }
        }

        return success;
    }
}
