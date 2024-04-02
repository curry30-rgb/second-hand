<template>
    <div class="login-container">
        <el-card class="box-card">
            <div class="login-body">
                <div class="sign-in-title" @click="toIndex">
                    <img src="../../logo/logo.png" alt="LOGO" style="width: 50px; margin-right: 5px" />
                    <b style="color: dodgerblue">闪淘</b>
                </div>

                <div class="title">管理员登录</div>

                <el-form ref="form" :model="userForm">
                    <el-input placeholder="请输入管理员账号" v-model="userForm.accountNumber" class="login-input">
                        <template slot="prepend">
                            <div class="el-icon-user-solid"></div>
                        </template>
                    </el-input>

                    <el-input
                        placeholder="请输入管理员密码"
                        v-model="userForm.adminPassword"
                        class="login-input"
                        @keyup.enter.native="login"
                        show-password
                    >
                        <template slot="prepend">
                            <div class="el-icon-lock"></div>
                        </template>
                    </el-input>

                    <div class="login-submit" style="margin-top: 20px">
                        <el-button type="primary" @click="login">登录</el-button>
                        <el-button type="primary" autocomplete="off" @click="$router.push('/login')" style="margin-left: 20px"
                            >返回前台</el-button
                        >
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
                adminPassword: ''
            }
        };
    },
    methods: {
        toIndex() {
            this.$router.replace({ path: '/index' });
        },
        login() {
            this.$api
                .adminLogin({
                    accountNumber: this.userForm.accountNumber,
                    adminPassword: this.userForm.adminPassword
                })
                .then((res) => {
                    console.log(res);
                    if (res.status_code === 1) {
                        console.log(res);
                        this.$sta.isLogin = true;
                        this.$sta.adminName = res.data.adminName;
                        this.$router.replace({ path: '/platform-admin' });
                    } else {
                        this.$message.error('登录失败，账号或密码错误！');
                    }
                });
        }
    }
};
</script>

<style scoped>
.sign-in-title {
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

.title {
    font-size: 30px;
    font-weight: bolder;
    color: #444;
    margin-bottom: 20px;
    text-align: center;
}
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
    background-color: #f1f1f1;
}
.login-body {
    padding: 30px;
    width: 300px;
    height: 100%;
}
.login-title {
    padding-bottom: 30px;
    text-align: center;
    font-weight: 600;
    font-size: 20px;
    color: #409eff;
    cursor: pointer;
}
.login-input {
    margin-bottom: 20px;
}
.login-submit {
    display: flex;
    justify-content: center;
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
    margin-top: 10px;
}
</style>
