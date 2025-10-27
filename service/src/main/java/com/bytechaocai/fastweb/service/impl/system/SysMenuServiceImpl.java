package com.bytechaocai.fastweb.service.impl.system;

import com.bytechaocai.fastweb.data.dao.system.SysMenuDAO;
import com.bytechaocai.fastweb.data.entity.system.SysMenuEntity;
import com.bytechaocai.fastweb.data.repository.system.SysMenuRepository;
import com.bytechaocai.fastweb.service.base.system.SysMenuService;
import com.bytechaocai.fastweb.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 菜单表 服务实现。
 *
 * @author bytechaocai
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuEntity, String, SysMenuDAO, SysMenuRepository>
        implements SysMenuService {
}
