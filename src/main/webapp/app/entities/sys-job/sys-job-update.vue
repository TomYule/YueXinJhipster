<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.sysJob.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.sysJob.home.createOrEditLabel')">Create or edit a SysJob</h2>
                <div>
                    <div class="form-group" v-if="sysJob.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="sysJob.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJob.jobName')" for="sys-job-jobName">Job Name</label>
                        <input type="text" class="form-control" name="jobName" id="sys-job-jobName"
                            :class="{'valid': !$v.sysJob.jobName.$invalid, 'invalid': $v.sysJob.jobName.$invalid }" v-model="$v.sysJob.jobName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJob.jobGroup')" for="sys-job-jobGroup">Job Group</label>
                        <input type="text" class="form-control" name="jobGroup" id="sys-job-jobGroup"
                            :class="{'valid': !$v.sysJob.jobGroup.$invalid, 'invalid': $v.sysJob.jobGroup.$invalid }" v-model="$v.sysJob.jobGroup.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJob.invokeTarget')" for="sys-job-invokeTarget">Invoke Target</label>
                        <input type="text" class="form-control" name="invokeTarget" id="sys-job-invokeTarget"
                            :class="{'valid': !$v.sysJob.invokeTarget.$invalid, 'invalid': $v.sysJob.invokeTarget.$invalid }" v-model="$v.sysJob.invokeTarget.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJob.cronExpression')" for="sys-job-cronExpression">Cron Expression</label>
                        <input type="text" class="form-control" name="cronExpression" id="sys-job-cronExpression"
                            :class="{'valid': !$v.sysJob.cronExpression.$invalid, 'invalid': $v.sysJob.cronExpression.$invalid }" v-model="$v.sysJob.cronExpression.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJob.misfirePolicy')" for="sys-job-misfirePolicy">Misfire Policy</label>
                        <input type="text" class="form-control" name="misfirePolicy" id="sys-job-misfirePolicy"
                            :class="{'valid': !$v.sysJob.misfirePolicy.$invalid, 'invalid': $v.sysJob.misfirePolicy.$invalid }" v-model="$v.sysJob.misfirePolicy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJob.status')" for="sys-job-status">Status</label>
                        <input type="text" class="form-control" name="status" id="sys-job-status"
                            :class="{'valid': !$v.sysJob.status.$invalid, 'invalid': $v.sysJob.status.$invalid }" v-model="$v.sysJob.status.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJob.createBy')" for="sys-job-createBy">Create By</label>
                        <input type="text" class="form-control" name="createBy" id="sys-job-createBy"
                            :class="{'valid': !$v.sysJob.createBy.$invalid, 'invalid': $v.sysJob.createBy.$invalid }" v-model="$v.sysJob.createBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJob.createTime')" for="sys-job-createTime">Create Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-job-createTime"
                                    v-model="$v.sysJob.createTime.$model"
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
                            <b-form-input id="sys-job-createTime" type="text" class="form-control" name="createTime"  :class="{'valid': !$v.sysJob.createTime.$invalid, 'invalid': $v.sysJob.createTime.$invalid }"
                            v-model="$v.sysJob.createTime.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJob.updateBy')" for="sys-job-updateBy">Update By</label>
                        <input type="text" class="form-control" name="updateBy" id="sys-job-updateBy"
                            :class="{'valid': !$v.sysJob.updateBy.$invalid, 'invalid': $v.sysJob.updateBy.$invalid }" v-model="$v.sysJob.updateBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJob.upLocalDate')" for="sys-job-upLocalDate">Up Local Date</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-job-upLocalDate"
                                    v-model="$v.sysJob.upLocalDate.$model"
                                    name="upLocalDate"
                                    class="form-control"
                                    :locale="currentLanguage"
                                    button-only
                                    today-button
                                    reset-button
                                    close-button
                                >
                                </b-form-datepicker>
                            </b-input-group-prepend>
                            <b-form-input id="sys-job-upLocalDate" type="text" class="form-control" name="upLocalDate"  :class="{'valid': !$v.sysJob.upLocalDate.$invalid, 'invalid': $v.sysJob.upLocalDate.$invalid }"
                            v-model="$v.sysJob.upLocalDate.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysJob.remark')" for="sys-job-remark">Remark</label>
                        <textarea class="form-control" name="remark" id="sys-job-remark"
                            :class="{'valid': !$v.sysJob.remark.$invalid, 'invalid': $v.sysJob.remark.$invalid }" v-model="$v.sysJob.remark.$model" ></textarea>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.sysJob.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./sys-job-update.component.ts">
</script>
