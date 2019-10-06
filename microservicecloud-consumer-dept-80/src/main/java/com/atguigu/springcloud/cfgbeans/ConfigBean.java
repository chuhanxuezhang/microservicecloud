package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ZeroV on 2018/11/6.
 */

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced   //默认轮询算法
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        //return new RandomRule();   //随机算法
        return new RetryRule();   //如果有一个down掉，则在失效时间deadline之前不断的进行重试，如果超过了deadline还是没取到则会返回一个null。
    }

}
