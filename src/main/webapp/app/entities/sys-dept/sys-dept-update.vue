<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.sysDept.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.sysDept.home.createOrEditLabel')">Create or edit a SysDept</h2>
                <div>
                    <div class="form-group" v-if="sysDept.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="sysDept.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDept.deptName')" for="sys-dept-deptName">Dept Name</label>
                        <input type="text" class="form-control" name="deptName" id="sys-dept-deptName"
                            :class="{'valid': !$v.sysDept.deptName.$invalid, 'invalid': $v.sysDept.deptName.$invalid }" v-model="$v.sysDept.deptName.$model"  required/>
                        <div v-if="$v.sysDept.deptName.$anyDirty && $v.sysDept.deptName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.sysDept.deptName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDept.parentId')" for="sys-dept-parentId">Parent Id</label>
                        <input type="text" class="form-control" name="parentId" id="sys-dept-parentId"
                            :class="{'valid': !$v.sysDept.parentId.$invalid, 'invalid': $v.sysDept.parentId.$invalid }" v-model="$v.sysDept.parentId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDept.ancestors')" for="sys-dept-ancestors">Ancestors</label>
                        <input type="text" class="form-control" name="ancestors" id="sys-dept-ancestors"
                            :class="{'valid': !$v.sysDept.ancestors.$invalid, 'invalid': $v.sysDept.ancestors.$invalid }" v-model="$v.sysDept.ancestors.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDept.orderNum')" for="sys-dept-orderNum">Order Num</label>
                        <input type="number" class="form-control" name="orderNum" id="sys-dept-orderNum"
                            :class="{'valid': !$v.sysDept.orderNum.$invalid, 'invalid': $v.sysDept.orderNum.$invalid }" v-model.number="$v.sysDept.orderNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDept.leader')" for="sys-dept-leader">Leader</label>
                        <input type="text" class="form-control" name="leader" id="sys-dept-leader"
                            :class="{'valid': !$v.sysDept.leader.$invalid, 'invalid': $v.sysDept.leader.$invalid }" v-model="$v.sysDept.leader.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDept.phone')" for="sys-dept-phone">Phone</label>
                        <input type="text" class="form-control" name="phone" id="sys-dept-phone"
                            :class="{'valid': !$v.sysDept.phone.$invalid, 'invalid': $v.sysDept.phone.$invalid }" v-model="$v.sysDept.phone.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDept.email')" for="sys-dept-email">Email</label>
                        <input type="text" class="form-control" name="email" id="sys-dept-email"
                            :class="{'valid': !$v.sysDept.email.$invalid, 'invalid': $v.sysDept.email.$invalid }" v-model="$v.sysDept.email.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDept.status')" for="sys-dept-status">Status</label>
                        <input type="text" class="form-control" name="status" id="sys-dept-status"
                            :class="{'valid': !$v.sysDept.status.$invalid, 'invalid': $v.sysDept.status.$invalid }" v-model="$v.sysDept.status.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDept.delFlag')" for="sys-dept-delFlag">Del Flag</label>
                        <input type="text" class="form-control" name="delFlag" id="sys-dept-delFlag"
                            :class="{'valid': !$v.sysDept.delFlag.$invalid, 'invalid': $v.sysDept.delFlag.$invalid }" v-model="$v.sysDept.delFlag.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDept.createBy')" for="sys-dept-createBy">Create By</label>
                        <input type="text" class="form-control" name="createBy" id="sys-dept-createBy"
                            :class="{'valid': !$v.sysDept.createBy.$invalid, 'invalid': $v.sysDept.createBy.$invalid }" v-model="$v.sysDept.createBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDept.createTime')" for="sys-dept-createTime">Create Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-dept-createTime"
                                    v-model="$v.sysDept.createTime.$model"
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
                            <b-form-input id="sys-dept-createTime" type="text" class="form-control" name="createTime"  :class="{'valid': !$v.sysDept.createTime.$invalid, 'invalid': $v.sysDept.createTime.$invalid }"
                            v-model="$v.sysDept.createTime.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDept.updateBy')" for="sys-dept-updateBy">Update By</label>
                        <input type="text" class="form-control" name="updateBy" id="sys-dept-updateBy"
                            :class="{'valid': !$v.sysDept.updateBy.$invalid, 'invalid': $v.sysDept.updateBy.$invalid }" v-model="$v.sysDept.updateBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDept.upLocalDate')" for="sys-dept-upLocalDate">Up Local Date</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-dept-upLocalDate"
                                    v-model="$v.sysDept.upLocalDate.$model"
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
                            <b-form-input id="sys-dept-upLocalDate" type="text" class="form-control" name="upLocalDate"  :class="{'valid': !$v.sysDept.upLocalDate.$invalid, 'invalid': $v.sysDept.upLocalDate.$invalid }"
                            v-model="$v.sysDept.upLocalDate.$model"  />
                        </b-input-group>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.sysDept.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./sys-dept-update.component.ts">
</script>
