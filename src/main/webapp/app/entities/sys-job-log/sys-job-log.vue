<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.sysJobLog.home.title')" id="sys-job-log-heading">Sys Job Logs</span>
            <router-link :to="{name: 'SysJobLogCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-sys-job-log">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.sysJobLog.home.createLabel')">
                    Create a new Sys Job Log
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
        <div class="alert alert-warning" v-if="!isFetching && sysJobLogs && sysJobLogs.length === 0">
            <span v-text="$t('yueXinJhipsterApp.sysJobLog.home.notFound')">No sysJobLogs found</span>
        </div>
        <div class="table-responsive" v-if="sysJobLogs && sysJobLogs.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('jobName')"><span v-text="$t('yueXinJhipsterApp.sysJobLog.jobName')">Job Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'jobName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('jobGroup')"><span v-text="$t('yueXinJhipsterApp.sysJobLog.jobGroup')">Job Group</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'jobGroup'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('invokeTarget')"><span v-text="$t('yueXinJhipsterApp.sysJobLog.invokeTarget')">Invoke Target</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'invokeTarget'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('status')"><span v-text="$t('yueXinJhipsterApp.sysJobLog.status')">Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'status'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('exceptionInfo')"><span v-text="$t('yueXinJhipsterApp.sysJobLog.exceptionInfo')">Exception Info</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'exceptionInfo'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createTime')"><span v-text="$t('yueXinJhipsterApp.sysJobLog.createTime')">Create Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="sysJobLog in sysJobLogs"
                    :key="sysJobLog.id">
                    <td>
                        <router-link :to="{name: 'SysJobLogView', params: {sysJobLogId: sysJobLog.id}}">{{sysJobLog.id}}</router-link>
                    </td>
                    <td>{{sysJobLog.jobName}}</td>
                    <td>{{sysJobLog.jobGroup}}</td>
                    <td>{{sysJobLog.invokeTarget}}</td>
                    <td>{{sysJobLog.status}}</td>
                    <td>{{sysJobLog.exceptionInfo}}</td>
                    <td>{{sysJobLog.createTime}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'SysJobLogView', params: {sysJobLogId: sysJobLog.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'SysJobLogEdit', params: {sysJobLogId: sysJobLog.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(sysJobLog)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.sysJobLog.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-sysJobLog-heading" v-text="$t('yueXinJhipsterApp.sysJobLog.delete.question', {'id': removeId})">Are you sure you want to delete this Sys Job Log?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-sysJobLog" v-text="$t('entity.action.delete')" v-on:click="removeSysJobLog()">Delete</button>
            </div>
        </b-modal>
        <div v-show="sysJobLogs && sysJobLogs.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-job-log.component.ts">
</script>
