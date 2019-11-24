package com.xx.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xx.sys.constast.SysConstast;
import com.xx.sys.domain.Menu;
import com.xx.sys.domain.Role;
import com.xx.sys.mapper.MenuMapper;
import com.xx.sys.mapper.RoleMapper;
import com.xx.sys.service.RoleService;
import com.xx.sys.utils.DataGridView;
import com.xx.sys.utils.TreeNode;
import com.xx.sys.vo.RoleVo;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Role> queryAllRoleForList(RoleVo roleVo) {
		return roleMapper.queryAllRole(roleVo);
	}
	
	/**
	 * 权限管理之后
	 */
	@Override
	public List<Role> queryAllRoleByUserIdForList(RoleVo roleVo, Integer userId) {
		return roleMapper.queryAllRole(roleVo);
	}

	@Override
	public DataGridView queryAllRole(RoleVo roleVo) {
	Page<Object> page = PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
		List<Role> data = roleMapper.queryAllRole(roleVo);
		return new DataGridView(page.getTotal(),data);
	}

	@Override
	public void addRole(RoleVo roleVo) {
		 roleMapper.insertSelective(roleVo);
	}

	@Override
	public void updateRole(RoleVo roleVo) {
		 roleMapper.updateByPrimaryKeySelective(roleVo);
		
	}


	@Override
	public void daleteRole(Integer roleid) {
		//删除角色表的数据
		this.roleMapper.deleteByPrimaryKey(roleid);
		//根据角色id删除sys_role_Menu里面的数据
		roleMapper.deleteRoleMenuByRid(roleid);
		//根据角色id删除sys_role_user里面的所有数据
		roleMapper.deleteRoleUserByRid(roleid);
	}

	@Override
	public void deleteBatchRole(Integer[] ids) {
		for (Integer id : ids) {
			daleteRole(id);
		}
	}

	@Override
	public DataGridView initRoleMenuTreeJson(Integer roleid) {
		//查询所有的可用的菜单
		Menu menu = new Menu();
		menu.setAvailable(SysConstast.AVAILABLE_TRUE);
		List<Menu> allMenu = menuMapper.queryAllMenu(menu);
		//根据角色id查询当前角色拥有的菜单
		List<Menu> roleMenu = menuMapper.queryMenuByRoleid(SysConstast.AVAILABLE_TRUE,roleid);
		
		List<TreeNode> data = new ArrayList<>();
		for (Menu m1 : allMenu) {
			String checkArr = SysConstast.CODE_ZERO+"";
			for (Menu m2 : roleMenu) {
				if(m1.getId()==m2.getId()) {
					checkArr=SysConstast.CODE_ONE+"";
					break;
				}
			}
			Integer id = m1.getId();
			Integer pid = m1.getPid();
			String title = m1.getTitle();
			Boolean spread = m1.getSpread()==SysConstast.SPREAD_TRUE?true:false;
			data.add(new TreeNode(id, pid, title, spread, checkArr));
		}	
		return  new DataGridView(data);
	}

	@Override
	public void saveRoleMenu(RoleVo roleVo) {
		
		Integer rid = roleVo.getRoleid();
		 Integer[] mids = roleVo.getIds();
		//根据角色id删除sys_role_Menu里面的数据
			roleMapper.deleteRoleMenuByRid(rid);
		//保存角色和菜单的关系
		 for (Integer mid : mids) {
			roleMapper.insertRoleMenu(rid,mid);
		}
	}
	

}
