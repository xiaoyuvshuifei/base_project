package com.bp.baseProject.mapper;


import com.bp.baseProject.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminLoginMapper {
	
	
	int selectAdminUserCount(AdminUser adminUser);
	
	List<AdminUser> selectAdminUserRoles(String adminUserName);
	
	int selectAdminRoleIdCount(String roleId);
	
}
