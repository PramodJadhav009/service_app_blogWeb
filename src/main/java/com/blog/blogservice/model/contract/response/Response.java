package com.blog.blogservice.model.contract.response;

import java.time.Instant;
import java.util.List;
import org.springframework.http.HttpStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "Response", description = "encapsulates an api response")
public class Response<T> {

  /**
   * @param status - int http status of the reponse
   * @param errors - List of errors found
   */
  public Response(final int status, final List<ResponseError> errors) {
    super();
    this.status = status;
    this.errors = errors;
    setTimestamp();
  }

  /**
   * @param status - int http status of the reponse
   * @param message - message to be sent to user if any error is found
   */
  public Response(final int status, final Object message) {
    super();
    this.status = status;
    this.message = message;
    setTimestamp();
  }

  @ApiModelProperty(value = "The http response status", accessMode = AccessMode.READ_ONLY)
  private int status;


  private Object message;
  
  private List<ResponseError> errors;

  /** The body of the response. */
  @ApiModelProperty(value = "The body of the response.")
  private T response;

  @Builder.Default
  @ApiModelProperty(value = "The timestamp of  the response.")
  private String timestamp = Instant.now().toString();

  /** The path of the resource. */
  @ApiModelProperty(value = "The path of the resource.")
  private String path;

  public void setTimestamp() {
    this.timestamp = Instant.now().toString();
  }

  public static final Response<Void> succesOf(String path)
  {
    Response<Void> response = new Response<>();
    response.setPath(path);
    response.setTimestamp();
    response.setStatus(HttpStatus.OK.value());

    return response;
  }
}
