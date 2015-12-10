package com.lib.transport;

public interface  BaseRequest {

	public String buildPath();
	
	public String Sign();
	
	public static final BaseRequest REQUEST = new BaseRequest() {
		
		public String buildPath() {
			return "DEFAULT";
		}
		
		public String Sign() {
			return null;
		}
	};
		
}
