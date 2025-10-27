package com.bytechaocai.fastweb.service.base.system;

import com.bytechaocai.fastweb.data.dao.system.SysConfigDAO;
import com.bytechaocai.fastweb.data.entity.system.SysConfigEntity;
import com.bytechaocai.fastweb.data.repository.system.SysConfigRepository;
import com.bytechaocai.fastweb.service.base.BaseService;

/**
 * 配置表 服务实现。
 *
 * @author bytechaocai
 */
public interface SysConfigService extends BaseService<SysConfigEntity, String, SysConfigDAO, SysConfigRepository> {
}
