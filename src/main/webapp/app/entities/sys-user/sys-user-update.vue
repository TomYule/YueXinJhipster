<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.sysUser.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.sysUser.home.createOrEditLabel')">Create or edit a SysUser</h2>
                <div>
                    <div class="form-group" v-if="sysUser.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="sysUser.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.deptId')" for="sys-user-deptId">Dept Id</label>
                        <input type="text" class="form-control" name="deptId" id="sys-user-deptId"
                            :class="{'valid': !$v.sysUser.deptId.$invalid, 'invalid': $v.sysUser.deptId.$invalid }" v-model="$v.sysUser.deptId.$model"  required/>
                        <div v-if="$v.sysUser.deptId.$anyDirty && $v.sysUser.deptId.$invalid">
                            <small class="form-text text-danger" v-if="!$v.sysUser.deptId.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.userName')" for="sys-user-userName">User Name</label>
                        <input type="text" class="form-control" name="userName" id="sys-user-userName"
                            :class="{'valid': !$v.sysUser.userName.$invalid, 'invalid': $v.sysUser.userName.$invalid }" v-model="$v.sysUser.userName.$model" />
                        <div v-if="$v.sysUser.userName.$anyDirty && $v.sysUser.userName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.sysUser.userName.maxLength" v-text="$t('entity.validation.maxlength', {max: 30})">
                                This field cannot be longer than 30 characters.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.nickName')" for="sys-user-nickName">Nick Name</label>
                        <input type="text" class="form-control" name="nickName" id="sys-user-nickName"
                            :class="{'valid': !$v.sysUser.nickName.$invalid, 'invalid': $v.sysUser.nickName.$invalid }" v-model="$v.sysUser.nickName.$model" />
                        <div v-if="$v.sysUser.nickName.$anyDirty && $v.sysUser.nickName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.sysUser.nickName.maxLength" v-text="$t('entity.validation.maxlength', {max: 30})">
                                This field cannot be longer than 30 characters.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.userType')" for="sys-user-userType">User Type</label>
                        <input type="text" class="form-control" name="userType" id="sys-user-userType"
                            :class="{'valid': !$v.sysUser.userType.$invalid, 'invalid': $v.sysUser.userType.$invalid }" v-model="$v.sysUser.userType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.email')" for="sys-user-email">Email</label>
                        <input type="text" class="form-control" name="email" id="sys-user-email"
                            :class="{'valid': !$v.sysUser.email.$invalid, 'invalid': $v.sysUser.email.$invalid }" v-model="$v.sysUser.email.$model" />
                        <div v-if="$v.sysUser.email.$anyDirty && $v.sysUser.email.$invalid">
                            <small class="form-text text-danger" v-if="!$v.sysUser.email.maxLength" v-text="$t('entity.validation.maxlength', {max: 50})">
                                This field cannot be longer than 50 characters.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.phoneNumber')" for="sys-user-phoneNumber">Phone Number</label>
                        <input type="text" class="form-control" name="phoneNumber" id="sys-user-phoneNumber"
                            :class="{'valid': !$v.sysUser.phoneNumber.$invalid, 'invalid': $v.sysUser.phoneNumber.$invalid }" v-model="$v.sysUser.phoneNumber.$model" />
                        <div v-if="$v.sysUser.phoneNumber.$anyDirty && $v.sysUser.phoneNumber.$invalid">
                            <small class="form-text text-danger" v-if="!$v.sysUser.phoneNumber.maxLength" v-text="$t('entity.validation.maxlength', {max: 11})">
                                This field cannot be longer than 11 characters.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.gender')" for="sys-user-gender">Gender</label>
                        <input type="text" class="form-control" name="gender" id="sys-user-gender"
                            :class="{'valid': !$v.sysUser.gender.$invalid, 'invalid': $v.sysUser.gender.$invalid }" v-model="$v.sysUser.gender.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.avatar')" for="sys-user-avatar">Avatar</label>
                        <input type="text" class="form-control" name="avatar" id="sys-user-avatar"
                            :class="{'valid': !$v.sysUser.avatar.$invalid, 'invalid': $v.sysUser.avatar.$invalid }" v-model="$v.sysUser.avatar.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.password')" for="sys-user-password">Password</label>
                        <input type="text" class="form-control" name="password" id="sys-user-password"
                            :class="{'valid': !$v.sysUser.password.$invalid, 'invalid': $v.sysUser.password.$invalid }" v-model="$v.sysUser.password.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.status')" for="sys-user-status">Status</label>
                        <select class="form-control" name="status" :class="{'valid': !$v.sysUser.status.$invalid, 'invalid': $v.sysUser.status.$invalid }" v-model="$v.sysUser.status.$model" id="sys-user-status" >
                            <option value="ENABLE" v-bind:label="$t('yueXinJhipsterApp.UserStatus.ENABLE')">ENABLE</option>
                            <option value="DISABLE" v-bind:label="$t('yueXinJhipsterApp.UserStatus.DISABLE')">DISABLE</option>
                            <option value="DELETED" v-bind:label="$t('yueXinJhipsterApp.UserStatus.DELETED')">DELETED</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.delFlag')" for="sys-user-delFlag">Del Flag</label>
                        <input type="text" class="form-control" name="delFlag" id="sys-user-delFlag"
                            :class="{'valid': !$v.sysUser.delFlag.$invalid, 'invalid': $v.sysUser.delFlag.$invalid }" v-model="$v.sysUser.delFlag.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.loginIp')" for="sys-user-loginIp">Login Ip</label>
                        <input type="text" class="form-control" name="loginIp" id="sys-user-loginIp"
                            :class="{'valid': !$v.sysUser.loginIp.$invalid, 'invalid': $v.sysUser.loginIp.$invalid }" v-model="$v.sysUser.loginIp.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.loginDate')" for="sys-user-loginDate">Login Date</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-user-loginDate"
                                    v-model="$v.sysUser.loginDate.$model"
                                    name="loginDate"
                                    class="form-control"
                                    :locale="currentLanguage"
                                    button-only
                                    today-button
                                    reset-button
                                    close-button
                                >
                                </b-form-datepicker>
                            </b-input-group-prepend>
                            <b-form-input id="sys-user-loginDate" type="text" class="form-control" name="loginDate"  :class="{'valid': !$v.sysUser.loginDate.$invalid, 'invalid': $v.sysUser.loginDate.$invalid }"
                            v-model="$v.sysUser.loginDate.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.createBy')" for="sys-user-createBy">Create By</label>
                        <input type="text" class="form-control" name="createBy" id="sys-user-createBy"
                            :class="{'valid': !$v.sysUser.createBy.$invalid, 'invalid': $v.sysUser.createBy.$invalid }" v-model="$v.sysUser.createBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.createTime')" for="sys-user-createTime">Create Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-user-createTime"
                                    v-model="$v.sysUser.createTime.$model"
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
                            <b-form-input id="sys-user-createTime" type="text" class="form-control" name="createTime"  :class="{'valid': !$v.sysUser.createTime.$invalid, 'invalid': $v.sysUser.createTime.$invalid }"
                            v-model="$v.sysUser.createTime.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.updateBy')" for="sys-user-updateBy">Update By</label>
                        <input type="text" class="form-control" name="updateBy" id="sys-user-updateBy"
                            :class="{'valid': !$v.sysUser.updateBy.$invalid, 'invalid': $v.sysUser.updateBy.$invalid }" v-model="$v.sysUser.updateBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.upLocalDate')" for="sys-user-upLocalDate">Up Local Date</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-user-upLocalDate"
                                    v-model="$v.sysUser.upLocalDate.$model"
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
                            <b-form-input id="sys-user-upLocalDate" type="text" class="form-control" name="upLocalDate"  :class="{'valid': !$v.sysUser.upLocalDate.$invalid, 'invalid': $v.sysUser.upLocalDate.$invalid }"
                            v-model="$v.sysUser.upLocalDate.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.remark')" for="sys-user-remark">Remark</label>
                        <textarea class="form-control" name="remark" id="sys-user-remark"
                            :class="{'valid': !$v.sysUser.remark.$invalid, 'invalid': $v.sysUser.remark.$invalid }" v-model="$v.sysUser.remark.$model" ></textarea>
                    </div>
                    <div class="form-group">
                        <label v-text="$t('yueXinJhipsterApp.sysUser.sysPost')" for="sys-user-sysPost">Sys Post</label>
                        <select class="form-control" id="sys-user-sysPost" multiple name="sysPost" v-model="sysUser.sysPosts">
                            <option v-bind:value="getSelected(sysUser.sysPosts, sysPostOption)" v-for="sysPostOption in sysPosts" :key="sysPostOption.id">{{sysPostOption.id}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysUser.sysDept')" for="sys-user-sysDept">Sys Dept</label>
                        <select class="form-control" id="sys-user-sysDept" name="sysDept" v-model="sysUser.sysDept">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="sysUser.sysDept && sysDeptOption.id === sysUser.sysDept.id ? sysUser.sysDept : sysDeptOption" v-for="sysDeptOption in sysDepts" :key="sysDeptOption.id">{{sysDeptOption.id}}</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.sysUser.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./sys-user-update.component.ts">
</script>
