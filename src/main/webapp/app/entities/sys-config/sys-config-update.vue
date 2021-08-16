<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.sysConfig.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.sysConfig.home.createOrEditLabel')">Create or edit a SysConfig</h2>
                <div>
                    <div class="form-group" v-if="sysConfig.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="sysConfig.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysConfig.configName')" for="sys-config-configName">Config Name</label>
                        <input type="text" class="form-control" name="configName" id="sys-config-configName"
                            :class="{'valid': !$v.sysConfig.configName.$invalid, 'invalid': $v.sysConfig.configName.$invalid }" v-model="$v.sysConfig.configName.$model"  required/>
                        <div v-if="$v.sysConfig.configName.$anyDirty && $v.sysConfig.configName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.sysConfig.configName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysConfig.configKey')" for="sys-config-configKey">Config Key</label>
                        <input type="text" class="form-control" name="configKey" id="sys-config-configKey"
                            :class="{'valid': !$v.sysConfig.configKey.$invalid, 'invalid': $v.sysConfig.configKey.$invalid }" v-model="$v.sysConfig.configKey.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysConfig.configValue')" for="sys-config-configValue">Config Value</label>
                        <input type="text" class="form-control" name="configValue" id="sys-config-configValue"
                            :class="{'valid': !$v.sysConfig.configValue.$invalid, 'invalid': $v.sysConfig.configValue.$invalid }" v-model="$v.sysConfig.configValue.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysConfig.configType')" for="sys-config-configType">Config Type</label>
                        <input type="text" class="form-control" name="configType" id="sys-config-configType"
                            :class="{'valid': !$v.sysConfig.configType.$invalid, 'invalid': $v.sysConfig.configType.$invalid }" v-model="$v.sysConfig.configType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysConfig.createBy')" for="sys-config-createBy">Create By</label>
                        <input type="text" class="form-control" name="createBy" id="sys-config-createBy"
                            :class="{'valid': !$v.sysConfig.createBy.$invalid, 'invalid': $v.sysConfig.createBy.$invalid }" v-model="$v.sysConfig.createBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysConfig.createTime')" for="sys-config-createTime">Create Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-config-createTime"
                                    v-model="$v.sysConfig.createTime.$model"
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
                            <b-form-input id="sys-config-createTime" type="text" class="form-control" name="createTime"  :class="{'valid': !$v.sysConfig.createTime.$invalid, 'invalid': $v.sysConfig.createTime.$invalid }"
                            v-model="$v.sysConfig.createTime.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysConfig.updateBy')" for="sys-config-updateBy">Update By</label>
                        <input type="text" class="form-control" name="updateBy" id="sys-config-updateBy"
                            :class="{'valid': !$v.sysConfig.updateBy.$invalid, 'invalid': $v.sysConfig.updateBy.$invalid }" v-model="$v.sysConfig.updateBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysConfig.upLocalDate')" for="sys-config-upLocalDate">Up Local Date</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-config-upLocalDate"
                                    v-model="$v.sysConfig.upLocalDate.$model"
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
                            <b-form-input id="sys-config-upLocalDate" type="text" class="form-control" name="upLocalDate"  :class="{'valid': !$v.sysConfig.upLocalDate.$invalid, 'invalid': $v.sysConfig.upLocalDate.$invalid }"
                            v-model="$v.sysConfig.upLocalDate.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysConfig.remark')" for="sys-config-remark">Remark</label>
                        <textarea class="form-control" name="remark" id="sys-config-remark"
                            :class="{'valid': !$v.sysConfig.remark.$invalid, 'invalid': $v.sysConfig.remark.$invalid }" v-model="$v.sysConfig.remark.$model" ></textarea>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.sysConfig.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./sys-config-update.component.ts">
</script>
