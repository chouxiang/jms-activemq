package com.xzhang.response;

/**
 * <p>请求状态码和描述</p>
 * @author imant@outlook.com
 * @date 2016-9-9 上午10:22:33
 */
public enum RequestStatus {

	SERVICE("12", "服务超时,单个服务运行时间超过了规定的时间范围"),
	AUTHORITY("13", "商户缺少当前运行权限"),
	MECHANT_ID("14", "merchant_id无效或商家不存在"),
	SIGN("15", "请求中缺少签名参数"),
	SIGN_VALID("16", "无效的签名,签名校验失败"),
	VERSION("17", "缺少版本参数"),
	METHOD("18", "不存在的方法名"),
	REQUEST("19", "请求重复提交"),
	
	MOBILE("202", "手机号码为空"),
	COURSE("203", "产品为空"),
	PERIOD("204", "期数为空"),
	AMOUNT("205", "金额为空"),
	AMOUNT_VALID("206", "金额格式不正确"),
	RETURN_URL("207", "回调链接为空"),
	INVOICE("208", "invoice为空"),
	REQUEST_TIME("209", "request_time为空"),
	MOBILE_VALID("210", "手机格式不正确"),
	
	/** Http error code */
	DATAEXIST("505", "数据已存在"),
	REQUEST_OK("200", "成功"),
	UNKNOWN_ERROR("500", "未知错误"),
	METHOD_NOT_ALLOWED("405", "请求方法错误");
	
	
	private String code;
	private String desc;
	
	private RequestStatus(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public static String getDescByCode(String code) {
		RequestStatus[] values = RequestStatus.values();
		for (RequestStatus status : values) {
			if (status.getCode().equals(code)) {
				return status.getDesc();
			}
		}
		return null;
	}
}
