<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('yueXinJhipsterApp.sysDept.home.title')" id="sys-dept-heading">Sys Depts</span>
            <router-link :to="{name: 'SysDeptCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-sys-dept">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('yueXinJhipsterApp.sysDept.home.createLabel')">
                    Create a new Sys Dept
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
        <div class="alert alert-warning" v-if="!isFetching && sysDepts && sysDepts.length === 0">
            <span v-text="$t('yueXinJhipsterApp.sysDept.home.notFound')">No sysDepts found</span>
        </div>
        <div class="table-responsive" v-if="sysDepts && sysDepts.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th><span v-text="$t('global.field.id')">ID</span></th>
                    <th><span v-text="$t('yueXinJhipsterApp.sysDept.deptName')">Dept Name</span></th>
                    <th><span v-text="$t('yueXinJhipsterApp.sysDept.parentId')">Parent Id</span></th>
                    <th><span v-text="$t('yueXinJhipsterApp.sysDept.ancestors')">Ancestors</span></th>
                    <th><span v-text="$t('yueXinJhipsterApp.sysDept.orderNum')">Order Num</span></th>
                    <th><span v-text="$t('yueXinJhipsterApp.sysDept.leader')">Leader</span></th>
                    <th><span v-text="$t('yueXinJhipsterApp.sysDept.phone')">Phone</span></th>
                    <th><span v-text="$t('yueXinJhipsterApp.sysDept.email')">Email</span></th>
                    <th><span v-text="$t('yueXinJhipsterApp.sysDept.status')">Status</span></th>
                    <th><span v-text="$t('yueXinJhipsterApp.sysDept.delFlag')">Del Flag</span></th>
                    <th><span v-text="$t('yueXinJhipsterApp.sysDept.createBy')">Create By</span></th>
                    <th><span v-text="$t('yueXinJhipsterApp.sysDept.createTime')">Create Time</span></th>
                    <th><span v-text="$t('yueXinJhipsterApp.sysDept.updateBy')">Update By</span></th>
                    <th><span v-text="$t('yueXinJhipsterApp.sysDept.upLocalDate')">Up Local Date</span></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="sysDept in sysDepts"
                    :key="sysDept.id">
                    <td>
                        <router-link :to="{name: 'SysDeptView', params: {sysDeptId: sysDept.id}}">{{sysDept.id}}</router-link>
                    </td>
                    <td>{{sysDept.deptName}}</td>
                    <td>{{sysDept.parentId}}</td>
                    <td>{{sysDept.ancestors}}</td>
                    <td>{{sysDept.orderNum}}</td>
                    <td>{{sysDept.leader}}</td>
                    <td>{{sysDept.phone}}</td>
                    <td>{{sysDept.email}}</td>
                    <td>{{sysDept.status}}</td>
                    <td>{{sysDept.delFlag}}</td>
                    <td>{{sysDept.createBy}}</td>
                    <td>{{sysDept.createTime}}</td>
                    <td>{{sysDept.updateBy}}</td>
                    <td>{{sysDept.upLocalDate}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'SysDeptView', params: {sysDeptId: sysDept.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'SysDeptEdit', params: {sysDeptId: sysDept.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(sysDept)"
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
            <span slot="modal-title"><span id="yueXinJhipsterApp.sysDept.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-sysDept-heading" v-text="$t('yueXinJhipsterApp.sysDept.delete.question', {'id': removeId})">Are you sure you want to delete this Sys Dept?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-sysDept" v-text="$t('entity.action.delete')" v-on:click="removeSysDept()">Delete</button>
            </div>
        </b-modal>
    </div>
</template>

<script lang="ts" src="./sys-dept.component.ts">
</script>
