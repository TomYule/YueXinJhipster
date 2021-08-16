<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="sysDictType">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.sysDictType.detail.title')">SysDictType</span> {{sysDictType.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictType.dictName')">Dict Name</span>
                    </dt>
                    <dd>
                        <span>{{sysDictType.dictName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictType.dictType')">Dict Type</span>
                    </dt>
                    <dd>
                        <span>{{sysDictType.dictType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictType.status')">Status</span>
                    </dt>
                    <dd>
                        <span>{{sysDictType.status}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictType.createBy')">Create By</span>
                    </dt>
                    <dd>
                        <span>{{sysDictType.createBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictType.createTime')">Create Time</span>
                    </dt>
                    <dd>
                        <span>{{sysDictType.createTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictType.updateBy')">Update By</span>
                    </dt>
                    <dd>
                        <span>{{sysDictType.updateBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictType.upLocalDate')">Up Local Date</span>
                    </dt>
                    <dd>
                        <span>{{sysDictType.upLocalDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDictType.remark')">Remark</span>
                    </dt>
                    <dd>
                        <span>{{sysDictType.remark}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="sysDictType.id" :to="{name: 'SysDictTypeEdit', params: {sysDictTypeId: sysDictType.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-dict-type-details.component.ts">
</script>
