package com.bp.baseProject.service.impl;

import com.bp.baseProject.entity.AdminRoles;
import com.bp.baseProject.mapper.AdminRolesMapper;
import com.bp.baseProject.service.AdminRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class AdminRolesServiceImpl implements AdminRolesService {

    @Autowired
    private AdminRolesMapper adminRolesMapper;

    @Override
    public List<AdminRoles> selectAdminRoles(AdminRoles adminRoles) {
        List<AdminRoles> list = adminRolesMapper.selectAdminRolesInfo(adminRoles);
        return list;
    }

    @Override
    public int insertAdminRole(AdminRoles adminUser) {
        int flag = adminRolesMapper.insertAdminRole(adminUser);
        return flag;
    }


    @Override
    public int selectAdminRolesInfoCount(AdminRoles adminUser) {
        int count = adminRolesMapper.selectAdminRolesInfoCount(adminUser);
        return count;
    }

    @Override
    public AdminRoles selectAdminRolesInfoById(String id) {
        AdminRoles adminRoles = adminRolesMapper.selectAdminRolesInfoById(id);
        return adminRoles;
    }

    @Override
    public int updateAdminRole(AdminRoles adminUser) {
        int flag = adminRolesMapper.updateAdminRole(adminUser);
        return flag;
    }

    @Override
    public int deleteAdminRole(String id) {
        int flag = adminRolesMapper.deleteAdminRole(id);
        return flag;
    }


    @Override
    public int deletePermissionRole(String roleId) {
        int flag = adminRolesMapper.deletePermissionRole(roleId);
        return flag;
    }

    @Override
    public int insertPermissionRole(Map<String,Object> argMap) {
        int flag = adminRolesMapper.insertPermissionRole(argMap);
        return flag;
    }

    @Override
    public List<String> getIdForRoleId(String roleId) {
        List<String> idList = adminRolesMapper.getIdForRoleId(roleId);
        return idList;
    }
}
