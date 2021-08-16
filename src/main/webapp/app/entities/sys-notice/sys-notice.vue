<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.sysNotice.home.title')" id="sys-notice-heading">Sys Notices</span>
            <router-link :to="{name: 'SysNoticeCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-sys-notice">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.sysNotice.home.createLabel')">
                    Create a new Sys Notice
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
        <div class="alert alert-warning" v-if="!isFetching && sysNotices && sysNotices.length === 0">
            <span v-text="$t('yueXinJhipsterApp.sysNotice.home.notFound')">No sysNotices found</span>
        </div>
        <div class="table-responsive" v-if="sysNotices && sysNotices.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('noticeTitle')"><span v-text="$t('yueXinJhipsterApp.sysNotice.noticeTitle')">Notice Title</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'noticeTitle'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('noticeType')"><span v-text="$t('yueXinJhipsterApp.sysNotice.noticeType')">Notice Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'noticeType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('noticeContent')"><span v-text="$t('yueXinJhipsterApp.sysNotice.noticeContent')">Notice Content</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'noticeContent'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('status')"><span v-text="$t('yueXinJhipsterApp.sysNotice.status')">Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'status'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createBy')"><span v-text="$t('yueXinJhipsterApp.sysNotice.createBy')">Create By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createTime')"><span v-text="$t('yueXinJhipsterApp.sysNotice.createTime')">Create Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('updateBy')"><span v-text="$t('yueXinJhipsterApp.sysNotice.updateBy')">Update By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('upLocalDate')"><span v-text="$t('yueXinJhipsterApp.sysNotice.upLocalDate')">Up Local Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upLocalDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('remark')"><span v-text="$t('yueXinJhipsterApp.sysNotice.remark')">Remark</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="sysNotice in sysNotices"
                    :key="sysNotice.id">
                    <td>
                        <router-link :to="{name: 'SysNoticeView', params: {sysNoticeId: sysNotice.id}}">{{sysNotice.id}}</router-link>
                    </td>
                    <td>{{sysNotice.noticeTitle}}</td>
                    <td>{{sysNotice.noticeType}}</td>
                    <td>{{sysNotice.noticeContent}}</td>
                    <td>{{sysNotice.status}}</td>
                    <td>{{sysNotice.createBy}}</td>
                    <td>{{sysNotice.createTime}}</td>
                    <td>{{sysNotice.updateBy}}</td>
                    <td>{{sysNotice.upLocalDate}}</td>
                    <td>{{sysNotice.remark}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'SysNoticeView', params: {sysNoticeId: sysNotice.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'SysNoticeEdit', params: {sysNoticeId: sysNotice.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(sysNotice)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.sysNotice.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-sysNotice-heading" v-text="$t('yueXinJhipsterApp.sysNotice.delete.question', {'id': removeId})">Are you sure you want to delete this Sys Notice?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-sysNotice" v-text="$t('entity.action.delete')" v-on:click="removeSysNotice()">Delete</button>
            </div>
        </b-modal>
        <div v-show="sysNotices && sysNotices.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-notice.component.ts">
</script>
