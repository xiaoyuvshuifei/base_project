package com.bp.baseProject.service;



import com.bp.baseProject.entity.AdminRoles;

import java.util.List;
import java.util.Map;

public interface AdminRolesService {
	
	List<AdminRoles> selectAdminRoles(AdminRoles adminRoles);
	
	int insertAdminRole(AdminRoles adminUser);
	
	int selectAdminRolesInfoCount(AdminRoles adminUser);
	
	AdminRoles selectAdminRolesInfoById(String id);
	
	int updateAdminRole(AdminRoles adminUser);
	
	int deleteAdminRole(String id);
	
//	List<AdminPermissionRole> selectPermissionRole(int roleId);
	
	int deletePermissionRole(String roleId);
	
	int insertPermissionRole(Map<String, Object> argMap);

 	List<String> getIdForRoleId(String roleId);
}
