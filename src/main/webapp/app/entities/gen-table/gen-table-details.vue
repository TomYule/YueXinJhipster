<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="genTable">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.genTable.detail.title')">GenTable</span> {{genTable.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.tableName')">Table Name</span>
                    </dt>
                    <dd>
                        <span>{{genTable.tableName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.tableComment')">Table Comment</span>
                    </dt>
                    <dd>
                        <span>{{genTable.tableComment}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.subTableName')">Sub Table Name</span>
                    </dt>
                    <dd>
                        <span>{{genTable.subTableName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.subTableFkName')">Sub Table Fk Name</span>
                    </dt>
                    <dd>
                        <span>{{genTable.subTableFkName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.className')">Class Name</span>
                    </dt>
                    <dd>
                        <span>{{genTable.className}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.tplCategory')">Tpl Category</span>
                    </dt>
                    <dd>
                        <span>{{genTable.tplCategory}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.packAgeName')">Pack Age Name</span>
                    </dt>
                    <dd>
                        <span>{{genTable.packAgeName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.moduleName')">Module Name</span>
                    </dt>
                    <dd>
                        <span>{{genTable.moduleName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.businessName')">Business Name</span>
                    </dt>
                    <dd>
                        <span>{{genTable.businessName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.functionName')">Function Name</span>
                    </dt>
                    <dd>
                        <span>{{genTable.functionName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.functionAuthor')">Function Author</span>
                    </dt>
                    <dd>
                        <span>{{genTable.functionAuthor}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.genType')">Gen Type</span>
                    </dt>
                    <dd>
                        <span>{{genTable.genType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.genPath')">Gen Path</span>
                    </dt>
                    <dd>
                        <span>{{genTable.genPath}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.options')">Options</span>
                    </dt>
                    <dd>
                        <span>{{genTable.options}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.createBy')">Create By</span>
                    </dt>
                    <dd>
                        <span>{{genTable.createBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.createTime')">Create Time</span>
                    </dt>
                    <dd>
                        <span>{{genTable.createTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.updateBy')">Update By</span>
                    </dt>
                    <dd>
                        <span>{{genTable.updateBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.upLocalDate')">Up Local Date</span>
                    </dt>
                    <dd>
                        <span>{{genTable.upLocalDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.genTable.remark')">Remark</span>
                    </dt>
                    <dd>
                        <span>{{genTable.remark}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="genTable.id" :to="{name: 'GenTableEdit', params: {genTableId: genTable.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./gen-table-details.component.ts">
</script>
