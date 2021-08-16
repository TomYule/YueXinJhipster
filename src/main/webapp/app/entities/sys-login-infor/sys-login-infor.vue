<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.sysLoginInfor.home.title')" id="sys-login-infor-heading">Sys Login Infors</span>
            <router-link :to="{name: 'SysLoginInforCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-sys-login-infor">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.sysLoginInfor.home.createLabel')">
                    Create a new Sys Login Infor
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
        <div class="alert alert-warning" v-if="!isFetching && sysLoginInfors && sysLoginInfors.length === 0">
            <span v-text="$t('yueXinJhipsterApp.sysLoginInfor.home.notFound')">No sysLoginInfors found</span>
        </div>
        <div class="table-responsive" v-if="sysLoginInfors && sysLoginInfors.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('userName')"><span v-text="$t('yueXinJhipsterApp.sysLoginInfor.userName')">User Name</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'userName'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('ipAddr')"><span v-text="$t('yueXinJhipsterApp.sysLoginInfor.ipAddr')">Ip Addr</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ipAddr'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('loginLocation')"><span v-text="$t('yueXinJhipsterApp.sysLoginInfor.loginLocation')">Login Location</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'loginLocation'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('browser')"><span v-text="$t('yueXinJhipsterApp.sysLoginInfor.browser')">Browser</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'browser'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('os')"><span v-text="$t('yueXinJhipsterApp.sysLoginInfor.os')">Os</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'os'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('status')"><span v-text="$t('yueXinJhipsterApp.sysLoginInfor.status')">Status</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'status'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('msg')"><span v-text="$t('yueXinJhipsterApp.sysLoginInfor.msg')">Msg</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'msg'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('loginTime')"><span v-text="$t('yueXinJhipsterApp.sysLoginInfor.loginTime')">Login Time</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'loginTime'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="sysLoginInfor in sysLoginInfors"
                    :key="sysLoginInfor.id">
                    <td>
                        <router-link :to="{name: 'SysLoginInforView', params: {sysLoginInforId: sysLoginInfor.id}}">{{sysLoginInfor.id}}</router-link>
                    </td>
                    <td>{{sysLoginInfor.userName}}</td>
                    <td>{{sysLoginInfor.ipAddr}}</td>
                    <td>{{sysLoginInfor.loginLocation}}</td>
                    <td>{{sysLoginInfor.browser}}</td>
                    <td>{{sysLoginInfor.os}}</td>
                    <td>{{sysLoginInfor.status}}</td>
                    <td>{{sysLoginInfor.msg}}</td>
                    <td>{{sysLoginInfor.loginTime}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'SysLoginInforView', params: {sysLoginInforId: sysLoginInfor.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'SysLoginInforEdit', params: {sysLoginInforId: sysLoginInfor.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(sysLoginInfor)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.sysLoginInfor.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-sysLoginInfor-heading" v-text="$t('yueXinJhipsterApp.sysLoginInfor.delete.question', {'id': removeId})">Are you sure you want to delete this Sys Login Infor?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-sysLoginInfor" v-text="$t('entity.action.delete')" v-on:click="removeSysLoginInfor()">Delete</button>
            </div>
        </b-modal>
        <div v-show="sysLoginInfors && sysLoginInfors.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-login-infor.component.ts">
</script>
