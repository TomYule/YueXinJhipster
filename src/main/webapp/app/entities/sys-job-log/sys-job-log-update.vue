<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.sysJobLog.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.sysJobLog.home.createOrEditLabel')">Create or edit a SysJobLog</h2>
                <div>
                    <div class="form-group" v-if="sysJobLog.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="sysJobLog.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJobLog.jobName')" for="sys-job-log-jobName">Job Name</label>
                        <input type="text" class="form-control" name="jobName" id="sys-job-log-jobName"
                            :class="{'valid': !$v.sysJobLog.jobName.$invalid, 'invalid': $v.sysJobLog.jobName.$invalid }" v-model="$v.sysJobLog.jobName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJobLog.jobGroup')" for="sys-job-log-jobGroup">Job Group</label>
                        <input type="text" class="form-control" name="jobGroup" id="sys-job-log-jobGroup"
                            :class="{'valid': !$v.sysJobLog.jobGroup.$invalid, 'invalid': $v.sysJobLog.jobGroup.$invalid }" v-model="$v.sysJobLog.jobGroup.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJobLog.invokeTarget')" for="sys-job-log-invokeTarget">Invoke Target</label>
                        <input type="text" class="form-control" name="invokeTarget" id="sys-job-log-invokeTarget"
                            :class="{'valid': !$v.sysJobLog.invokeTarget.$invalid, 'invalid': $v.sysJobLog.invokeTarget.$invalid }" v-model="$v.sysJobLog.invokeTarget.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJobLog.status')" for="sys-job-log-status">Status</label>
                        <input type="text" class="form-control" name="status" id="sys-job-log-status"
                            :class="{'valid': !$v.sysJobLog.status.$invalid, 'invalid': $v.sysJobLog.status.$invalid }" v-model="$v.sysJobLog.status.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJobLog.exceptionInfo')" for="sys-job-log-exceptionInfo">Exception Info</label>
                        <input type="text" class="form-control" name="exceptionInfo" id="sys-job-log-exceptionInfo"
                            :class="{'valid': !$v.sysJobLog.exceptionInfo.$invalid, 'invalid': $v.sysJobLog.exceptionInfo.$invalid }" v-model="$v.sysJobLog.exceptionInfo.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJobLog.createTime')" for="sys-job-log-createTime">Create Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-job-log-createTime"
                                    v-model="$v.sysJobLog.createTime.$model"
                                    name="createTime"
                                    class="form-control"
                                    :locale="currentLanguage"
                                    button-only
                                    today-button
                                    reset-button
                                    close-button
                                >
                                </b-form-datepicker>
                            </b-input-group-prepend>
                            <b-form-input id="sys-job-log-createTime" type="text" class="form-control" name="createTime"  :class="{'valid': !$v.sysJobLog.createTime.$invalid, 'invalid': $v.sysJobLog.createTime.$invalid }"
                            v-model="$v.sysJobLog.createTime.$model"  />
                        </b-input-group>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.sysJobLog.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./sys-job-log-update.component.ts">
</script>
