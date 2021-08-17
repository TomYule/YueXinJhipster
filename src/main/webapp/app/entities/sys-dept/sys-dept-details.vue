<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="sysDept">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.sysDept.detail.title')">SysDept</span> {{sysDept.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDept.deptName')">Dept Name</span>
                    </dt>
                    <dd>
                        <span>{{sysDept.deptName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDept.parentId')">Parent Id</span>
                    </dt>
                    <dd>
                        <span>{{sysDept.parentId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDept.ancestors')">Ancestors</span>
                    </dt>
                    <dd>
                        <span>{{sysDept.ancestors}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDept.orderNum')">Order Num</span>
                    </dt>
                    <dd>
                        <span>{{sysDept.orderNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDept.leader')">Leader</span>
                    </dt>
                    <dd>
                        <span>{{sysDept.leader}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDept.phone')">Phone</span>
                    </dt>
                    <dd>
                        <span>{{sysDept.phone}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDept.email')">Email</span>
                    </dt>
                    <dd>
                        <span>{{sysDept.email}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDept.status')">Status</span>
                    </dt>
                    <dd>
                        <span>{{sysDept.status}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDept.delFlag')">Del Flag</span>
                    </dt>
                    <dd>
                        <span>{{sysDept.delFlag}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDept.createBy')">Create By</span>
                    </dt>
                    <dd>
                        <span>{{sysDept.createBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDept.createTime')">Create Time</span>
                    </dt>
                    <dd>
                        <span>{{sysDept.createTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDept.updateBy')">Update By</span>
                    </dt>
                    <dd>
                        <span>{{sysDept.updateBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysDept.upLocalDate')">Up Local Date</span>
                    </dt>
                    <dd>
                        <span>{{sysDept.upLocalDate}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="sysDept.id" :to="{name: 'SysDeptEdit', params: {sysDeptId: sysDept.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-dept-details.component.ts">
</script>
