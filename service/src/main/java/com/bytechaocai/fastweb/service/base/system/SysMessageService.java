
package com.bytechaocai.fastweb.service.base.system;

import com.bytechaocai.fastweb.data.dao.system.SysMessageDAO;
import com.bytechaocai.fastweb.data.dao.system.SysMessageRepository;
import com.bytechaocai.fastweb.data.entity.system.SysMessageEntity;
import com.bytechaocai.fastweb.service.base.BaseService;

/**
* 提示消息表 服务实现。
*
* @author bytechaocai
*/
public interface SysMessageService extends BaseService<SysMessageEntity, String, SysMessageDAO, SysMessageRepository> {
}
