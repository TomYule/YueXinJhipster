package com.yuexin.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.yuexin.web.rest.TestUtil;

public class SysMenuTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysMenu.class);
        SysMenu sysMenu1 = new SysMenu();
        sysMenu1.setId(1L);
        SysMenu sysMenu2 = new SysMenu();
        sysMenu2.setId(sysMenu1.getId());
        assertThat(sysMenu1).isEqualTo(sysMenu2);
        sysMenu2.setId(2L);
        assertThat(sysMenu1).isNotEqualTo(sysMenu2);
        sysMenu1.setId(null);
        assertThat(sysMenu1).isNotEqualTo(sysMenu2);
    }
}
