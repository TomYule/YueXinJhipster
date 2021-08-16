<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.sysJob.home.title')" id="sys-job-heading">Sys Jobs</span>
            <router-link :to="{name: 'SysJobCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-sys-job">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.sysJob.home.createLabel')">
                    Create a new Sys Job
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
        <div class="alert alert-warning" v-if="!isFetching && sysJobs && sysJobs.length === 0">
            <span v-text="$t('yueXinJhipsterApp.sysJob.home.notFound')">No sysJobs found</span>
        </div>
        <div class="table-responsive" v-if="sysJobs && sysJobs.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('jobName')"><span v-text="$t('yueXinJhipsterApp.sysJob.jobName')">Job Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'jobName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('jobGroup')"><span v-text="$t('yueXinJhipsterApp.sysJob.jobGroup')">Job Group</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'jobGroup'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('invokeTarget')"><span v-text="$t('yueXinJhipsterApp.sysJob.invokeTarget')">Invoke Target</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'invokeTarget'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('cronExpression')"><span v-text="$t('yueXinJhipsterApp.sysJob.cronExpression')">Cron Expression</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cronExpression'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('misfirePolicy')"><span v-text="$t('yueXinJhipsterApp.sysJob.misfirePolicy')">Misfire Policy</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'misfirePolicy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('status')"><span v-text="$t('yueXinJhipsterApp.sysJob.status')">Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'status'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createBy')"><span v-text="$t('yueXinJhipsterApp.sysJob.createBy')">Create By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createTime')"><span v-text="$t('yueXinJhipsterApp.sysJob.createTime')">Create Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('updateBy')"><span v-text="$t('yueXinJhipsterApp.sysJob.updateBy')">Update By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('upLocalDate')"><span v-text="$t('yueXinJhipsterApp.sysJob.upLocalDate')">Up Local Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upLocalDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('remark')"><span v-text="$t('yueXinJhipsterApp.sysJob.remark')">Remark</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="sysJob in sysJobs"
                    :key="sysJob.id">
                    <td>
                        <router-link :to="{name: 'SysJobView', params: {sysJobId: sysJob.id}}">{{sysJob.id}}</router-link>
                    </td>
                    <td>{{sysJob.jobName}}</td>
                    <td>{{sysJob.jobGroup}}</td>
                    <td>{{sysJob.invokeTarget}}</td>
                    <td>{{sysJob.cronExpression}}</td>
                    <td>{{sysJob.misfirePolicy}}</td>
                    <td>{{sysJob.status}}</td>
                    <td>{{sysJob.createBy}}</td>
                    <td>{{sysJob.createTime}}</td>
                    <td>{{sysJob.updateBy}}</td>
                    <td>{{sysJob.upLocalDate}}</td>
                    <td>{{sysJob.remark}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'SysJobView', params: {sysJobId: sysJob.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'SysJobEdit', params: {sysJobId: sysJob.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(sysJob)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.sysJob.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-sysJob-heading" v-text="$t('yueXinJhipsterApp.sysJob.delete.question', {'id': removeId})">Are you sure you want to delete this Sys Job?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-sysJob" v-text="$t('entity.action.delete')" v-on:click="removeSysJob()">Delete</button>
            </div>
        </b-modal>
        <div v-show="sysJobs && sysJobs.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-job.component.ts">
</script>
