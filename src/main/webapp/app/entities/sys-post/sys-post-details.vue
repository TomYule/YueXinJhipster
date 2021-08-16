<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="sysPost">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.sysPost.detail.title')">SysPost</span> {{sysPost.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysPost.postCode')">Post Code</span>
                    </dt>
                    <dd>
                        <span>{{sysPost.postCode}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysPost.postName')">Post Name</span>
                    </dt>
                    <dd>
                        <span>{{sysPost.postName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysPost.postSort')">Post Sort</span>
                    </dt>
                    <dd>
                        <span>{{sysPost.postSort}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysPost.status')">Status</span>
                    </dt>
                    <dd>
                        <span>{{sysPost.status}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysPost.createBy')">Create By</span>
                    </dt>
                    <dd>
                        <span>{{sysPost.createBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysPost.createTime')">Create Time</span>
                    </dt>
                    <dd>
                        <span>{{sysPost.createTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysPost.updateBy')">Update By</span>
                    </dt>
                    <dd>
                        <span>{{sysPost.updateBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysPost.upLocalDate')">Up Local Date</span>
                    </dt>
                    <dd>
                        <span>{{sysPost.upLocalDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysPost.remark')">Remark</span>
                    </dt>
                    <dd>
                        <span>{{sysPost.remark}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="sysPost.id" :to="{name: 'SysPostEdit', params: {sysPostId: sysPost.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-post-details.component.ts">
</script>
