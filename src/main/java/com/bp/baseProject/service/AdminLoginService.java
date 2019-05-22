package com.bp.baseProject.service;




import com.bp.baseProject.entity.AdminUser;

import java.util.List;

public interface AdminLoginService {
	
	int checkUserPassword(AdminUser adminUser);
	
	List<AdminUser> selectAdminUserRoles(String adminUserName);
	
	int selectAdminRoleIdCount(String roleId);
}
