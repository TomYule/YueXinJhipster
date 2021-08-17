<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.sysConfig.home.title')" id="sys-config-heading">Sys Configs</span>
            <router-link :to="{name: 'SysConfigCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-sys-config">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.sysConfig.home.createLabel')">
                    Create a new Sys Config
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
        <div class="alert alert-warning" v-if="!isFetching && sysConfigs && sysConfigs.length === 0">
            <span v-text="$t('yueXinJhipsterApp.sysConfig.home.notFound')">No sysConfigs found</span>
        </div>
        <div class="table-responsive" v-if="sysConfigs && sysConfigs.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('configName')"><span v-text="$t('yueXinJhipsterApp.sysConfig.configName')">Config Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'configName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('configKey')"><span v-text="$t('yueXinJhipsterApp.sysConfig.configKey')">Config Key</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'configKey'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('configValue')"><span v-text="$t('yueXinJhipsterApp.sysConfig.configValue')">Config Value</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'configValue'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('configType')"><span v-text="$t('yueXinJhipsterApp.sysConfig.configType')">Config Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'configType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createBy')"><span v-text="$t('yueXinJhipsterApp.sysConfig.createBy')">Create By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createTime')"><span v-text="$t('yueXinJhipsterApp.sysConfig.createTime')">Create Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('updateBy')"><span v-text="$t('yueXinJhipsterApp.sysConfig.updateBy')">Update By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('upLocalDate')"><span v-text="$t('yueXinJhipsterApp.sysConfig.upLocalDate')">Up Local Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upLocalDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('remark')"><span v-text="$t('yueXinJhipsterApp.sysConfig.remark')">Remark</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="sysConfig in sysConfigs"
                    :key="sysConfig.id">
                    <td>
                        <router-link :to="{name: 'SysConfigView', params: {sysConfigId: sysConfig.id}}">{{sysConfig.id}}</router-link>
                    </td>
                    <td>{{sysConfig.configName}}</td>
                    <td>{{sysConfig.configKey}}</td>
                    <td>{{sysConfig.configValue}}</td>
                    <td>{{sysConfig.configType}}</td>
                    <td>{{sysConfig.createBy}}</td>
                    <td>{{sysConfig.createTime}}</td>
                    <td>{{sysConfig.updateBy}}</td>
                    <td>{{sysConfig.upLocalDate}}</td>
                    <td>{{sysConfig.remark}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'SysConfigView', params: {sysConfigId: sysConfig.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'SysConfigEdit', params: {sysConfigId: sysConfig.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(sysConfig)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.sysConfig.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-sysConfig-heading" v-text="$t('yueXinJhipsterApp.sysConfig.delete.question', {'id': removeId})">Are you sure you want to delete this Sys Config?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-sysConfig" v-text="$t('entity.action.delete')" v-on:click="removeSysConfig()">Delete</button>
            </div>
        </b-modal>
        <div v-show="sysConfigs && sysConfigs.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-config.component.ts">
</script>
