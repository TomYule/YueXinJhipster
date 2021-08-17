package com.yuexin.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.yuexin.web.rest.TestUtil;

public class SysRoleTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysRole.class);
        SysRole sysRole1 = new SysRole();
        sysRole1.setId(1L);
        SysRole sysRole2 = new SysRole();
        sysRole2.setId(sysRole1.getId());
        assertThat(sysRole1).isEqualTo(sysRole2);
        sysRole2.setId(2L);
        assertThat(sysRole1).isNotEqualTo(sysRole2);
        sysRole1.setId(null);
        assertThat(sysRole1).isNotEqualTo(sysRole2);
    }
}
