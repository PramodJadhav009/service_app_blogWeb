package com.blog.blogservice.constant;

/** Service User constants file. */
public final class ServiceUserConstants {

  public static final String UTILITY_CLASSES_SHOULD_NOT_BE_INSTANTIATED =
      "Utility classes should not be instantiated.";
  public static final String REPOSITORY_SPECIFICATIONS_CLASSES_SHOULD_NOT_BE_INSTANTIATED =
      "Repository specifications classes should not be instantiated.";

  public static final String UPPER_CASE_LETTERS = "ABCDEFGHJKMNPQRSTUVWXYZ";
  public static final String LOWER_CASE_LETTERS = "abcdefghjkmnpqrstuvwxyz";
  public static final String NUMBERS = "23456789";
  public static final String SYMBOLS = "@#$%&*";
  public static final String SUCCESS = "Success";
  public static final String FAIL = "Fail";
  public static final String INTERNAL_SERVER_ERROR_MSG =
      "Error occured while processing. Please contact admin. ";
  public static final String PATIENT_SUBROLE = "SUBROLE1";
  public static final String ACCEPTED = "ACCEPTED";
  public static final String PRIMARY = "Primary";
  public static final String PROFESSIONAL = "PROFESSIONAL";

  public static final String INVALID_DIABETES_TYPE_FOR_MALE = "INVALID_USER_MALE_DIABETESTYPE";
  public static final String INVALID_LENGTH_USER_FIRST_NAME = "INVALID_LENGTH_USER_FIRSTNAME";
  public static final String INVALID_LENGTH_USER_LAST_NAME = "INVALID_LENGTH_USER_LASTNAME";
  public static final String INVALID_LENGTH_USER_MIDDLE_NAME = "INVALID_LENGTH_USER_MIDDLENAME";
  public static final String INVALID_LENGTH_USER_SUFFIX = "INVALID_LENGTH_USER_SUFFIX";
  public static final String INVALID_LENGTH_USER_EMAIL = "INVALID_LENGTH_USER_EMAILADDRESS";

  public static final String INVALID_FORMAT_USER_EMAIL = "INVALID_FORMAT_USER_EMAILADDRESS";
  public static final String INVALID_FORMAT_USER_LANGUAGE = "INVALID_FORMAT_USER_LANGUAGE";
  public static final String INVALID_USER_DATEOFBIRTH = "INVALID_USER_DATEOFBIRTH";
  public static final String INVALID_COUNTRY_ID = "INVALID_COUNTRY_ID";
  public static final String INVALID_FIRST_USE_COMPLETE = "INVALID_FIRST_USE_COMPLETE";
  public static final String INVALID_HCP_ID = "INVALID_HCP_ID";

  public static final String REQUIRED_HCP_ID = "REQUIRED_HCP_ID";
  public static final String REQUIRED_USER_FIRSTNAME = "REQUIRED_USER_FIRSTNAME";
  public static final String REQUIRED_USER_LANGUAGE = "REQUIRED_USER_LANGUAGE";
  public static final String REQUIRED_USER_COUNTRY = "REQUIRED_USER_COUNTRY";
  public static final String REQUIRED_USER_LASTNAME = "REQUIRED_USER_LASTNAME";
  public static final String REQUIRED_USER_GENDER = "REQUIRED_USER_GENDER";
  public static final String REQUIRED_DIABETES_CARE = "REQUIRED_DIABETES_CARE";
  public static final String REQUIRED_USER_DATEOFBIRTH = "REQUIRED_USER_DATEOFBIRTH";
  public static final String REQUIRED_USER_FROM = "REQUIRED_USER_FROM";
  public static final String REQUIRED_EMAIL_OR_ADDRESS = "REQUIRED_EMAIL_OR_ADDRESS";

  public static final String EMAIL_NOT_UNIQUE = "EMAIL_NOT_UNIQUE";
  public static final String DUPLICATE_EMR_ID = "DUPLICATE_EMR_ID";
  public static final String EMAIL_AND_EMR_ID_ALREADY_IN_USE = "EMAIL_AND_EMR_ID_ALREADY_IN_USE";

  public static final int PASSWORD_MAX_ALLOWED_LENGTH = 16;
  public static final int USERNAME_MAX_LASTNAME_LENGTH = 10;
  public static final int USER_FIRSTNAME_LENGTH = 75;
  public static final int USER_MIDDLENAME_LENGTH = 75;
  public static final int USER_LASTNAME_LENGTH = 75;
  public static final int USER_EMAIL_LENGTH = 75;
  public static final int USER_SUFFIX_LENGTH = 3;

  public static final int MIN_AGE = 18;
  public static final int MAX_AGE = 126;
  public static final int MIN_AGE_PEDIATRICS = 2;

  public static final String WEB = "Connect";
  public static final String MANGO = "Mango";

  public static final Long FOUR_TEEN_DAY_MILLIS = (long) (60 * 1000 * 60 * 24 * 14);

  public static final Long TWO_DAY_MILLIS = (long) (60 * 1000 * 60 * 24 * 2);

  public static final int SIX_DIGIT_RANDOM_NUMBER_BASE = 100000;
  public static final int SIX_DIGIT_RANDOM_NUMBER_MAX = 900000;

  public static final String PRIMARY_PHONE_NUMBER = "Primary";

  public static final String UTF_8_ENCODING = "UTF-8";

  public static final String LOGIN_CHALLENGE_INFO_URL = "/auth/requests/login/{loginChallengeId}";
  public static final String LOGIN_CHALLENGE_INFO_SCOPE_PROPERTY = "scope";
  public static final String LOGIN_CHALLENGE_INFO_STATE_PROPERTY = "state";
  public static final String LOGIN_CHALLENGE_INFO_LANG_ISO_PROPERTY = "lang_iso";
  public static final String LOGIN_CHALLENGE_INFO_CLIENT_ID_PROPERTY = "client_id";
  public static final String LOGIN_CHALLENGE_INFO_CLIENT_NAME_PROPERTY = "client_name";

  public static final String ACCEPT_CONSENT_CHALLENGE_URL =
      "/auth/requests/consent/{consentChallengeId}/accept";

  public static final String ACCEPT_LOGIN_CHALLENGE_URL =
      "/auth/requests/login/{loginChallengeId}/accept";
  public static final String CANCEL_LOGIN_CHALLENGE_URL =
      "/auth/requests/login/{loginChallengeId}/reject";
  public static final String OFFLINE_SCOPE = "offline";

  public static final String MIME_MULTIPART_SUBTYPE = "alternative";

  public static final String CROWD_MFA_SETUP_COMPLETE = "mfaSetupComplete";
  public static final String CROWD_MFA_TYPE = "mfaType";
  public static final String CROWD_CONNECTION_ERROR = "Error connecting to Crowd :-";
  public static final String CROWD_USER_NOT_FOUND = "user not found with given login id ";
  public static final String CROWD_CREATE_SOAP_ATTRIBUTE_CALL =
      "Calling createSoapAttribute with {} {} ";
  public static final String CROWD_EXCEPTION_WHILE_LOGIN = "Crowd exception thrown while login :- ";

  public static final String COGNITO_TEMP_PSWD = "#TempPwd@Lifescan#&&89ddwg[]a";
  public static final String COGNITO_FIXED_PSWD = "#Pwd@Lifescan#&&89ddwg[]a";
  public static final String COGNITO_TOKEN_KEY = "totpToken";
  public static final String COGNITO_SESSION_KEY = "sessionId";

  public static final String COGNITO_PSWD_KEY = "PASSWORD";
  public static final String COGNITO_USERNAME_KEY = "USERNAME";
  public static final String COGNITO_SECRET_HASH_KEY = "SECRET_HASH";
  public static final String COGNITO_NEW_PSWD_KEY = "NEW_PASSWORD";
  public static final String COGNITO_SMS_MFA_CODE = "SMS_MFA_CODE";
  public static final String COGNITO_SOFTWARE_TOKEN_MFA_CODE = "SOFTWARE_TOKEN_MFA_CODE";

  /** AWS Cognito email attribute key. */
  public static final String EMAIL = "email";

  public static final String EMAIL_VERIFIED = "email_verified";
  public static final String USERNAME = "username";

  public static final String RESET_PSWD_TOKEN = "custom:reset_pwd_token";
  public static final String RESET_PSWD_TIME = "custom:reset_pwd_time";
  public static final String CONF_TOKEN = "custom:confirmation_token";
  public static final String CONFIRMED = "custom:confirmed";
  public static final String CONF_TOKEN_TIME = "custom:conf_token_time";

  /**
   * The CONFIRMED custom attribute is configured in AWS to be a number of 1 digit. 0 means FALSE
   * (not confirmed) while 1 means TRUE (confirmed).
   */
  public static final String CONFIRMED_VALUE = "1";

  public static final String NOT_CONFIRMED_VALUE = "0";

  public static final String CALLING_USER_SERVICE_GET_HCP_INFO_BY_GUID =
      "Calling userService.getHCPInfoByGuid {}";

  public static final String HYDRA_SERVICE_CALL_EXECUTED_SUCCESS =
      "Hydra service call executed without errors";

  public static final int MFA_QRCODE_MIN_HEIGHT = 100;
  public static final int MFA_QRCODE_MAX_HEIGHT = 1000;
  public static final int MFA_QRCODE_MIN_WIDTH = 100;
  public static final int MFA_QRCODE_MAX_WIDTH = 1000;

  public static final String MFA_REGEX_CONFIGURATION_CODE = "^[0-9]{6,6}$";

  public static final String SIZE_ERROR_CODE = "SIZE";
  public static final String NOT_BLANK_ERROR_CODE = "NOTBLANK";
  public static final String EMAIL_ERROR_CODE = "EMAIL";
  public static final String NOT_NULL_ERROR_CODE = "NOTNULL";

  public static final String NOT_UNIQUE_USER_EMAIL_ADDRESS = "NOT_UNIQUE_USER_EMAIL_ADDRESS";
  public static final String NOT_UNIQUE_USER_EMAIL_ADDRESS_FRIENDLY_ERROR_MSG =
      "Email Address is not unique.";

  public static final String USER_NOT_FOUND_MESSAGE = "User with id '%s' could not be found";

  public static final String DEPENDENT_GUARDIAN_NOT_FOUND_MESSAGE =
      "None dependent guardian with id '%s' could be found";

  public static final String UNAUTHORIZED_USER_DEFAULT = "Incorrect username or password.";
  public static final String INVALID_CURRENT_PASS_MESSAGE =
      "User's current password does not match given value.";

  /** Name of the UOM report preference in the database. */
  public static final String REPORT_PREFERENCE_UOM = "UOM";

  /** hexadecimal id pattern to be validated */
  public static final String ID_REGEX = "^[0-9A-Fa-f]*$";
  /** Default message to return when a property has wrong size. */
  public static final String ID_SIZE_ERROR_MESSAGE = "must be 32 characters long";
  /** Default message to return when a validated property fails pattern validations. */
  public static final String CLINIC_ID_PATTERN_ERROR_MESSAGE = "must be a valid clinic id";
  /** Default message to return when a patient guid fails pattern validations */
  public static final String PATIENT_GUID_PATTERN_ERROR_MESSAGE =
      "must be a valid patient GUID (hexadecimal characters only)";

  /** Bean qualifier for clinic processor. */
  public static final String CLINIC_PROCESSOR = "CLINIC";
  /** Bean qualifier for patient processor. */
  public static final String PATIENT_PROCESSOR = "PATIENT";
  /** Bean qualifier for hcp processor. */
  public static final String HCP_PROCESSOR = "HCP";

  /** Maximum number of expression in a list to query Oracle databases. */
  public static final int ORACLE_MAXIMUM_NUMBER_OF_EXPRESSIONS_IN_LIST = 900;

  public static final String USER_EMAIL_ALREADY_CONFIRMED =
      "The user's email has been already confirmed.";
  public static final String PENDING = "PENDING";

  private ServiceUserConstants() {
    throw new IllegalStateException(UTILITY_CLASSES_SHOULD_NOT_BE_INSTANTIATED);
  }
}
