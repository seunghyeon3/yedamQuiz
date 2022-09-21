package com.yedam.quiz.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.quiz.users.mapper.UsersMapper;
import com.yedam.quiz.users.service.UsersVO;

@Service
public class UsersService implements UserDetailsService{

	@Autowired UsersMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersVO vo = new UsersVO();
		vo.setId(username);
		vo = mapper.getUser(vo);
		
      //사용자가 존재하지 않는 경우
		if(vo == null) {
			throw new UsernameNotFoundException("no user");
		}
		return vo;
	}

}
