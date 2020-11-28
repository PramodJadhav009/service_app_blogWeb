
package com.blog.blogservice.constant;

public class AnnotationConstants {

  public static final String NEW_PSWD_REGEX = "^(.(?! |\\s)(?<! |\\s)){8,16}$";
  public static final String NEW_PSWD_ERROR_MESSAGE =
      "must be between 8 and 16 characters long, and have no leading or trailing whitespaces.";

  public static final String NEW_PSWD_COMPLEXITY_REGEX = "^(?=.*\\d)(?=.*[a-zA-Z]).*$";
  public static final String NEW_PSWD_COMPLEXITY_ERROR_MESSAGE =
      "must contain at least one letter and one number.";

  /** Username pattern to be validated */
  public static final String USERNAME_REGEX = "^[A-Za-z0-9-.@_+{}~^*]*";

  /** Default message to return when a validated property has a not allowed character. */
  public static final String USERNAME_REGEX_ERROR_MESSAGE =
      "must contain only letters, numbers, hyphen, underscore, period, at sign, plus, brackets, tilde, circumflex or asterisk.";

  /** XSS pattern to be validated */
  public static final String XSS_REGEX = "[^<>\"=+]*";

  /** Default message to return when a validated property has XSS character. */
  public static final String XSS_REGEX_ERROR_MESSAGE =
      "must not contain angle brackets, double quotes, and equal or plus signs.";

  /** Name pattern to be validated */
  public static final String NAME_REGEX = "^[a-zA-Z0-9.'_\\-\\s]+$";

  /** Default message to return when a validated property has a not allowed character. */
  public static final String NAME_ERROR_MESSAGE =
      "must contain only letters, numbers, hyphen, space, quote, dot and space";

  /** Phone pattern to be validated */
  public static final String PHONE_REGEX = "^[0-9]+$";

  /** Default message to return when a validated property has a not allowed character. */
  public static final String PHONE_ERROR_MESSAGE = "must contain only numbers";

  /** Professional Id pattern to be validated */
  public static final String PROFESSIONAL_ID_REGEX = "^[a-zA-Z0-9\\-._,\\/\\s]+$";

  /** Default message to return when a validated property has a not allowed character. */
  public static final String PROFESSIONAL_ID_ERROR_MESSAGE =
      "must contain only letters, numbers, hyphen, dot, underscore, comma, slash or space";

  /** Zip code pattern to be validated */
  public static final String ZIP_CODE_REGEX = "^[a-zA-Z0-9]+$";

  /** Default message to return when a validated property has a not allowed character. */
  public static final String ZIP_CODE_ERROR_MESSAGE = "must contain only letters and numbers";

  /** Whitespace pattern to be validated */
  public static final String WHITESPACES_REGEX = "^\\S+$";

  /** Default message to return when a validated property has a whitespace character. */
  public static final String WHITESPACES_ERROR_MESSAGE = "must not have whitespaces";

  /** Leading whitespaces pattern to be validated. */
  public static final String LEADING_WHITESPACES_REGEX = "^[^ \\s].+$|^.{0,1}$|^[ \\s]+$";

  /** Default message to return when a validated property has leading whitespace character. */
  public static final String LEADING_WHITESPACES_ERROR_MESSAGE =
      "must not have leading whitespaces";

  /** Trailing whitespaces pattern to be validated. */
  public static final String TRAILING_WHITESPACES_REGEX = "^.+[^ \\s]$|^.{0,1}$|^[ \\s]+$";

  /** Default message to return when a validated property has trailing whitespace character. */
  public static final String TRAILING_WHITESPACES_ERROR_MESSAGE =
      "must not have trailing whitespaces";

  /** Email pattern to be validated */
  /*
   * LOCAL PART: Start with a single allowed char, except ".", followed by zero or more allowed
   * characters, not ending in "." or "@". All "." chars must be followed by at least one other
   * different allowed char
   * 
   * DOMAIN PART: Start with a single allowed char, except ".", followed by zero or more allowed
   * characters, not ending in ".". All "." chars must be followed by at least one other different
   * allowed char and the final group must be at least 2 other different allowed chars
   */
  public static final String EMAIL_PATTERN_REGEX =
      "^[a-zA-Z0-9+{}~^*_-]+(\\.[a-zA-Z0-9+{}~^*_-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9-]{2,}$";

  /** Default message to return when the email is not valid. */
  public static final String EMAIL_PATTERN_ERROR_MESSAGE = "must contain a valid email";

  /** Validation for source id pattern* */
  public static final String SOURCE_ID_PATTERN_REGEX =
      "[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}";

  /** Default message to return when source id is not valid * */
  public static final String SOURCE_ID_PATTERN_MESSAGE = "must be a valid source id";

  /** Default message to return when source id size is not valid * */
  public static final String SOURCE_ID_SIZE_MESSAGE = "must be a 36 characters long";

  /** Date pattern to be validated (1990-04-07) */
  public static final String VALID_DATE_REGEX =
      "^([0-9]{4})[.\\/-]([0][1-9]|[1][0-2])[.\\/-]([0][1-9]|[1|2][0-9]|[3][0|1])$";
  /** Default message to return when a validated date property is invalid. */
  public static final String VALID_DATE_ERROR_MESSAGE =
      "must contain a valid date format (YYYY-MM-DD)";

  private AnnotationConstants() {
    throw new IllegalStateException(
        ServiceUserConstants.UTILITY_CLASSES_SHOULD_NOT_BE_INSTANTIATED);
  }
}
