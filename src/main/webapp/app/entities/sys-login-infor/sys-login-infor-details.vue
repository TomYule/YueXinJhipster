<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="sysLoginInfor">
                <h2 class="jh-entity-heading"><span v-text="$t('yueXinJhipsterApp.sysLoginInfor.detail.title')">SysLoginInfor</span> {{sysLoginInfor.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysLoginInfor.userName')">User Name</span>
                    </dt>
                    <dd>
                        <span>{{sysLoginInfor.userName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysLoginInfor.ipAddr')">Ip Addr</span>
                    </dt>
                    <dd>
                        <span>{{sysLoginInfor.ipAddr}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysLoginInfor.loginLocation')">Login Location</span>
                    </dt>
                    <dd>
                        <span>{{sysLoginInfor.loginLocation}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysLoginInfor.browser')">Browser</span>
                    </dt>
                    <dd>
                        <span>{{sysLoginInfor.browser}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysLoginInfor.os')">Os</span>
                    </dt>
                    <dd>
                        <span>{{sysLoginInfor.os}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysLoginInfor.status')">Status</span>
                    </dt>
                    <dd>
                        <span>{{sysLoginInfor.status}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysLoginInfor.msg')">Msg</span>
                    </dt>
                    <dd>
                        <span>{{sysLoginInfor.msg}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('yueXinJhipsterApp.sysLoginInfor.loginTime')">Login Time</span>
                    </dt>
                    <dd>
                        <span>{{sysLoginInfor.loginTime}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="sysLoginInfor.id" :to="{name: 'SysLoginInforEdit', params: {sysLoginInforId: sysLoginInfor.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./sys-login-infor-details.component.ts">
</script>
