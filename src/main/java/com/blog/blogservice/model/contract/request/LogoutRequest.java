
package com.blog.blogservice.model.contract.request;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Login Request
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "LogoutRequest", description = "Logout Request Model")
public class LogoutRequest {
  
  @NotBlank
  @ApiModelProperty(example = "0LtczR0V2Y58poJq3Nza5Q00", required = true, value = "")
  private String authToken;
  
}
