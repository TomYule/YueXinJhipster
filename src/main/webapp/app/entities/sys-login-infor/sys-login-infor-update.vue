<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="yueXinJhipsterApp.sysLoginInfor.home.createOrEditLabel" v-text="$t('yueXinJhipsterApp.sysLoginInfor.home.createOrEditLabel')">Create or edit a SysLoginInfor</h2>
                <div>
                    <div class="form-group" v-if="sysLoginInfor.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="sysLoginInfor.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysLoginInfor.userName')" for="sys-login-infor-userName">User Name</label>
                        <input type="text" class="form-control" name="userName" id="sys-login-infor-userName"
                            :class="{'valid': !$v.sysLoginInfor.userName.$invalid, 'invalid': $v.sysLoginInfor.userName.$invalid }" v-model="$v.sysLoginInfor.userName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysLoginInfor.ipAddr')" for="sys-login-infor-ipAddr">Ip Addr</label>
                        <input type="text" class="form-control" name="ipAddr" id="sys-login-infor-ipAddr"
                            :class="{'valid': !$v.sysLoginInfor.ipAddr.$invalid, 'invalid': $v.sysLoginInfor.ipAddr.$invalid }" v-model="$v.sysLoginInfor.ipAddr.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysLoginInfor.loginLocation')" for="sys-login-infor-loginLocation">Login Location</label>
                        <input type="text" class="form-control" name="loginLocation" id="sys-login-infor-loginLocation"
                            :class="{'valid': !$v.sysLoginInfor.loginLocation.$invalid, 'invalid': $v.sysLoginInfor.loginLocation.$invalid }" v-model="$v.sysLoginInfor.loginLocation.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysLoginInfor.browser')" for="sys-login-infor-browser">Browser</label>
                        <input type="text" class="form-control" name="browser" id="sys-login-infor-browser"
                            :class="{'valid': !$v.sysLoginInfor.browser.$invalid, 'invalid': $v.sysLoginInfor.browser.$invalid }" v-model="$v.sysLoginInfor.browser.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysLoginInfor.os')" for="sys-login-infor-os">Os</label>
                        <input type="text" class="form-control" name="os" id="sys-login-infor-os"
                            :class="{'valid': !$v.sysLoginInfor.os.$invalid, 'invalid': $v.sysLoginInfor.os.$invalid }" v-model="$v.sysLoginInfor.os.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysLoginInfor.status')" for="sys-login-infor-status">Status</label>
                        <input type="text" class="form-control" name="status" id="sys-login-infor-status"
                            :class="{'valid': !$v.sysLoginInfor.status.$invalid, 'invalid': $v.sysLoginInfor.status.$invalid }" v-model="$v.sysLoginInfor.status.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysLoginInfor.msg')" for="sys-login-infor-msg">Msg</label>
                        <input type="text" class="form-control" name="msg" id="sys-login-infor-msg"
                            :class="{'valid': !$v.sysLoginInfor.msg.$invalid, 'invalid': $v.sysLoginInfor.msg.$invalid }" v-model="$v.sysLoginInfor.msg.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('yueXinJhipsterApp.sysLoginInfor.loginTime')" for="sys-login-infor-loginTime">Login Time</label>
                        <b-input-group class="mb-3">
                            <b-input-group-prepend>
                                <b-form-datepicker
                                    aria-controls="sys-login-infor-loginTime"
                                    v-model="$v.sysLoginInfor.loginTime.$model"
                                    name="loginTime"
                                    class="form-control"
                                    :locale="currentLanguage"
                                    button-only
                                    today-button
                                    reset-button
                                    close-button
                                >
                                </b-form-datepicker>
                            </b-input-group-prepend>
                            <b-form-input id="sys-login-infor-loginTime" type="text" class="form-control" name="loginTime"  :class="{'valid': !$v.sysLoginInfor.loginTime.$invalid, 'invalid': $v.sysLoginInfor.loginTime.$invalid }"
                            v-model="$v.sysLoginInfor.loginTime.$model"  />
                        </b-input-group>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.sysLoginInfor.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./sys-login-infor-update.component.ts">
</script>
