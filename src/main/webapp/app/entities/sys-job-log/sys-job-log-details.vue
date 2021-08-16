<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="sysJobLog">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.sysJobLog.detail.title')">SysJobLog</span> {{sysJobLog.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJobLog.jobName')">Job Name</span>
                    </dt>
                    <dd>
                        <span>{{sysJobLog.jobName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJobLog.jobGroup')">Job Group</span>
                    </dt>
                    <dd>
                        <span>{{sysJobLog.jobGroup}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJobLog.invokeTarget')">Invoke Target</span>
                    </dt>
                    <dd>
                        <span>{{sysJobLog.invokeTarget}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJobLog.status')">Status</span>
                    </dt>
                    <dd>
                        <span>{{sysJobLog.status}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJobLog.exceptionInfo')">Exception Info</span>
                    </dt>
                    <dd>
                        <span>{{sysJobLog.exceptionInfo}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJobLog.createTime')">Create Time</span>
                    </dt>
                    <dd>
                        <span>{{sysJobLog.createTime}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="sysJobLog.id" :to="{name: 'SysJobLogEdit', params: {sysJobLogId: sysJobLog.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-job-log-details.component.ts">
</script>
