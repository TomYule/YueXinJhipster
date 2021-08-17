package com.yuexin.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.yuexin.web.rest.TestUtil;

public class SysConfigTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysConfig.class);
        SysConfig sysConfig1 = new SysConfig();
        sysConfig1.setId(1L);
        SysConfig sysConfig2 = new SysConfig();
        sysConfig2.setId(sysConfig1.getId());
        assertThat(sysConfig1).isEqualTo(sysConfig2);
        sysConfig2.setId(2L);
        assertThat(sysConfig1).isNotEqualTo(sysConfig2);
        sysConfig1.setId(null);
        assertThat(sysConfig1).isNotEqualTo(sysConfig2);
    }
}
