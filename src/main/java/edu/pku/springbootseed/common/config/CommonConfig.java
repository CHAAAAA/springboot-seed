package edu.pku.springbootseed.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

/**
 * MyBatisConfig
 *
 * @author wangyc
 * @since 2019/11/10
 */
@Configuration
public class CommonConfig {

    @Bean
    public FastJsonConfig fastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        fastJsonConfig.setDateFormat("yyyyMMdd HHmmss");
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        return fastJsonConfig;
    }
}

