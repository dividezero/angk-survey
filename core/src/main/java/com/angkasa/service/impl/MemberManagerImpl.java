package com.angkasa.service.impl;

import com.angkasa.dao.MemberDao;
import com.angkasa.model.Member;
import com.angkasa.service.MemberManager;
import com.angkasa.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("memberManager")
@WebService(serviceName = "MemberService", endpointInterface = "com.angkasa.service.MemberManager")
public class MemberManagerImpl extends GenericManagerImpl<Member, Long> implements MemberManager {
    MemberDao memberDao;

    @Autowired
    public MemberManagerImpl(MemberDao memberDao) {
        super(memberDao);
        this.memberDao = memberDao;
    }
}