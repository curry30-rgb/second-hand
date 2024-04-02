<template>
    <div class="login-container">
        <el-card class="box-card">
            <div class="login-body">
                <div class="login-title" @click="toIndex">
                    <img src="../../logo/logo.png" alt="LOGO" style="width: 50px; margin-right: 5px" />
                    <b style="color: dodgerblue">闪淘</b>
                </div>

                <div class="title">用户登录</div>

                <el-form ref="form" :model="userForm">
                    <el-input placeholder="用户名" v-model="userForm.accountNumber" class="login-input">
                        <template slot="prepend">
                            <div class="el-icon-user-solid"></div>
                        </template>
                    </el-input>

                    <el-input
                        placeholder="密码"
                        v-model="userForm.userPassword"
                        class="login-input"
                        @keyup.enter.native="login"
                        show-password
                    >
                        <template slot="prepend">
                            <div class="el-icon-lock"></div>
                        </template>
                    </el-input>

                    <div class="login-submit">
                        <el-button type="primary" @click="login">登录</el-button>
                        <el-button type="primary" autocomplete="off" @click="$router.push('/sign-in')" style="margin-left: 20px"
                            >注册</el-button
                        >
                    </div>

                    <div class="other-submit">
                        <router-link to="/login-admin" class="sign-in-text">管理员登录</router-link>
                    </div>
                </el-form>
            </div>
        </el-card>
    </div>
</template>

<script>
export default {
    name: 'login',
    data() {
        return {
            userForm: {
                accountNumber: '',
                userPassword: ''
            }
        };
    },

    methods: {
        login() {
            this.$api
                .userLogin({
                    accountNumber: this.userForm.accountNumber,
                    userPassword: this.userForm.userPassword
                })
                .then((res) => {
                    console.log(res);
                    if (res.status_code === 1) {
                        res.data.signInTime = res.data.signInTime.substring(0, 10);
                        this.$globalData.userInfo = res.data;
                        this.$router.replace({ path: '/index' });
                    } else {
                        this.$message.error(res.msg);
                    }
                });
        },
        toIndex() {
            this.$router.replace({ path: '/index' });
        }
    }
};
</script>

<style scoped>
.box-card {
    position: fixed;
    border-radius: 30px;
    top: 150px;
}
.login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    width: 100%;
}

.login-body {
    padding: 30px;
    width: 300px;
    height: 100%;
}

.login-title {
    display: flex;
    align-items: center;
    justify-content: center;
    padding-bottom: 30px;
    text-align: center;
    font-weight: 600;
    font-size: 40px;
    color: #409eff;
    cursor: pointer;
}

.login-input {
    margin-bottom: 20px;
}

.login-submit {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    border-radius: 30px;
}

.sign-in-container {
    padding: 0 10px;
}

.sign-in-text {
    color: #409eff;
    font-size: 16px;
    text-decoration: none;
    line-height: 28px;
}
.other-submit {
    display: flex;
    justify-content: space-between;
    margin-top: 30px;
    margin-left: 200px;
}
.title {
    font-size: 30px;
    font-weight: bolder;
    color: #444;
    margin-bottom: 20px;
    text-align: center;
}
</style>
