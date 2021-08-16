<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.genTable.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.genTable.home.createOrEditLabel')">Create or edit a GenTable</h2>
                <div>
                    <div class="form-group" v-if="genTable.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="genTable.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.tableName')" for="gen-table-tableName">Table Name</label>
                        <input type="text" class="form-control" name="tableName" id="gen-table-tableName"
                            :class="{'valid': !$v.genTable.tableName.$invalid, 'invalid': $v.genTable.tableName.$invalid }" v-model="$v.genTable.tableName.$model"  required/>
                        <div v-if="$v.genTable.tableName.$anyDirty && $v.genTable.tableName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.genTable.tableName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.tableComment')" for="gen-table-tableComment">Table Comment</label>
                        <input type="text" class="form-control" name="tableComment" id="gen-table-tableComment"
                            :class="{'valid': !$v.genTable.tableComment.$invalid, 'invalid': $v.genTable.tableComment.$invalid }" v-model="$v.genTable.tableComment.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.subTableName')" for="gen-table-subTableName">Sub Table Name</label>
                        <input type="text" class="form-control" name="subTableName" id="gen-table-subTableName"
                            :class="{'valid': !$v.genTable.subTableName.$invalid, 'invalid': $v.genTable.subTableName.$invalid }" v-model="$v.genTable.subTableName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.subTableFkName')" for="gen-table-subTableFkName">Sub Table Fk Name</label>
                        <input type="text" class="form-control" name="subTableFkName" id="gen-table-subTableFkName"
                            :class="{'valid': !$v.genTable.subTableFkName.$invalid, 'invalid': $v.genTable.subTableFkName.$invalid }" v-model="$v.genTable.subTableFkName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.className')" for="gen-table-className">Class Name</label>
                        <input type="text" class="form-control" name="className" id="gen-table-className"
                            :class="{'valid': !$v.genTable.className.$invalid, 'invalid': $v.genTable.className.$invalid }" v-model="$v.genTable.className.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.tplCategory')" for="gen-table-tplCategory">Tpl Category</label>
                        <input type="text" class="form-control" name="tplCategory" id="gen-table-tplCategory"
                            :class="{'valid': !$v.genTable.tplCategory.$invalid, 'invalid': $v.genTable.tplCategory.$invalid }" v-model="$v.genTable.tplCategory.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.packAgeName')" for="gen-table-packAgeName">Pack Age Name</label>
                        <input type="text" class="form-control" name="packAgeName" id="gen-table-packAgeName"
                            :class="{'valid': !$v.genTable.packAgeName.$invalid, 'invalid': $v.genTable.packAgeName.$invalid }" v-model="$v.genTable.packAgeName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.moduleName')" for="gen-table-moduleName">Module Name</label>
                        <input type="text" class="form-control" name="moduleName" id="gen-table-moduleName"
                            :class="{'valid': !$v.genTable.moduleName.$invalid, 'invalid': $v.genTable.moduleName.$invalid }" v-model="$v.genTable.moduleName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.businessName')" for="gen-table-businessName">Business Name</label>
                        <input type="text" class="form-control" name="businessName" id="gen-table-businessName"
                            :class="{'valid': !$v.genTable.businessName.$invalid, 'invalid': $v.genTable.businessName.$invalid }" v-model="$v.genTable.businessName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.functionName')" for="gen-table-functionName">Function Name</label>
                        <input type="text" class="form-control" name="functionName" id="gen-table-functionName"
                            :class="{'valid': !$v.genTable.functionName.$invalid, 'invalid': $v.genTable.functionName.$invalid }" v-model="$v.genTable.functionName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.functionAuthor')" for="gen-table-functionAuthor">Function Author</label>
                        <input type="text" class="form-control" name="functionAuthor" id="gen-table-functionAuthor"
                            :class="{'valid': !$v.genTable.functionAuthor.$invalid, 'invalid': $v.genTable.functionAuthor.$invalid }" v-model="$v.genTable.functionAuthor.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.genType')" for="gen-table-genType">Gen Type</label>
                        <input type="text" class="form-control" name="genType" id="gen-table-genType"
                            :class="{'valid': !$v.genTable.genType.$invalid, 'invalid': $v.genTable.genType.$invalid }" v-model="$v.genTable.genType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.genPath')" for="gen-table-genPath">Gen Path</label>
                        <input type="text" class="form-control" name="genPath" id="gen-table-genPath"
                            :class="{'valid': !$v.genTable.genPath.$invalid, 'invalid': $v.genTable.genPath.$invalid }" v-model="$v.genTable.genPath.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.options')" for="gen-table-options">Options</label>
                        <input type="text" class="form-control" name="options" id="gen-table-options"
                            :class="{'valid': !$v.genTable.options.$invalid, 'invalid': $v.genTable.options.$invalid }" v-model="$v.genTable.options.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.createBy')" for="gen-table-createBy">Create By</label>
                        <input type="text" class="form-control" name="createBy" id="gen-table-createBy"
                            :class="{'valid': !$v.genTable.createBy.$invalid, 'invalid': $v.genTable.createBy.$invalid }" v-model="$v.genTable.createBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.createTime')" for="gen-table-createTime">Create Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="gen-table-createTime"
                                    v-model="$v.genTable.createTime.$model"
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
                            <b-form-input id="gen-table-createTime" type="text" class="form-control" name="createTime"  :class="{'valid': !$v.genTable.createTime.$invalid, 'invalid': $v.genTable.createTime.$invalid }"
                            v-model="$v.genTable.createTime.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.updateBy')" for="gen-table-updateBy">Update By</label>
                        <input type="text" class="form-control" name="updateBy" id="gen-table-updateBy"
                            :class="{'valid': !$v.genTable.updateBy.$invalid, 'invalid': $v.genTable.updateBy.$invalid }" v-model="$v.genTable.updateBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.upLocalDate')" for="gen-table-upLocalDate">Up Local Date</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="gen-table-upLocalDate"
                                    v-model="$v.genTable.upLocalDate.$model"
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
                            <b-form-input id="gen-table-upLocalDate" type="text" class="form-control" name="upLocalDate"  :class="{'valid': !$v.genTable.upLocalDate.$invalid, 'invalid': $v.genTable.upLocalDate.$invalid }"
                            v-model="$v.genTable.upLocalDate.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTable.remark')" for="gen-table-remark">Remark</label>
                        <textarea class="form-control" name="remark" id="gen-table-remark"
                            :class="{'valid': !$v.genTable.remark.$invalid, 'invalid': $v.genTable.remark.$invalid }" v-model="$v.genTable.remark.$model" ></textarea>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.genTable.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./gen-table-update.component.ts">
</script>
