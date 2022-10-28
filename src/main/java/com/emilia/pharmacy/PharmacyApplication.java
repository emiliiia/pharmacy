package com.emilia.pharmacy;

import com.emilia.pharmacy.service.sql.key.impls.SQLKeyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

@EnableWebSecurity
@SpringBootApplication
public class PharmacyApplication extends WebSecurityConfigurerAdapter {

    @Autowired
    SQLKeyServiceImpl service;
    public static void main(String[] args) {
        SpringApplication.run(PharmacyApplication.class, args);
    }

    @Bean
    PasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setPasswordEncoder(bcryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.service);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/forgotPassword").not().fullyAuthenticated()
                .antMatchers("/titleOfWork").permitAll()
                .antMatchers("/").not().fullyAuthenticated()

                //role sql table
                .antMatchers(HttpMethod.POST, "/ui/v1/postgreeSQL/role")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")

                //key sql table
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/key/createOwnerForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers(HttpMethod.POST, "/ui/v1/postgreeSQL/key/endCreateOwnerForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/key/createAdminForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers(HttpMethod.POST, "/ui/v1/postgreeSQL/key/endCreateAdminForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")

                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/key/createOperatorForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.POST, "/ui/v1/postgreeSQL/key/endCreateOperatorForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/key/createUserForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.POST, "/ui/v1/postgreeSQL/key/endCreateUserForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")

                .antMatchers("/ui/v1/postgreeSQL/key/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")

                //clients mongo table
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/clients/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/clients/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers("/ui/v1/mongoDB/clients/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")

                //clients sql table
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/clients/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/clients/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers("/ui/v1/postgreeSQL/clients/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")

                //drugs mongo table
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/drugs/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/drugs/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers("/ui/v1/mongoDB/drugs/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")

                //drugs sql table
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/drugs/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/drugs/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers("/ui/v1/postgreeSQL/drugs/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")

                //orders mongo table
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/orders/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/orders/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers("/ui/v1/mongoDB/orders/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")

                //orders sql table
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/orders/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/orders/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers("/ui/v1/postgreeSQL/orders/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")

                //manufacturers mongo table
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/manufacturers/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/manufacturers/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers("/ui/v1/mongoDB/manufacturers/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")

                //manufacturers sql table
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/manufacturers/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/manufacturers/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers("/ui/v1/postgreeSQL/manufacturers/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")

                //technologyBook mongo table
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/technologyBook/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/technologyBook/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers("/ui/v1/mongoDB/technologyBook/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")

                //technologyBook sql table
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/technologyBook/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/technologyBook/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers("/ui/v1/postgreeSQL/technologyBook/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")

                //components mongo table
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/components/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/components/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers("/ui/v1/mongoDB/components/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")

                .antMatchers("/ui/v1/mongoDB/components/editPriceForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_OPERATOR') or hasAuthority('OPERATOR')")
                .antMatchers("/ui/v1/mongoDB/components/editInStockForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_OPERATOR') or hasAuthority('OPERATOR')")
                //components sql table
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/components/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/components/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")
                .antMatchers("/ui/v1/postgreeSQL/components/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER')")

                .antMatchers("/ui/v1/postgreeSQL/components/editInStockForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_OPERATOR') or hasAuthority('OPERATOR')")
                .antMatchers("/ui/v1/postgreeSQL/components/editPriceForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_OPERATOR') or hasAuthority('OPERATOR')")
                //requestComponents mongo table
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/requestComponents/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.GET, "/ui/v1/mongoDB/requestComponents/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers("/ui/v1/mongoDB/requestComponents/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")

                .antMatchers("/ui/v1/mongoDB/requestComponents/editStatusForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN') or hasRole('ROLE_OPERATOR') or hasAuthority('OPERATOR') ")
                //requestComponents sql table
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/requestComponents/createForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.GET, "/ui/v1/postgreeSQL/requestComponents/endCreateForm")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")
                .antMatchers("/ui/v1/postgreeSQL/requestComponents/editForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN')")

                .antMatchers("/ui/v1/postgreeSQL/requestComponents/editStatusForm/{id}")
                .access("hasRole('ROLE_OWNER') or hasAuthority('OWNER') or hasRole('ROLE_ADMIN') or hasAuthority('ADMIN') or hasRole('ROLE_OPERATOR') or hasAuthority('OPERATOR') ")

                .antMatchers("/css/**",
                        "/img/**",
                        "/js/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/ui/v1/adminPage/", true)
                .failureUrl("/home")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/home")
                .permitAll()
                .and()
                .httpBasic();
    }
}
