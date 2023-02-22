package com.amuse.framedynamic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @ClassName SecurityConfiguration
 * @Description TODO
 * @Author 刘培振
 * @Date 2022-12-05 14:34
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    //项目应用路径
    private final String adminContextPath = "";

//    public SecurityConfiguration(AdminServerProperties adminServerProperties) {
//        System.out.println(adminServerProperties.getContextPath());
//        this.adminContextPath = adminServerProperties.getContextPath();
//    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin")
                //.password("sadwewdsasw22112dsd")
                .roles("admin")
                .and()
                //.passwordEncoder(new BCryptPasswordEncoder())
                .and().build();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/");

        http.authorizeRequests()
                //无需登录即可访问
                .antMatchers(adminContextPath + "/assets/**").permitAll()
                .antMatchers(adminContextPath + "/login").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()

                //登录和登出路径
                .formLogin()
//                .loginPage(adminContextPath + "/login").successHandler(successHandler).and()
//                .logout().logoutUrl(adminContextPath + "/logout")
                .and()

                //开启http basic支持，admin-client注册时需要使用
                .httpBasic().and()
                .csrf()

                //开启基于cookie的csrf保护
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //忽略这些路径的csrf保护以便admin-client注册
                .ignoringAntMatchers(
                        adminContextPath + "/instances",
                        adminContextPath + "/actuator/**"
                );
        return http.build();

//        http
//                .httpBasic().and()//formLogin是默认登陆方式
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .logout();
//        return http.build();
    }
}
