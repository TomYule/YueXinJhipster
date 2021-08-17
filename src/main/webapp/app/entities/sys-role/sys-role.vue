<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.sysRole.home.title')" id="sys-role-heading">Sys Roles</span>
            <router-link :to="{name: 'SysRoleCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-sys-role">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.sysRole.home.createLabel')">
                    Create a new Sys Role
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
        <div class="alert alert-warning" v-if="!isFetching && sysRoles && sysRoles.length === 0">
            <span v-text="$t('yueXinJhipsterApp.sysRole.home.notFound')">No sysRoles found</span>
        </div>
        <div class="table-responsive" v-if="sysRoles && sysRoles.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('roleName')"><span v-text="$t('yueXinJhipsterApp.sysRole.roleName')">Role Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roleName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('roleKey')"><span v-text="$t('yueXinJhipsterApp.sysRole.roleKey')">Role Key</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roleKey'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('roleSort')"><span v-text="$t('yueXinJhipsterApp.sysRole.roleSort')">Role Sort</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roleSort'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('dataScope')"><span v-text="$t('yueXinJhipsterApp.sysRole.dataScope')">Data Scope</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dataScope'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('menuCheckStrictly')"><span v-text="$t('yueXinJhipsterApp.sysRole.menuCheckStrictly')">Menu Check Strictly</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'menuCheckStrictly'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('deptCheckStrictly')"><span v-text="$t('yueXinJhipsterApp.sysRole.deptCheckStrictly')">Dept Check Strictly</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'deptCheckStrictly'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('status')"><span v-text="$t('yueXinJhipsterApp.sysRole.status')">Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'status'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('delFlag')"><span v-text="$t('yueXinJhipsterApp.sysRole.delFlag')">Del Flag</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'delFlag'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createBy')"><span v-text="$t('yueXinJhipsterApp.sysRole.createBy')">Create By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createTime')"><span v-text="$t('yueXinJhipsterApp.sysRole.createTime')">Create Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('updateBy')"><span v-text="$t('yueXinJhipsterApp.sysRole.updateBy')">Update By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('upLocalDate')"><span v-text="$t('yueXinJhipsterApp.sysRole.upLocalDate')">Up Local Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upLocalDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('remark')"><span v-text="$t('yueXinJhipsterApp.sysRole.remark')">Remark</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="sysRole in sysRoles"
                    :key="sysRole.id">
                    <td>
                        <router-link :to="{name: 'SysRoleView', params: {sysRoleId: sysRole.id}}">{{sysRole.id}}</router-link>
                    </td>
                    <td>{{sysRole.roleName}}</td>
                    <td>{{sysRole.roleKey}}</td>
                    <td>{{sysRole.roleSort}}</td>
                    <td>{{sysRole.dataScope}}</td>
                    <td>{{sysRole.menuCheckStrictly}}</td>
                    <td>{{sysRole.deptCheckStrictly}}</td>
                    <td>{{sysRole.status}}</td>
                    <td>{{sysRole.delFlag}}</td>
                    <td>{{sysRole.createBy}}</td>
                    <td>{{sysRole.createTime}}</td>
                    <td>{{sysRole.updateBy}}</td>
                    <td>{{sysRole.upLocalDate}}</td>
                    <td>{{sysRole.remark}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'SysRoleView', params: {sysRoleId: sysRole.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'SysRoleEdit', params: {sysRoleId: sysRole.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(sysRole)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.sysRole.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-sysRole-heading" v-text="$t('yueXinJhipsterApp.sysRole.delete.question', {'id': removeId})">Are you sure you want to delete this Sys Role?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-sysRole" v-text="$t('entity.action.delete')" v-on:click="removeSysRole()">Delete</button>
            </div>
        </b-modal>
        <div v-show="sysRoles && sysRoles.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-role.component.ts">
</script>
