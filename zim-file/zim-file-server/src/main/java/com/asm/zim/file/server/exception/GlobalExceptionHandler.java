package com.asm.zim.file.server.exception;

import com.asm.zim.common.constants.Result;
import com.asm.zim.common.constants.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author : azhao
 * @description
 */
@Order
@ControllerAdvice
@Component
@ResponseBody
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Result<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		logger.error("400 参数解析异常", e);
		e.printStackTrace();
		return new Result<String>().failure(ResultCode.Argument_Error);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Result<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		e.printStackTrace();
		return new Result<String>().failure(ResultCode.Request_Method_Error);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public Result<String> missingServletRequestParameterException(MissingServletRequestParameterException e) {
		e.printStackTrace();
		return new Result<String>().failure(ResultCode.Missing_Argument_Error);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(Exception.class)
	public Result<String> handleException(Exception e) {
		logger.error("500 服务运行异常", e);
		e.printStackTrace();
		return new Result<String>().failure(ResultCode.Service_Error);
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(QueryTimeoutException.class)
	public Result<String> queryTimeoutException(QueryTimeoutException e) {
		logger.error("redis 连接超时 ", e);
		e.printStackTrace();
		return new Result<String>().failure(ResultCode.Redis_Time_Out);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(FileServerTimeOutException.class)
	public Result<String> fileServerTimeOutException(FileServerTimeOutException e) {
		logger.error("文件服务器 连接超时 ", e);
		e.printStackTrace();
		return new Result<String>().failure(ResultCode.Redis_Time_Out);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(RedisConnectionFailureException.class)
	public Result<String> redisConnectionFailureException(RedisConnectionFailureException e) {
		logger.error("redis 连接失败 ", e);
		e.printStackTrace();
		return new Result<String>().failure(ResultCode.Redis_Connect_Failure);
	}
}
