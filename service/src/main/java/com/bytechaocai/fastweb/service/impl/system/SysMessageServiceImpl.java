package com.bytechaocai.fastweb.service.impl.system;

import com.bytechaocai.fastweb.data.dao.system.SysMessageDAO;
import com.bytechaocai.fastweb.data.entity.system.SysMessageEntity;
import com.bytechaocai.fastweb.data.repository.system.SysMessageRepository;
import com.bytechaocai.fastweb.service.base.system.SysMessageService;
import com.bytechaocai.fastweb.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 提示消息表 服务实现。
 *
 * @author bytechaocai
 */
@Service
public class SysMessageServiceImpl
        extends BaseServiceImpl<SysMessageEntity, String, SysMessageDAO, SysMessageRepository>
        implements SysMessageService {
}
