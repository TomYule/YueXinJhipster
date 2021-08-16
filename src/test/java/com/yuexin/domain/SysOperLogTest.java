package com.yuexin.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.yuexin.web.rest.TestUtil;

public class SysOperLogTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysOperLog.class);
        SysOperLog sysOperLog1 = new SysOperLog();
        sysOperLog1.setId(1L);
        SysOperLog sysOperLog2 = new SysOperLog();
        sysOperLog2.setId(sysOperLog1.getId());
        assertThat(sysOperLog1).isEqualTo(sysOperLog2);
        sysOperLog2.setId(2L);
        assertThat(sysOperLog1).isNotEqualTo(sysOperLog2);
        sysOperLog1.setId(null);
        assertThat(sysOperLog1).isNotEqualTo(sysOperLog2);
    }
}
