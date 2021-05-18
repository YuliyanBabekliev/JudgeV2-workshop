package com.softuni.judgeV2.service;

import com.softuni.judgeV2.models.entities.Role;
import com.softuni.judgeV2.models.entities.RoleName;

public interface RoleService {
    void initRoles();

    Role findRole(RoleName roleName);
}
