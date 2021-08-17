<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="sysJob">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.sysJob.detail.title')">SysJob</span> {{sysJob.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJob.jobName')">Job Name</span>
                    </dt>
                    <dd>
                        <span>{{sysJob.jobName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJob.jobGroup')">Job Group</span>
                    </dt>
                    <dd>
                        <span>{{sysJob.jobGroup}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJob.invokeTarget')">Invoke Target</span>
                    </dt>
                    <dd>
                        <span>{{sysJob.invokeTarget}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJob.cronExpression')">Cron Expression</span>
                    </dt>
                    <dd>
                        <span>{{sysJob.cronExpression}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJob.misfirePolicy')">Misfire Policy</span>
                    </dt>
                    <dd>
                        <span>{{sysJob.misfirePolicy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJob.status')">Status</span>
                    </dt>
                    <dd>
                        <span>{{sysJob.status}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJob.createBy')">Create By</span>
                    </dt>
                    <dd>
                        <span>{{sysJob.createBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJob.createTime')">Create Time</span>
                    </dt>
                    <dd>
                        <span>{{sysJob.createTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJob.updateBy')">Update By</span>
                    </dt>
                    <dd>
                        <span>{{sysJob.updateBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJob.upLocalDate')">Up Local Date</span>
                    </dt>
                    <dd>
                        <span>{{sysJob.upLocalDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysJob.remark')">Remark</span>
                    </dt>
                    <dd>
                        <span>{{sysJob.remark}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="sysJob.id" :to="{name: 'SysJobEdit', params: {sysJobId: sysJob.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-job-details.component.ts">
</script>
