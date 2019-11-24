package com.xx.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xx.sys.domain.Menu;
import com.xx.sys.mapper.MenuMapper;
import com.xx.sys.service.MenuService;
import com.xx.sys.utils.DataGridView;
import com.xx.sys.vo.MenuVo;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> queryAllMenuForList(MenuVo menuVo) {
		return menuMapper.queryAllMenu(menuVo);
	}
	
	/**
	 * 权限管理之后
	 */
	@Override
	public List<Menu> queryAllMenuByUserIdForList(MenuVo menuVo, Integer userId) {
		return menuMapper.queryAllMenu(menuVo);
	}

	@Override
	public DataGridView queryAllMenu(MenuVo menuVo) {
	Page<Object> page = PageHelper.startPage(menuVo.getPage(), menuVo.getLimit());
		List<Menu> data = menuMapper.queryAllMenu(menuVo);
		return new DataGridView(page.getTotal(),data);
	}

	@Override
	public void addMenu(MenuVo menuVo) {
		 menuMapper.insertSelective(menuVo);
	}

	@Override
	public void updateMenu(MenuVo menuVo) {
		 menuMapper.updateByPrimaryKeySelective(menuVo);
		
	}

	@Override
	public Integer queryMenuByPid(Integer pid) {
		
		return menuMapper.queryMenuByPid(pid);
	}

	@Override
	public void daleteMenu(MenuVo menuVo) {
		//删除菜单表的数据
		this.menuMapper.deleteByPrimaryKey(menuVo.getId());
		//根据菜单id删除sys_role_menu里面的数据
		menuMapper.deleteRoleMenuByMid(menuVo.getId());
	}
	

}
