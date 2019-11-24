package com.xx.sys.service;

import java.util.List;

import com.xx.sys.domain.Role;
import com.xx.sys.utils.DataGridView;
import com.xx.sys.vo.RoleVo;

/**
 * 
 *角色管理的服务接口
 * @author lenovo
 *
 */
public interface RoleService {
		/**
		 * 查询所有的角色返回
		 */
	public List<Role> queryAllRoleForList(RoleVo roleVo);
	
		/**
		 * 根据用户id查询用户的可用角色
		 */
	public List<Role> queryAllRoleByUserIdForList(RoleVo roleVo,Integer userId);
		/**
		 * 查询所有角色
		 */
	public DataGridView queryAllRole(RoleVo roleVo);
		/**
		 * 添加角色
		 * @param roleVo
		 */
	public void addRole(RoleVo roleVo);
		/**
		 * 修改角色
		 * @param roleVo
		 */
	public void updateRole(RoleVo roleVo);
		
		/**
		 * 根据id删除角色
		 * @param roleid
		 */
	public void daleteRole(Integer roleid);

		/**
		 * 批量删除角色
		 */
	public void deleteBatchRole(Integer [] ids);

	public DataGridView initRoleMenuTreeJson(Integer roleid);
		/**
		 * 保存角色和菜单的关系
		 * @param roleVo
		 */
	public void saveRoleMenu(RoleVo roleVo);
}
