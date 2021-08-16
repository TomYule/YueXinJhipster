package com.yuexin.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.yuexin.web.rest.TestUtil;

public class SysJobLogTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysJobLog.class);
        SysJobLog sysJobLog1 = new SysJobLog();
        sysJobLog1.setId(1L);
        SysJobLog sysJobLog2 = new SysJobLog();
        sysJobLog2.setId(sysJobLog1.getId());
        assertThat(sysJobLog1).isEqualTo(sysJobLog2);
        sysJobLog2.setId(2L);
        assertThat(sysJobLog1).isNotEqualTo(sysJobLog2);
        sysJobLog1.setId(null);
        assertThat(sysJobLog1).isNotEqualTo(sysJobLog2);
    }
}
