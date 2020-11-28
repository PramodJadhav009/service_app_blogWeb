
package com.blog.blogservice.exception;

import com.blog.blogservice.util.ResponseErrorType;

public class UnAuthorizedException extends AbstractException {
  public enum UnAuthorizedErrorsCodes {
    USER_NOT_FOUND, UNAUTHORIZED_USER, ACCOUNT_LOCKED, INACTIVE_ACCOUNT, TOTP_INVALID_CODE, TOTP_MISSING_TOKEN_KEY, TOTP_MISSING_SESSION_KEY, TOTP_TOKEN_EXPIRED, INVALID_VERIFICATION_CODE, TOTP_VERIFICATION_CODE_MISMATCH, INVALID_CONFIRMATION_CODE, EXPIRED_CONFIRMATION_TOKEN, INVALID_CURRENT_PASSWORD, PWD_RECOVERY_TOKEN_MISMATCH, PWD_RECOVERY_TOKEN_EXPIRED
  }

  private static final long serialVersionUID = 1L;
  private static final String MSG = "UNAUTHORIZED_USER";

  private boolean accountLocked;

  public UnAuthorizedException() {
    super(MSG);
  }

  public UnAuthorizedException(final String errorCode, final String friendlyMessage) {
    super(errorCode);
    setType(ResponseErrorType.UNAUTHORIZED);
    setFriendlyMessage(friendlyMessage);
  }

  /**
   * Throws an exception with a custom error code and a custom error message
   *
   * @param errorCode the error code, which is an enum value
   * @param friendlyMessage a custom human-readable error message
   */
  public UnAuthorizedException(final UnAuthorizedErrorsCodes errorCode,
      final String friendlyMessage) {
    super(errorCode.name());
    setType(ResponseErrorType.UNAUTHORIZED);
    setFriendlyMessage(friendlyMessage);
  }

  public boolean isAccountLocked() {
    return accountLocked;
  }

  public void setAccountLocked() {
    accountLocked = true;
  }
}
