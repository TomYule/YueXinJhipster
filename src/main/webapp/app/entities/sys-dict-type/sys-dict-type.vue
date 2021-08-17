<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.sysDictType.home.title')" id="sys-dict-type-heading">Sys Dict Types</span>
            <router-link :to="{name: 'SysDictTypeCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-sys-dict-type">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.sysDictType.home.createLabel')">
                    Create a new Sys Dict Type
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
        <div class="alert alert-warning" v-if="!isFetching && sysDictTypes && sysDictTypes.length === 0">
            <span v-text="$t('yueXinJhipsterApp.sysDictType.home.notFound')">No sysDictTypes found</span>
        </div>
        <div class="table-responsive" v-if="sysDictTypes && sysDictTypes.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('dictName')"><span v-text="$t('yueXinJhipsterApp.sysDictType.dictName')">Dict Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dictName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('dictType')"><span v-text="$t('yueXinJhipsterApp.sysDictType.dictType')">Dict Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dictType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('status')"><span v-text="$t('yueXinJhipsterApp.sysDictType.status')">Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'status'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createBy')"><span v-text="$t('yueXinJhipsterApp.sysDictType.createBy')">Create By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createTime')"><span v-text="$t('yueXinJhipsterApp.sysDictType.createTime')">Create Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('updateBy')"><span v-text="$t('yueXinJhipsterApp.sysDictType.updateBy')">Update By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('upLocalDate')"><span v-text="$t('yueXinJhipsterApp.sysDictType.upLocalDate')">Up Local Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upLocalDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('remark')"><span v-text="$t('yueXinJhipsterApp.sysDictType.remark')">Remark</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="sysDictType in sysDictTypes"
                    :key="sysDictType.id">
                    <td>
                        <router-link :to="{name: 'SysDictTypeView', params: {sysDictTypeId: sysDictType.id}}">{{sysDictType.id}}</router-link>
                    </td>
                    <td>{{sysDictType.dictName}}</td>
                    <td>{{sysDictType.dictType}}</td>
                    <td>{{sysDictType.status}}</td>
                    <td>{{sysDictType.createBy}}</td>
                    <td>{{sysDictType.createTime}}</td>
                    <td>{{sysDictType.updateBy}}</td>
                    <td>{{sysDictType.upLocalDate}}</td>
                    <td>{{sysDictType.remark}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'SysDictTypeView', params: {sysDictTypeId: sysDictType.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'SysDictTypeEdit', params: {sysDictTypeId: sysDictType.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(sysDictType)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.sysDictType.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-sysDictType-heading" v-text="$t('yueXinJhipsterApp.sysDictType.delete.question', {'id': removeId})">Are you sure you want to delete this Sys Dict Type?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-sysDictType" v-text="$t('entity.action.delete')" v-on:click="removeSysDictType()">Delete</button>
            </div>
        </b-modal>
        <div v-show="sysDictTypes && sysDictTypes.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-dict-type.component.ts">
</script>
