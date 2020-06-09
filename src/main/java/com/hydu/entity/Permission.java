package com.hydu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @TableField(value = "permission_id")
    private Integer permissionId;

    /**
     * 请求url
     */
    @TableField(value = "request_url")
    private String requestUrl;

    /**
     * 权限名称
     */
    @TableField(value = "permission_name")
    private String permissionName;

    /**
     * 权限标识
     */
    @TableField(value = "permission_status")
    private String permissionStatus;

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", requestUrl='" + requestUrl + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", permissionStatus='" + permissionStatus + '\'' +
                '}';
    }
}
