package com.hx.swagger2.toos;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import java.util.Optional;

@Validated
@ApiModel("分页参数对象")
public class PageParam extends AbstractApiParam {
    @ApiModelProperty(
            value = "页码,默认为1,最小为1",
            example = "1"
    )
    @Min(1L)
    private Integer pageNo;
    @ApiModelProperty(
            value = "页大小,默认为10，最小为10，最大为2000",
            example = "10"
    )
    @Range(
            min = 10L,
            max = 2000L
    )
    private Integer limit;
    @ApiModelProperty(
            value = "搜索字符串",
            example = ""
    )
    private String keyword;

    public void check() {
    }

    public Integer getPageNo() {
        this.pageNo = (Integer)Optional.ofNullable(this.pageNo).orElse(1);
        return this.pageNo;
    }

    public Integer getLimit() {
        this.limit = (Integer) Optional.ofNullable(this.limit).orElse(10);
        return this.limit;
    }

    public void setPageNo(final Integer pageNo) {
        this.pageNo = pageNo;
    }

    public void setLimit(final Integer limit) {
        this.limit = limit;
    }

    public void setKeyword(final String keyword) {
        this.keyword = keyword;
    }

    public PageParam() {
    }
}