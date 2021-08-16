package com.yuexin.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.yuexin.web.rest.TestUtil;

public class SysPostTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysPost.class);
        SysPost sysPost1 = new SysPost();
        sysPost1.setId(1L);
        SysPost sysPost2 = new SysPost();
        sysPost2.setId(sysPost1.getId());
        assertThat(sysPost1).isEqualTo(sysPost2);
        sysPost2.setId(2L);
        assertThat(sysPost1).isNotEqualTo(sysPost2);
        sysPost1.setId(null);
        assertThat(sysPost1).isNotEqualTo(sysPost2);
    }
}
