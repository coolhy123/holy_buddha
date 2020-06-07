package com.hydu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hydu.entity.Permission;
import com.hydu.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 * @author jobob
 * @since 2020-06-07
 */

public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名称查询
     * @param userName
     * @return
     */

    User findByUsername(@Param("userName") String userName);

    /**
     * 查询用户的权限根据用户查询权限
     * @param userName
     * @return
     */

    List<Permission> findPermissionByUsername(@Param("userName") String userName);

}
