
package com.bytechaocai.fastweb.service.impl.system;

import com.bytechaocai.fastweb.data.dao.system.SysUserDAO;
import com.bytechaocai.fastweb.data.entity.system.SysUserEntity;
import com.bytechaocai.fastweb.data.repository.system.SysUserRepository;
import com.bytechaocai.fastweb.service.base.system.SysUserService;
import com.bytechaocai.fastweb.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户信息表 服务实现。
 *
 * @author bytechaocai
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserEntity, String, SysUserDAO, SysUserRepository>
    implements SysUserService {
}
