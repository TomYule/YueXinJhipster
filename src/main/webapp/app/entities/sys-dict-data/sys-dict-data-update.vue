<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.sysDictData.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.sysDictData.home.createOrEditLabel')">Create or edit a SysDictData</h2>
                <div>
                    <div class="form-group" v-if="sysDictData.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="sysDictData.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.dictSort')" for="sys-dict-data-dictSort">Dict Sort</label>
                        <input type="text" class="form-control" name="dictSort" id="sys-dict-data-dictSort"
                            :class="{'valid': !$v.sysDictData.dictSort.$invalid, 'invalid': $v.sysDictData.dictSort.$invalid }" v-model="$v.sysDictData.dictSort.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.dictLabel')" for="sys-dict-data-dictLabel">Dict Label</label>
                        <input type="text" class="form-control" name="dictLabel" id="sys-dict-data-dictLabel"
                            :class="{'valid': !$v.sysDictData.dictLabel.$invalid, 'invalid': $v.sysDictData.dictLabel.$invalid }" v-model="$v.sysDictData.dictLabel.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.dictValue')" for="sys-dict-data-dictValue">Dict Value</label>
                        <input type="text" class="form-control" name="dictValue" id="sys-dict-data-dictValue"
                            :class="{'valid': !$v.sysDictData.dictValue.$invalid, 'invalid': $v.sysDictData.dictValue.$invalid }" v-model="$v.sysDictData.dictValue.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.dictType')" for="sys-dict-data-dictType">Dict Type</label>
                        <input type="text" class="form-control" name="dictType" id="sys-dict-data-dictType"
                            :class="{'valid': !$v.sysDictData.dictType.$invalid, 'invalid': $v.sysDictData.dictType.$invalid }" v-model="$v.sysDictData.dictType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.cssClass')" for="sys-dict-data-cssClass">Css Class</label>
                        <input type="text" class="form-control" name="cssClass" id="sys-dict-data-cssClass"
                            :class="{'valid': !$v.sysDictData.cssClass.$invalid, 'invalid': $v.sysDictData.cssClass.$invalid }" v-model="$v.sysDictData.cssClass.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.listClass')" for="sys-dict-data-listClass">List Class</label>
                        <input type="text" class="form-control" name="listClass" id="sys-dict-data-listClass"
                            :class="{'valid': !$v.sysDictData.listClass.$invalid, 'invalid': $v.sysDictData.listClass.$invalid }" v-model="$v.sysDictData.listClass.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.isDefault')" for="sys-dict-data-isDefault">Is Default</label>
                        <input type="text" class="form-control" name="isDefault" id="sys-dict-data-isDefault"
                            :class="{'valid': !$v.sysDictData.isDefault.$invalid, 'invalid': $v.sysDictData.isDefault.$invalid }" v-model="$v.sysDictData.isDefault.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.status')" for="sys-dict-data-status">Status</label>
                        <input type="text" class="form-control" name="status" id="sys-dict-data-status"
                            :class="{'valid': !$v.sysDictData.status.$invalid, 'invalid': $v.sysDictData.status.$invalid }" v-model="$v.sysDictData.status.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.createBy')" for="sys-dict-data-createBy">Create By</label>
                        <input type="text" class="form-control" name="createBy" id="sys-dict-data-createBy"
                            :class="{'valid': !$v.sysDictData.createBy.$invalid, 'invalid': $v.sysDictData.createBy.$invalid }" v-model="$v.sysDictData.createBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.createTime')" for="sys-dict-data-createTime">Create Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-dict-data-createTime"
                                    v-model="$v.sysDictData.createTime.$model"
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
                            <b-form-input id="sys-dict-data-createTime" type="text" class="form-control" name="createTime"  :class="{'valid': !$v.sysDictData.createTime.$invalid, 'invalid': $v.sysDictData.createTime.$invalid }"
                            v-model="$v.sysDictData.createTime.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.updateBy')" for="sys-dict-data-updateBy">Update By</label>
                        <input type="text" class="form-control" name="updateBy" id="sys-dict-data-updateBy"
                            :class="{'valid': !$v.sysDictData.updateBy.$invalid, 'invalid': $v.sysDictData.updateBy.$invalid }" v-model="$v.sysDictData.updateBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.upLocalDate')" for="sys-dict-data-upLocalDate">Up Local Date</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-dict-data-upLocalDate"
                                    v-model="$v.sysDictData.upLocalDate.$model"
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
                            <b-form-input id="sys-dict-data-upLocalDate" type="text" class="form-control" name="upLocalDate"  :class="{'valid': !$v.sysDictData.upLocalDate.$invalid, 'invalid': $v.sysDictData.upLocalDate.$invalid }"
                            v-model="$v.sysDictData.upLocalDate.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.remark')" for="sys-dict-data-remark">Remark</label>
                        <textarea class="form-control" name="remark" id="sys-dict-data-remark"
                            :class="{'valid': !$v.sysDictData.remark.$invalid, 'invalid': $v.sysDictData.remark.$invalid }" v-model="$v.sysDictData.remark.$model" ></textarea>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysDictData.sysDictType')" for="sys-dict-data-sysDictType">Sys Dict Type</label>
                        <select class="form-control" id="sys-dict-data-sysDictType" name="sysDictType" v-model="sysDictData.sysDictType">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="sysDictData.sysDictType && sysDictTypeOption.id === sysDictData.sysDictType.id ? sysDictData.sysDictType : sysDictTypeOption" v-for="sysDictTypeOption in sysDictTypes" :key="sysDictTypeOption.id">{{sysDictTypeOption.id}}</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.sysDictData.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./sys-dict-data-update.component.ts">
</script>
