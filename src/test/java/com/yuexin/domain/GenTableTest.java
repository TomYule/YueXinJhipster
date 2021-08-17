package com.yuexin.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.yuexin.web.rest.TestUtil;

public class GenTableTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(GenTable.class);
        GenTable genTable1 = new GenTable();
        genTable1.setId(1L);
        GenTable genTable2 = new GenTable();
        genTable2.setId(genTable1.getId());
        assertThat(genTable1).isEqualTo(genTable2);
        genTable2.setId(2L);
        assertThat(genTable1).isNotEqualTo(genTable2);
        genTable1.setId(null);
        assertThat(genTable1).isNotEqualTo(genTable2);
    }
}
