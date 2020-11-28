
package com.blog.blogservice.service.auth;

import java.util.Random;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.blog.blogservice.exception.UnAuthorizedException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@Lazy
public class AuthServiceImpl implements AuthService {
  private final Random rnd = new Random();
  private final int leftLimit = 97; // letter 'a'
  private final int rightLimit = 122; // letter 'z'
  private final int targetStringLength = 10;

  public AuthServiceImpl() {}

  private String getRandomString() {
    final String generatedString = rnd.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    return generatedString;
  }

  /**
   * (non-Javadoc)
   *
   * @see AuthService#login(String, String)
   */
  @Override
  public String login(final String loginIdOrEmail, final String password)
      throws UnAuthorizedException {
    log.entry(loginIdOrEmail);

    /*
     * Getting the login id information using loginIdOrEmail and calling the crowd service to get
     * the token.
     */
    log.debug("Calling the Crowd service to get the token for the user {}", loginIdOrEmail);
    return log.traceExit(getRandomString());
  }
}
