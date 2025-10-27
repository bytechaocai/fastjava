package com.bytechaocai.fastweb.service.impl.system;

import com.bytechaocai.fastweb.data.dao.system.SysUserRoleDAO;
import com.bytechaocai.fastweb.data.entity.system.SysUserRoleEntity;
import com.bytechaocai.fastweb.data.repository.system.SysUserRoleRepository;
import com.bytechaocai.fastweb.service.base.system.SysUserRoleService;
import com.bytechaocai.fastweb.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户-角色关联表 服务实现。
 *
 * @author bytechaocai
 */
@Service
public class SysUserRoleServiceImpl
        extends BaseServiceImpl<SysUserRoleEntity, String, SysUserRoleDAO, SysUserRoleRepository>
        implements SysUserRoleService {
}
