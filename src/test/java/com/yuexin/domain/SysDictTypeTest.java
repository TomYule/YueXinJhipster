package com.yuexin.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.yuexin.web.rest.TestUtil;

public class SysDictTypeTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysDictType.class);
        SysDictType sysDictType1 = new SysDictType();
        sysDictType1.setId(1L);
        SysDictType sysDictType2 = new SysDictType();
        sysDictType2.setId(sysDictType1.getId());
        assertThat(sysDictType1).isEqualTo(sysDictType2);
        sysDictType2.setId(2L);
        assertThat(sysDictType1).isNotEqualTo(sysDictType2);
        sysDictType1.setId(null);
        assertThat(sysDictType1).isNotEqualTo(sysDictType2);
    }
}
