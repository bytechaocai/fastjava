
package com.bytechaocai.fastweb.service.base.system;

import com.bytechaocai.fastweb.data.dao.system.SysMenuDAO;
import com.bytechaocai.fastweb.data.dao.system.SysMenuRepository;
import com.bytechaocai.fastweb.data.entity.system.SysMenuEntity;
import com.bytechaocai.fastweb.service.base.BaseService;

/**
* 菜单表 服务实现。
*
* @author bytechaocai
*/
public interface SysMenuService extends BaseService<SysMenuEntity, String, SysMenuDAO, SysMenuRepository> {
}
