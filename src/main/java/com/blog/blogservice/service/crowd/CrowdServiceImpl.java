package com.blog.blogservice.service.crowd;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
// @RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CrowdServiceImpl implements CrowdService {

  // private AuthenticatedToken appToken;

  @Value("${crowd.application.name}")
  private String crowdApplicationName;

  @Value("${crowd.application.password}")
  private String crowdApplicationPassword;

  @Value("${crowd.max.retry}")
  private Integer crowdMaxRetry;

  // private final CrowdClient crowdRestClient;

  /**
   * Authenticate login id and password from Crowd
   *
   * @param loginId - User's login id
   * @param password - User's password
   * @return - String containing user token detail
   */
  public String getApplicationToken(final String loginId, final String password) {
    log.entry(loginId);

    // try {
    // token = crowdRestClient.authenticateSSOUser(getUserAuthenticationContext(loginId, password));
    // } catch (final com.atlassian.crowd.exception.InactiveAccountException e) {
    // log.info(ServiceUserConstants.CROWD_EXCEPTION_WHILE_LOGIN, e);
    // throw new UnAuthorizedException(UnAuthorizedErrorsCodes.INACTIVE_ACCOUNT,
    // "User account is inactive");
    // } catch (final com.atlassian.crowd.exception.InvalidAuthenticationException e) {
    // log.info(ServiceUserConstants.CROWD_EXCEPTION_WHILE_LOGIN, e);
    // if (verifyUserAccountIsLocked(loginId))
    // throw new UnAuthorizedException(UnAuthorizedErrorsCodes.ACCOUNT_LOCKED,
    // CrowdConstants.USER_ACCOUNT_IS_LOCKED_MESSAGE);
    // else
    // throw new UnAuthorizedException(UnAuthorizedErrorsCodes.UNAUTHORIZED_USER,
    // "User is unauthorized");
    // } catch (com.atlassian.crowd.exception.ApplicationAccessDeniedException
    // | com.atlassian.crowd.exception.ExpiredCredentialException
    // | com.atlassian.crowd.exception.ApplicationPermissionException
    // | OperationFailedException e) {
    // log.info(ServiceUserConstants.CROWD_EXCEPTION_WHILE_LOGIN, e);
    // throw new UnAuthorizedException(UnAuthorizedErrorsCodes.UNAUTHORIZED_USER,
    // "User is unauthorized");
    // }
    // log.debug("Method name: getApplicationToken() -> Crowd Application Name: {}",
    // crowdApplicationName);
    return log.traceExit("");
  }

}
