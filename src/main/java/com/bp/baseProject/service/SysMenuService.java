package com.bp.baseProject.service;



import com.bp.baseProject.entity.vo.MenuDTO;

import java.util.List;


public interface SysMenuService {

    List<MenuDTO> getMenuForParentId(String parentId);

    List<MenuDTO> getMenuForRoleId(String roleId);

    int deleteMenu(String menuId);

    int updateMenu(MenuDTO menuDTO);

    int insertMenu(MenuDTO menuDTO);

}
