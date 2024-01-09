package org.fastcampus.oruryclient.auth.jwt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

//    @Value("${jwt.token-validity-in-seconds}")
//    private long accessExpirationTime;
//    private final long refreshExpirationTime = 86400000L * 30L; // 30일
//    private final Key key;
//
//    @Autowired
//    public JwtTokenProvider(@Value("${jwt.secret}") String secretKey) {
//        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//        this.key = Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    // JWT 토큰 생성
//    public JwtToken createJwtToken(String email, String authorities) {
//
//        Claims claims = Jwts.claims().setSubject(email);
//        claims.put("roles", authorities);
//
//        String accessToken = Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + accessExpirationTime))
//                .signWith(key, SignatureAlgorithm.HS256)
//                .compact();
//
//        String refreshToken = Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + refreshExpirationTime))
//                .signWith(key, SignatureAlgorithm.HS512)
//                .compact();
//
//        return JwtToken.of(accessToken, refreshToken);
//    }
//
//    // JWT 토큰에서 인증 정보 조회
//    public boolean validateAccessToken(String accessToken) {
//        try {
//            parseToken(accessToken);
//            return true;
//        } catch (final JwtException | IllegalArgumentException exception) {
//            return false;
//        }
//    }
//
//    private Claims parseToken(final String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    //해당 부분은 저도 잘 모릅니다 ㅠㅠ
//    // 토큰 정보 조회하고 권한을 추출해서 Authentication 객체를 리턴하는 메서드인 것 같습니다.
//    public Authentication getAuthenticationByAccessToken(String accessToken) {
//
//        Claims claims = parseToken(accessToken);
//
//        Collection<? extends GrantedAuthority> authorities =
//                Arrays.stream(claims.get("roles").toString().split(","))
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
//
//        UserDetails principal = new User(claims.getSubject(), "", authorities);
//        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
//    }
}
