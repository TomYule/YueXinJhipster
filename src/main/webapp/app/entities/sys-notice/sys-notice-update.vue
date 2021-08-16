<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.sysNotice.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.sysNotice.home.createOrEditLabel')">Create or edit a SysNotice</h2>
                <div>
                    <div class="form-group" v-if="sysNotice.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="sysNotice.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysNotice.noticeTitle')" for="sys-notice-noticeTitle">Notice Title</label>
                        <input type="text" class="form-control" name="noticeTitle" id="sys-notice-noticeTitle"
                            :class="{'valid': !$v.sysNotice.noticeTitle.$invalid, 'invalid': $v.sysNotice.noticeTitle.$invalid }" v-model="$v.sysNotice.noticeTitle.$model"  required/>
                        <div v-if="$v.sysNotice.noticeTitle.$anyDirty && $v.sysNotice.noticeTitle.$invalid">
                            <small class="form-text text-danger" v-if="!$v.sysNotice.noticeTitle.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysNotice.noticeType')" for="sys-notice-noticeType">Notice Type</label>
                        <input type="text" class="form-control" name="noticeType" id="sys-notice-noticeType"
                            :class="{'valid': !$v.sysNotice.noticeType.$invalid, 'invalid': $v.sysNotice.noticeType.$invalid }" v-model="$v.sysNotice.noticeType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysNotice.noticeContent')" for="sys-notice-noticeContent">Notice Content</label>
                        <input type="text" class="form-control" name="noticeContent" id="sys-notice-noticeContent"
                            :class="{'valid': !$v.sysNotice.noticeContent.$invalid, 'invalid': $v.sysNotice.noticeContent.$invalid }" v-model="$v.sysNotice.noticeContent.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysNotice.status')" for="sys-notice-status">Status</label>
                        <input type="number" class="form-control" name="status" id="sys-notice-status"
                            :class="{'valid': !$v.sysNotice.status.$invalid, 'invalid': $v.sysNotice.status.$invalid }" v-model.number="$v.sysNotice.status.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysNotice.createBy')" for="sys-notice-createBy">Create By</label>
                        <input type="text" class="form-control" name="createBy" id="sys-notice-createBy"
                            :class="{'valid': !$v.sysNotice.createBy.$invalid, 'invalid': $v.sysNotice.createBy.$invalid }" v-model="$v.sysNotice.createBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysNotice.createTime')" for="sys-notice-createTime">Create Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-notice-createTime"
                                    v-model="$v.sysNotice.createTime.$model"
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
                            <b-form-input id="sys-notice-createTime" type="text" class="form-control" name="createTime"  :class="{'valid': !$v.sysNotice.createTime.$invalid, 'invalid': $v.sysNotice.createTime.$invalid }"
                            v-model="$v.sysNotice.createTime.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysNotice.updateBy')" for="sys-notice-updateBy">Update By</label>
                        <input type="text" class="form-control" name="updateBy" id="sys-notice-updateBy"
                            :class="{'valid': !$v.sysNotice.updateBy.$invalid, 'invalid': $v.sysNotice.updateBy.$invalid }" v-model="$v.sysNotice.updateBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysNotice.upLocalDate')" for="sys-notice-upLocalDate">Up Local Date</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-notice-upLocalDate"
                                    v-model="$v.sysNotice.upLocalDate.$model"
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
                            <b-form-input id="sys-notice-upLocalDate" type="text" class="form-control" name="upLocalDate"  :class="{'valid': !$v.sysNotice.upLocalDate.$invalid, 'invalid': $v.sysNotice.upLocalDate.$invalid }"
                            v-model="$v.sysNotice.upLocalDate.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysNotice.remark')" for="sys-notice-remark">Remark</label>
                        <textarea class="form-control" name="remark" id="sys-notice-remark"
                            :class="{'valid': !$v.sysNotice.remark.$invalid, 'invalid': $v.sysNotice.remark.$invalid }" v-model="$v.sysNotice.remark.$model" ></textarea>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.sysNotice.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./sys-notice-update.component.ts">
</script>
