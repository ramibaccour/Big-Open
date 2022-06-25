package big.open.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import big.open.security.services.UserDetailsServiceImpl;
import big.open.security.jwt.AuthEntryPointJwt;
import big.open.security.jwt.AuthTokenFilter;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() 
	{
		return new AuthTokenFilter();
	}
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception 
	{
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception 
	{
		return super.authenticationManagerBean();
	}
	@Bean
	public PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers(
				"/api/user/save",
				"/api/user/signin",
				"/api/test/**").permitAll()			
			.antMatchers("/api/test/**").permitAll()
			.anyRequest().authenticated();
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
//	@Autowired
//	UserDetailsServiceImpl userDetailsService;
//	@Autowired
//	private AuthEntryPointJwt unauthorizedHandler;
//	@Bean
//	public AuthTokenFilter authenticationJwtTokenFilter() 
//	{
//		return new AuthTokenFilter();
//	}
//	@Override
//	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception 
//	{
//		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception 
//	{
//		return super.authenticationManagerBean();
//	}
//	@Bean
//	public PasswordEncoder passwordEncoder() 
//	{
//		return new BCryptPasswordEncoder();
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception 
//	{
//		http.cors().and().csrf().disable()
//			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//			.authorizeRequests()
//			.antMatchers(	"api/fournisseur/findById/**",
//						 	"api/fournisseur/findByServiceAndCity",
//						 	"api/fournisseur/findBySearchTextAndIsArchived",
//						 	"api/fournisseur/findByServiceAndCityWithinAndIsArchived",
//						 	"api/service/findByIsArchived",
//						 	"api/article/findByFournisseurAndCategory",
//						 	"api/article/findById",
//						 	"api/payement/findByisArchived",
//						 	"api/payement/findById/**",
//						 	"api/commande/save",
//						 	"api/commande/findById",
//						 	"api/commande/findByClient",
//						 	"api/commande/findByLivreurAndEtat",
//						 	"api/user/findById",
//						 	"api/user/saveFullNameAndEmail",
//						 	"api/user/transfertPoint",
//						 	"api/user/changePassword",
//						 	"api/frais/findAll",
//						 	"api/promo/findByCodeAndUser",
//						 	"api/category/findByFournisseurAndIsArchived").hasAnyAuthority(ERole.ROLE_CLIENT.toString() )			
//			
//			.antMatchers(	"api/type/findByName",
//							"api/user/saveUser",
//							"api/user/findById",
//							"api/user/changePassword",
//							"api/user/delete/**",
//							"api/user/findByUsernameLikeAndEmailLikeAndFullNameLikeAndPhoneLikeAndRoleIdAndTypeIdAndIsArchived",
//							"api/article/findByNameLikeIgnoreCaseAndCategoryInAndFournisseurInAndIsArchived",
//							"api/article/delete/**",
//							"api/article/findById",
//							"api/article/save",
//							"api/article/upload",
//							"api/article/pathUpload",
//							"api/fournisseur/findByNameLikeIgnoreCaseAndPhoneLikeIgnoreCaseAndSpecialityLikeIgnoreCaseAndDisponibilityLikeIgnoreCaseAndCityLikeIgnoreCaseAndIsArchived",
//							"api/supplement/delete",
//							"api/supplement/save",
//							"api/supplement/findById",
//							"api/supplement/findByNameLikeIgnoreCaseAndFournisseurAndIsArchived",
//							"api/fournisseur/findById/**",
//							"api/fournisseur/save",
//							"api/fournisseur/delete",
//							"api/service/findByIsArchived",
//							"api/service/findByArchived",
//							"api/service/findById",
//							"api/service/save",
//							"api/service/delete/**",
//							"api/commande/findByEtatEndFournisseur",
//						 	"api/frais/findAll",
//						 	"api/frais/save",
//							"api/category/save",
//							"api/category/delete/**",
//							"api/category/findById/**",
//							"api/category/findByFournisseurAndIsArchived",
//							"api/category/findByNameLikeIgnoreCaseAndFournisseurAndIsArchived",
//							"api/home/save",
//							"api/home/findByIsArchived",							
//							"api/home/findById",							
//							"api/home/delete",
//							"api/promo/save",
//							"api/promo/delete/**",
//							"api/promo/findById",
//							
//							"api/promo/findByRemiseAndTypePromoAndSubTypePromoAndDateDebutBetweenAndDateFinBetweenAndIsArchived").hasAnyAuthority(ERole.ROLE_ADMIN.toString(), ERole.ROLE_FOURNISSEUR.toString())
//							
//			.antMatchers(	
//							"/uploads/files/**",
//							"/api/user/signinClient",
//							"/api/user/signinUser",
//							"/api/user/saveUserClient",
//							"/api/user/existsByPhone",
//							"/api/test/**").permitAll()
//			
//			.antMatchers(	"/api/commande/CommandeAffecterCommandeResponse",
//							"/api/commande/changeStateCommande",
//							"/api/positionsLivreurs/findByLivreurInAndCreatedAtBetween",
//							"/api/user/findByRoleIdAndIsArchived").hasAnyAuthority(ERole.ROLE_ADMIN.toString(), ERole.ROLE_DISPATCHER.toString())
//			
//			.antMatchers(	"/api/positionsLivreurs/save",
//							"/api/commande/changeStateCommande").hasAnyAuthority( ERole.ROLE_LIVREUR.toString())
//			
//			.anyRequest().authenticated();
//		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//		
//	}
}