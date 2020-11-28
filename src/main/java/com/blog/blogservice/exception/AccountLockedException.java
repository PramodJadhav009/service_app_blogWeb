package com.blog.blogservice.exception;

/**
 * AccountLockedException a checked exception.
 *
 */
public class AccountLockedException extends Exception {
  private static final long serialVersionUID = 1L;
  private static final String MSG = "ACCOUNT_LOCKED";

  /**
   * @param string
   */
  public AccountLockedException() {
    super(MSG);
  }
}
