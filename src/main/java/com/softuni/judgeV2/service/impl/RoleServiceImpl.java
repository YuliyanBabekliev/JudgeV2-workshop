package com.softuni.judgeV2.service.impl;

import com.softuni.judgeV2.models.entities.Role;
import com.softuni.judgeV2.models.entities.RoleName;
import com.softuni.judgeV2.repository.RoleRepository;
import com.softuni.judgeV2.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if(roleRepository.count() == 0){
            Role admin = new Role(RoleName.ADMIN);
            Role user = new Role(RoleName.USER);

            roleRepository.save(admin);
            roleRepository.save(user);
        }
    }

    @Override
    public Role findRole(RoleName roleName) {
        return roleRepository.findByName(roleName).orElse(null);
    }
}
