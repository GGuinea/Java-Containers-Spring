package pl.kontenery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.kontenery.model.request.JwtRequest;
import pl.kontenery.model.response.JwtResponse;
import pl.kontenery.util.JwtTokenUtil;

@CrossOrigin
@Controller
public class JwtAuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @PostMapping("/authenticate")
  public ResponseEntity<?> createJwtToken(@RequestBody JwtRequest request) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    return ResponseEntity.ok(new JwtResponse(jwtTokenUtil.generateToken(userDetails)));
  }
}
