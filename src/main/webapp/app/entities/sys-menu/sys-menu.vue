<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.sysMenu.home.title')" id="sys-menu-heading">Sys Menus</span>
            <router-link :to="{name: 'SysMenuCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-sys-menu">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.sysMenu.home.createLabel')">
                    Create a new Sys Menu
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
        <div class="alert alert-warning" v-if="!isFetching && sysMenus && sysMenus.length === 0">
            <span v-text="$t('yueXinJhipsterApp.sysMenu.home.notFound')">No sysMenus found</span>
        </div>
        <div class="table-responsive" v-if="sysMenus && sysMenus.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('menuName')"><span v-text="$t('yueXinJhipsterApp.sysMenu.menuName')">Menu Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'menuName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('parentId')"><span v-text="$t('yueXinJhipsterApp.sysMenu.parentId')">Parent Id</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'parentId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('orderNum')"><span v-text="$t('yueXinJhipsterApp.sysMenu.orderNum')">Order Num</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'orderNum'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('path')"><span v-text="$t('yueXinJhipsterApp.sysMenu.path')">Path</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'path'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('components')"><span v-text="$t('yueXinJhipsterApp.sysMenu.components')">Components</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'components'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('isFrame')"><span v-text="$t('yueXinJhipsterApp.sysMenu.isFrame')">Is Frame</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isFrame'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('isCache')"><span v-text="$t('yueXinJhipsterApp.sysMenu.isCache')">Is Cache</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isCache'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('menuType')"><span v-text="$t('yueXinJhipsterApp.sysMenu.menuType')">Menu Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'menuType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('visible')"><span v-text="$t('yueXinJhipsterApp.sysMenu.visible')">Visible</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'visible'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('status')"><span v-text="$t('yueXinJhipsterApp.sysMenu.status')">Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'status'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('perms')"><span v-text="$t('yueXinJhipsterApp.sysMenu.perms')">Perms</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'perms'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('icon')"><span v-text="$t('yueXinJhipsterApp.sysMenu.icon')">Icon</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'icon'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createBy')"><span v-text="$t('yueXinJhipsterApp.sysMenu.createBy')">Create By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createTime')"><span v-text="$t('yueXinJhipsterApp.sysMenu.createTime')">Create Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('updateBy')"><span v-text="$t('yueXinJhipsterApp.sysMenu.updateBy')">Update By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('upLocalDate')"><span v-text="$t('yueXinJhipsterApp.sysMenu.upLocalDate')">Up Local Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upLocalDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('remark')"><span v-text="$t('yueXinJhipsterApp.sysMenu.remark')">Remark</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="sysMenu in sysMenus"
                    :key="sysMenu.id">
                    <td>
                        <router-link :to="{name: 'SysMenuView', params: {sysMenuId: sysMenu.id}}">{{sysMenu.id}}</router-link>
                    </td>
                    <td>{{sysMenu.menuName}}</td>
                    <td>{{sysMenu.parentId}}</td>
                    <td>{{sysMenu.orderNum}}</td>
                    <td>{{sysMenu.path}}</td>
                    <td>{{sysMenu.components}}</td>
                    <td>{{sysMenu.isFrame}}</td>
                    <td>{{sysMenu.isCache}}</td>
                    <td>{{sysMenu.menuType}}</td>
                    <td>{{sysMenu.visible}}</td>
                    <td>{{sysMenu.status}}</td>
                    <td>{{sysMenu.perms}}</td>
                    <td>{{sysMenu.icon}}</td>
                    <td>{{sysMenu.createBy}}</td>
                    <td>{{sysMenu.createTime}}</td>
                    <td>{{sysMenu.updateBy}}</td>
                    <td>{{sysMenu.upLocalDate}}</td>
                    <td>{{sysMenu.remark}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'SysMenuView', params: {sysMenuId: sysMenu.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'SysMenuEdit', params: {sysMenuId: sysMenu.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(sysMenu)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.sysMenu.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-sysMenu-heading" v-text="$t('yueXinJhipsterApp.sysMenu.delete.question', {'id': removeId})">Are you sure you want to delete this Sys Menu?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-sysMenu" v-text="$t('entity.action.delete')" v-on:click="removeSysMenu()">Delete</button>
            </div>
        </b-modal>
        <div v-show="sysMenus && sysMenus.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-menu.component.ts">
</script>
