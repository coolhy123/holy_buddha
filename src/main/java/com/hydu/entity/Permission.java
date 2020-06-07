package com.hydu.entity;

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
    private Integer permissionId;

    /**
     * 请求url
     */
    private String requestUrl;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限标识
     */
    private String permissionStatus;


}
