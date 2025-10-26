
package com.bytechaocai.fastweb.data.dao.system;

import com.bytechaocai.fastweb.data.dao.BaseDAO;
import com.bytechaocai.fastweb.data.entity.system.SysMessageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 提示消息表 数据操作对象。
*
* @author bytechaocai
*/
@Mapper
public interface SysMessageDAO extends BaseDAO<SysMessageEntity, String> {
}
