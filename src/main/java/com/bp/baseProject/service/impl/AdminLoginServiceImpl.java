package com.bp.baseProject.service.impl;


import com.bp.baseProject.entity.AdminUser;
import com.bp.baseProject.mapper.AdminLoginMapper;
import com.bp.baseProject.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	
	@Autowired
    private AdminLoginMapper adminLoginMapper;

	@Override
	public int checkUserPassword(AdminUser adminUser) {
		int checkResult = adminLoginMapper.selectAdminUserCount(adminUser);
		return checkResult;
	}

	@Override
	public List<AdminUser> selectAdminUserRoles(String adminUserName) {
		List<AdminUser> list = adminLoginMapper.selectAdminUserRoles(adminUserName);
		return list;
	}

	@Override
	public int selectAdminRoleIdCount(String roleId) {
		int count = adminLoginMapper.selectAdminRoleIdCount(roleId);
		return count;
	}





	
	
}
