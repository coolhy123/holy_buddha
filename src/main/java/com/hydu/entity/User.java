package com.hydu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-06-07
 */
@Data
public class User implements UserDetails {


    private Integer id;


    private String username;


    private String userRealname;


    private String password;


    private Date createDate;


    private Date lastLoginTime;


    private boolean enabled;


    private boolean accountNonExpired;


    private boolean accountNonLocked;


    private boolean credentialsNonExpired;
    /**
     * 用户权限
     */
    private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }


}
