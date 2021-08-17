<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.genTable.home.title')" id="gen-table-heading">Gen Tables</span>
            <router-link :to="{name: 'GenTableCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-gen-table">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.genTable.home.createLabel')">
                    Create a new Gen Table
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
        <div class="alert alert-warning" v-if="!isFetching && genTables && genTables.length === 0">
            <span v-text="$t('yueXinJhipsterApp.genTable.home.notFound')">No genTables found</span>
        </div>
        <div class="table-responsive" v-if="genTables && genTables.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('tableName')"><span v-text="$t('yueXinJhipsterApp.genTable.tableName')">Table Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tableName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('tableComment')"><span v-text="$t('yueXinJhipsterApp.genTable.tableComment')">Table Comment</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tableComment'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('subTableName')"><span v-text="$t('yueXinJhipsterApp.genTable.subTableName')">Sub Table Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'subTableName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('subTableFkName')"><span v-text="$t('yueXinJhipsterApp.genTable.subTableFkName')">Sub Table Fk Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'subTableFkName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('className')"><span v-text="$t('yueXinJhipsterApp.genTable.className')">Class Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'className'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('tplCategory')"><span v-text="$t('yueXinJhipsterApp.genTable.tplCategory')">Tpl Category</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tplCategory'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('packAgeName')"><span v-text="$t('yueXinJhipsterApp.genTable.packAgeName')">Pack Age Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'packAgeName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('moduleName')"><span v-text="$t('yueXinJhipsterApp.genTable.moduleName')">Module Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'moduleName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('businessName')"><span v-text="$t('yueXinJhipsterApp.genTable.businessName')">Business Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'businessName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('functionName')"><span v-text="$t('yueXinJhipsterApp.genTable.functionName')">Function Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'functionName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('functionAuthor')"><span v-text="$t('yueXinJhipsterApp.genTable.functionAuthor')">Function Author</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'functionAuthor'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('genType')"><span v-text="$t('yueXinJhipsterApp.genTable.genType')">Gen Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'genType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('genPath')"><span v-text="$t('yueXinJhipsterApp.genTable.genPath')">Gen Path</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'genPath'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('options')"><span v-text="$t('yueXinJhipsterApp.genTable.options')">Options</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'options'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createBy')"><span v-text="$t('yueXinJhipsterApp.genTable.createBy')">Create By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createTime')"><span v-text="$t('yueXinJhipsterApp.genTable.createTime')">Create Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('updateBy')"><span v-text="$t('yueXinJhipsterApp.genTable.updateBy')">Update By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('upLocalDate')"><span v-text="$t('yueXinJhipsterApp.genTable.upLocalDate')">Up Local Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upLocalDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('remark')"><span v-text="$t('yueXinJhipsterApp.genTable.remark')">Remark</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="genTable in genTables"
                    :key="genTable.id">
                    <td>
                        <router-link :to="{name: 'GenTableView', params: {genTableId: genTable.id}}">{{genTable.id}}</router-link>
                    </td>
                    <td>{{genTable.tableName}}</td>
                    <td>{{genTable.tableComment}}</td>
                    <td>{{genTable.subTableName}}</td>
                    <td>{{genTable.subTableFkName}}</td>
                    <td>{{genTable.className}}</td>
                    <td>{{genTable.tplCategory}}</td>
                    <td>{{genTable.packAgeName}}</td>
                    <td>{{genTable.moduleName}}</td>
                    <td>{{genTable.businessName}}</td>
                    <td>{{genTable.functionName}}</td>
                    <td>{{genTable.functionAuthor}}</td>
                    <td>{{genTable.genType}}</td>
                    <td>{{genTable.genPath}}</td>
                    <td>{{genTable.options}}</td>
                    <td>{{genTable.createBy}}</td>
                    <td>{{genTable.createTime}}</td>
                    <td>{{genTable.updateBy}}</td>
                    <td>{{genTable.upLocalDate}}</td>
                    <td>{{genTable.remark}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'GenTableView', params: {genTableId: genTable.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'GenTableEdit', params: {genTableId: genTable.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(genTable)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.genTable.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-genTable-heading" v-text="$t('yueXinJhipsterApp.genTable.delete.question', {'id': removeId})">Are you sure you want to delete this Gen Table?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-genTable" v-text="$t('entity.action.delete')" v-on:click="removeGenTable()">Delete</button>
            </div>
        </b-modal>
        <div v-show="genTables && genTables.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./gen-table.component.ts">
</script>
