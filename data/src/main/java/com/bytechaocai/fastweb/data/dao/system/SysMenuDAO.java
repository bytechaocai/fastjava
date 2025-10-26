
package com.bytechaocai.fastweb.data.dao.system;

import com.bytechaocai.fastweb.data.dao.BaseDAO;
import com.bytechaocai.fastweb.data.entity.system.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 菜单表 数据操作对象。
*
* @author bytechaocai
*/
@Mapper
public interface SysMenuDAO extends BaseDAO<SysMenuEntity, String> {
}
