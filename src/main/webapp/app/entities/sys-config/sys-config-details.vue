<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="sysConfig">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.sysConfig.detail.title')">SysConfig</span> {{sysConfig.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysConfig.configName')">Config Name</span>
                    </dt>
                    <dd>
                        <span>{{sysConfig.configName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysConfig.configKey')">Config Key</span>
                    </dt>
                    <dd>
                        <span>{{sysConfig.configKey}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysConfig.configValue')">Config Value</span>
                    </dt>
                    <dd>
                        <span>{{sysConfig.configValue}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysConfig.configType')">Config Type</span>
                    </dt>
                    <dd>
                        <span>{{sysConfig.configType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysConfig.createBy')">Create By</span>
                    </dt>
                    <dd>
                        <span>{{sysConfig.createBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysConfig.createTime')">Create Time</span>
                    </dt>
                    <dd>
                        <span>{{sysConfig.createTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysConfig.updateBy')">Update By</span>
                    </dt>
                    <dd>
                        <span>{{sysConfig.updateBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysConfig.upLocalDate')">Up Local Date</span>
                    </dt>
                    <dd>
                        <span>{{sysConfig.upLocalDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysConfig.remark')">Remark</span>
                    </dt>
                    <dd>
                        <span>{{sysConfig.remark}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="sysConfig.id" :to="{name: 'SysConfigEdit', params: {sysConfigId: sysConfig.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-config-details.component.ts">
</script>
