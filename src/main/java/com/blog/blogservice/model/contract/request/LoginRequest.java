package com.blog.blogservice.model.contract.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import com.blog.blogservice.constant.AnnotationConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/** Login Request */
@ApiModel(value = "LoginRequest", description = "Login Request Model")
@AllArgsConstructor()
@NoArgsConstructor
@Builder
@Data
public class LoginRequest {
  @NotEmpty
  @ApiModelProperty(example = "testuser@abc.com", required = true)
  private String loginId;

  @ApiModelProperty(example = "test1234", required = true)
  @ToString.Exclude
  @Pattern(regexp = AnnotationConstants.XSS_REGEX,
      message = AnnotationConstants.XSS_REGEX_ERROR_MESSAGE)
  private String password;
}
