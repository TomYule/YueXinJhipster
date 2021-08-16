package com.yuexin.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 代码生成业务表 entity.\n@author haiming
 */
@ApiModel(description = "代码生成业务表 entity.\n@author haiming")
@Entity
@Table(name = "gen_table")
public class GenTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "table_name", nullable = false)
    private String tableName;

    @Column(name = "table_comment")
    private String tableComment;

    @Column(name = "sub_table_name")
    private String subTableName;

    @Column(name = "sub_table_fk_name")
    private String subTableFkName;

    @Column(name = "class_name")
    private String className;

    @Column(name = "tpl_category")
    private String tplCategory;

    @Column(name = "pack_age_name")
    private String packAgeName;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "function_name")
    private String functionName;

    @Column(name = "function_author")
    private String functionAuthor;

    @Column(name = "gen_type")
    private String genType;

    @Column(name = "gen_path")
    private String genPath;

    @Column(name = "options")
    private String options;

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

    @OneToMany(mappedBy = "genTable")
    private Set<GenTableColumn> tableIds = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public GenTable tableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public GenTable tableComment(String tableComment) {
        this.tableComment = tableComment;
        return this;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getSubTableName() {
        return subTableName;
    }

    public GenTable subTableName(String subTableName) {
        this.subTableName = subTableName;
        return this;
    }

    public void setSubTableName(String subTableName) {
        this.subTableName = subTableName;
    }

    public String getSubTableFkName() {
        return subTableFkName;
    }

    public GenTable subTableFkName(String subTableFkName) {
        this.subTableFkName = subTableFkName;
        return this;
    }

    public void setSubTableFkName(String subTableFkName) {
        this.subTableFkName = subTableFkName;
    }

    public String getClassName() {
        return className;
    }

    public GenTable className(String className) {
        this.className = className;
        return this;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTplCategory() {
        return tplCategory;
    }

    public GenTable tplCategory(String tplCategory) {
        this.tplCategory = tplCategory;
        return this;
    }

    public void setTplCategory(String tplCategory) {
        this.tplCategory = tplCategory;
    }

    public String getPackAgeName() {
        return packAgeName;
    }

    public GenTable packAgeName(String packAgeName) {
        this.packAgeName = packAgeName;
        return this;
    }

    public void setPackAgeName(String packAgeName) {
        this.packAgeName = packAgeName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public GenTable moduleName(String moduleName) {
        this.moduleName = moduleName;
        return this;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public GenTable businessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public GenTable functionName(String functionName) {
        this.functionName = functionName;
        return this;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionAuthor() {
        return functionAuthor;
    }

    public GenTable functionAuthor(String functionAuthor) {
        this.functionAuthor = functionAuthor;
        return this;
    }

    public void setFunctionAuthor(String functionAuthor) {
        this.functionAuthor = functionAuthor;
    }

    public String getGenType() {
        return genType;
    }

    public GenTable genType(String genType) {
        this.genType = genType;
        return this;
    }

    public void setGenType(String genType) {
        this.genType = genType;
    }

    public String getGenPath() {
        return genPath;
    }

    public GenTable genPath(String genPath) {
        this.genPath = genPath;
        return this;
    }

    public void setGenPath(String genPath) {
        this.genPath = genPath;
    }

    public String getOptions() {
        return options;
    }

    public GenTable options(String options) {
        this.options = options;
        return this;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getCreateBy() {
        return createBy;
    }

    public GenTable createBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public GenTable createTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public GenTable updateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDate getUpLocalDate() {
        return upLocalDate;
    }

    public GenTable upLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
        return this;
    }

    public void setUpLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
    }

    public String getRemark() {
        return remark;
    }

    public GenTable remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<GenTableColumn> getTableIds() {
        return tableIds;
    }

    public GenTable tableIds(Set<GenTableColumn> genTableColumns) {
        this.tableIds = genTableColumns;
        return this;
    }

    public GenTable addTableId(GenTableColumn genTableColumn) {
        this.tableIds.add(genTableColumn);
        genTableColumn.setGenTable(this);
        return this;
    }

    public GenTable removeTableId(GenTableColumn genTableColumn) {
        this.tableIds.remove(genTableColumn);
        genTableColumn.setGenTable(null);
        return this;
    }

    public void setTableIds(Set<GenTableColumn> genTableColumns) {
        this.tableIds = genTableColumns;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GenTable)) {
            return false;
        }
        return id != null && id.equals(((GenTable) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GenTable{" +
            "id=" + getId() +
            ", tableName='" + getTableName() + "'" +
            ", tableComment='" + getTableComment() + "'" +
            ", subTableName='" + getSubTableName() + "'" +
            ", subTableFkName='" + getSubTableFkName() + "'" +
            ", className='" + getClassName() + "'" +
            ", tplCategory='" + getTplCategory() + "'" +
            ", packAgeName='" + getPackAgeName() + "'" +
            ", moduleName='" + getModuleName() + "'" +
            ", businessName='" + getBusinessName() + "'" +
            ", functionName='" + getFunctionName() + "'" +
            ", functionAuthor='" + getFunctionAuthor() + "'" +
            ", genType='" + getGenType() + "'" +
            ", genPath='" + getGenPath() + "'" +
            ", options='" + getOptions() + "'" +
            ", createBy='" + getCreateBy() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", upLocalDate='" + getUpLocalDate() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}
