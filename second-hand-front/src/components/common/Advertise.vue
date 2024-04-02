<template>
    <div class="main-border">
        <el-menu default-active="1" class="el-menu-demo" mode="horizontal" @select="handleSelect">
            <el-menu-item index="1">上线的广告</el-menu-item>
            <el-menu-item index="2">下架的广告</el-menu-item>

            <div v-show="this.mode == 1" class="addAdvButton">
                <el-button size="mini" type="success" @click="adminRegVisible = true">添加广告</el-button>

                <el-dialog title="添加广告" :visible.sync="adminRegVisible" width="28%">
                    <span style="margin-left: 10px">广告作者</span>
                    <el-input
                        v-model="advInfo.author"
                        maxlength="8"
                        placeholder="请输入广告作者"
                        style="padding: 10px 0"
                        clearable
                        required
                    ></el-input>

                    <div class="release-idle-container-picture">
                        <div class="release-idle-container-picture-title">上传广告图片</div>
                        <el-upload
                            action="http://localhost:8080/file/"
                            :on-preview="fileHandlePreview"
                            :on-remove="fileHandleRemove"
                            :on-success="fileHandleSuccess"
                            :show-file-list="showFileList"
                            :limit="1"
                            :file-list="fileList"
                            :on-exceed="handleExceed"
                            accept="image/*"
                            drag
                            multiple
                        >
                            <i class="el-icon-upload"></i>
                            <div class="el-upload__text">将图片拖到此处，或<em>点击上传</em></div>
                        </el-upload>

                        <div class="picture-list">
                            <el-image
                                style="width: 500px; height: 400px; margin-bottom: 2px"
                                fit="contain"
                                v-for="(img, index) in imgList"
                                :key="index"
                                :src="img"
                                :preview-src-list="imgList"
                            ></el-image>
                        </div>

                        <el-dialog :visible.sync="imgDialogVisible">
                            <img width="100%" :src="dialogImageUrl" alt="" />
                        </el-dialog>
                    </div>

                    <span slot="footer" class="dialog-footer">
                        <el-button type="primary" @click="addAdvButton">添加</el-button>
                    </span>
                </el-dialog>
            </div>
        </el-menu>

        <el-table v-if="this.mode == 1" :data="onlineAdv" stripe style="width: 100%; color: #5a5c61">
            <el-table-column prop="id" label="id" width="200"> </el-table-column>
            <el-table-column label="广告图片" width="150">
                <template slot-scope="scope">
                    <el-avatar shape="square" :size="23" :src="scope.row.path.slice(2, -2)"></el-avatar>
                </template>
            </el-table-column>
            <el-table-column prop="author" label="广告作者" width="300" show-overflow-tooltip> </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="mini" type="danger" @click="makeOfflineAdv(scope.$index)">下架</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-table v-show="this.mode == 2" :data="OfflineAdv" stripe style="width: 100%; color: #5a5c61">
            <el-table-column prop="id" label="id" width="200"> </el-table-column>
            <el-table-column label="广告图片" width="150">
                <template slot-scope="scope">
                    <el-avatar shape="square" :size="23" :src="scope.row.path.slice(2, -2)"></el-avatar>
                </template>
            </el-table-column>
            <el-table-column prop="author" label="广告作者" width="300" show-overflow-tooltip> </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="mini" type="danger" @click="deleteAdv(scope.$index)">永久删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <div class="block">
            <el-pagination
                @current-change="handleCurrentChange"
                :current-page.sync="nowPage"
                :page-size="8"
                background
                layout="prev, pager, next,jumper"
                :total="total"
            >
            </el-pagination>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Advertise',
    data() {
        return {
            adminRegVisible: false,
            imgDialogVisible: false,
            dialogImageUrl: '',
            showFileList: true,
            imgList: [],
            mode: 1,
            nowPage: 1,
            total: 0,
            onlineAdv: [],
            OfflineAdv: [],
            advInfo: {
                path: '',
                author: ''
            },
            fileList: []
        };
    },
    created() {
        this.getOnlineAdv();
    },
    methods: {
        handleCurrentChange(val) {
            this.nowPage = val;
            if (this.mode == 1) {
                this.getOnlineAdv();
            }
            if (this.mode == 2) {
                this.getOfflineAdv();
            }
        },
        handleSelect(val) {
            if (this.mode !== val) {
                this.mode = val;
                if (val == 1) {
                    this.nowPage = 1;
                    this.getOnlineAdv();
                }
                if (val == 2) {
                    this.nowPage = 1;
                    this.getOfflineAdv();
                }
            }
        },
        getOnlineAdv() {
            this.$api
                .getAdv({
                    status: 1,
                    page: this.nowPage,
                    nums: 8
                })
                .then((res) => {
                    if (res.status_code == 1) {
                        this.onlineAdv = res.data.list;
                        this.total = res.data.count;
                    } else {
                        this.$message.error(res.msg);
                    }
                })
                .catch((e) => {
                    console.log(e);
                });
        },
        getOfflineAdv() {
            this.$api
                .getAdv({
                    status: 2,
                    page: this.nowPage,
                    nums: 8
                })
                .then((res) => {
                    if (res.status_code == 1) {
                        this.OfflineAdv = res.data.list;
                        this.total = res.data.count;
                    } else {
                        this.$message.error(res.msg);
                    }
                })
                .catch((e) => {
                    console.log(e);
                });
        },
        makeOfflineAdv(i) {
            this.$api
                .updateAdv({
                    id: this.onlineAdv[i].id,
                    status: 2
                })
                .then((res) => {
                    if (res.status_code == 1) {
                        this.getOnlineAdv();
                    } else {
                        this.$message.error(res.msg);
                    }
                })
                .catch((e) => {
                    console.log(e);
                });
        },
        deleteAdv(i) {
            this.$api
                .updateAdv({
                    id: this.OfflineAdv[i].id,
                    status: 0
                })
                .then((res) => {
                    if (res.status_code == 1) {
                        this.getOfflineAdv();
                    } else {
                        this.$message.error(res.msg);
                    }
                })
                .catch((e) => {
                    console.log(e);
                });
        },

        fileHandleRemove(file, fileList) {
            console.log(file, fileList);
            for (let i = 0; i < this.imgList.length; i++) {
                if (this.imgList[i] === file.response.data) {
                    this.imgList.splice(i, 1);
                }
            }
        },
        fileHandlePreview(file) {
            console.log(file);
            this.dialogImageUrl = file.response.data;
            this.imgDialogVisible = true;
        },
        fileHandleSuccess(response, file, fileList) {
            console.log('file:', response, file, fileList);
            this.imgList.push(response.data);
        },
        handleExceed(files, fileList) {
            this.$message.warning(`限制1张图片，本次选择了 ${files.length} 张图，共选择了 ${files.length + fileList.length} 张图`);
        },
        clearFileList() {
            // 清空文件列表
            this.fileList = [];
        },

        addAdvButton() {
            this.advInfo.path = JSON.stringify(this.imgList);
            if (this.advInfo.author) {
                this.$api
                    .addAdv({ path: this.advInfo.path, author: this.advInfo.author })
                    .then((res) => {
                        if (res.status_code === 1) {
                            this.$message({
                                message: '发布成功！',
                                type: 'success'
                            });
                            console.log(res.data);
                            console.log('1');
                            this.getOnlineAdv();

                            // 清空对话框内容
                            this.advInfo.author = '';
                            this.imgList = [];

                            this.clearFileList();
                        } else {
                            this.$message.error('发布失败！' + res.msg);
                        }
                    })
                    .catch((e) => {
                        this.$message.error('请填！');
                        console.log(e);
                    });
                this.adminRegVisible = false;
            } else {
                this.$message.error('请填写完整信息！');
            }
        }
    }
};
</script>

<style >
.main-border {
    background-color: #fff;
    padding: 10px 30px;
    box-shadow: 0 1px 15px -6px rgba(0, 0, 0, 0.5);
    border-radius: 5px;
}
.block {
    display: flex;
    justify-content: center;
    padding-top: 15px;
    padding-bottom: 10px;
    width: 100%;
}
.addAdvButton {
    display: flex;
    justify-content: flex-end;
    align-items: center;
    height: 60px;
    outline: none;
}
.release-idle-container-picture {
    width: 500px;
    height: 400px;
    margin: 20px 0;
}
.release-idle-container-picture-title {
    margin: 10px 0;
    color: #555555;
    font-size: 14px;
}
.picture-list {
    margin: 20px 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100px;
}
.el-upload-dragger {
    width: 500px;
}
</style>