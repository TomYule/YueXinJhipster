<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.genTableColumn.home.title')" id="gen-table-column-heading">Gen Table Columns</span>
            <router-link :to="{name: 'GenTableColumnCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-gen-table-column">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.genTableColumn.home.createLabel')">
                    Create a new Gen Table Column
                </span>
            </router-link>
        </h2>
        <b-alert :show="dismissCountDown"
            dismissible
            :variant="alertType"
            @dismissed="dismissCountDown=0"
            @dismiss-count-down="countDownChanged">
            {{alertMessage}}
        </b-alert>
        <br/>
        <div class="alert alert-warning" v-if="!isFetching && genTableColumns && genTableColumns.length === 0">
            <span v-text="$t('yueXinJhipsterApp.genTableColumn.home.notFound')">No genTableColumns found</span>
        </div>
        <div class="table-responsive" v-if="genTableColumns && genTableColumns.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('tableId')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.tableId')">Table Id</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tableId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('columnName')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.columnName')">Column Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'columnName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('columnComment')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.columnComment')">Column Comment</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'columnComment'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('columnType')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.columnType')">Column Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'columnType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('javaType')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.javaType')">Java Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'javaType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('javaField')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.javaField')">Java Field</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'javaField'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('isPk')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.isPk')">Is Pk</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isPk'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('isIncrement')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.isIncrement')">Is Increment</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isIncrement'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('isRequired')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.isRequired')">Is Required</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isRequired'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('isInsert')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.isInsert')">Is Insert</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isInsert'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('isEdit')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.isEdit')">Is Edit</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isEdit'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('isList')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.isList')">Is List</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isList'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('isQuery')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.isQuery')">Is Query</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isQuery'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('htmlType')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.htmlType')">Html Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'htmlType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('dictType')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.dictType')">Dict Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dictType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('sort')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.sort')">Sort</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sort'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createBy')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.createBy')">Create By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createTime')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.createTime')">Create Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('updateBy')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.updateBy')">Update By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('upLocalDate')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.upLocalDate')">Up Local Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upLocalDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('remark')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.remark')">Remark</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('genTable.id')"><span v-text="$t('yueXinJhipsterApp.genTableColumn.genTable')">Gen Table</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'genTable.id'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="genTableColumn in genTableColumns"
                    :key="genTableColumn.id">
                    <td>
                        <router-link :to="{name: 'GenTableColumnView', params: {genTableColumnId: genTableColumn.id}}">{{genTableColumn.id}}</router-link>
                    </td>
                    <td>{{genTableColumn.tableId}}</td>
                    <td>{{genTableColumn.columnName}}</td>
                    <td>{{genTableColumn.columnComment}}</td>
                    <td>{{genTableColumn.columnType}}</td>
                    <td>{{genTableColumn.javaType}}</td>
                    <td>{{genTableColumn.javaField}}</td>
                    <td>{{genTableColumn.isPk}}</td>
                    <td>{{genTableColumn.isIncrement}}</td>
                    <td>{{genTableColumn.isRequired}}</td>
                    <td>{{genTableColumn.isInsert}}</td>
                    <td>{{genTableColumn.isEdit}}</td>
                    <td>{{genTableColumn.isList}}</td>
                    <td>{{genTableColumn.isQuery}}</td>
                    <td>{{genTableColumn.htmlType}}</td>
                    <td>{{genTableColumn.dictType}}</td>
                    <td>{{genTableColumn.sort}}</td>
                    <td>{{genTableColumn.createBy}}</td>
                    <td>{{genTableColumn.createTime}}</td>
                    <td>{{genTableColumn.updateBy}}</td>
                    <td>{{genTableColumn.upLocalDate}}</td>
                    <td>{{genTableColumn.remark}}</td>
                    <td>
                        <div v-if="genTableColumn.genTable">
                            <router-link :to="{name: 'GenTableView', params: {genTableId: genTableColumn.genTable.id}}">{{genTableColumn.genTable.id}}</router-link>
                        </div>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'GenTableColumnView', params: {genTableColumnId: genTableColumn.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'GenTableColumnEdit', params: {genTableColumnId: genTableColumn.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(genTableColumn)"
                                   variant="danger"
                                   class="btn btn-sm"
                                   v-b-modal.removeEntity>
                                <font-awesome-icon icon="times"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                            </b-button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <b-modal ref="removeEntity" id="removeEntity" >
            <span slot="modal-title"><span id="yueXinJhipsterApp.genTableColumn.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-genTableColumn-heading" v-text="$t('yueXinJhipsterApp.genTableColumn.delete.question', {'id': removeId})">Are you sure you want to delete this Gen Table Column?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-genTableColumn" v-text="$t('entity.action.delete')" v-on:click="removeGenTableColumn()">Delete</button>
            </div>
        </b-modal>
        <div v-show="genTableColumns && genTableColumns.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./gen-table-column.component.ts">
</script>
