package sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrl {

    /**
     * 微信公众号授权url
     */
    public String wechatMpAuthorize;

    /**
     * 微信开放平台的授权Url
     */
    public String wechatOpenAuthorize;

    /**
     * 项目url
     */
    public String sell;
}
