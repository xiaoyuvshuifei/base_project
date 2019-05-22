package com.bp.baseProject.mapper;

import com.bp.baseProject.entity.vo.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper {

    List<MenuDTO> getMenuForParentId(String parentId);

    List<MenuDTO> getMenuForRoleId(String roleId);

    int deleteMenu(String menuId);

    int updateMenu(MenuDTO menuDTO);

    int insertMenu(MenuDTO menuDTO);
}
