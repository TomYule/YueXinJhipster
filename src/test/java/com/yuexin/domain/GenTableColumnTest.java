package com.yuexin.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.yuexin.web.rest.TestUtil;

public class GenTableColumnTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(GenTableColumn.class);
        GenTableColumn genTableColumn1 = new GenTableColumn();
        genTableColumn1.setId(1L);
        GenTableColumn genTableColumn2 = new GenTableColumn();
        genTableColumn2.setId(genTableColumn1.getId());
        assertThat(genTableColumn1).isEqualTo(genTableColumn2);
        genTableColumn2.setId(2L);
        assertThat(genTableColumn1).isNotEqualTo(genTableColumn2);
        genTableColumn1.setId(null);
        assertThat(genTableColumn1).isNotEqualTo(genTableColumn2);
    }
}
