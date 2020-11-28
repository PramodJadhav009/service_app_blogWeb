
package com.blog.blogservice.exception;

import com.blog.blogservice.util.ResponseErrorType;

/**
 * BadRequestException a checked exception.
 */
public class BadRequestException extends AbstractException {
  public enum BadRequestErrorsCodes {
    INVALID_STATE_CODE, INVALID_ZIP_CODE, UPDATED_BY_USER_NOT_FOUND, PATIENT_ID_ALREADY_IN_USE, PRIMARY_HCP_NOT_FOUND, INVALID_PATIENT_CLINIC_STATUS, DEVICE_NOT_FOUND, EXPIRED_OTP_CODE, INVALID_OTP_CODE, EMAIL_HCP_NOT_UNIQUE, INVALID_DIABETES_TYPE_ASSOCIATION, INVALID_HCP_SUB_ROLE, HCP_NOT_FOUND, REQUIRED_FIELD, UPDATE_USER_EMAIL_ALREADY_IN_USE, CURRENT_PASSWORD_CANNOT_BE_NULL, INVALID_CURRENT_PASSWORD, NO_UPDATED_FIELD, HCP_FIRST_USE_PASSWORD_REQUIRED, HYDRA_INTEGRATION_ERROR, LOGIN_CHALLENGE_ID_REQUIRED, PATIENT_NOT_FOUND, CONFIGURATION_CODE_NOT_FOUND, INVALID_CROWD_USER, MFA_TOTP_SETUP_NOT_COMPLETE, HCP_EMAIL_NOT_CONFIRMED, GESTATIONAL_DIABETES_DOES_NOT_EXIST_FOR_MEN, DIABETES_TYPE_NOT_FOUND, LANGUAGE_NOT_FOUND, USER_NOT_FOUND, INVALID_EMAIL, THERAPY_TYPE_NOT_FOUND, CONF_CODE_AND_EMAIL_CONF_TIME_NOT_FOUND, CONF_CODE_NOT_FOUND, EMAIL_CONF_TIME_NOT_FOUND, EMAIL_ALREADY_CONFIRMED, INVALID_PARAMETER, PWD_RECOVERY_TOKEN_MISMATCH, PWD_RECOVERY_TOKEN_EXPIRED, CONFIRMATION_TOKEN_EXPIRED, INVALID_USER_TYPE, UNDERAGE_PATIENT, SOURCE_CANNOT_BLANK, AUTHORIZED_SOURCE_NOT_FOUND, PARTNER_NOT_FOUND, CLINIC_NOT_FOUND, PAGE_SIZE_NEGATIVE, PAGE_INDEX_NEGATIVE, PAGE_INDEX_OUT_OF_BOUNDS
  }

  private static final long serialVersionUID = 2078727074274057346L;

  private static final String MSG = "BAD_REQUEST";

  /**
   * Default constructor
   */
  public BadRequestException() {
    super(MSG);
    setType(ResponseErrorType.BAD_REQUEST);
  }

  /**
   * Throws an exception with a custom error code and a custom error message
   *
   * @param errorCode the error code, which is an enum value
   * @param friendlyMessage a custom human-readable error message
   */
  public BadRequestException(final BadRequestErrorsCodes errorCode, final String friendlyMessage) {
    super(errorCode.name());
    setType(ResponseErrorType.BAD_REQUEST);
    setFriendlyMessage(friendlyMessage);
  }

  /**
   * Throw exception when you need to send custom message to user as an error message along with
   * logging the actual exception.
   */
  public BadRequestException(final String errorMsg) {
    super(MSG);
    setType(ResponseErrorType.BAD_REQUEST);
    setFriendlyMessage(errorMsg);
  }

  public BadRequestException(final String friendlyMessage, final ResponseErrorType errorType) {
    super(MSG, friendlyMessage, errorType);
  }

  public BadRequestException(final String errorCode, final String friendlyMessage) {
    super(errorCode);
    setType(ResponseErrorType.BAD_REQUEST);
    setFriendlyMessage(friendlyMessage);
  }

  /**
   * Throw exception when you need to send custom message to user as an error message along with
   * logging the actual exception.
   */
  public BadRequestException(final String errorMsg, final Throwable err) {
    super(MSG, err);
    setType(ResponseErrorType.BAD_REQUEST);
    setFriendlyMessage(errorMsg);
  }
}
