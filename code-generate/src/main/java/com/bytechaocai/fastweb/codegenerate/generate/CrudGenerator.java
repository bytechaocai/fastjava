package com.bytechaocai.fastweb.codegenerate.generate;

import com.bytechaocai.fastweb.codegenerate.config.CrudConfig;
import com.bytechaocai.fastweb.core.exceptions.SystemException;
import com.bytechaocai.fastweb.core.exceptions.SystemExceptionCode;
import com.bytechaocai.fastweb.core.util.PropertiesUtil;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.util.Properties;

/**
 * 代码生成器。
 *
 * @author bytechaocai
 */
public class CrudGenerator {
    private CrudConfig crudConfig;

    public CrudGenerator(CrudConfig crudConfig) {
        this.crudConfig = crudConfig;
    }

    /**
     * 加载默认值。
     */
    public void loadDefaultConfig() {
        Properties properties = PropertiesUtil.load("classpath:default.properties");
        PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(CrudConfig.class);
        try {
            for (PropertyDescriptor pd : pds) {
                String name = pd.getName();
                if ("class".equals(name)) {
                    continue;
                }
                Class<?> propertyType = pd.getPropertyType();
                Object value = pd.getReadMethod().invoke(crudConfig);
                if (value != null) {
                    continue;
                }
                if (propertyType == Boolean.TYPE) {
                    value = Boolean.parseBoolean(properties.getProperty("crud." + name));
                } else {
                    value = properties.getProperty("crud." + name);
                }
                pd.getWriteMethod().invoke(crudConfig, value);
            }
        } catch (ReflectiveOperationException e) {
            throw new SystemException(SystemExceptionCode.REFLECT_EXCEPTION, e);
        }
    }
}
