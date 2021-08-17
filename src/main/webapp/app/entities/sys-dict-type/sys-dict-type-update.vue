<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.sysDictType.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.sysDictType.home.createOrEditLabel')">Create or edit a SysDictType</h2>
                <div>
                    <div class="form-group" v-if="sysDictType.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="sysDictType.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictType.dictName')" for="sys-dict-type-dictName">Dict Name</label>
                        <input type="text" class="form-control" name="dictName" id="sys-dict-type-dictName"
                            :class="{'valid': !$v.sysDictType.dictName.$invalid, 'invalid': $v.sysDictType.dictName.$invalid }" v-model="$v.sysDictType.dictName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictType.dictType')" for="sys-dict-type-dictType">Dict Type</label>
                        <input type="text" class="form-control" name="dictType" id="sys-dict-type-dictType"
                            :class="{'valid': !$v.sysDictType.dictType.$invalid, 'invalid': $v.sysDictType.dictType.$invalid }" v-model="$v.sysDictType.dictType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictType.status')" for="sys-dict-type-status">Status</label>
                        <input type="text" class="form-control" name="status" id="sys-dict-type-status"
                            :class="{'valid': !$v.sysDictType.status.$invalid, 'invalid': $v.sysDictType.status.$invalid }" v-model="$v.sysDictType.status.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictType.createBy')" for="sys-dict-type-createBy">Create By</label>
                        <input type="text" class="form-control" name="createBy" id="sys-dict-type-createBy"
                            :class="{'valid': !$v.sysDictType.createBy.$invalid, 'invalid': $v.sysDictType.createBy.$invalid }" v-model="$v.sysDictType.createBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictType.createTime')" for="sys-dict-type-createTime">Create Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-dict-type-createTime"
                                    v-model="$v.sysDictType.createTime.$model"
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
                            <b-form-input id="sys-dict-type-createTime" type="text" class="form-control" name="createTime"  :class="{'valid': !$v.sysDictType.createTime.$invalid, 'invalid': $v.sysDictType.createTime.$invalid }"
                            v-model="$v.sysDictType.createTime.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictType.updateBy')" for="sys-dict-type-updateBy">Update By</label>
                        <input type="text" class="form-control" name="updateBy" id="sys-dict-type-updateBy"
                            :class="{'valid': !$v.sysDictType.updateBy.$invalid, 'invalid': $v.sysDictType.updateBy.$invalid }" v-model="$v.sysDictType.updateBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictType.upLocalDate')" for="sys-dict-type-upLocalDate">Up Local Date</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-dict-type-upLocalDate"
                                    v-model="$v.sysDictType.upLocalDate.$model"
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
                            <b-form-input id="sys-dict-type-upLocalDate" type="text" class="form-control" name="upLocalDate"  :class="{'valid': !$v.sysDictType.upLocalDate.$invalid, 'invalid': $v.sysDictType.upLocalDate.$invalid }"
                            v-model="$v.sysDictType.upLocalDate.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictType.remark')" for="sys-dict-type-remark">Remark</label>
                        <textarea class="form-control" name="remark" id="sys-dict-type-remark"
                            :class="{'valid': !$v.sysDictType.remark.$invalid, 'invalid': $v.sysDictType.remark.$invalid }" v-model="$v.sysDictType.remark.$model" ></textarea>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.sysDictType.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./sys-dict-type-update.component.ts">
</script>
