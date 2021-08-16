package com.yuexin.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.yuexin.web.rest.TestUtil;

public class SysDictDataTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysDictData.class);
        SysDictData sysDictData1 = new SysDictData();
        sysDictData1.setId(1L);
        SysDictData sysDictData2 = new SysDictData();
        sysDictData2.setId(sysDictData1.getId());
        assertThat(sysDictData1).isEqualTo(sysDictData2);
        sysDictData2.setId(2L);
        assertThat(sysDictData1).isNotEqualTo(sysDictData2);
        sysDictData1.setId(null);
        assertThat(sysDictData1).isNotEqualTo(sysDictData2);
    }
}
