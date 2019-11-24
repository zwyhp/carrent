package com.xx.sys.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xx.sys.constast.SysConstast;
import com.xx.sys.domain.Menu;
import com.xx.sys.domain.User;
import com.xx.sys.service.MenuService;
import com.xx.sys.utils.DataGridView;
import com.xx.sys.utils.ResultObj;
import com.xx.sys.utils.TreeNode;
import com.xx.sys.utils.TreeNodeBuilder;
import com.xx.sys.utils.WebUtils;
import com.xx.sys.vo.MenuVo;

/**
 * 
 * 菜单管理控制器
 * @author lenovo
 *
 */

@RestController
@RequestMapping("menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("loadIndexLeftMenuJson")
	public List<TreeNode> loadIndexLeftMenuJson(MenuVo menuVo){
		//
		User user = (User)WebUtils.getHttpSession().getAttribute("user");
		 List<Menu> list = null;
		 menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);//不管是谁只查询可用的
		if(user.getType()==SysConstast.USER_TYPE_SUPER) {
			list = menuService.queryAllMenuForList(menuVo);
		}else {
			list = menuService.queryAllMenuByUserIdForList(menuVo, user.getUserid());
		}
	
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		//把list里面的数据放在nodes
		for (Menu menu : list) {
			Integer id = menu.getId();
			Integer pid = menu.getPid();
			String title = menu.getTitle();
			String icon = menu.getIcon();
			String href = menu.getHref();
			Boolean spread = menu.getSpread()==SysConstast.SPREAD_TRUE?true:false;
			String target = menu.getTarget();
			nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
		}
		return TreeNodeBuilder.builder(nodes, 1);
	}

	/**
	 *  加载菜单管理左边的菜单树
	 */
	@RequestMapping("loadMenuManagerLeftTreeJson")
	public DataGridView loadMenuManagerLeftTreeJson(MenuVo menuVo){
		menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);//不管是谁只查询可用的
		List<Menu> list = menuService.queryAllMenuForList(menuVo);
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		//把list里面的数据放在nodes
		for (Menu menu : list) {
			Integer id = menu.getId();
			Integer pid = menu.getPid();
			String title = menu.getTitle();
			String icon = menu.getIcon();
			String href = menu.getHref();
			Boolean spread = menu.getSpread()==SysConstast.SPREAD_TRUE?true:false;
			String target = menu.getTarget();
			nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
		}
		return new DataGridView(nodes) ;
	}
	
	/**
	 *  加载菜单列表
	 */
	@RequestMapping("loadAllMenu")
	public DataGridView  loadAllMenu(MenuVo menuVo) {
		return menuService.queryAllMenu(menuVo);
	}
	
	/**
	 * 添加菜单
	 */
	@RequestMapping("addMenu")
	public ResultObj  addMenu(MenuVo menuVo) {
		try {
			menuService.addMenu(menuVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	/**
	 * 修改菜单
	 */
	@RequestMapping("updateMenu")
	public ResultObj  updateMenu(MenuVo menuVo) {
		try {
			menuService.updateMenu(menuVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}
	/**
	 * 根据id判断当前菜单有没有字节点
	 * 有访问Code>=0
	 * 没有返回Code<0
	 */
	@RequestMapping("checkMenuHasChildren")
	public ResultObj checkMenuHasChildren(MenuVo menuVo){
		//根据pid查询菜单数量
		
		Integer count = menuService.queryMenuByPid(menuVo.getId());
		if (count>0) {
			return ResultObj.STATUS_TRUE;
		}else {
			return ResultObj.STATUS_FALSE;
		}
	}

	/**
	 * 删除菜单
	 */
	@RequestMapping("daleteMenu")
	public ResultObj  daleteMenu(MenuVo menuVo) {
		try {
			menuService.daleteMenu(menuVo);
			return ResultObj.DELECT_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELECT_ERROR;
		}
	}

}
