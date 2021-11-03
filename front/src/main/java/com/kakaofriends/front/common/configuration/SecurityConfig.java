package com.kakaofriends.front.common.configuration;

import com.kakaofriends.front.common.security.CustomLoginFailureHandler;
import com.kakaofriends.front.common.security.UserDetailsService;
import com.kakaofriends.front.common.social.FrontUserDetail;
import com.kakaofriends.front.common.social.SocialUsersDetailService;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.utils.LocaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;
import org.springframework.social.security.SpringSocialConfigurerForKakao;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.NONMEMBER;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	LocaleUtils localeUtils ;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/favicon.ico", "/_hcheck.hdn");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
				.ignoringAntMatchers("/kr/*/inimobile/*")
				.ignoringAntMatchers("/en/*/inimobile/*")
				.ignoringAntMatchers("/kr/*/paypal/*")
				.ignoringAntMatchers("/en/*/paypal/*")
				.ignoringAntMatchers("/order/**")
				.ignoringAntMatchers("/orderadddeli/**")
//				.ignoringAntMatchers("/uniqueIdCheck")
//				.ignoringAntMatchers("/**/basket/basket/*")
//				.ignoringAntMatchers("/**/order/*")
//				.ignoringAntMatchers("/*/mypage/wishlist/insert")
				.and()
			.authorizeRequests()
				//.antMatchers("/signin").permitAll()
				.antMatchers("/*/usr/findpwChange").permitAll()
				.antMatchers("/mypage/updateMyInfo").permitAll()
				.antMatchers("/member/welcome").permitAll()
				.antMatchers("/kakao/*").permitAll()
				.antMatchers("/order/**").permitAll()
				.antMatchers("/orderadddeli/**").permitAll()
				.antMatchers("/kr/*/inimobile/*").permitAll()
				.antMatchers("/en/*/inimobile/*").permitAll()
				.antMatchers("/kr/*/paypal/*").permitAll()
				.antMatchers("/en/*/paypal/*").permitAll()
				.antMatchers("/**/mypage/**").access("hasRole('USER')")
				.antMatchers("/**/order/shipping").access("hasRole('USER')")
			.and()
			.formLogin()
				.loginPage("/signin")
				.defaultSuccessUrl("/signin")
				.loginProcessingUrl("/login/authenticate")
				.failureHandler(new CustomLoginFailureHandler())
			.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.deleteCookies("JSESSIONID")
				//.deleteCookies("friends")
				.invalidateHttpSession(true)
			.and()
				.apply(getSpringSocialConfigurer());
		http.sessionManagement().maximumSessions(5);
		//http.sessionManagement().invalidSessionUrl("/signin?sessionExpired=true");
		//http.rememberMe().rememberMeServices(rememberMeServices());
		http.anonymous().principal(new FrontUserDetail(new Member().setEmail(NONMEMBER)));

	}
	/*@Autowired
	FindByIndexNameSessionRepository<ExpiringSession> sessionRepository;*/


	/*@Bean
	RememberMeServices rememberMeServices() {
		SpringSessionRememberMeServices rememberMeServices =
				new SpringSessionRememberMeServices();
		// optionally customize
		rememberMeServices.setAlwaysRemember(true);
		return rememberMeServices;
	}*/

	@Bean
	public SpringSocialConfigurerForKakao getSpringSocialConfigurer() {

	    return new SpringSocialConfigurerForKakao();
	}

	@Bean
	public SocialUserDetailsService socialUsersDetailService() {
		return new SocialUsersDetailService(userDetailsService);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
		return daoAuthenticationProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return userDetailsService;
	}


	/*@Bean
	static HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}*/


}