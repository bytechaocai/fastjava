package com.bytechaocai.fastweb.core.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StrUtilTest {

    @Test
    void underlineToLowerCamel() {
        assertEquals("userName", StrUtil.underlineToLowerCamel("user_name"));
        assertEquals("abcDefGhi", StrUtil.underlineToLowerCamel("abc_def_ghi"));
        assertEquals("abcDefGhi", StrUtil.underlineToLowerCamel("abc_def_ghi"));
    }
}
