package com.centit.demo.authorizeserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


   /* @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }*/

    /*@Bean
    @Override
    protected UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user_1").password("{noop}123456").authorities("USER").build());
        manager.createUser(User.withUsername("user_2").password("{noop}123456").authorities("USER").build());
        manager.createUser(User.withUsername("client_1").password("{noop}123456").authorities("USER").build());
        manager.createUser(User.withUsername("client_2").password("{noop}123456").authorities("USER").build());
        return manager;
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*auth.inMemoryAuthentication().withUser("user_1").password("{noop}123456").authorities("USER")
                .and().withUser("user_2").password("{noop}123456").authorities("USER")
                .and().withUser("client_1").password("{noop}123456").authorities("CLIENT")
                .and().withUser("client_2").password("{noop}123456").authorities("CLIENT")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());//在此处应用自定义PasswordEncoder*/

        UserDetailsManager userDetailsService = auth.inMemoryAuthentication().getUserDetailsService();
        userDetailsService.createUser(User.withUsername("user_1").password("{noop}123456").authorities("USER").build());
        userDetailsService.createUser(User.withUsername("user_2").password("{noop}123456").authorities("USER").build());
        userDetailsService.createUser(User.withUsername("client_1").password("{noop}123456").authorities("CLIENT").build());
        userDetailsService.createUser(User.withUsername("client_2").password("{noop}123456").authorities("CLIENT").build());
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance());

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }
    /*
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        List<AuthenticationProvider> providerList = new ArrayList<>();
        providerList.add(authenticationProvider);
        return new ProviderManager(providerList);
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().anyRequest().fullyAuthenticated();
        http.formLogin().loginPage("/login").failureUrl("/login?error").permitAll();
        http.logout().permitAll();


        // @formatter:off
        http
                .requestMatchers().anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/*").permitAll();
        // @formatter:on
    }
}
