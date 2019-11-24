package com.xx.sys.service;

import com.xx.sys.domain.User;
import com.xx.sys.utils.DataGridView;
import com.xx.sys.vo.UserVo;
/**
 * 用户服务接口
 * @author lenovo
 *
 */
public interface UserService {
	User  login(UserVo userVo );
	/**
	 * 查询所有角色
	 */
public DataGridView queryAllUser(UserVo userVo);
	/**
	 * 添加用户
	 * 
	 * @param userVo
	 */
	public void addUser(UserVo userVo);

	/**
	 * 修改用户
	 * 
	 * @param userVo
	 */
	public void updateUser(UserVo userVo);

	/**
	 * 根据id删除用户
	 * 
	 * @param userid
	 */
	public void daleteUser(Integer userid);

	/**
	 * 批量删除用户
	 */
	public void deleteBatchUser(Integer[] ids);
	/**
	 * 重置密码
	 */
	public void reserUserPwd(Integer userid);
}
