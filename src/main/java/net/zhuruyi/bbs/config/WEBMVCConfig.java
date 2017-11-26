package net.zhuruyi.bbs.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Author :zhuruyi
 * @Description:
 * @Date:Create in 23:05 2017/11/20
 * @Modified By:
 */
@Configuration
public class WEBMVCConfig {

    /*public WebMvcConfigurer custorConfiger() {
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/static/**")
                        .addResourceLocations("classpath:/static/");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("").setViewName("index");
            }
        };

        return webMvcConfigurerAdapter;
    }*/
}
