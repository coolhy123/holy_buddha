package com.hydu.config;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hydu.entity.Permission;
import com.hydu.mapper.PermissionMapper;
import com.hydu.services.MemberDetailsService;
import com.hydu.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Wrapper;
import java.util.*;

/**
 * @Author heyong
 * @Date: 2020/6/4  22:52
 */
@Component
@EnableWebSecurity
public class SecuritySericeImpl extends WebSecurityConfigurerAdapter {

    @Autowired
    private MemberDetailsService memberDetailsService;

    @Autowired
    private PermissionMapper permissionMapper;
    /**
     * 添加授权账号
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberDetailsService).passwordEncoder(new PasswordEncoder() {
            /**
             * charSequence对密码MD5加密
             * @param charSequence
             * @return
             */
            @Override
            public String encode(CharSequence charSequence) {
                return   MD5Util.encode((String) charSequence);
            }

            /**
             * @param charSequence 用户输入的密码，
             * @param encodedPassword 数据库查询的密码
             * @return
             */
            @Override
            public boolean matches(CharSequence charSequence, String encodedPassword) {
                String rawPass = MD5Util.encode((String) charSequence);
                boolean result = rawPass.equals(encodedPassword);
                return result;
            }
        });
//        auth.inMemoryAuthentication().withUser("admin")
//                .password(passwordEncoder().encode("admin"))
//                //配置权限  多个权限使用逗号隔开"addMember","delMember", "updateMember", "showMember"
//                .authorities("addMember");
        /**
         * 多个用户多次配置即可（从数据库查询所有用户循环配置即可）
         */
//        auth.inMemoryAuthentication().withUser("heyong")
//                .password(passwordEncoder().encode("heyong"))
//                //配置权限  多个权限使用逗号隔开"addMember","delMember", "updateMember", "showMember"
//                //该用户只有访问addMember的权限
//                .authorities("showMember");

    }

    /**
     *  配置HttpSecurity 拦截资源
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 使用basic登录，浏览器自带登录
         *
         */

        QueryWrapper<Permission>  wrapper = new QueryWrapper<>();
        List<Permission> permissions = permissionMapper.selectList(wrapper);

        /**
         * 动态重数据库查询数据权限数据之后通过Java8 新特性动态配置权限
         */
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry
                expressionInterceptUrlRegistry = http.authorizeRequests();
        permissions.forEach((permission)->{expressionInterceptUrlRegistry
                .antMatchers(permission.getRequestUrl()).hasAnyAuthority(permission.getPermissionStatus());
        });
        expressionInterceptUrlRegistry.antMatchers("/login").permitAll()
                .antMatchers("/**").fullyAuthenticated().and().formLogin().loginPage("/login").and().csrf().disable();
        /**
         * 使用formlogin形式
         * 默认使用 loginForm登录
         */
//        http.authorizeRequests().antMatchers("/addMember").hasAnyAuthority("addMember")
//                .antMatchers("/showMmember").hasAnyAuthority("showMmember")
//                .antMatchers("/login").permitAll()
//                .antMatchers("/**").fullyAuthenticated().and().formLogin().loginPage("/login").and().csrf().disable();
    }

    @Bean
    public  NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
    }
}
