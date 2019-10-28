package cn.com.xgit.parts.rm;

import cn.com.xgit.parts.rm.listener.ApplicationStartupListener;
import com.codingapi.txlcn.logger.helper.MysqlLoggerHelper;
import com.codingapi.txlcn.logger.helper.TxLcnLogDbHelper;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@EnableDistributedTransaction
@EnableFeignClients(basePackages = {"cn.com.xgit.platform.basic.feign", "cn.com.xgit.parts.rm"})
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"cn.com.xgit.parts.rm", "cn.com.xgit.platform.basic.feign"})
@EnableCaching
@MapperScan("${hcloud.mybatis.mapper-scan:cn.com.xgit.**.mapper}")
public class PartsBackSysnApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(PartsBackSysnApplication.class);
        springApplication.addListeners(new ApplicationStartupListener());
        springApplication.run(args);
    }

    @Bean
    public TxLcnLogDbHelper txLcnLoggerHelper() {
        MysqlLoggerHelper m = new MysqlLoggerHelper();

        return m;
    }

}
