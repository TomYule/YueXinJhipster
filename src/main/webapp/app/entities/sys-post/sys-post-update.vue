<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.sysPost.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.sysPost.home.createOrEditLabel')">Create or edit a SysPost</h2>
                <div>
                    <div class="form-group" v-if="sysPost.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="sysPost.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysPost.postCode')" for="sys-post-postCode">Post Code</label>
                        <input type="text" class="form-control" name="postCode" id="sys-post-postCode"
                            :class="{'valid': !$v.sysPost.postCode.$invalid, 'invalid': $v.sysPost.postCode.$invalid }" v-model="$v.sysPost.postCode.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysPost.postName')" for="sys-post-postName">Post Name</label>
                        <input type="text" class="form-control" name="postName" id="sys-post-postName"
                            :class="{'valid': !$v.sysPost.postName.$invalid, 'invalid': $v.sysPost.postName.$invalid }" v-model="$v.sysPost.postName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysPost.postSort')" for="sys-post-postSort">Post Sort</label>
                        <input type="number" class="form-control" name="postSort" id="sys-post-postSort"
                            :class="{'valid': !$v.sysPost.postSort.$invalid, 'invalid': $v.sysPost.postSort.$invalid }" v-model.number="$v.sysPost.postSort.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysPost.status')" for="sys-post-status">Status</label>
                        <input type="text" class="form-control" name="status" id="sys-post-status"
                            :class="{'valid': !$v.sysPost.status.$invalid, 'invalid': $v.sysPost.status.$invalid }" v-model="$v.sysPost.status.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysPost.createBy')" for="sys-post-createBy">Create By</label>
                        <input type="text" class="form-control" name="createBy" id="sys-post-createBy"
                            :class="{'valid': !$v.sysPost.createBy.$invalid, 'invalid': $v.sysPost.createBy.$invalid }" v-model="$v.sysPost.createBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysPost.createTime')" for="sys-post-createTime">Create Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-post-createTime"
                                    v-model="$v.sysPost.createTime.$model"
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
                            <b-form-input id="sys-post-createTime" type="text" class="form-control" name="createTime"  :class="{'valid': !$v.sysPost.createTime.$invalid, 'invalid': $v.sysPost.createTime.$invalid }"
                            v-model="$v.sysPost.createTime.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysPost.updateBy')" for="sys-post-updateBy">Update By</label>
                        <input type="text" class="form-control" name="updateBy" id="sys-post-updateBy"
                            :class="{'valid': !$v.sysPost.updateBy.$invalid, 'invalid': $v.sysPost.updateBy.$invalid }" v-model="$v.sysPost.updateBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysPost.upLocalDate')" for="sys-post-upLocalDate">Up Local Date</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-post-upLocalDate"
                                    v-model="$v.sysPost.upLocalDate.$model"
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
                            <b-form-input id="sys-post-upLocalDate" type="text" class="form-control" name="upLocalDate"  :class="{'valid': !$v.sysPost.upLocalDate.$invalid, 'invalid': $v.sysPost.upLocalDate.$invalid }"
                            v-model="$v.sysPost.upLocalDate.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysPost.remark')" for="sys-post-remark">Remark</label>
                        <textarea class="form-control" name="remark" id="sys-post-remark"
                            :class="{'valid': !$v.sysPost.remark.$invalid, 'invalid': $v.sysPost.remark.$invalid }" v-model="$v.sysPost.remark.$model" ></textarea>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.sysPost.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./sys-post-update.component.ts">
</script>
