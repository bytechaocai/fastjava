package com.bytechaocai.fastweb.service.base.system;

import com.bytechaocai.fastweb.data.dao.system.SysEnumDAO;
import com.bytechaocai.fastweb.data.entity.system.SysEnumEntity;
import com.bytechaocai.fastweb.data.repository.system.SysEnumRepository;
import com.bytechaocai.fastweb.service.base.BaseService;

/**
 * 枚举类型表 服务实现。
 *
 * @author bytechaocai
 */
public interface SysEnumService extends BaseService<SysEnumEntity, String, SysEnumDAO, SysEnumRepository> {
}
