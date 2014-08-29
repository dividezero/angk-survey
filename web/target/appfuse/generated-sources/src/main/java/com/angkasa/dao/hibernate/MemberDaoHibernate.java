package com.angkasa.dao.hibernate;

import com.angkasa.model.Member;
import com.angkasa.dao.MemberDao;
import com.angkasa.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDaoHibernate extends GenericDaoHibernate<Member, Long> implements MemberDao {

    public MemberDaoHibernate() {
        super(Member.class);
    }
}
