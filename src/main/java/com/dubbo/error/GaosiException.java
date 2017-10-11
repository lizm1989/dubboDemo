package com.dubbo.error;



/**
 * 公共异常类.
 *
 *
 */
public class GaosiException extends RuntimeException {

    private static final long serialVersionUID = 7678391512213624975L;
	/**
	 * 异常错误代码
	 */
    private ErrorCode errorCode;

	/**
	 * 公共基础异常.
	 *
	 * @param errorCode 错误代码
	 * @param message 错误信息
	 */
	public GaosiException(final ErrorCode errorCode, final String message){
		super(message);
		this.errorCode = errorCode;
	}
	/**
	 * 公共基础异常.
	 *
	 * @param errorCode 错误代码
	 */
	public GaosiException(final ErrorCode errorCode){
		this.errorCode = errorCode;
	}
	/**
	 * 公共基础异常.
	 *
	 * @param message 错误信息
	 */
	@Deprecated
	public GaosiException(final String message){
		super(message);
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
