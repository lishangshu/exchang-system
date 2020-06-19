package com.fuxi.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpPost;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;

public class CookieUtil {

	/**
	 *  Get parameters from cookies.
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static String get(HttpServletRequest request, String cookieName)
	{
		String cookieValue="";
		try {
			cookieValue = URLEncoder.encode(cookieValue, "utf-8");
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals(cookieName)) {
						cookieValue = cookie.getValue();
						break;
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return cookieValue;
	}
	
	public static void set(HttpServletResponse response, String cookieName, String cookieValue, String domain)
	{
		Cookie cookie;
		try {
			
			cookieValue = URLEncoder.encode(cookieValue, "utf-8");
			cookie = new Cookie(cookieName, cookieValue);
			cookie.setPath("/");
			if(!StringUtils.isBlank(domain))
			{
				cookie.setDomain(domain);
			}
			response.addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void del(HttpServletRequest request, HttpServletResponse response, String cookieName, String domain){
		Cookie cookies[] = request.getCookies();
		if (cookies != null)
		{
			for (int i = 0; i < cookies.length; i++)
			{
				if (cookies[i].getName().equals(cookieName))
				{
					Cookie cookie = new Cookie(cookieName,"");
					cookie.setPath("/");
					if(!StringUtils.isBlank(domain))
					{
						cookie.setDomain(domain);
					}
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
	}

	/**
	 * Get the IP address from the request.
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if (ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")) {
//			Fetch the Natively configured IP based on the network card.
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ip = inet.getHostAddress();
			}
		}
		if (ip != null && ip.length() > 15) {
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}
		return ip;
	}

	/**
	 *  Get the parameters from the header
	 * @param request
	 * @param tokenName
	 * @return
	 */
	public  static String getAuthToken(HttpServletRequest request,String tokenName) {
		return request.getHeader(tokenName);
	}

}
