package com.bytechaocai.fastweb.security.bean;

import com.bytechaocai.fastweb.data.entity.system.SysUserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SysUserDetailsImpl implements UserDetails {
    private SysUserEntity sysUserEntity;

    public SysUserDetailsImpl(SysUserEntity sysUserEntity) {
        this.sysUserEntity = sysUserEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return sysUserEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUserEntity.getUserName();
    }
}
