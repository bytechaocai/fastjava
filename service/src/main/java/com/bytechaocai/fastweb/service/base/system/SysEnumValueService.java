
package com.bytechaocai.fastweb.service.base.system;

import com.bytechaocai.fastweb.data.dao.system.SysEnumValueDAO;
import com.bytechaocai.fastweb.data.dao.system.SysEnumValueRepository;
import com.bytechaocai.fastweb.data.entity.system.SysEnumValueEntity;
import com.bytechaocai.fastweb.service.base.BaseService;

/**
* 枚举值表 服务实现。
*
* @author bytechaocai
*/
public interface SysEnumValueService extends BaseService<SysEnumValueEntity, String, SysEnumValueDAO, SysEnumValueRepository> {
}
