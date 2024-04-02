<template>
    <div class="swiper-container">
        <div class="swiper-wrapper">
            <div v-for="item in banner" class="swiper-slide">
                <img :src="item.path.slice(2, -2)" alt="" />
            </div>
        </div>

        <div class="swiper-pagination"></div>
    </div>
</template>
  
<script>
import Swiper from 'swiper';
import 'swiper/css/swiper.min.css';
export default {
    data() {
        return {
            banner: []
        };
    },
    created() {
        this.getAdv();
    },
    updated() {
        new Swiper('.swiper-container', {
            loop: true, // 循环模式选项

            pagination: {
                el: '.swiper-pagination'
            },
            effect: 'fade',
            autoplay: true,
            centeredSlides: true
        });
    },
    methods: {
        getAdv() {
            this.$api
                .getAdvByStatus()
                .then((res) => {
                    console.log(res.data);
                    this.banner = res.data;
                })
                .catch((e) => {
                    console.log(e);
                });
        }
    }
};
</script>
  
<style scoped>
.swiper-container {
    top: 75px;
    width: 1900px;
    height: 500px;
    margin: auto;
}
</style>
  