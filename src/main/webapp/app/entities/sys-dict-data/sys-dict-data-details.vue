<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="sysDictData">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.sysDictData.detail.title')">SysDictData</span> {{sysDictData.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.dictSort')">Dict Sort</span>
                    </dt>
                    <dd>
                        <span>{{sysDictData.dictSort}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.dictLabel')">Dict Label</span>
                    </dt>
                    <dd>
                        <span>{{sysDictData.dictLabel}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.dictValue')">Dict Value</span>
                    </dt>
                    <dd>
                        <span>{{sysDictData.dictValue}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.dictType')">Dict Type</span>
                    </dt>
                    <dd>
                        <span>{{sysDictData.dictType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.cssClass')">Css Class</span>
                    </dt>
                    <dd>
                        <span>{{sysDictData.cssClass}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.listClass')">List Class</span>
                    </dt>
                    <dd>
                        <span>{{sysDictData.listClass}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.isDefault')">Is Default</span>
                    </dt>
                    <dd>
                        <span>{{sysDictData.isDefault}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.status')">Status</span>
                    </dt>
                    <dd>
                        <span>{{sysDictData.status}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.createBy')">Create By</span>
                    </dt>
                    <dd>
                        <span>{{sysDictData.createBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.createTime')">Create Time</span>
                    </dt>
                    <dd>
                        <span>{{sysDictData.createTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.updateBy')">Update By</span>
                    </dt>
                    <dd>
                        <span>{{sysDictData.updateBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.upLocalDate')">Up Local Date</span>
                    </dt>
                    <dd>
                        <span>{{sysDictData.upLocalDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.remark')">Remark</span>
                    </dt>
                    <dd>
                        <span>{{sysDictData.remark}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictData.sysDictType')">Sys Dict Type</span>
                    </dt>
                    <dd>
                        <div v-if="sysDictData.sysDictType">
                            <router-link :to="{name: 'SysDictTypeView', params: {sysDictTypeId: sysDictData.sysDictType.id}}">{{sysDictData.sysDictType.id}}</router-link>
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="sysDictData.id" :to="{name: 'SysDictDataEdit', params: {sysDictDataId: sysDictData.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-dict-data-details.component.ts">
</script>
