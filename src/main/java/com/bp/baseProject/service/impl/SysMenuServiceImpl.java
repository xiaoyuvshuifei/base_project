package com.bp.baseProject.service.impl;


import com.bp.baseProject.entity.vo.MenuDTO;
import com.bp.baseProject.mapper.SysMenuMapper;
import com.bp.baseProject.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<MenuDTO> getMenuForParentId(String parentId){

        return sysMenuMapper.getMenuForParentId(parentId);
    }

    @Override
    public List<MenuDTO> getMenuForRoleId(String roleId) {
        return sysMenuMapper.getMenuForRoleId(roleId);
    }

    @Override
    public int deleteMenu(String menuId){
        return sysMenuMapper.deleteMenu(menuId);
    }

    @Override
    public int updateMenu(MenuDTO menuDTO) {
        return sysMenuMapper.updateMenu(menuDTO);
    }

    @Override
    public int insertMenu(MenuDTO menuDTO) {
        return sysMenuMapper.insertMenu(menuDTO);
    }

}
