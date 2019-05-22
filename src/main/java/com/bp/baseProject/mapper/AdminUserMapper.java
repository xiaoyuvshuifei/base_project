package com.bp.baseProject.mapper;

import com.bp.baseProject.entity.AdminUser;
import com.bp.baseProject.entity.AdminUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminUserMapper {
	
	
	List<AdminUser> selectAdminUserInfo(AdminUser adminUser);
	
	int selectAdminUserInfoCount(AdminUser adminUser);
	
	int insertAdminUserInfo(AdminUser adminUser);
	
	int insertAdminUserRoles(AdminUser adminUser);
	
	AdminUser selectAdminUserInfoById(String userId);
	
	AdminUser selectAdminUserInfoByName(String name);
	
	List<AdminUserRole> selectAdminUserRoles(String userId);
	
	int deleteAdminUserRole(String userId);
	
	int updateAdminUserInfo(AdminUser adminUser);
	
	int deleteAdminUserInfo(String userId);
	
	

}
