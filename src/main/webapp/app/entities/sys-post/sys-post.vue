<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.sysPost.home.title')" id="sys-post-heading">Sys Posts</span>
            <router-link :to="{name: 'SysPostCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-sys-post">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.sysPost.home.createLabel')">
                    Create a new Sys Post
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
        <div class="alert alert-warning" v-if="!isFetching && sysPosts && sysPosts.length === 0">
            <span v-text="$t('yueXinJhipsterApp.sysPost.home.notFound')">No sysPosts found</span>
        </div>
        <div class="table-responsive" v-if="sysPosts && sysPosts.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('postCode')"><span v-text="$t('yueXinJhipsterApp.sysPost.postCode')">Post Code</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postCode'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('postName')"><span v-text="$t('yueXinJhipsterApp.sysPost.postName')">Post Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('postSort')"><span v-text="$t('yueXinJhipsterApp.sysPost.postSort')">Post Sort</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postSort'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('status')"><span v-text="$t('yueXinJhipsterApp.sysPost.status')">Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'status'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createBy')"><span v-text="$t('yueXinJhipsterApp.sysPost.createBy')">Create By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createTime')"><span v-text="$t('yueXinJhipsterApp.sysPost.createTime')">Create Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('updateBy')"><span v-text="$t('yueXinJhipsterApp.sysPost.updateBy')">Update By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('upLocalDate')"><span v-text="$t('yueXinJhipsterApp.sysPost.upLocalDate')">Up Local Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upLocalDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('remark')"><span v-text="$t('yueXinJhipsterApp.sysPost.remark')">Remark</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="sysPost in sysPosts"
                    :key="sysPost.id">
                    <td>
                        <router-link :to="{name: 'SysPostView', params: {sysPostId: sysPost.id}}">{{sysPost.id}}</router-link>
                    </td>
                    <td>{{sysPost.postCode}}</td>
                    <td>{{sysPost.postName}}</td>
                    <td>{{sysPost.postSort}}</td>
                    <td>{{sysPost.status}}</td>
                    <td>{{sysPost.createBy}}</td>
                    <td>{{sysPost.createTime}}</td>
                    <td>{{sysPost.updateBy}}</td>
                    <td>{{sysPost.upLocalDate}}</td>
                    <td>{{sysPost.remark}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'SysPostView', params: {sysPostId: sysPost.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'SysPostEdit', params: {sysPostId: sysPost.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(sysPost)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.sysPost.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-sysPost-heading" v-text="$t('yueXinJhipsterApp.sysPost.delete.question', {'id': removeId})">Are you sure you want to delete this Sys Post?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-sysPost" v-text="$t('entity.action.delete')" v-on:click="removeSysPost()">Delete</button>
            </div>
        </b-modal>
        <div v-show="sysPosts && sysPosts.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-post.component.ts">
</script>
