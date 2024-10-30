package org.example.springboottest.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at", nullable = false )
    private LocalDateTime createdAt; // SQL의 datetime이 JAVA의 DateTime과 호환

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public User(String email, String password, LocalDateTime createdAt) {
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }


    // cf) UserDetails 인터페이스
    //  : 사용자의 인증 정보를 담고 있는 객체를 정의하는 인터페이스
    //  : Spring Security가 사용자의 권한 및 인증 관련 정보를 확인할 때 사용

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 사용자가 가지고있는 권한(roles) 목록을 반환
        // EX) 일반 사용자, 관리자, 임원 등의 권한이 있을 경우 가지고 있는 권한을 모두 반환
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정 만료 여부 반환
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠금 여부 반환
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 패스워드 만료 여부 반환
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 계정 사용 가능 여부 반환
        return true;
    }
}
