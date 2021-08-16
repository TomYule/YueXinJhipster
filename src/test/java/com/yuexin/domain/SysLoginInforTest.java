package com.yuexin.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.yuexin.web.rest.TestUtil;

public class SysLoginInforTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysLoginInfor.class);
        SysLoginInfor sysLoginInfor1 = new SysLoginInfor();
        sysLoginInfor1.setId(1L);
        SysLoginInfor sysLoginInfor2 = new SysLoginInfor();
        sysLoginInfor2.setId(sysLoginInfor1.getId());
        assertThat(sysLoginInfor1).isEqualTo(sysLoginInfor2);
        sysLoginInfor2.setId(2L);
        assertThat(sysLoginInfor1).isNotEqualTo(sysLoginInfor2);
        sysLoginInfor1.setId(null);
        assertThat(sysLoginInfor1).isNotEqualTo(sysLoginInfor2);
    }
}
