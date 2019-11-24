package com.xx.sys.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import com.xx.sys.domain.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    /**
     * 查询所有菜单
     */
    
    List<Menu> queryAllMenu(Menu menu);
    /**
     * 根据pid查询菜单数量
     * @param pid
     * @return
     */
	Integer queryMenuByPid(@Param("pid")Integer pid);
	/**
	 * 根据菜单id删除sys_role_menu里面的数据
	 * @param id
	 */
	void deleteRoleMenuByMid(@Param("mid")Integer id);
	/**
	 * 根据角色id查询菜单
	 * @param availableTrue
	 * @param roleid
	 * @return
	 */
	List<Menu> queryMenuByRoleid(@Param("available")Integer available, @Param("rid")Integer rid);

}