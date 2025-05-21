package com.scu.bpo.service;

import org.springframework.stereotype.Service;

@Service
public interface ProjectTypeService {
    public String findProjectTypeName(Integer projectTypeId);
}
