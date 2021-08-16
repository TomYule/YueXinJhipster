<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.sysUser.home.title')" id="sys-user-heading">Sys Users</span>
            <router-link :to="{name: 'SysUserCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-sys-user">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.sysUser.home.createLabel')">
                    Create a new Sys User
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
        <div class="alert alert-warning" v-if="!isFetching && sysUsers && sysUsers.length === 0">
            <span v-text="$t('yueXinJhipsterApp.sysUser.home.notFound')">No sysUsers found</span>
        </div>
        <div class="table-responsive" v-if="sysUsers && sysUsers.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('deptId')"><span v-text="$t('yueXinJhipsterApp.sysUser.deptId')">Dept Id</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'deptId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('userName')"><span v-text="$t('yueXinJhipsterApp.sysUser.userName')">User Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'userName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('nickName')"><span v-text="$t('yueXinJhipsterApp.sysUser.nickName')">Nick Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nickName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('userType')"><span v-text="$t('yueXinJhipsterApp.sysUser.userType')">User Type</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'userType'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('email')"><span v-text="$t('yueXinJhipsterApp.sysUser.email')">Email</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'email'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('phoneNumber')"><span v-text="$t('yueXinJhipsterApp.sysUser.phoneNumber')">Phone Number</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'phoneNumber'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('gender')"><span v-text="$t('yueXinJhipsterApp.sysUser.gender')">Gender</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'gender'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('avatar')"><span v-text="$t('yueXinJhipsterApp.sysUser.avatar')">Avatar</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'avatar'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('password')"><span v-text="$t('yueXinJhipsterApp.sysUser.password')">Password</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'password'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('status')"><span v-text="$t('yueXinJhipsterApp.sysUser.status')">Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'status'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('delFlag')"><span v-text="$t('yueXinJhipsterApp.sysUser.delFlag')">Del Flag</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'delFlag'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('loginIp')"><span v-text="$t('yueXinJhipsterApp.sysUser.loginIp')">Login Ip</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'loginIp'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('loginDate')"><span v-text="$t('yueXinJhipsterApp.sysUser.loginDate')">Login Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'loginDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createBy')"><span v-text="$t('yueXinJhipsterApp.sysUser.createBy')">Create By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('createTime')"><span v-text="$t('yueXinJhipsterApp.sysUser.createTime')">Create Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('updateBy')"><span v-text="$t('yueXinJhipsterApp.sysUser.updateBy')">Update By</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('upLocalDate')"><span v-text="$t('yueXinJhipsterApp.sysUser.upLocalDate')">Up Local Date</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upLocalDate'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('remark')"><span v-text="$t('yueXinJhipsterApp.sysUser.remark')">Remark</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('sysDept.id')"><span v-text="$t('yueXinJhipsterApp.sysUser.sysDept')">Sys Dept</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sysDept.id'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="sysUser in sysUsers"
                    :key="sysUser.id">
                    <td>
                        <router-link :to="{name: 'SysUserView', params: {sysUserId: sysUser.id}}">{{sysUser.id}}</router-link>
                    </td>
                    <td>{{sysUser.deptId}}</td>
                    <td>{{sysUser.userName}}</td>
                    <td>{{sysUser.nickName}}</td>
                    <td>{{sysUser.userType}}</td>
                    <td>{{sysUser.email}}</td>
                    <td>{{sysUser.phoneNumber}}</td>
                    <td>{{sysUser.gender}}</td>
                    <td>{{sysUser.avatar}}</td>
                    <td>{{sysUser.password}}</td>
                    <td v-text="$t('yueXinJhipsterApp.UserStatus.' + sysUser.status)">{{sysUser.status}}</td>
                    <td>{{sysUser.delFlag}}</td>
                    <td>{{sysUser.loginIp}}</td>
                    <td>{{sysUser.loginDate}}</td>
                    <td>{{sysUser.createBy}}</td>
                    <td>{{sysUser.createTime}}</td>
                    <td>{{sysUser.updateBy}}</td>
                    <td>{{sysUser.upLocalDate}}</td>
                    <td>{{sysUser.remark}}</td>
                    <td>
                        <div v-if="sysUser.sysDept">
                            <router-link :to="{name: 'SysDeptView', params: {sysDeptId: sysUser.sysDept.id}}">{{sysUser.sysDept.id}}</router-link>
                        </div>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'SysUserView', params: {sysUserId: sysUser.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'SysUserEdit', params: {sysUserId: sysUser.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(sysUser)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.sysUser.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-sysUser-heading" v-text="$t('yueXinJhipsterApp.sysUser.delete.question', {'id': removeId})">Are you sure you want to delete this Sys User?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-sysUser" v-text="$t('entity.action.delete')" v-on:click="removeSysUser()">Delete</button>
            </div>
        </b-modal>
        <div v-show="sysUsers && sysUsers.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-user.component.ts">
</script>
