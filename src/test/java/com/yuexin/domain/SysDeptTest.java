package com.yuexin.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.yuexin.web.rest.TestUtil;

public class SysDeptTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysDept.class);
        SysDept sysDept1 = new SysDept();
        sysDept1.setId(1L);
        SysDept sysDept2 = new SysDept();
        sysDept2.setId(sysDept1.getId());
        assertThat(sysDept1).isEqualTo(sysDept2);
        sysDept2.setId(2L);
        assertThat(sysDept1).isNotEqualTo(sysDept2);
        sysDept1.setId(null);
        assertThat(sysDept1).isNotEqualTo(sysDept2);
    }
}
