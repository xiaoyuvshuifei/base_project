package com.bp.baseProject.mapper;

import com.bp.baseProject.entity.AdminRoles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminRolesMapper {

	List<AdminRoles> selectAdminRolesInfo(AdminRoles adminUser);
	
	int selectAdminRolesInfoCount(AdminRoles adminUser);
	
	int insertAdminRole(AdminRoles adminUser);
	
	AdminRoles selectAdminRolesInfoById(String id);
	
	int updateAdminRole(AdminRoles adminUser);
	
	int deleteAdminRole(String id);

	int deletePermissionRole(String roleId);
	
	int insertPermissionRole(Map<String, Object> argMap);

	List<String> getIdForRoleId(String roleId);

}
