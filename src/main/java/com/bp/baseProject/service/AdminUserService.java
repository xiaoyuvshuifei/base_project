package com.bp.baseProject.service;




import com.bp.baseProject.entity.AdminUser;
import com.bp.baseProject.entity.AdminUserRole;

import java.util.List;

public interface AdminUserService {
	
	List<AdminUser> selectAdminUserInfo(AdminUser adminUser);
	
	int insertAdminUserInfo(AdminUser adminUser);
	
	int insertAdminUserRoles(AdminUser adminUser);
	
	int selectAdminUserInfoCount(AdminUser adminUser);
	
	AdminUser selectAdminUserInfoById(String id);
	
	AdminUser selectAdminUserInfoByName(String name);
	
	List<AdminUserRole> selectAdminUserRoles(String userId);
	
	int deleteAdminUserRole(String userId);
	
	int updateAdminUserInfo(AdminUser adminUser);
	
	int deleteAdminUserInfo(String userId);
	

}
