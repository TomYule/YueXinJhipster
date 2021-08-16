package com.yuexin.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 代码生成业务表字段 entity.\n@author haiming
 */
@ApiModel(description = "代码生成业务表字段 entity.\n@author haiming")
@Entity
@Table(name = "gen_table_column")
public class GenTableColumn implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "table_id", nullable = false)
    private String tableId;

    @Column(name = "column_name")
    private String columnName;

    @Column(name = "column_comment")
    private String columnComment;

    @Column(name = "column_type")
    private String columnType;

    @Column(name = "java_type")
    private String javaType;

    @Column(name = "java_field")
    private String javaField;

    @Column(name = "is_pk")
    private String isPk;

    @Column(name = "is_increment")
    private String isIncrement;

    @Column(name = "is_required")
    private String isRequired;

    @Column(name = "is_insert")
    private String isInsert;

    @Column(name = "is_edit")
    private String isEdit;

    @Column(name = "is_list")
    private String isList;

    @Column(name = "is_query")
    private String isQuery;

    @Column(name = "html_type")
    private String htmlType;

    @Column(name = "dict_type")
    private String dictType;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_time")
    private LocalDate createTime;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "up_local_date")
    private LocalDate upLocalDate;

    @Lob
    @Column(name = "remark")
    private String remark;

    @ManyToOne
    @JsonIgnoreProperties(value = "tableIds", allowSetters = true)
    private GenTable genTable;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableId() {
        return tableId;
    }

    public GenTableColumn tableId(String tableId) {
        this.tableId = tableId;
        return this;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getColumnName() {
        return columnName;
    }

    public GenTableColumn columnName(String columnName) {
        this.columnName = columnName;
        return this;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public GenTableColumn columnComment(String columnComment) {
        this.columnComment = columnComment;
        return this;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnType() {
        return columnType;
    }

    public GenTableColumn columnType(String columnType) {
        this.columnType = columnType;
        return this;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getJavaType() {
        return javaType;
    }

    public GenTableColumn javaType(String javaType) {
        this.javaType = javaType;
        return this;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJavaField() {
        return javaField;
    }

    public GenTableColumn javaField(String javaField) {
        this.javaField = javaField;
        return this;
    }

    public void setJavaField(String javaField) {
        this.javaField = javaField;
    }

    public String getIsPk() {
        return isPk;
    }

    public GenTableColumn isPk(String isPk) {
        this.isPk = isPk;
        return this;
    }

    public void setIsPk(String isPk) {
        this.isPk = isPk;
    }

    public String getIsIncrement() {
        return isIncrement;
    }

    public GenTableColumn isIncrement(String isIncrement) {
        this.isIncrement = isIncrement;
        return this;
    }

    public void setIsIncrement(String isIncrement) {
        this.isIncrement = isIncrement;
    }

    public String getIsRequired() {
        return isRequired;
    }

    public GenTableColumn isRequired(String isRequired) {
        this.isRequired = isRequired;
        return this;
    }

    public void setIsRequired(String isRequired) {
        this.isRequired = isRequired;
    }

    public String getIsInsert() {
        return isInsert;
    }

    public GenTableColumn isInsert(String isInsert) {
        this.isInsert = isInsert;
        return this;
    }

    public void setIsInsert(String isInsert) {
        this.isInsert = isInsert;
    }

    public String getIsEdit() {
        return isEdit;
    }

    public GenTableColumn isEdit(String isEdit) {
        this.isEdit = isEdit;
        return this;
    }

    public void setIsEdit(String isEdit) {
        this.isEdit = isEdit;
    }

    public String getIsList() {
        return isList;
    }

    public GenTableColumn isList(String isList) {
        this.isList = isList;
        return this;
    }

    public void setIsList(String isList) {
        this.isList = isList;
    }

    public String getIsQuery() {
        return isQuery;
    }

    public GenTableColumn isQuery(String isQuery) {
        this.isQuery = isQuery;
        return this;
    }

    public void setIsQuery(String isQuery) {
        this.isQuery = isQuery;
    }

    public String getHtmlType() {
        return htmlType;
    }

    public GenTableColumn htmlType(String htmlType) {
        this.htmlType = htmlType;
        return this;
    }

    public void setHtmlType(String htmlType) {
        this.htmlType = htmlType;
    }

    public String getDictType() {
        return dictType;
    }

    public GenTableColumn dictType(String dictType) {
        this.dictType = dictType;
        return this;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public Integer getSort() {
        return sort;
    }

    public GenTableColumn sort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCreateBy() {
        return createBy;
    }

    public GenTableColumn createBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public GenTableColumn createTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public GenTableColumn updateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDate getUpLocalDate() {
        return upLocalDate;
    }

    public GenTableColumn upLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
        return this;
    }

    public void setUpLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
    }

    public String getRemark() {
        return remark;
    }

    public GenTableColumn remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public GenTable getGenTable() {
        return genTable;
    }

    public GenTableColumn genTable(GenTable genTable) {
        this.genTable = genTable;
        return this;
    }

    public void setGenTable(GenTable genTable) {
        this.genTable = genTable;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GenTableColumn)) {
            return false;
        }
        return id != null && id.equals(((GenTableColumn) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GenTableColumn{" +
            "id=" + getId() +
            ", tableId='" + getTableId() + "'" +
            ", columnName='" + getColumnName() + "'" +
            ", columnComment='" + getColumnComment() + "'" +
            ", columnType='" + getColumnType() + "'" +
            ", javaType='" + getJavaType() + "'" +
            ", javaField='" + getJavaField() + "'" +
            ", isPk='" + getIsPk() + "'" +
            ", isIncrement='" + getIsIncrement() + "'" +
            ", isRequired='" + getIsRequired() + "'" +
            ", isInsert='" + getIsInsert() + "'" +
            ", isEdit='" + getIsEdit() + "'" +
            ", isList='" + getIsList() + "'" +
            ", isQuery='" + getIsQuery() + "'" +
            ", htmlType='" + getHtmlType() + "'" +
            ", dictType='" + getDictType() + "'" +
            ", sort=" + getSort() +
            ", createBy='" + getCreateBy() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", upLocalDate='" + getUpLocalDate() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}
