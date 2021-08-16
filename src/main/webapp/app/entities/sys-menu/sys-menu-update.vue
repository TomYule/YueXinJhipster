<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.sysMenu.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.sysMenu.home.createOrEditLabel')">Create or edit a SysMenu</h2>
                <div>
                    <div class="form-group" v-if="sysMenu.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="sysMenu.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.menuName')" for="sys-menu-menuName">Menu Name</label>
                        <input type="text" class="form-control" name="menuName" id="sys-menu-menuName"
                            :class="{'valid': !$v.sysMenu.menuName.$invalid, 'invalid': $v.sysMenu.menuName.$invalid }" v-model="$v.sysMenu.menuName.$model"  required/>
                        <div v-if="$v.sysMenu.menuName.$anyDirty && $v.sysMenu.menuName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.sysMenu.menuName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.parentId')" for="sys-menu-parentId">Parent Id</label>
                        <input type="number" class="form-control" name="parentId" id="sys-menu-parentId"
                            :class="{'valid': !$v.sysMenu.parentId.$invalid, 'invalid': $v.sysMenu.parentId.$invalid }" v-model.number="$v.sysMenu.parentId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.orderNum')" for="sys-menu-orderNum">Order Num</label>
                        <input type="number" class="form-control" name="orderNum" id="sys-menu-orderNum"
                            :class="{'valid': !$v.sysMenu.orderNum.$invalid, 'invalid': $v.sysMenu.orderNum.$invalid }" v-model.number="$v.sysMenu.orderNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.path')" for="sys-menu-path">Path</label>
                        <input type="text" class="form-control" name="path" id="sys-menu-path"
                            :class="{'valid': !$v.sysMenu.path.$invalid, 'invalid': $v.sysMenu.path.$invalid }" v-model="$v.sysMenu.path.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.components')" for="sys-menu-components">Components</label>
                        <input type="text" class="form-control" name="components" id="sys-menu-components"
                            :class="{'valid': !$v.sysMenu.components.$invalid, 'invalid': $v.sysMenu.components.$invalid }" v-model="$v.sysMenu.components.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.isFrame')" for="sys-menu-isFrame">Is Frame</label>
                        <input type="text" class="form-control" name="isFrame" id="sys-menu-isFrame"
                            :class="{'valid': !$v.sysMenu.isFrame.$invalid, 'invalid': $v.sysMenu.isFrame.$invalid }" v-model="$v.sysMenu.isFrame.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.isCache')" for="sys-menu-isCache">Is Cache</label>
                        <input type="text" class="form-control" name="isCache" id="sys-menu-isCache"
                            :class="{'valid': !$v.sysMenu.isCache.$invalid, 'invalid': $v.sysMenu.isCache.$invalid }" v-model="$v.sysMenu.isCache.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.menuType')" for="sys-menu-menuType">Menu Type</label>
                        <input type="text" class="form-control" name="menuType" id="sys-menu-menuType"
                            :class="{'valid': !$v.sysMenu.menuType.$invalid, 'invalid': $v.sysMenu.menuType.$invalid }" v-model="$v.sysMenu.menuType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.visible')" for="sys-menu-visible">Visible</label>
                        <input type="text" class="form-control" name="visible" id="sys-menu-visible"
                            :class="{'valid': !$v.sysMenu.visible.$invalid, 'invalid': $v.sysMenu.visible.$invalid }" v-model="$v.sysMenu.visible.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.status')" for="sys-menu-status">Status</label>
                        <input type="text" class="form-control" name="status" id="sys-menu-status"
                            :class="{'valid': !$v.sysMenu.status.$invalid, 'invalid': $v.sysMenu.status.$invalid }" v-model="$v.sysMenu.status.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.perms')" for="sys-menu-perms">Perms</label>
                        <input type="text" class="form-control" name="perms" id="sys-menu-perms"
                            :class="{'valid': !$v.sysMenu.perms.$invalid, 'invalid': $v.sysMenu.perms.$invalid }" v-model="$v.sysMenu.perms.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.icon')" for="sys-menu-icon">Icon</label>
                        <input type="text" class="form-control" name="icon" id="sys-menu-icon"
                            :class="{'valid': !$v.sysMenu.icon.$invalid, 'invalid': $v.sysMenu.icon.$invalid }" v-model="$v.sysMenu.icon.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.createBy')" for="sys-menu-createBy">Create By</label>
                        <input type="text" class="form-control" name="createBy" id="sys-menu-createBy"
                            :class="{'valid': !$v.sysMenu.createBy.$invalid, 'invalid': $v.sysMenu.createBy.$invalid }" v-model="$v.sysMenu.createBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.createTime')" for="sys-menu-createTime">Create Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-menu-createTime"
                                    v-model="$v.sysMenu.createTime.$model"
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
                            <b-form-input id="sys-menu-createTime" type="text" class="form-control" name="createTime"  :class="{'valid': !$v.sysMenu.createTime.$invalid, 'invalid': $v.sysMenu.createTime.$invalid }"
                            v-model="$v.sysMenu.createTime.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.updateBy')" for="sys-menu-updateBy">Update By</label>
                        <input type="text" class="form-control" name="updateBy" id="sys-menu-updateBy"
                            :class="{'valid': !$v.sysMenu.updateBy.$invalid, 'invalid': $v.sysMenu.updateBy.$invalid }" v-model="$v.sysMenu.updateBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.upLocalDate')" for="sys-menu-upLocalDate">Up Local Date</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-menu-upLocalDate"
                                    v-model="$v.sysMenu.upLocalDate.$model"
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
                            <b-form-input id="sys-menu-upLocalDate" type="text" class="form-control" name="upLocalDate"  :class="{'valid': !$v.sysMenu.upLocalDate.$invalid, 'invalid': $v.sysMenu.upLocalDate.$invalid }"
                            v-model="$v.sysMenu.upLocalDate.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysMenu.remark')" for="sys-menu-remark">Remark</label>
                        <textarea class="form-control" name="remark" id="sys-menu-remark"
                            :class="{'valid': !$v.sysMenu.remark.$invalid, 'invalid': $v.sysMenu.remark.$invalid }" v-model="$v.sysMenu.remark.$model" ></textarea>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.sysMenu.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./sys-menu-update.component.ts">
</script>
