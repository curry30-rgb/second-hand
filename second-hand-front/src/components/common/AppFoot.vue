<template>
    <div class="foot-container">
        <div class="contact">Feedback: 1627590317@qq.com</div>
        <div class="it"></div>
        <div class="copyright">© 2024 二手物品交易平台. 版权所有.</div>
    </div>
</template>

<script>
export default {
    name: 'Foot'
};
</script>

<style scoped>
.foot-container {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column; /* 垂直方向布局 */
    margin-left: auto;
    margin-right: auto;
    width: 960px;
    height: 80px;
    background-color: #f7f7f7;
    margin-top: 30px;
    border-top: 2px solid #d8d8d8;
    color: #000000;
    padding: 0 20px;
    color: #c0c4cc;
}
.it {
    height: 4px;
}
</style>
