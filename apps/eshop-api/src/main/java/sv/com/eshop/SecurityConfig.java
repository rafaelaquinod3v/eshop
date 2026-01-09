package sv.com.eshop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http
            .httpBasic(withDefaults())
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth.requestMatchers("/h2-console/**").permitAll())
            .authorizeHttpRequests(auth -> auth.requestMatchers("/*.jpg", "/*.png", "/images/**").permitAll())
            .authorizeHttpRequests(auth -> auth.requestMatchers("/api/basket/**").permitAll().anyRequest().permitAll())
            // remover en prod
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .anonymous(anonymous -> anonymous.principal("anonymousUser").authorities("ROLE_ANONYMOUS"));
        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Creamos un usuario de prueba: "usuario_real" con password "12345"
        UserDetails user = User.builder()
            .username("usuario_real")
            .password(passwordEncoder().encode("12345"))
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
