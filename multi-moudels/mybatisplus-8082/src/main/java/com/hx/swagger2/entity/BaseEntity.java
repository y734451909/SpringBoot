package com.hx.swagger2.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 基础父类测试
 * </p>
 *
 * @author hubin
 * @since 2018-08-11
 */
@Data
@Accessors(chain = true)
public class BaseEntity {
    @TableId(
            type = IdType.AUTO
    )
    private Long id;
    @TableLogic
    private Integer deleted;
}
