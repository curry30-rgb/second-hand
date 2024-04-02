<template>
    <div class="main-border">
        <div class="container">
            <div class="chart-left-top">
                <div class="chart-container" ref="chartContainerNum"></div>
            </div>
            <div class="chart-right-top">
                <div class="chart-container" ref="chartContainerPrice"></div>
            </div>
            <div class="chart-left-bottom">
                <div class="chart-container" ref="chartContainerDateNum"></div>
            </div>
            <div class="chart-right-bottom">
                <div class="chart-container" ref="chartContainerDatePrice"></div>
            </div>
        </div>
    </div>
</template>

<script>
import * as echarts from 'echarts';

export default {
    created() {
        this.getNum();
        this.getPrice();
        this.getDateNum();
        this.getDatePrice();
    },
    methods: {
        getNum() {
            this.$api
                .getData()
                .then((res) => {
                    // 调用渲染图表的方法并将数据传入
                    this.renderChart1(res.data);
                    console.log(res.data);
                })
                .catch((e) => {
                    console.log(e);
                });
        },
        getPrice() {
            this.$api
                .getData()
                .then((res) => {
                    // 调用渲染图表的方法并将数据传入
                    this.renderChart2(res.data);
                    console.log(res.data);
                })
                .catch((e) => {
                    console.log(e);
                });
        },
        getDateNum() {
            this.$api
                .getNumByDate()
                .then((res) => {
                    // 调用渲染图表的方法并将数据传入
                    this.renderChart3(res.data);
                    console.log(res.data);
                })
                .catch((e) => {
                    console.log(e);
                });
        },
        getDatePrice() {
            this.$api
                .getNumByDate()
                .then((res) => {
                    // 调用渲染图表的方法并将数据传入
                    this.renderChart4(res.data);
                    console.log(res.data);
                })
                .catch((e) => {
                    console.log(e);
                });
        },
        renderChart1(data) {
            // 初始化 ECharts 实例
            let chart = echarts.init(this.$refs.chartContainerNum);

            // 配置图表
            let option = {
                grid: {
                    left: '5%',
                    right: '5%',
                    top: '60px',
                    bottom: '5%',
                    containLabel: true
                },
                title: {
                    text: '各类别销量统计', // 设置标题文本
                    left: 'center', // 标题水平居中
                    top: 10, // 标题距离上边距的距离，单位为像素
                    textStyle: {
                        color: '#333', // 标题文字颜色
                        fontSize: 32, // 标题文字大小
                        fontWeight: 'bold' // 标题文字加粗
                    }
                },
                xAxis: {
                    type: 'category',
                    data: data.map((item) => item.label),
                    axisLine: {
                        lineStyle: {
                            color: '#999' // x轴线颜色
                        }
                    },
                    axisLabel: {
                        textStyle: {
                            fontWeight: 'bolder',
                            color: '#000000',
                            fontSize: 15
                        }
                    }
                },
                yAxis: {
                    minInterval: 1,
                    type: 'value',
                    axisLine: {
                        lineStyle: {
                            color: '#999' // y轴线颜色
                        }
                    },
                    axisLabel: {
                        textStyle: {
                            fontWeight: 'bolder',
                            color: '#000000',
                            fontSize: 15
                        }
                    }
                },
                series: [
                    {
                        data: data.map((item) => item.num),
                        type: 'bar',
                        itemStyle: {
                            color: '#2EC7C9' // 柱状图颜色
                        }
                    }
                ]
            };
            chart.setOption(option);
        },
        renderChart2(data) {
            // 初始化 ECharts 实例
            let chart = echarts.init(this.$refs.chartContainerPrice);

            // 配置图表
            let option = {
                grid: {
                    left: '5%',
                    right: '5%',
                    top: '60px',
                    bottom: '5%',
                    containLabel: true
                },
                title: {
                    text: '各类别销售额统计', // 设置标题文本
                    left: 'center', // 标题水平居中
                    top: 10, // 标题距离上边距的距离，单位为像素
                    textStyle: {
                        color: '#333', // 标题文字颜色
                        fontSize: 32, // 标题文字大小
                        fontWeight: 'bold' // 标题文字加粗
                    }
                },
                xAxis: {
                    type: 'category',
                    data: data.map((item) => item.label),
                    axisLine: {
                        lineStyle: {
                            color: '#000' // x轴线颜色
                        }
                    },
                    axisLabel: {
                        textStyle: {
                            fontWeight: 'bolder',
                            color: '#000000',
                            fontSize: 15
                        }
                    }
                },
                yAxis: {
                    minInterval: 1,
                    type: 'value',
                    axisLine: {
                        lineStyle: {
                            color: '#999' // y轴线颜色
                        }
                    },
                    axisLabel: {
                        textStyle: {
                            fontWeight: 'bolder',
                            color: '#000000',
                            fontSize: 15
                        }
                    }
                },
                series: [
                    {
                        data: data.map((item) => item.price),
                        type: 'bar',
                        itemStyle: {
                            color: '#2EC7C9' // 柱状图颜色
                        }
                    }
                ]
            };
            chart.setOption(option);
        },
        renderChart3(data) {
            // 初始化 ECharts 实例
            let chart = echarts.init(this.$refs.chartContainerDateNum);

            let option = {
                grid: {
                    left: '5%',
                    right: '5%',
                    top: '60px',
                    bottom: '5%',
                    containLabel: true
                },
                title: {
                    text: '近七天总销量变化', // 设置标题文本
                    left: 'center', // 标题水平居中
                    top: 10, // 标题距离上边距的距离，单位为像素
                    textStyle: {
                        color: '#333', // 标题文字颜色
                        fontSize: 32, // 标题文字大小
                        fontWeight: 'bold' // 标题文字加粗
                    }
                },
                xAxis: {
                    type: 'category',
                    data: data.map((item) => item.time),
                    axisLabel: {
                        rotate: 30,
                        margin: 30,
                        align: 'center',
                        textStyle: {
                            fontWeight: 'bolder',
                            color: '#000000'
                        }
                    }
                },
                yAxis: {
                    minInterval: 1,
                    type: 'value',
                    axisLabel: {
                        textStyle: {
                            fontWeight: 'bolder',
                            color: '#000000',
                            fontSize: 15
                        }
                    }
                },
                series: [
                    {
                        data: data.map((item) => item.num),
                        type: 'line',
                        smooth: true,
                        lineStyle: {
                            color: '#2EC7C9' // 设置折线的颜色
                        },
                        itemStyle: {
                            color: '#2EC7C9' // 设置点的颜色
                        }
                    }
                ]
            };
            chart.setOption(option);
        },
        renderChart4(data) {
            // 初始化 ECharts 实例
            let chart = echarts.init(this.$refs.chartContainerDatePrice);

            let option = {
                grid: {
                    left: '5%',
                    right: '5%',
                    top: '60px',
                    bottom: '5%',
                    containLabel: true
                },
                title: {
                    text: '近七天总销售额变化', // 设置标题文本
                    left: 'center', // 标题水平居中
                    top: 10, // 标题距离上边距的距离，单位为像素
                    textStyle: {
                        color: '#333', // 标题文字颜色
                        fontSize: 32, // 标题文字大小
                        fontWeight: 'bold' // 标题文字加粗
                    }
                },
                xAxis: {
                    type: 'category',
                    data: data.map((item) => item.time),
                    axisLabel: {
                        rotate: 30,
                        margin: 30,
                        align: 'center',
                        textStyle: {
                            fontWeight: 'bolder',
                            color: '#000000'
                        }
                    }
                },
                yAxis: {
                    minInterval: 1,
                    type: 'value',
                    axisLabel: {
                        textStyle: {
                            fontWeight: 'bolder',
                            color: '#000000',
                            fontSize: 15
                        }
                    }
                },
                series: [
                    {
                        data: data.map((item) => item.price),
                        type: 'line',
                        smooth: true,
                        lineStyle: {
                            color: '#2EC7C9' // 设置折线的颜色
                        },
                        itemStyle: {
                            color: '#2EC7C9' // 设置点的颜色
                        }
                    }
                ]
            };
            chart.setOption(option);
        }
    }
};
</script>

<style>
/* 修改样式 */
.main-border {
    background-color: #fff;
    padding: 10px 30px;
    box-shadow: 0 1px 15px -6px rgba(0, 0, 0, 0.5);
    border-radius: 5px;
}
.chart-container {
    width: 100%;
    height: 100%;
}
.container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
}

.chart-left-top,
.chart-right-top,
.chart-left-bottom,
.chart-right-bottom {
    width: 49%;
    height: 400px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
}
</style>