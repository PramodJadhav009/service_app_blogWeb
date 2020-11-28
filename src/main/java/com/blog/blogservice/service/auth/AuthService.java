
package com.blog.blogservice.service.auth;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.blog.blogservice.exception.UnAuthorizedException;

/** Interface exposing methods for performing auth operations */
@Service
@Lazy
public interface AuthService {

  String login(String loginId, String password) throws UnAuthorizedException;


}
