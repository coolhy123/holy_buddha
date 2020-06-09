package com.hydu.services;

import com.hydu.entity.Permission;
import com.hydu.entity.User;
import com.hydu.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author heyong
 * @Date: 2020/6/7  11:41
 */
@Component
@Slf4j
public class MemberDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //根据传入的用户名查询到用户
        User user = userMapper.findByUsername(userName);
        if(user==null){
            return null;
        }
        //如果能查到用户，根据用户名称查询权限
        List<Permission> permissionList = userMapper.findPermissionByUsername(userName);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        //循环把权限标识插入到grantedAuthorities中
        permissionList.forEach(
                permission->{grantedAuthorities.add(new SimpleGrantedAuthority(permission.getPermissionStatus()));
                });
//                (a)->grantedAuthorities.add(new SimpleGrantedAuthority(a.getPermissionStatus())));
        log.info(">>>authorities:{}<<<", grantedAuthorities);
        user.setAuthorities(grantedAuthorities);
        return user;
    }
}
