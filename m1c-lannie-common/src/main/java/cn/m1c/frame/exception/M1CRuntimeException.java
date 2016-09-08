package cn.m1c.frame.exception;

import cn.m1c.frame.constants.StatusCode;
import cn.m1c.frame.utils.StringUtil;

/**
 * @date 2016年7月27日
 * @description 异常基类，所有都为非强制检查异常
 * @author  phil --> E-mail: s@m1c.cn
 * @corp m1c softCo.,ltd
 * @since lannie
 */
public class M1CRuntimeException extends M1CBaseRuntimeException {
	
	private static final long serialVersionUID = 3864405014888201211L;
	
	private StatusCode statusCode;
	
	public M1CRuntimeException(StatusCode statusCode, String defaultMessage) {
		this(StringUtil.hasLength( defaultMessage ) ? defaultMessage : statusCode.getMessage());
		this.statusCode = statusCode;
	}
	
	public M1CRuntimeException(StatusCode statusCode) {
		this(statusCode.getMessage());
		this.statusCode = statusCode;
	}
	
	private M1CRuntimeException(String message) {
		super(message);
	}

	public StatusCode getStatusCode() {
		return statusCode;
	}


}
