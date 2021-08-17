<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="sysMenu">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.sysMenu.detail.title')">SysMenu</span> {{sysMenu.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.menuName')">Menu Name</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.menuName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.parentId')">Parent Id</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.parentId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.orderNum')">Order Num</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.orderNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.path')">Path</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.path}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.components')">Components</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.components}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.isFrame')">Is Frame</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.isFrame}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.isCache')">Is Cache</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.isCache}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.menuType')">Menu Type</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.menuType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.visible')">Visible</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.visible}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.status')">Status</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.status}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.perms')">Perms</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.perms}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.icon')">Icon</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.icon}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.createBy')">Create By</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.createBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.createTime')">Create Time</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.createTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.updateBy')">Update By</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.updateBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.upLocalDate')">Up Local Date</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.upLocalDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysMenu.remark')">Remark</span>
                    </dt>
                    <dd>
                        <span>{{sysMenu.remark}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="sysMenu.id" :to="{name: 'SysMenuEdit', params: {sysMenuId: sysMenu.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-menu-details.component.ts">
</script>
