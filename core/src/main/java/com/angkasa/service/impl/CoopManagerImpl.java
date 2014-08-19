package com.angkasa.service.impl;

import com.angkasa.dao.CoopDao;
import com.angkasa.model.Coop;
import com.angkasa.service.CoopManager;
import com.angkasa.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("coopManager")
@WebService(serviceName = "CoopService", endpointInterface = "com.angkasa.service.CoopManager")
public class CoopManagerImpl extends GenericManagerImpl<Coop, Long> implements CoopManager {
    CoopDao coopDao;

    @Autowired
    public CoopManagerImpl(CoopDao coopDao) {
        super(coopDao);
        this.coopDao = coopDao;
    }
}