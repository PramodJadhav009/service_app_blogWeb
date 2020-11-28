package com.blog.blogservice.exception;

import com.blog.blogservice.util.ResponseErrorType;

/**
 * UserNotFoundException a checked exception.
 */
public class UserNotFoundException extends BadRequestException {
  private static final long serialVersionUID = 1L;
  private static final String MSG = "USER_NOT_FOUND";

  /**
   * Default constructor
   */
  public UserNotFoundException() {
    super(MSG);
    setType(ResponseErrorType.USER_NOT_FOUND);
  }

  /**
   * Throw exception when you need to send custom message to user as an error message along with
   * logging the actual exception.
   *
   * @param friendlyErrorMsg
   */
  public UserNotFoundException(final String friendlyErrorMsg) {
    super(MSG, friendlyErrorMsg);
  }

  /**
   * Throw exception when you need to send custom message to user as an error message along with
   * logging the actual exception.
   *
   * @param errorMsg
   * @param err
   */
  public UserNotFoundException(final String errorMsg, final Throwable err) {
    super(MSG, err);
    setType(ResponseErrorType.USER_NOT_FOUND);
    setFriendlyMessage(errorMsg);
  }
}
