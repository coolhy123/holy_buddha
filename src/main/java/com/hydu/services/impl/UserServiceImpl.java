package com.hydu.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hydu.entity.User;
import com.hydu.mapper.UserMapper;
import com.hydu.services.IUserService;

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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
