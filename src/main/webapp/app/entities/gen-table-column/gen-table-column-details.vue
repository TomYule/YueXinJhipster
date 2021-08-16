<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="genTableColumn">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.genTableColumn.detail.title')">GenTableColumn</span> {{genTableColumn.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.tableId')">Table Id</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.tableId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.columnName')">Column Name</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.columnName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.columnComment')">Column Comment</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.columnComment}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.columnType')">Column Type</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.columnType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.javaType')">Java Type</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.javaType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.javaField')">Java Field</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.javaField}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.isPk')">Is Pk</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.isPk}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.isIncrement')">Is Increment</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.isIncrement}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.isRequired')">Is Required</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.isRequired}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.isInsert')">Is Insert</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.isInsert}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.isEdit')">Is Edit</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.isEdit}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.isList')">Is List</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.isList}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.isQuery')">Is Query</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.isQuery}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.htmlType')">Html Type</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.htmlType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.dictType')">Dict Type</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.dictType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.sort')">Sort</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.sort}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.createBy')">Create By</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.createBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.createTime')">Create Time</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.createTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.updateBy')">Update By</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.updateBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.upLocalDate')">Up Local Date</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.upLocalDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.remark')">Remark</span>
                    </dt>
                    <dd>
                        <span>{{genTableColumn.remark}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTableColumn.genTable')">Gen Table</span>
                    </dt>
                    <dd>
                        <div v-if="genTableColumn.genTable">
                            <router-link :to="{name: 'GenTableView', params: {genTableId: genTableColumn.genTable.id}}">{{genTableColumn.genTable.id}}</router-link>
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="genTableColumn.id" :to="{name: 'GenTableColumnEdit', params: {genTableColumnId: genTableColumn.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./gen-table-column-details.component.ts">
</script>
