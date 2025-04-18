package on.thi.java6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/nhanVien/add").hasRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .httpBasic(httpBasic -> {}) // enable basic auth
                .csrf(csrf -> csrf.disable()); // disable csrf cho API

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password("{noop}pass") // không mã hoá mật khẩu
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }
}
