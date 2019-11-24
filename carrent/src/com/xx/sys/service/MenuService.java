package com.xx.sys.service;

import java.util.List;

import com.xx.sys.domain.Menu;
import com.xx.sys.utils.DataGridView;
import com.xx.sys.vo.MenuVo;

/**
 * 
 *菜单管理的服务接口
 * @author lenovo
 *
 */
public interface MenuService {
		/**
		 * 查询所有的菜单返回
		 */
	public List<Menu> queryAllMenuForList(MenuVo menuVo);
	
		/**
		 * 根据用户id查询用户的可用菜单
		 */
	public List<Menu> queryAllMenuByUserIdForList(MenuVo menuVo,Integer userId);
		/**
		 * 查询所有菜单
		 */
	public DataGridView queryAllMenu(MenuVo menuVo);
		/**
		 * 添加菜单
		 * @param menuVo
		 */
	public void addMenu(MenuVo menuVo);
		/**
		 * 修改菜单
		 * @param menuVo
		 */
	public void updateMenu(MenuVo menuVo);
		/**
		 * 根据pid查询菜单数量
		 * @param id
		 * @return
		 */
	public Integer queryMenuByPid(Integer id);
		/**
		 * 根据id删除菜单
		 * @param menuVo
		 */
	public void daleteMenu(MenuVo menuVo);


}
