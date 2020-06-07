package com.hydu.services.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hydu.entity.Role;
import com.hydu.mapper.RoleMapper;
import com.hydu.services.IRoleService;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-06-07
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
