package edu.pku.springbootseed.common.config;

import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import edu.pku.springbootseed.common.model.ResultSetHashMap;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * desc
 *
 * @author wangyc
 * @since 2019/11/10
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration corsConfiguration = new CorsConfiguration();
//        /* 是否允许请求带有验证信息 */
//        corsConfiguration.setAllowCredentials(true);
//        /* 允许访问的客户端域名 */
//        corsConfiguration.addAllowedOrigin("*");
//        /* 允许服务端访问的客户端请求头 */
//        corsConfiguration.addAllowedHeader("*");
//        /* 允许访问的方法名,GET POST等 */
//        corsConfiguration.addAllowedMethod("*");
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);

        // 修改返回Map中的key为小写
        SerializeConfig serializationConfig = new SerializeConfig();
        NameFilter lowCaseNameFilter = new NameFilter() {
            @Override
            public String process(Object object, String name, Object value) {
                if (name == null || name.length() == 0) {
                    return name;
                }
                char[] chars = name.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    chars[i] = Character.toLowerCase(chars[i]);
                }
                return new String(chars);
            }
        };
        serializationConfig.addFilter(Map.class, lowCaseNameFilter);
        serializationConfig.addFilter(HashMap.class, lowCaseNameFilter);
        serializationConfig.addFilter(ResultSetHashMap.class, lowCaseNameFilter);
        serializationConfig.setPropertyNamingStrategy(PropertyNamingStrategy.SnakeCase);
        fastJsonConfig.setSerializeConfig(serializationConfig);

        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(0, fastConverter);
    }


}