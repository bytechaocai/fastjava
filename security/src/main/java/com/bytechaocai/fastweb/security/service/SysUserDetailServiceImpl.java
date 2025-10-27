package com.bytechaocai.fastweb.security.service;

import com.bytechaocai.fastweb.data.entity.system.SysUserEntity;
import com.bytechaocai.fastweb.data.repository.system.SysUserRepository;
import com.bytechaocai.fastweb.security.bean.SysUserDetailsImpl;
import com.bytechaocai.fastweb.service.base.system.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 用户详情实现类。
 *
 * @author bytechaocai
 */
@Component
public class SysUserDetailServiceImpl implements UserDetailsService {
    @Resource
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserRepository repository = sysUserService.getRepository();
        Optional<SysUserEntity> opt = repository.findOne((r, q, b) ->
                b.equal(r.get("loginName"), username));
        if (opt.isPresent()) {
            SysUserEntity entity = opt.get();
            return new SysUserDetailsImpl(entity);
        }
        return null;
    }
}
