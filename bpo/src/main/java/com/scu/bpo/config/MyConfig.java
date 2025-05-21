package com.scu.bpo.config;

// import com.alibaba.druid.pool.DruidDataSource;
// import com.alibaba.druid.support.http.StatViewServlet;
// import com.alibaba.druid.support.http.WebStatFilter;
import com.scu.bpo.component.LoginInterceptor;
import com.scu.bpo.component.RoleInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("index").setViewName("pages/front/login");
        registry.addViewController("/").setViewName("pages/front/login");
        registry.addViewController("/index.html").setViewName("pages/front/login");
        registry.addViewController("/register.html").setViewName("pages/front/register");
        registry.addViewController("/register").setViewName("pages/front/register");
        registry.addViewController("/listPage").setViewName("pages/front/bpo_main/bpo_list2");
        registry.addViewController("/addNewProject").setViewName("pages/front/bpo_main/PublishProject");
        registry.addViewController("/employer_basis_info").setViewName("pages/front/personal_info/employer_basis_info");
        registry.addViewController("/examineProject").setViewName("pages/back/examineProject");
        registry.addViewController("/viewProject").setViewName("pages/front/bpo_main/ViewProject");
        registry.addViewController("/CompetitiveBidding").setViewName("pages/front/bpo_employee/CompetitiveBidding");
        registry.addViewController("/EmployerProject").setViewName("pages/front/bpo_employer/EmployerProject");
        registry.addViewController("/BiddingScheme").setViewName("pages/front/bpo_employer/BiddingScheme");
        registry.addViewController("/ShowScheme").setViewName("pages/front/bpo_employer/ShowScheme");
        registry.addViewController("/EmployerOrder").setViewName("pages/front/bpo_employer/EmployerOrder");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index", "/", "/index.html",
                        "/register.html", "/register",
                        "/pages/front/login", "/pages/front/register",
                        "/static/**");
        registry.addInterceptor(new RoleInterceptor())
                .addPathPatterns("/Desk");
    }
/*
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet servlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(servlet, "/druid/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.icp,/druid/*");
        return filterRegistrationBean;
    }

 */
}
