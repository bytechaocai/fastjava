package com.bytechaocai.fastweb.service.impl.system;

import com.bytechaocai.fastweb.data.dao.system.SysEnumValueDAO;
import com.bytechaocai.fastweb.data.entity.system.SysEnumValueEntity;
import com.bytechaocai.fastweb.data.repository.system.SysEnumValueRepository;
import com.bytechaocai.fastweb.service.base.system.SysEnumValueService;
import com.bytechaocai.fastweb.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 枚举值表 服务实现。
 *
 * @author bytechaocai
 */
@Service
public class SysEnumValueServiceImpl
        extends BaseServiceImpl<SysEnumValueEntity, String, SysEnumValueDAO, SysEnumValueRepository>
        implements SysEnumValueService {
}
