<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.sysOperLog.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.sysOperLog.home.createOrEditLabel')">Create or edit a SysOperLog</h2>
                <div>
                    <div class="form-group" v-if="sysOperLog.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="sysOperLog.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.title')" for="sys-oper-log-title">Title</label>
                        <input type="text" class="form-control" name="title" id="sys-oper-log-title"
                            :class="{'valid': !$v.sysOperLog.title.$invalid, 'invalid': $v.sysOperLog.title.$invalid }" v-model="$v.sysOperLog.title.$model"  required/>
                        <div v-if="$v.sysOperLog.title.$anyDirty && $v.sysOperLog.title.$invalid">
                            <small class="form-text text-danger" v-if="!$v.sysOperLog.title.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.businessType')" for="sys-oper-log-businessType">Business Type</label>
                        <input type="number" class="form-control" name="businessType" id="sys-oper-log-businessType"
                            :class="{'valid': !$v.sysOperLog.businessType.$invalid, 'invalid': $v.sysOperLog.businessType.$invalid }" v-model.number="$v.sysOperLog.businessType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.method')" for="sys-oper-log-method">Method</label>
                        <input type="text" class="form-control" name="method" id="sys-oper-log-method"
                            :class="{'valid': !$v.sysOperLog.method.$invalid, 'invalid': $v.sysOperLog.method.$invalid }" v-model="$v.sysOperLog.method.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.requestMethod')" for="sys-oper-log-requestMethod">Request Method</label>
                        <input type="text" class="form-control" name="requestMethod" id="sys-oper-log-requestMethod"
                            :class="{'valid': !$v.sysOperLog.requestMethod.$invalid, 'invalid': $v.sysOperLog.requestMethod.$invalid }" v-model="$v.sysOperLog.requestMethod.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.operatorType')" for="sys-oper-log-operatorType">Operator Type</label>
                        <input type="number" class="form-control" name="operatorType" id="sys-oper-log-operatorType"
                            :class="{'valid': !$v.sysOperLog.operatorType.$invalid, 'invalid': $v.sysOperLog.operatorType.$invalid }" v-model.number="$v.sysOperLog.operatorType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.operName')" for="sys-oper-log-operName">Oper Name</label>
                        <input type="text" class="form-control" name="operName" id="sys-oper-log-operName"
                            :class="{'valid': !$v.sysOperLog.operName.$invalid, 'invalid': $v.sysOperLog.operName.$invalid }" v-model="$v.sysOperLog.operName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.deptName')" for="sys-oper-log-deptName">Dept Name</label>
                        <input type="text" class="form-control" name="deptName" id="sys-oper-log-deptName"
                            :class="{'valid': !$v.sysOperLog.deptName.$invalid, 'invalid': $v.sysOperLog.deptName.$invalid }" v-model="$v.sysOperLog.deptName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.operUrl')" for="sys-oper-log-operUrl">Oper Url</label>
                        <input type="text" class="form-control" name="operUrl" id="sys-oper-log-operUrl"
                            :class="{'valid': !$v.sysOperLog.operUrl.$invalid, 'invalid': $v.sysOperLog.operUrl.$invalid }" v-model="$v.sysOperLog.operUrl.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.operIp')" for="sys-oper-log-operIp">Oper Ip</label>
                        <input type="text" class="form-control" name="operIp" id="sys-oper-log-operIp"
                            :class="{'valid': !$v.sysOperLog.operIp.$invalid, 'invalid': $v.sysOperLog.operIp.$invalid }" v-model="$v.sysOperLog.operIp.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.operLocation')" for="sys-oper-log-operLocation">Oper Location</label>
                        <input type="text" class="form-control" name="operLocation" id="sys-oper-log-operLocation"
                            :class="{'valid': !$v.sysOperLog.operLocation.$invalid, 'invalid': $v.sysOperLog.operLocation.$invalid }" v-model="$v.sysOperLog.operLocation.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.operParam')" for="sys-oper-log-operParam">Oper Param</label>
                        <textarea class="form-control" name="operParam" id="sys-oper-log-operParam"
                            :class="{'valid': !$v.sysOperLog.operParam.$invalid, 'invalid': $v.sysOperLog.operParam.$invalid }" v-model="$v.sysOperLog.operParam.$model" ></textarea>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.jsonResult')" for="sys-oper-log-jsonResult">Json Result</label>
                        <textarea class="form-control" name="jsonResult" id="sys-oper-log-jsonResult"
                            :class="{'valid': !$v.sysOperLog.jsonResult.$invalid, 'invalid': $v.sysOperLog.jsonResult.$invalid }" v-model="$v.sysOperLog.jsonResult.$model" ></textarea>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.status')" for="sys-oper-log-status">Status</label>
                        <input type="number" class="form-control" name="status" id="sys-oper-log-status"
                            :class="{'valid': !$v.sysOperLog.status.$invalid, 'invalid': $v.sysOperLog.status.$invalid }" v-model.number="$v.sysOperLog.status.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.errorMsg')" for="sys-oper-log-errorMsg">Error Msg</label>
                        <textarea class="form-control" name="errorMsg" id="sys-oper-log-errorMsg"
                            :class="{'valid': !$v.sysOperLog.errorMsg.$invalid, 'invalid': $v.sysOperLog.errorMsg.$invalid }" v-model="$v.sysOperLog.errorMsg.$model" ></textarea>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysOperLog.operTime')" for="sys-oper-log-operTime">Oper Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-oper-log-operTime"
                                    v-model="$v.sysOperLog.operTime.$model"
                                    name="operTime"
                                    class="form-control"
                                    :locale="currentLanguage"
                                    button-only
                                    today-button
                                    reset-button
                                    close-button
                                >
                                </b-form-datepicker>
                            </b-input-group-prepend>
                            <b-form-input id="sys-oper-log-operTime" type="text" class="form-control" name="operTime"  :class="{'valid': !$v.sysOperLog.operTime.$invalid, 'invalid': $v.sysOperLog.operTime.$invalid }"
                            v-model="$v.sysOperLog.operTime.$model"  />
                        </b-input-group>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.sysOperLog.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./sys-oper-log-update.component.ts">
</script>
