<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="sysNotice">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.sysNotice.detail.title')">SysNotice</span> {{sysNotice.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysNotice.noticeTitle')">Notice Title</span>
                    </dt>
                    <dd>
                        <span>{{sysNotice.noticeTitle}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysNotice.noticeType')">Notice Type</span>
                    </dt>
                    <dd>
                        <span>{{sysNotice.noticeType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysNotice.noticeContent')">Notice Content</span>
                    </dt>
                    <dd>
                        <span>{{sysNotice.noticeContent}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysNotice.status')">Status</span>
                    </dt>
                    <dd>
                        <span>{{sysNotice.status}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysNotice.createBy')">Create By</span>
                    </dt>
                    <dd>
                        <span>{{sysNotice.createBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysNotice.createTime')">Create Time</span>
                    </dt>
                    <dd>
                        <span>{{sysNotice.createTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysNotice.updateBy')">Update By</span>
                    </dt>
                    <dd>
                        <span>{{sysNotice.updateBy}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysNotice.upLocalDate')">Up Local Date</span>
                    </dt>
                    <dd>
                        <span>{{sysNotice.upLocalDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysNotice.remark')">Remark</span>
                    </dt>
                    <dd>
                        <span>{{sysNotice.remark}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="sysNotice.id" :to="{name: 'SysNoticeEdit', params: {sysNoticeId: sysNotice.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-notice-details.component.ts">
</script>
