package com.bp.baseProject.service.impl;



import com.bp.baseProject.entity.AdminUser;
import com.bp.baseProject.entity.AdminUserRole;
import com.bp.baseProject.mapper.AdminUserMapper;
import com.bp.baseProject.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminUserServiceImpl implements AdminUserService {
	
	
	
	@Autowired
    private AdminUserMapper adminUserMapper;

	@Override
	public List<AdminUser> selectAdminUserInfo(AdminUser adminUser) {
		List<AdminUser> list = adminUserMapper.selectAdminUserInfo(adminUser);
		return list;
	}

	@Override
	public int insertAdminUserInfo(AdminUser adminUser) {
		int flag = adminUserMapper.insertAdminUserInfo(adminUser);
		return flag;
	}

	@Override
	public int insertAdminUserRoles(AdminUser adminUser) {
		int flag = adminUserMapper.insertAdminUserRoles(adminUser);
		return flag;
	}

	@Override
	public int selectAdminUserInfoCount(AdminUser adminUser) {
		int count = adminUserMapper.selectAdminUserInfoCount(adminUser);
		return count;
	}

	@Override
	public AdminUser selectAdminUserInfoById(String id) {
		AdminUser adminUser = adminUserMapper.selectAdminUserInfoById(id);
		adminUser.setPassword("******");
		return adminUser;
	}

	@Override
	public List<AdminUserRole> selectAdminUserRoles(String userId) {
		List<AdminUserRole> list = adminUserMapper.selectAdminUserRoles(userId);
		return list;
	}

	@Override
	public int deleteAdminUserRole(String userId) {
		int flag = adminUserMapper.deleteAdminUserRole(userId);
		return flag;
	}

	@Override
	public int updateAdminUserInfo(AdminUser adminUser) {
		int flag = adminUserMapper.updateAdminUserInfo(adminUser);
		return flag;
	}

	@Override
	public int deleteAdminUserInfo(String userId) {
		int userFlag = adminUserMapper.deleteAdminUserInfo(userId);
		int roleFlag = adminUserMapper.deleteAdminUserRole(userId);
		if(userFlag == 1 && roleFlag == 1){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public AdminUser selectAdminUserInfoByName(String name) {
		AdminUser adminUser = adminUserMapper.selectAdminUserInfoByName(name);
		adminUser.setPassword("******");
		return adminUser;
	}



	
	
}
