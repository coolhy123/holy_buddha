package com.hydu.services.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hydu.entity.Permission;
import com.hydu.services.IPermissionService;
import com.hydu.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author heyong
 * @since 2020-06-07
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
