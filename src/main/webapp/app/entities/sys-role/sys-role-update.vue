<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.sysRole.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.sysRole.home.createOrEditLabel')">Create or edit a SysRole</h2>
                <div>
                    <div class="form-group" v-if="sysRole.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="sysRole.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysRole.roleName')" for="sys-role-roleName">Role Name</label>
                        <input type="text" class="form-control" name="roleName" id="sys-role-roleName"
                            :class="{'valid': !$v.sysRole.roleName.$invalid, 'invalid': $v.sysRole.roleName.$invalid }" v-model="$v.sysRole.roleName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysRole.roleKey')" for="sys-role-roleKey">Role Key</label>
                        <input type="text" class="form-control" name="roleKey" id="sys-role-roleKey"
                            :class="{'valid': !$v.sysRole.roleKey.$invalid, 'invalid': $v.sysRole.roleKey.$invalid }" v-model="$v.sysRole.roleKey.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysRole.roleSort')" for="sys-role-roleSort">Role Sort</label>
                        <input type="number" class="form-control" name="roleSort" id="sys-role-roleSort"
                            :class="{'valid': !$v.sysRole.roleSort.$invalid, 'invalid': $v.sysRole.roleSort.$invalid }" v-model.number="$v.sysRole.roleSort.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysRole.dataScope')" for="sys-role-dataScope">Data Scope</label>
                        <input type="text" class="form-control" name="dataScope" id="sys-role-dataScope"
                            :class="{'valid': !$v.sysRole.dataScope.$invalid, 'invalid': $v.sysRole.dataScope.$invalid }" v-model="$v.sysRole.dataScope.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysRole.menuCheckStrictly')" for="sys-role-menuCheckStrictly">Menu Check Strictly</label>
                        <input type="number" class="form-control" name="menuCheckStrictly" id="sys-role-menuCheckStrictly"
                            :class="{'valid': !$v.sysRole.menuCheckStrictly.$invalid, 'invalid': $v.sysRole.menuCheckStrictly.$invalid }" v-model.number="$v.sysRole.menuCheckStrictly.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysRole.deptCheckStrictly')" for="sys-role-deptCheckStrictly">Dept Check Strictly</label>
                        <input type="number" class="form-control" name="deptCheckStrictly" id="sys-role-deptCheckStrictly"
                            :class="{'valid': !$v.sysRole.deptCheckStrictly.$invalid, 'invalid': $v.sysRole.deptCheckStrictly.$invalid }" v-model.number="$v.sysRole.deptCheckStrictly.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysRole.status')" for="sys-role-status">Status</label>
                        <input type="text" class="form-control" name="status" id="sys-role-status"
                            :class="{'valid': !$v.sysRole.status.$invalid, 'invalid': $v.sysRole.status.$invalid }" v-model="$v.sysRole.status.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysRole.delFlag')" for="sys-role-delFlag">Del Flag</label>
                        <input type="text" class="form-control" name="delFlag" id="sys-role-delFlag"
                            :class="{'valid': !$v.sysRole.delFlag.$invalid, 'invalid': $v.sysRole.delFlag.$invalid }" v-model="$v.sysRole.delFlag.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysRole.createBy')" for="sys-role-createBy">Create By</label>
                        <input type="text" class="form-control" name="createBy" id="sys-role-createBy"
                            :class="{'valid': !$v.sysRole.createBy.$invalid, 'invalid': $v.sysRole.createBy.$invalid }" v-model="$v.sysRole.createBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysRole.createTime')" for="sys-role-createTime">Create Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-role-createTime"
                                    v-model="$v.sysRole.createTime.$model"
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
                            <b-form-input id="sys-role-createTime" type="text" class="form-control" name="createTime"  :class="{'valid': !$v.sysRole.createTime.$invalid, 'invalid': $v.sysRole.createTime.$invalid }"
                            v-model="$v.sysRole.createTime.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysRole.updateBy')" for="sys-role-updateBy">Update By</label>
                        <input type="text" class="form-control" name="updateBy" id="sys-role-updateBy"
                            :class="{'valid': !$v.sysRole.updateBy.$invalid, 'invalid': $v.sysRole.updateBy.$invalid }" v-model="$v.sysRole.updateBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysRole.upLocalDate')" for="sys-role-upLocalDate">Up Local Date</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-role-upLocalDate"
                                    v-model="$v.sysRole.upLocalDate.$model"
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
                            <b-form-input id="sys-role-upLocalDate" type="text" class="form-control" name="upLocalDate"  :class="{'valid': !$v.sysRole.upLocalDate.$invalid, 'invalid': $v.sysRole.upLocalDate.$invalid }"
                            v-model="$v.sysRole.upLocalDate.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysRole.remark')" for="sys-role-remark">Remark</label>
                        <textarea class="form-control" name="remark" id="sys-role-remark"
                            :class="{'valid': !$v.sysRole.remark.$invalid, 'invalid': $v.sysRole.remark.$invalid }" v-model="$v.sysRole.remark.$model" ></textarea>
                    </div>
                    <div class="form-group">
                        <label v-text="$t('yueXinJhipsterApp.sysRole.sysMenu')" for="sys-role-sysMenu">Sys Menu</label>
                        <select class="form-control" id="sys-role-sysMenu" multiple name="sysMenu" v-model="sysRole.sysMenus">
                            <option v-bind:value="getSelected(sysRole.sysMenus, sysMenuOption)" v-for="sysMenuOption in sysMenus" :key="sysMenuOption.id">{{sysMenuOption.id}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label v-text="$t('yueXinJhipsterApp.sysRole.sysUser')" for="sys-role-sysUser">Sys User</label>
                        <select class="form-control" id="sys-role-sysUser" multiple name="sysUser" v-model="sysRole.sysUsers">
                            <option v-bind:value="getSelected(sysRole.sysUsers, sysUserOption)" v-for="sysUserOption in sysUsers" :key="sysUserOption.id">{{sysUserOption.id}}</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.sysRole.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./sys-role-update.component.ts">
</script>
