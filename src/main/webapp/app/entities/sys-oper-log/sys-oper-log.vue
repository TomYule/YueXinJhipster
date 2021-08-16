<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.sysOperLog.home.title')" id="sys-oper-log-heading">Sys Oper Logs</span>
            <router-link :to="{name: 'SysOperLogCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-sys-oper-log">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.sysOperLog.home.createLabel')">
                    Create a new Sys Oper Log
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
        <div class="alert alert-warning" v-if="!isFetching && sysOperLogs && sysOperLogs.length === 0">
            <span v-text="$t('yueXinJhipsterApp.sysOperLog.home.notFound')">No sysOperLogs found</span>
        </div>
        <div class="table-responsive" v-if="sysOperLogs && sysOperLogs.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('title')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.title')">Title</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'title'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('businessType')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.businessType')">Business Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'businessType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('method')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.method')">Method</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'method'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('requestMethod')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.requestMethod')">Request Method</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'requestMethod'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('operatorType')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.operatorType')">Operator Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'operatorType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('operName')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.operName')">Oper Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'operName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('deptName')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.deptName')">Dept Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'deptName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('operUrl')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.operUrl')">Oper Url</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'operUrl'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('operIp')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.operIp')">Oper Ip</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'operIp'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('operLocation')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.operLocation')">Oper Location</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'operLocation'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('operParam')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.operParam')">Oper Param</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'operParam'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('jsonResult')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.jsonResult')">Json Result</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'jsonResult'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('status')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.status')">Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'status'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('errorMsg')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.errorMsg')">Error Msg</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'errorMsg'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('operTime')"><span v-text="$t('yueXinJhipsterApp.sysOperLog.operTime')">Oper Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'operTime'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="sysOperLog in sysOperLogs"
                    :key="sysOperLog.id">
                    <td>
                        <router-link :to="{name: 'SysOperLogView', params: {sysOperLogId: sysOperLog.id}}">{{sysOperLog.id}}</router-link>
                    </td>
                    <td>{{sysOperLog.title}}</td>
                    <td>{{sysOperLog.businessType}}</td>
                    <td>{{sysOperLog.method}}</td>
                    <td>{{sysOperLog.requestMethod}}</td>
                    <td>{{sysOperLog.operatorType}}</td>
                    <td>{{sysOperLog.operName}}</td>
                    <td>{{sysOperLog.deptName}}</td>
                    <td>{{sysOperLog.operUrl}}</td>
                    <td>{{sysOperLog.operIp}}</td>
                    <td>{{sysOperLog.operLocation}}</td>
                    <td>{{sysOperLog.operParam}}</td>
                    <td>{{sysOperLog.jsonResult}}</td>
                    <td>{{sysOperLog.status}}</td>
                    <td>{{sysOperLog.errorMsg}}</td>
                    <td>{{sysOperLog.operTime}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'SysOperLogView', params: {sysOperLogId: sysOperLog.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'SysOperLogEdit', params: {sysOperLogId: sysOperLog.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(sysOperLog)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.sysOperLog.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-sysOperLog-heading" v-text="$t('yueXinJhipsterApp.sysOperLog.delete.question', {'id': removeId})">Are you sure you want to delete this Sys Oper Log?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-sysOperLog" v-text="$t('entity.action.delete')" v-on:click="removeSysOperLog()">Delete</button>
            </div>
        </b-modal>
        <div v-show="sysOperLogs && sysOperLogs.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-oper-log.component.ts">
</script>
