package com.angkasa.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.angkasa.service.MemberManager;
import com.angkasa.model.Member;
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
@RequestMapping("/memberform*")
public class MemberFormController extends BaseFormController {
    private MemberManager memberManager = null;

    @Autowired
    public void setMemberManager(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    public MemberFormController() {
        setCancelView("redirect:members");
        setSuccessView("redirect:members");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Member showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return memberManager.get(new Long(id));
        }

        return new Member();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Member member, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(member, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "memberform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (member.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            memberManager.remove(member.getId());
            saveMessage(request, getText("member.deleted", locale));
        } else {
            memberManager.save(member);
            String key = (isNew) ? "member.added" : "member.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:memberform?id=" + member.getId();
            }
        }

        return success;
    }
}
