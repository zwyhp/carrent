package com.xx.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xx.sys.domain.User;
import com.xx.sys.mapper.UserMapper;
import com.xx.sys.service.UserService;
import com.xx.sys.utils.DataGridView;
import com.xx.sys.vo.UserVo;

@Service
public class UserServiceImpl  implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public User login(UserVo userVo) {
		//明文  生成密文
		String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
		userVo.setPwd(pwd);
		return userMapper.login(userVo);
	}
	@Override
	public DataGridView queryAllUser(UserVo userVo) {
		Page<Object> page = PageHelper.startPage(userVo.getPage(),userVo.getLimit());
		List<User> data = userMapper.queryAllUser(userVo);
		return new DataGridView(page.getTotal(), data);
	}
	@Override
	public void addUser(UserVo userVo) {
		/*userMapper.*/
	}
	@Override
	public void updateUser(UserVo userVo) {
		
	}
	@Override
	public void daleteUser(Integer userid) {
		
	}
	@Override
	public void deleteBatchUser(Integer[] ids) {
		
	}
	@Override
	public void reserUserPwd(Integer userid) {
		
	}
	 
}
