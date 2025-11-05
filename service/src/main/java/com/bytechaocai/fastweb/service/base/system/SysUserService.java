
package com.bytechaocai.fastweb.service.base.system;

import com.bytechaocai.fastweb.data.dao.system.SysUserDAO;
import com.bytechaocai.fastweb.data.entity.system.SysUserEntity;
import com.bytechaocai.fastweb.data.repository.system.SysUserRepository;
import com.bytechaocai.fastweb.service.base.BaseService;

/**
 * 用户信息表 服务实现。
 *
 * @author bytechaocai
 */
public interface SysUserService extends BaseService<SysUserEntity, String, SysUserDAO, SysUserRepository> {
}
