
package com.blog.blogservice.constant;

public class ExceptionConstants {
  public static final String ERROR_VALIDATING_TOTP_CODE = "Error validating TOTP code.";

  private ExceptionConstants() {
    throw new IllegalStateException(
        ServiceUserConstants.UTILITY_CLASSES_SHOULD_NOT_BE_INSTANTIATED);
  }
}
