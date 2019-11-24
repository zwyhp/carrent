package com.xx.sys.mapper;

import java.util.List;

import com.xx.sys.domain.User;
import com.xx.sys.vo.UserVo;

public interface UserMapper {
	int deleteByPrimaryKey(Integer userid);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer userid);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	/**
	 * 登录
	 */
	User login(User user);

	/**
	 * 查询用戶
	 */
	List<User> queryAllUser(User user);

	
}