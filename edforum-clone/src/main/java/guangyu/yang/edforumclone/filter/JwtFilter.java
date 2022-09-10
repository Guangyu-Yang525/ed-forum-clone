package guangyu.yang.edforumclone.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import guangyu.yang.edforumclone.services.JwtUtil;

public class JwtFilter extends OncePerRequestFilter {
    private JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
            final String authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader == null || authorizationHeader.isEmpty() || !authorizationHeader.startsWith("Bearer")) {
                filterChain.doFilter(request, response);
                return;
            }
            final String token = authorizationHeader.split(" ")[1].trim();
            if (!jwtUtil.validate(token)) {
                filterChain.doFilter(request, response);
                return;
            }
            String Email = jwtUtil.getEmail(token);
            UsernamePasswordAuthenticationToken userPassToken = new UsernamePasswordAuthenticationToken(Email, null, new ArrayList<>());
            userPassToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(userPassToken);
            filterChain.doFilter(request, response);
    }

}
