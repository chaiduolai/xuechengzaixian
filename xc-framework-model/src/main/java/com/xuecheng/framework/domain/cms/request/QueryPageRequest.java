package com.xuecheng.framework.domain.cms.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.http.protocol.RequestDate;

/**
 * @program: xcEduService01
 * @description: 请求模型
 * @author: Chai.duolai
 * @create: 2020-02-26 17:49
 **/
@Data
public class QueryPageRequest extends RequestDate {
    /**
     * 站点id
     */
    @ApiModelProperty("站点id")
    private String siteId;
    /**
     * 页面id
     */
    @ApiModelProperty("页面ID")
    private String pageId;
    /**
     * 页面名称
     */
    @ApiModelProperty("页面名称")
    private  String pageName;
    /**
     * 别名
     */
    @ApiModelProperty("页面别名")
    private String pageAliase;
    /**
     * 模板Id
     */
    @ApiModelProperty("模版id")
    private String templateId;
}