<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="sysUser">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.sysUser.detail.title')">SysUser</span> {{sysUser.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.deptId')">Dept Id</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.deptId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.userName')">User Name</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.userName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.nickName')">Nick Name</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.nickName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.userType')">User Type</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.userType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.email')">Email</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.email}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.phoneNumber')">Phone Number</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.phoneNumber}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.gender')">Gender</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.gender}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.avatar')">Avatar</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.avatar}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.password')">Password</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.password}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.status')">Status</span>
                    </dt>
                    <dd>
                        <span v-text="$t('yueXinJhipsterApp.UserStatus.' + sysUser.status)">{{sysUser.status}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.delFlag')">Del Flag</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.delFlag}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.loginIp')">Login Ip</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.loginIp}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.loginDate')">Login Date</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.loginDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.createBy')">Create By</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.createBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.createTime')">Create Time</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.createTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.updateBy')">Update By</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.updateBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.upLocalDate')">Up Local Date</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.upLocalDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.remark')">Remark</span>
                    </dt>
                    <dd>
                        <span>{{sysUser.remark}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.sysPost')">Sys Post</span>
                    </dt>
                    <dd>
                        <span v-for="(sysPost, i) in sysUser.sysPosts" :key="sysPost.id">{{i > 0 ? ', ' : ''}}
                            <router-link :to="{name: 'SysPostView', params: {sysPostId: sysPost.id}}">{{sysPost.id}}</router-link>
                        </span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysUser.sysDept')">Sys Dept</span>
                    </dt>
                    <dd>
                        <div v-if="sysUser.sysDept">
                            <router-link :to="{name: 'SysDeptView', params: {sysDeptId: sysUser.sysDept.id}}">{{sysUser.sysDept.id}}</router-link>
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="sysUser.id" :to="{name: 'SysUserEdit', params: {sysUserId: sysUser.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-user-details.component.ts">
</script>
