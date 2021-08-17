<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="sysRole">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.sysRole.detail.title')">SysRole</span> {{sysRole.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.roleName')">Role Name</span>
                    </dt>
                    <dd>
                        <span>{{sysRole.roleName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.roleKey')">Role Key</span>
                    </dt>
                    <dd>
                        <span>{{sysRole.roleKey}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.roleSort')">Role Sort</span>
                    </dt>
                    <dd>
                        <span>{{sysRole.roleSort}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.dataScope')">Data Scope</span>
                    </dt>
                    <dd>
                        <span>{{sysRole.dataScope}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.menuCheckStrictly')">Menu Check Strictly</span>
                    </dt>
                    <dd>
                        <span>{{sysRole.menuCheckStrictly}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.deptCheckStrictly')">Dept Check Strictly</span>
                    </dt>
                    <dd>
                        <span>{{sysRole.deptCheckStrictly}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.status')">Status</span>
                    </dt>
                    <dd>
                        <span>{{sysRole.status}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.delFlag')">Del Flag</span>
                    </dt>
                    <dd>
                        <span>{{sysRole.delFlag}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.createBy')">Create By</span>
                    </dt>
                    <dd>
                        <span>{{sysRole.createBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.createTime')">Create Time</span>
                    </dt>
                    <dd>
                        <span>{{sysRole.createTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.updateBy')">Update By</span>
                    </dt>
                    <dd>
                        <span>{{sysRole.updateBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.upLocalDate')">Up Local Date</span>
                    </dt>
                    <dd>
                        <span>{{sysRole.upLocalDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.remark')">Remark</span>
                    </dt>
                    <dd>
                        <span>{{sysRole.remark}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.sysMenu')">Sys Menu</span>
                    </dt>
                    <dd>
                        <span v-for="(sysMenu, i) in sysRole.sysMenus" :key="sysMenu.id">{{i > 0 ? ', ' : ''}}
                            <router-link :to="{name: 'SysMenuView', params: {sysMenuId: sysMenu.id}}">{{sysMenu.id}}</router-link>
                        </span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysRole.sysUser')">Sys User</span>
                    </dt>
                    <dd>
                        <span v-for="(sysUser, i) in sysRole.sysUsers" :key="sysUser.id">{{i > 0 ? ', ' : ''}}
                            <router-link :to="{name: 'SysUserView', params: {sysUserId: sysUser.id}}">{{sysUser.id}}</router-link>
                        </span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="sysRole.id" :to="{name: 'SysRoleEdit', params: {sysRoleId: sysRole.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-role-details.component.ts">
</script>
