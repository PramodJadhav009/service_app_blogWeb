package com.blog.blogservice.exception;

import com.blog.blogservice.util.ResponseErrorType;

/**
 * InternalServerErrorException a checked exception.
 */
public class InternalServerErrorException extends AbstractException {
  public enum InternalServerErrorCodes {

    CROWD_ERROR, EXPECTED_PROPERTY_NOT_PRESENT_ON_HYDRA_RESPONSE, INTERNAL_SERVER_ERROR, COGNITO_ERROR
  }

  private static final long serialVersionUID = -8794756135558420354L;

  private static final String MSG = "INTERNAL_SERVER_ERROR";

  /**
   * Default constructor
   */
  public InternalServerErrorException() {
    super(MSG);
    setType(ResponseErrorType.SERVICE_ERROR);
  }

  public InternalServerErrorException(final InternalServerErrorCodes errorCode,
      final String friendlyMessage) {
    super(errorCode.toString());
    setType(ResponseErrorType.SERVICE_ERROR);
    setFriendlyMessage(friendlyMessage);
  }

  /**
   * Throw exception when you need to send custom message to user as an error message along with
   * logging the actual exception.
   *
   * @param errorMsg
   */
  public InternalServerErrorException(final String errorMsg) {
    super(MSG);
    setType(ResponseErrorType.SERVICE_ERROR);
    setFriendlyMessage(errorMsg);
  }

  /**
   * Throw exception when you need to set the response error type along with a custom error message
   *
   * @param friendlyMessage
   * @param errorType
   */
  public InternalServerErrorException(final String friendlyMessage,
      final ResponseErrorType errorType) {
    super(MSG, friendlyMessage, errorType);
  }

  /**
   * Throw exception when you need to set a custom error code and a custom error message
   *
   * @param errorCode
   * @param friendlyMessage
   */
  public InternalServerErrorException(final String errorCode, final String friendlyMessage) {
    super(errorCode);
    setType(ResponseErrorType.SERVICE_ERROR);
    setFriendlyMessage(friendlyMessage);
  }

  /**
   * Throw exception when you need to send custom message to user as an error message along with
   * logging the actual exception.
   *
   * @param errorMsg
   * @param err
   */
  public InternalServerErrorException(final String errorMsg, final Throwable err) {
    super(MSG, err);
    setType(ResponseErrorType.SERVICE_ERROR);
    setFriendlyMessage(errorMsg);
  }
}
