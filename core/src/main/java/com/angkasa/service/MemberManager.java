package com.angkasa.service;

import com.angkasa.service.GenericManager;
import com.angkasa.model.Member;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface MemberManager extends GenericManager<Member, Long> {
    
}