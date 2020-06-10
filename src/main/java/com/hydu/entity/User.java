package com.hydu.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author heyong
 * @since 2020-06-07
 */
@Data
public class User implements UserDetails {

    /**
     * 用户id
     */
    private Integer id;


    /**
     * 用户名
     */
    private String username;

    /**
     * 用户真实姓名
     */
    private String userRealname;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 是否可用
     */
    private boolean enabled;

    /**
     *账户是否过期
     */
    private boolean accountNonExpired;

    /**
     *账户是否被锁定
     */
    private boolean accountNonLocked;

    /**
     * 证数是否过期
     */
    private boolean credentialsNonExpired;

    /**
     * 加密盐
     */
    private String salt;
    /**
     * 用户权限
     */
    private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }


}
