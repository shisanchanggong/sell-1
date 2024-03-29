package sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * wechatAccount
 * @author totalo
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    private String openAppId;

    private String openAppSecret;

    /**商户号*/
    private String mchId;

    /**商户密匙*/
    private String mchKey;

    /**商户证书路径*/
    private String keyPath;

    /**微信异步通知地址*/
    private String notifyPath;

    private Map<String, String> templateId;
}
