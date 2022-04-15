package dk.matzon.oauth.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeHttpRequests()
                    // allow index
                    .antMatchers("/").permitAll()

                    // require everything else to be authenticated
                    .anyRequest().authenticated()
                .and()

                // enable oauth2 login
                .oauth2Login();
        // @formatter:on
    }
}
