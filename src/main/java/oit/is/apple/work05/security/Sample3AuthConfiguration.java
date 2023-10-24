package oit.is.apple.work05.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Sample3AuthConfiguration {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin(login -> login
        .permitAll())
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")) // ログアウト後に / にリダイレクト
        .authorizeHttpRequests(authz -> authz
            .requestMatchers(AntPathRequestMatcher.antMatcher("/sample5/**"))
            .authenticated() // /sample3/以下は認証済みであること
            .requestMatchers(AntPathRequestMatcher.antMatcher("/**"))
            .permitAll());// 上記以外は全員アクセス可能

    return http.build();
  }

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {

    // $ sshrun htpasswd -nbBC 10 customer1 yama
    UserDetails customer1 = User.withUsername("yama")
        .password("{bcrypt}$2y$10$qAaOt7BKhLiF83XSOO5HneHgyX3k1ZCD5kE4XNKGreZFp259HFdIS")
        .roles("CUSTOMER")
        .build();
    // $ sshrun htpasswd -nbBC 10 customer2 umi
    UserDetails customer2 = User.withUsername("umi")
        .password("{bcrypt}$2y$10$EUR/uVuOyPR.qVbs1LiOa.EL/fl3547XnErEsyO86yJ/6oFHuI7qa")
        .roles("CUSTOMER")
        .build();
    // $ sshrun htpasswd -nbBC 10 seller sora
    UserDetails seller = User.withUsername("sora")
        .password("{bcrypt}$2y$10$s8RhTVZCEePTyT9OR96oxOOw0vvGfIvV7vFXWd8B3bqo8N0l/MPD2")
        .roles("SELLER")
        .build();

    // 生成したユーザをImMemoryUserDetailsManagerに渡す（いくつでも良い）
    return new InMemoryUserDetailsManager(customer1, customer2, seller);
  }
}
