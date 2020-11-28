
package com.blog.blogservice.model.contract.response;

import com.blog.blogservice.util.ResponseErrorType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseError
{

  /**
   * Generic error type related to http response type like BAD_REQUEST,
   * UN_AUTHORIZED
   */
  private ResponseErrorType type;

  /**
   * Specific error code of the error example USER_NOT_FOUND, INVALID_LENGTH
   */
  private String errorCode;

  /**
   * User friendly message for specific error like "user not found for given id"
   */
  private String message;

  public ResponseError(ResponseErrorType type, String message)
  {
    super();
    this.type = type;
    this.message = message;
  }

  @JsonCreator
  public ResponseError(@JsonProperty("errorCode") String errorCode,
      @JsonProperty("message") String message,
      @JsonProperty("errorType") ResponseErrorType errorType)
  {
    super();
    this.errorCode = errorCode;
    this.message = message;
    this.type = errorType;
  }
}