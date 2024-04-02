package com.second.hand.trading.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Title: AdvModel
 * @Description:
 * @Author: localUser
 * @Version: 1.0
 * @create: 2024/3/21 23:08
 */
public class AdvModel {
    private Long id;

    private String path;

    private String author;

    /**
     * 状态（发布1、下架2、删除0）
     */
    private Byte status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvModel advModel = (AdvModel) o;
        return (this.getId() == null ? advModel.getId() == null : this.getId().equals(advModel.getId()))
                && (this.getPath() == null ?advModel.getPath() == null : this.getPath().equals(advModel.getPath()))
                && (this.getAuthor() == null ?advModel.getAuthor() == null : this.getAuthor().equals(advModel.getAuthor()))
                && (this.getStatus() == null ?advModel.getStatus() == null : this.getStatus().equals(advModel.getStatus()));


    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", path=").append(path);
        sb.append(", author=").append(author);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}
