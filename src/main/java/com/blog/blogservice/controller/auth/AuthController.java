package com.blog.blogservice.controller.auth;

import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.blog.blogservice.constant.ServiceUserConstants;
import com.blog.blogservice.exception.UnAuthorizedException;
import com.blog.blogservice.exception.UserNotFoundException;
import com.blog.blogservice.model.contract.request.LoginRequest;
import com.blog.blogservice.model.contract.response.Response;
import com.blog.blogservice.model.contract.response.ResponseError;
import com.blog.blogservice.service.auth.AuthService;
import com.blog.blogservice.util.ResponseErrorType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Validated
@RestController
@Api(value = "blog/auth", tags = "Auth")
public class AuthController {
  private static final String UNAUTHORIZED_KEY = "UNAUTHORIZED_USER";
  private final AuthService authService;

  public AuthController(final AuthService authService) {
    this.authService = authService;
  }

  /**
   * This endpoint is used to login user against crowd and return a token string.
   */
  @PostMapping(value = "/v1/authentication/login", produces = "application/json")
  @ApiOperation(value = "Authenticate user using credentials and return login token.",
      tags = "Blog Service")
  @ApiResponses({@ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
      @ApiResponse(code = 401, message = "Un Authorized", response = Response.class),
      @ApiResponse(code = 404, message = "User not found", response = Response.class),
      @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class)})
  public ResponseEntity<Response<String>> login(@Valid @RequestBody final LoginRequest requestBody,
      final HttpServletRequest request) {
    log.traceEntry("{}", requestBody);

    final Response<String> response = new Response<>();
    response.setPath(request.getServletPath());

    try {
      if (requestBody != null && StringUtils.isNotBlank(requestBody.getLoginId())
          && StringUtils.isNotBlank(requestBody.getPassword())) {
        log.info("Login method called with the these values: {}", requestBody.toString());

        final String token = authService.login(requestBody.getLoginId(), requestBody.getPassword());

        response.setResponse(token);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(ServiceUserConstants.SUCCESS);

        return log.traceExit(new ResponseEntity<>(response, HttpStatus.OK));
      } else {
        response.setMessage(HttpStatus.BAD_REQUEST);
        response.setStatus(HttpStatus.BAD_REQUEST.value());

        return log.traceExit(new ResponseEntity<>(response, HttpStatus.BAD_REQUEST));
      }
    } catch (final UnAuthorizedException e) {
      // Logged the error - info at Crowd service level
      response.setStatus(HttpStatus.UNAUTHORIZED.value());
      response.setErrors(Collections.singletonList(new ResponseError(e.getMessage(),
          e.getFriendlyMessage(), ResponseErrorType.UNAUTHORIZED)));

      return log.traceExit(new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED));
    } catch (final UserNotFoundException e) {
      // Logged the error - info at Crowd service level
      response.setStatus(HttpStatus.UNAUTHORIZED.value());
      response.setErrors(Collections
          .singletonList(new ResponseError(UNAUTHORIZED_KEY, "", ResponseErrorType.UNAUTHORIZED)));

      return log.traceExit(new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED));
    } catch (final Exception e) {
      log.error("Exception thrown while login :- ", e);

      response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      response.setMessage(ServiceUserConstants.INTERNAL_SERVER_ERROR_MSG);

      return log.traceExit(new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR));
    }
  }
}
