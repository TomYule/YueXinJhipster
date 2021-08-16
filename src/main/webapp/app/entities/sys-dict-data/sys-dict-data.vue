<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.sysDictData.home.title')" id="sys-dict-data-heading">Sys Dict Data</span>
            <router-link :to="{name: 'SysDictDataCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-sys-dict-data">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.sysDictData.home.createLabel')">
                    Create a new Sys Dict Data
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
        <div class="alert alert-warning" v-if="!isFetching && sysDictData && sysDictData.length === 0">
            <span v-text="$t('yueXinJhipsterApp.sysDictData.home.notFound')">No sysDictData found</span>
        </div>
        <div class="table-responsive" v-if="sysDictData && sysDictData.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('dictSort')"><span v-text="$t('yueXinJhipsterApp.sysDictData.dictSort')">Dict Sort</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dictSort'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('dictLabel')"><span v-text="$t('yueXinJhipsterApp.sysDictData.dictLabel')">Dict Label</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dictLabel'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('dictValue')"><span v-text="$t('yueXinJhipsterApp.sysDictData.dictValue')">Dict Value</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dictValue'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('dictType')"><span v-text="$t('yueXinJhipsterApp.sysDictData.dictType')">Dict Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dictType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('cssClass')"><span v-text="$t('yueXinJhipsterApp.sysDictData.cssClass')">Css Class</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cssClass'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('listClass')"><span v-text="$t('yueXinJhipsterApp.sysDictData.listClass')">List Class</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'listClass'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('isDefault')"><span v-text="$t('yueXinJhipsterApp.sysDictData.isDefault')">Is Default</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isDefault'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('status')"><span v-text="$t('yueXinJhipsterApp.sysDictData.status')">Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'status'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createBy')"><span v-text="$t('yueXinJhipsterApp.sysDictData.createBy')">Create By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createTime')"><span v-text="$t('yueXinJhipsterApp.sysDictData.createTime')">Create Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('updateBy')"><span v-text="$t('yueXinJhipsterApp.sysDictData.updateBy')">Update By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('upLocalDate')"><span v-text="$t('yueXinJhipsterApp.sysDictData.upLocalDate')">Up Local Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upLocalDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('remark')"><span v-text="$t('yueXinJhipsterApp.sysDictData.remark')">Remark</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('sysDictType.id')"><span v-text="$t('yueXinJhipsterApp.sysDictData.sysDictType')">Sys Dict Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sysDictType.id'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="sysDictData in sysDictData"
                    :key="sysDictData.id">
                    <td>
                        <router-link :to="{name: 'SysDictDataView', params: {sysDictDataId: sysDictData.id}}">{{sysDictData.id}}</router-link>
                    </td>
                    <td>{{sysDictData.dictSort}}</td>
                    <td>{{sysDictData.dictLabel}}</td>
                    <td>{{sysDictData.dictValue}}</td>
                    <td>{{sysDictData.dictType}}</td>
                    <td>{{sysDictData.cssClass}}</td>
                    <td>{{sysDictData.listClass}}</td>
                    <td>{{sysDictData.isDefault}}</td>
                    <td>{{sysDictData.status}}</td>
                    <td>{{sysDictData.createBy}}</td>
                    <td>{{sysDictData.createTime}}</td>
                    <td>{{sysDictData.updateBy}}</td>
                    <td>{{sysDictData.upLocalDate}}</td>
                    <td>{{sysDictData.remark}}</td>
                    <td>
                        <div v-if="sysDictData.sysDictType">
                            <router-link :to="{name: 'SysDictTypeView', params: {sysDictTypeId: sysDictData.sysDictType.id}}">{{sysDictData.sysDictType.id}}</router-link>
                        </div>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'SysDictDataView', params: {sysDictDataId: sysDictData.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'SysDictDataEdit', params: {sysDictDataId: sysDictData.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(sysDictData)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.sysDictData.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-sysDictData-heading" v-text="$t('yueXinJhipsterApp.sysDictData.delete.question', {'id': removeId})">Are you sure you want to delete this Sys Dict Data?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-sysDictData" v-text="$t('entity.action.delete')" v-on:click="removeSysDictData()">Delete</button>
            </div>
        </b-modal>
        <div v-show="sysDictData && sysDictData.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-dict-data.component.ts">
</script>
