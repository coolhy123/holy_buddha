package com.hydu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
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
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * userid
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String userRealName;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private LocalDate createDate;

    /**
     * 最后登录时间
     */
    private LocalDate lastLoginTime;

    /**
     * 是否过期0否、1是
     */
    private Integer overdue;

    /**
     * 是否可用0否 1是
     */
    private Integer userStatus;

    /**
     * 是否锁定0否、1是
     */
    private Integer islocking;

    /**
     * 证书是否过期0否、1是
     */
    private Integer certificateOverdue;

    // 用户所有权限
    private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }


}
