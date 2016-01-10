package pl.edu.agh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.inMemoryAuthentication().withUser("admin").password("admin1")
				.roles("SUPERADMIN");
		auth.inMemoryAuthentication().withUser("dispatcher").password("dispatcher1")
				.roles("DISPATCHER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/").hasAnyRole("SUPERADMIN", "DISPATCHER")
				.antMatchers("/manage/**").hasRole("SUPERADMIN")
				.antMatchers("/dispatcher/**").hasRole("DISPATCHER")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login").failureUrl("/login?error").loginProcessingUrl("/login")
				.permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
				.and().csrf();
	}
}