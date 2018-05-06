package spring.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author 刘晨
 * @create 2018-03-17 20:30
 * To change this template use File | Settings | Editor | File and Code Templates.
 **/
@Configuration
@ComponentScan(basePackages = {"interview.app"},excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value = EnableWebMvc.class)} )
public class RootConfig {

}
