<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.genTableColumn.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.genTableColumn.home.createOrEditLabel')">Create or edit a GenTableColumn</h2>
                <div>
                    <div class="form-group" v-if="genTableColumn.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="genTableColumn.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.tableId')" for="gen-table-column-tableId">Table Id</label>
                        <input type="text" class="form-control" name="tableId" id="gen-table-column-tableId"
                            :class="{'valid': !$v.genTableColumn.tableId.$invalid, 'invalid': $v.genTableColumn.tableId.$invalid }" v-model="$v.genTableColumn.tableId.$model"  required/>
                        <div v-if="$v.genTableColumn.tableId.$anyDirty && $v.genTableColumn.tableId.$invalid">
                            <small class="form-text text-danger" v-if="!$v.genTableColumn.tableId.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.columnName')" for="gen-table-column-columnName">Column Name</label>
                        <input type="text" class="form-control" name="columnName" id="gen-table-column-columnName"
                            :class="{'valid': !$v.genTableColumn.columnName.$invalid, 'invalid': $v.genTableColumn.columnName.$invalid }" v-model="$v.genTableColumn.columnName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.columnComment')" for="gen-table-column-columnComment">Column Comment</label>
                        <input type="text" class="form-control" name="columnComment" id="gen-table-column-columnComment"
                            :class="{'valid': !$v.genTableColumn.columnComment.$invalid, 'invalid': $v.genTableColumn.columnComment.$invalid }" v-model="$v.genTableColumn.columnComment.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.columnType')" for="gen-table-column-columnType">Column Type</label>
                        <input type="text" class="form-control" name="columnType" id="gen-table-column-columnType"
                            :class="{'valid': !$v.genTableColumn.columnType.$invalid, 'invalid': $v.genTableColumn.columnType.$invalid }" v-model="$v.genTableColumn.columnType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.javaType')" for="gen-table-column-javaType">Java Type</label>
                        <input type="text" class="form-control" name="javaType" id="gen-table-column-javaType"
                            :class="{'valid': !$v.genTableColumn.javaType.$invalid, 'invalid': $v.genTableColumn.javaType.$invalid }" v-model="$v.genTableColumn.javaType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.javaField')" for="gen-table-column-javaField">Java Field</label>
                        <input type="text" class="form-control" name="javaField" id="gen-table-column-javaField"
                            :class="{'valid': !$v.genTableColumn.javaField.$invalid, 'invalid': $v.genTableColumn.javaField.$invalid }" v-model="$v.genTableColumn.javaField.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.isPk')" for="gen-table-column-isPk">Is Pk</label>
                        <input type="text" class="form-control" name="isPk" id="gen-table-column-isPk"
                            :class="{'valid': !$v.genTableColumn.isPk.$invalid, 'invalid': $v.genTableColumn.isPk.$invalid }" v-model="$v.genTableColumn.isPk.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.isIncrement')" for="gen-table-column-isIncrement">Is Increment</label>
                        <input type="text" class="form-control" name="isIncrement" id="gen-table-column-isIncrement"
                            :class="{'valid': !$v.genTableColumn.isIncrement.$invalid, 'invalid': $v.genTableColumn.isIncrement.$invalid }" v-model="$v.genTableColumn.isIncrement.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.isRequired')" for="gen-table-column-isRequired">Is Required</label>
                        <input type="text" class="form-control" name="isRequired" id="gen-table-column-isRequired"
                            :class="{'valid': !$v.genTableColumn.isRequired.$invalid, 'invalid': $v.genTableColumn.isRequired.$invalid }" v-model="$v.genTableColumn.isRequired.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.isInsert')" for="gen-table-column-isInsert">Is Insert</label>
                        <input type="text" class="form-control" name="isInsert" id="gen-table-column-isInsert"
                            :class="{'valid': !$v.genTableColumn.isInsert.$invalid, 'invalid': $v.genTableColumn.isInsert.$invalid }" v-model="$v.genTableColumn.isInsert.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.isEdit')" for="gen-table-column-isEdit">Is Edit</label>
                        <input type="text" class="form-control" name="isEdit" id="gen-table-column-isEdit"
                            :class="{'valid': !$v.genTableColumn.isEdit.$invalid, 'invalid': $v.genTableColumn.isEdit.$invalid }" v-model="$v.genTableColumn.isEdit.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.isList')" for="gen-table-column-isList">Is List</label>
                        <input type="text" class="form-control" name="isList" id="gen-table-column-isList"
                            :class="{'valid': !$v.genTableColumn.isList.$invalid, 'invalid': $v.genTableColumn.isList.$invalid }" v-model="$v.genTableColumn.isList.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.isQuery')" for="gen-table-column-isQuery">Is Query</label>
                        <input type="text" class="form-control" name="isQuery" id="gen-table-column-isQuery"
                            :class="{'valid': !$v.genTableColumn.isQuery.$invalid, 'invalid': $v.genTableColumn.isQuery.$invalid }" v-model="$v.genTableColumn.isQuery.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.htmlType')" for="gen-table-column-htmlType">Html Type</label>
                        <input type="text" class="form-control" name="htmlType" id="gen-table-column-htmlType"
                            :class="{'valid': !$v.genTableColumn.htmlType.$invalid, 'invalid': $v.genTableColumn.htmlType.$invalid }" v-model="$v.genTableColumn.htmlType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.dictType')" for="gen-table-column-dictType">Dict Type</label>
                        <input type="text" class="form-control" name="dictType" id="gen-table-column-dictType"
                            :class="{'valid': !$v.genTableColumn.dictType.$invalid, 'invalid': $v.genTableColumn.dictType.$invalid }" v-model="$v.genTableColumn.dictType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.sort')" for="gen-table-column-sort">Sort</label>
                        <input type="number" class="form-control" name="sort" id="gen-table-column-sort"
                            :class="{'valid': !$v.genTableColumn.sort.$invalid, 'invalid': $v.genTableColumn.sort.$invalid }" v-model.number="$v.genTableColumn.sort.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.createBy')" for="gen-table-column-createBy">Create By</label>
                        <input type="text" class="form-control" name="createBy" id="gen-table-column-createBy"
                            :class="{'valid': !$v.genTableColumn.createBy.$invalid, 'invalid': $v.genTableColumn.createBy.$invalid }" v-model="$v.genTableColumn.createBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.createTime')" for="gen-table-column-createTime">Create Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="gen-table-column-createTime"
                                    v-model="$v.genTableColumn.createTime.$model"
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
                            <b-form-input id="gen-table-column-createTime" type="text" class="form-control" name="createTime"  :class="{'valid': !$v.genTableColumn.createTime.$invalid, 'invalid': $v.genTableColumn.createTime.$invalid }"
                            v-model="$v.genTableColumn.createTime.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.updateBy')" for="gen-table-column-updateBy">Update By</label>
                        <input type="text" class="form-control" name="updateBy" id="gen-table-column-updateBy"
                            :class="{'valid': !$v.genTableColumn.updateBy.$invalid, 'invalid': $v.genTableColumn.updateBy.$invalid }" v-model="$v.genTableColumn.updateBy.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.upLocalDate')" for="gen-table-column-upLocalDate">Up Local Date</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="gen-table-column-upLocalDate"
                                    v-model="$v.genTableColumn.upLocalDate.$model"
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
                            <b-form-input id="gen-table-column-upLocalDate" type="text" class="form-control" name="upLocalDate"  :class="{'valid': !$v.genTableColumn.upLocalDate.$invalid, 'invalid': $v.genTableColumn.upLocalDate.$invalid }"
                            v-model="$v.genTableColumn.upLocalDate.$model"  />
                        </b-input-group>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.remark')" for="gen-table-column-remark">Remark</label>
                        <textarea class="form-control" name="remark" id="gen-table-column-remark"
                            :class="{'valid': !$v.genTableColumn.remark.$invalid, 'invalid': $v.genTableColumn.remark.$invalid }" v-model="$v.genTableColumn.remark.$model" ></textarea>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.genTableColumn.genTable')" for="gen-table-column-genTable">Gen Table</label>
                        <select class="form-control" id="gen-table-column-genTable" name="genTable" v-model="genTableColumn.genTable">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="genTableColumn.genTable && genTableOption.id === genTableColumn.genTable.id ? genTableColumn.genTable : genTableOption" v-for="genTableOption in genTables" :key="genTableOption.id">{{genTableOption.id}}</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.genTableColumn.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./gen-table-column-update.component.ts">
</script>
