/**
 *
 * This exception is base for all custom exceptions
 *
 * @author henrique.oliveira
 * @version 1 Copyright: Copyright (c) 2019 Company: LifeScan IP Holdings, LLC This file contains
 *          trade secrets of LifeScan IP Holdings, LLC. No part may be reproduced or transmitted in
 *          any form by any means or for any purpose without the express written permission of
 *          LifeScan IP Holdings, LLC.
 */
package com.blog.blogservice.exception;

import com.blog.blogservice.util.ResponseErrorType;

/**
 * AbstractException for custom classes
 */
public abstract class AbstractException extends RuntimeException {
  private static final long serialVersionUID = -6695540703027954078L;

  private ResponseErrorType type;
  private String friendlyMessage;


  /**
   * @param msg
   */
  public AbstractException(final String msg) {
    super(msg);
  }

  public AbstractException(final String errorMsg, final String friendlyMessage) {
    super(errorMsg);
    this.friendlyMessage = friendlyMessage;
  }

  /**
   *
   * @param message
   * @param friendlyMessage
   * @param errorType
   */
  public AbstractException(final String message, final String friendlyMessage,
      final ResponseErrorType errorType) {
    super(message);
    this.friendlyMessage = friendlyMessage;
    type = errorType;
  }

  /**
   * @param errorMsg
   * @param err
   */
  public AbstractException(final String errorMsg, final Throwable err) {
    super(errorMsg, err);
  }

  /**
   * @return friendlyMessage
   */
  public String getFriendlyMessage() {
    return friendlyMessage;
  }

  /**
   * @return
   */
  public ResponseErrorType getType() {
    return type;
  }

  /**
   * @param friendlyMessage
   */
  public void setFriendlyMessage(final String friendlyMessage) {
    this.friendlyMessage = friendlyMessage;
  }

  /**
   * @param type
   */
  public void setType(final ResponseErrorType type) {
    this.type = type;
  }

}

