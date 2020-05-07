package com.minidwep.myshop.config.service;

import com.google.common.collect.Lists;
import com.minidwep.myshop.domain.TbPermission;
import com.minidwep.myshop.domain.TbUser;
import com.minidwep.myshop.service.TbPermissionService;
import com.minidwep.myshop.service.TbUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    public TbUserService tbUserService;

    @Resource
    public TbPermissionService tbPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser byUserName = tbUserService.getByUserName(username);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if(byUserName != null){
            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(byUserName.getId());
            for (TbPermission tbPermission : tbPermissions) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                grantedAuthorities.add(grantedAuthority);
            }
        }
        return new User(byUserName.getUsername(),byUserName.getPassword(),grantedAuthorities);
    }
}
