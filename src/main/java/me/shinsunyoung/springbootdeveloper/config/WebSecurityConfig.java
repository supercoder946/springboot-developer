package me.shinsunyoung.springbootdeveloper.config;

//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class WebSecurityConfig {
//
//  private final UserDetailService userService;
//
//  @Bean
//  public WebSecurityCustomizer configure(){
//    return (web) -> web.ignoring()
//            .requestMatchers(toH2Console())
//            .requestMatchers(new AntPathRequestMatcher("/static/**"));
//  }
//
//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//    return http
//            .authorizeHttpRequests(auth -> auth
//                    .requestMatchers(
//                            new AntPathRequestMatcher("/login"),
//                            new AntPathRequestMatcher("/signup"),
//                            new AntPathRequestMatcher("/user")
//                    ).permitAll().anyRequest().authenticated())
//            .formLogin(formLogin -> formLogin
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/articles"))
//            .logout(logout -> logout
//                    .logoutSuccessUrl("/login")
//                    .invalidateHttpSession(true))
//            .csrf(AbstractHttpConfigurer::disable)
//            .build();
//  }
//
//  @Bean
//  public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailsService) throws Exception{
//    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//    authProvider.setUserDetailsService(userService);
//    authProvider.setPasswordEncoder(bCryptPasswordEncoder);
//    return new ProviderManager(authProvider);
//  }
//
//  @Bean
//  public BCryptPasswordEncoder bCryptPasswordEncoder(){
//    return new BCryptPasswordEncoder();
//  }
//}
