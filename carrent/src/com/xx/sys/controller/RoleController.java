package com.xx.sys.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xx.sys.constast.SysConstast;
import com.xx.sys.domain.Role;
import com.xx.sys.domain.User;
import com.xx.sys.service.RoleService;
import com.xx.sys.utils.DataGridView;
import com.xx.sys.utils.ResultObj;
import com.xx.sys.utils.TreeNode;
import com.xx.sys.utils.TreeNodeBuilder;
import com.xx.sys.utils.WebUtils;
import com.xx.sys.vo.RoleVo;

/**
 * 
 * 角色管理控制器
 * @author lenovo
 *
 */

@RestController
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	

	/**
	 *  加载角色列表
	 */
	@RequestMapping("loadAllRole")
	public DataGridView  loadAllRole(RoleVo roleVo) {
		return roleService.queryAllRole(roleVo);
	}
	
	/**
	 * 添加角色
	 */
	@RequestMapping("addRole")
	public ResultObj  addRole(RoleVo roleVo) {
		try {
			roleService.addRole(roleVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	/**
	 * 修改角色
	 */
	@RequestMapping("updateRole")
	public ResultObj  updateRole(RoleVo roleVo) {
		try {
			roleService.updateRole(roleVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}
	

	/**
	 * 删除角色
	 */
	@RequestMapping("daleteRole")
	public ResultObj  daleteRole(RoleVo roleVo) {
		try {
			roleService.daleteRole(roleVo.getRoleid());
			return ResultObj.DELECT_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELECT_ERROR;
		}
	}
	/**
	 * 删除角色
	 */
	@RequestMapping("deleteBatchRole")
	public ResultObj  deleteBatchRole(RoleVo roleVo) {
		try {
			roleService.deleteBatchRole(roleVo.getIds());
			return ResultObj.DELECT_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELECT_ERROR;
		}
	}
	/**
	 * 加载角色管理分配菜单的  json
	 */
	@RequestMapping("initRoleMenuTreeJson")
	public DataGridView initRoleMenuTreeJson(Integer roleid) {
		return roleService.initRoleMenuTreeJson(roleid);
	}
	
	/**
	 * 保存角色和菜单的关系
	 */
	@RequestMapping("saveRoleMenu")
	public ResultObj saveRoleMenu(RoleVo roleVo) {
		try {
			roleService.saveRoleMenu(roleVo);
			return ResultObj.DISPATCH_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DISPATCH_ERROR;
		}
		
	}

}
