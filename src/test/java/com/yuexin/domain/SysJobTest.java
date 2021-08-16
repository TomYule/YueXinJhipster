package com.yuexin.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.yuexin.web.rest.TestUtil;

public class SysJobTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysJob.class);
        SysJob sysJob1 = new SysJob();
        sysJob1.setId(1L);
        SysJob sysJob2 = new SysJob();
        sysJob2.setId(sysJob1.getId());
        assertThat(sysJob1).isEqualTo(sysJob2);
        sysJob2.setId(2L);
        assertThat(sysJob1).isNotEqualTo(sysJob2);
        sysJob1.setId(null);
        assertThat(sysJob1).isNotEqualTo(sysJob2);
    }
}
