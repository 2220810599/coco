package com.coco;

public class WXAthtUil {

	/**
	 * 
	 * @param appid  公众号的唯一标识appid
	 * @param redirect_uri  授权后重定向的回调链接地址
	 * @param state  自定义状态吗  重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
	 * @return
	 */
	
	public String getAuthorize(String appid,String redirect_uri,String state) {
		
		if(appid==null || appid.trim().equalsIgnoreCase("")) {
			return "缺失公众号的唯一标识appid";
		}
		if(redirect_uri==null || redirect_uri.trim().equalsIgnoreCase("")) {
			return "缺失回调路径";
		}
		if(state==null || state.trim().equalsIgnoreCase("")) {
			state = "WXAthtUil";
		}
		
		String AuthorizeURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=";
	 
		return "redirect:"+AuthorizeURL+appid+"&redirect_uri="+redirect_uri+"&response_type=code&scope=snsapi_base&state="+state+"&connect_redirect=1#wechat_redirect";
		
		
	}
	
	/**
	 * 
	 * @param appid  公众号的唯一标识
	 * @param appsecret  公众号的appsecret
	 * @param code
	 * @param state
	 * @return
	 */
	public String getOpenid_access_token(String appid,String appsecret ,String code,String state) {
	 
		if(appid==null || appid.trim().equalsIgnoreCase("")) {
			return "缺失公众号的唯一标识appid";
		}
		if(appsecret==null || appsecret.trim().equalsIgnoreCase("")) {
			return "缺失公众号的appsecret";
		}
		
		String URL_WECHAT_GET_OPENID = "https://api.weixin.qq.com/sns/oauth2/access_token";
	 
		
		StringBuilder sb = new StringBuilder(200);
		sb.append(URL_WECHAT_GET_OPENID);
		sb.append("?appid=").append(appid);
		sb.append("&secret=").append(appsecret);
		sb.append("&code=").append(code);
		sb.append("&grant_type=authorization_code");

		String 	stringuserinfo = CocoHttpSent.cocoSendGet(sb.toString()).toString(); 
 		
		return stringuserinfo;
		
	}
	
}
