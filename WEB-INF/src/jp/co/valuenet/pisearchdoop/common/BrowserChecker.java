package jp.co.valuenet.pisearchdoop.common;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class BrowserChecker {

	public enum Browser{
		/** ブラウザ不明 */
		BROWSER_UNKNOWN,
		/** ブラウザIE */
		BROWSER_IE,
		/** ブラウザFirefox */
		BROWSER_FIREFOX,
		/** ブラウザOpera */
		BROWSER_OPERA,
		/** ブラウザChrome */
		BROWSER_CHROME,
		/** ブラウザSafari */
		BROWSER_SAFARI,
		/** ブラウザNetscape */
		BROWSER_NETSCAPE;
	}

	public static boolean checkBrowser(List<Browser> browserList,HttpServletRequest request) {

		Browser browser = getBrowser(request);

		for (int i = 0; i < browserList.size(); i++) {
			if (browser == browserList.get(i)) {
				return true;
			}
		}

		return false;
	}

	 /**
	  * ブラウザの判定を行います。
	  * @param request {@link HttpServletRequest}
	  * @return ブラウザを表す文字列
	  */
	public static Browser getBrowser(HttpServletRequest request) {

	    String sUserAgent = request.getHeader("user-agent");

	    if ( isIE(sUserAgent) ) {
	        return Browser.BROWSER_IE;
	    }
	    if ( isFirefox(sUserAgent) ) {
	        return Browser.BROWSER_FIREFOX;
	    }
	    if ( isOpera(sUserAgent) ) {
	        return Browser.BROWSER_OPERA;
	    }
	    if ( isChrome(sUserAgent) ) {
	        return Browser.BROWSER_CHROME;
	    }
	    if ( isSafari(sUserAgent) ) {
	        return Browser.BROWSER_SAFARI;
	    }
	    if ( isNetscape(sUserAgent) ) {
	        return Browser.BROWSER_NETSCAPE;
	    }
	    return Browser.BROWSER_UNKNOWN;
	}


	/**
	  * ブラウザがIEであるかどうかの判定を行います。
	  * @param sUserAgent ユーザエージェント
	  * @return IEであるかどうか
	  */
	public static boolean isIE(String sUserAgent) {
	    Pattern pattern = Pattern.compile(".*((MSIE)+ [0-9]\\.[0-9]).*");
	    Matcher matcher = pattern.matcher(sUserAgent);
	    boolean bMatch = matcher.matches();
	    return bMatch;
	}


	/**
	  * ブラウザがFirefoxであるかどうかの判定を行います。
	  * @param sUserAgent ユーザエージェント
	  * @return Firefoxであるかどうか
	  */
	public static boolean isFirefox(String sUserAgent) {
	    Pattern pattern = Pattern.compile(".*((Firefox/)+[0-9]\\.[0-9]\\.?[0-9]?).*");
	    Matcher matcher = pattern.matcher(sUserAgent);
	    boolean bMatch = matcher.matches();
	    return bMatch;
	}


	/**
	  * ブラウザがOperaであるかどうかの判定を行います。
	  * @param sUserAgent ユーザエージェント
	  * @return Opereであるかどうか
	  */
	public static boolean isOpera(String sUserAgent) {
	    Pattern pattern = Pattern.compile(".*((Opera)+/? ?[0-9]\\.[0-9][0-9]?).*");
	    Matcher matcher = pattern.matcher(sUserAgent);
	    boolean bMatch = matcher.matches();
	    return bMatch;
	}


	/**
	  * ブラウザがChromeであるかどうかの判定を行います。
	  * @param sUserAgent ユーザエージェント
	  * @return Chromeであるかどうか
	  */
	public static boolean isChrome(String sUserAgent) {
	    Pattern pattern = Pattern.compile(".*((Chrome)+/?[0-9]\\.?[0-9]?).*");
	    Matcher matcher = pattern.matcher(sUserAgent);
	    boolean bMatch = matcher.matches();
	    return bMatch;
	}


	/**
	  * ブラウザがSafariであるかどうかの判定を行います。
	  * @param sUserAgent ユーザエージェント
	  * @return Safariであるかどうか
	  */
	public static boolean isSafari(String sUserAgent) {
	    Pattern pattern = Pattern.compile(".*((Version/)+[0-9]\\.?[0-9]?\\.?[0-9]? Safari).*");
	    Matcher matcher = pattern.matcher(sUserAgent);
	    boolean bMatch = matcher.matches();
	    return bMatch;
	}


	/**
	  * ブラウザがNetscapeであるかどうかの判定を行います。
	  * @param sUserAgent ユーザエージェント
	  * @return Netscapeであるかどうか
	  */
	public static boolean isNetscape(String sUserAgent) {
	    Pattern pattern = Pattern.compile(".*((Netscape)+[0-9]\\.[0-9][0-9]?).*");
	    Matcher matcher = pattern.matcher(sUserAgent);
	    boolean bMatch = matcher.matches();
	    return bMatch;
	}

}
