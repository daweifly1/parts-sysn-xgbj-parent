package cn.com.xgit.parts.rm.config;

import cn.com.xgit.parts.rm.mybatisplus.plugin.parser.handle.tenant.handle.DefaultStoreHandler;
import cn.com.xgit.platform.mybatis.autoconfigure.mybatisplus.plugin.parser.DefaultSqlParser;
import cn.com.xgit.platform.mybatis.autoconfigure.mybatisplus.plugin.parser.handle.data.DataRuleSqlParser;
import cn.com.xgit.platform.mybatis.autoconfigure.mybatisplus.plugin.parser.handle.logic.LogicDeleteSqlParser;
import cn.com.xgit.platform.mybatis.autoconfigure.mybatisplus.plugin.parser.handle.tenant.DefaultTenantSqlParser;
import cn.com.xgit.platform.mybatis.autoconfigure.mybatisplus.plugin.parser.intercept.filter.DefaultSqlParserFilter;
import com.baomidou.mybatisplus.core.parser.AbstractJsqlParser;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author f00lish
 * @version 2019-08-02
 * Created By IntelliJ IDEA.
 * Qun:530350843
 */
@Configuration
public class CommonConfig {

    @Bean
    public DefaultSqlParser defaultSqlParser() {
        List<AbstractJsqlParser> sqlParserList = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new DefaultTenantSqlParser();
        //换成store_id
        tenantSqlParser.setTenantHandler(new DefaultStoreHandler());
        sqlParserList.add(tenantSqlParser);
        //数据规则解析器
        sqlParserList.add(new DataRuleSqlParser());
        //逻辑删解析器
        sqlParserList.add(new LogicDeleteSqlParser());
        return new DefaultSqlParser(new DefaultSqlParserFilter(), sqlParserList);
    }

}
