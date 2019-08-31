package com.coco;

public class WXAthtUil {

	/**
	 * 
	 * @param appid  ���ںŵ�Ψһ��ʶappid
	 * @param redirect_uri  ��Ȩ���ض���Ļص����ӵ�ַ
	 * @param state  �Զ���״̬��  �ض��������state�����������߿�����дa-zA-Z0-9�Ĳ���ֵ�����128�ֽ�
	 * @return
	 */
	
	public String getAuthorize(String appid,String redirect_uri,String state) {
		
		if(appid==null || appid.trim().equalsIgnoreCase("")) {
			return "ȱʧ���ںŵ�Ψһ��ʶappid";
		}
		if(redirect_uri==null || redirect_uri.trim().equalsIgnoreCase("")) {
			return "ȱʧ�ص�·��";
		}
		if(state==null || state.trim().equalsIgnoreCase("")) {
			state = "WXAthtUil";
		}
		
		String AuthorizeURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=";
	 
		return "redirect:"+AuthorizeURL+appid+"&redirect_uri="+redirect_uri+"&response_type=code&scope=snsapi_base&state="+state+"&connect_redirect=1#wechat_redirect";
		
		
	}
	
	/**
	 * 
	 * @param appid  ���ںŵ�Ψһ��ʶ
	 * @param appsecret  ���ںŵ�appsecret
	 * @param code
	 * @param state
	 * @return
	 */
	public String getOpenid_access_token(String appid,String appsecret ,String code,String state) {
	 
		if(appid==null || appid.trim().equalsIgnoreCase("")) {
			return "ȱʧ���ںŵ�Ψһ��ʶappid";
		}
		if(appsecret==null || appsecret.trim().equalsIgnoreCase("")) {
			return "ȱʧ���ںŵ�appsecret";
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
