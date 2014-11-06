package jp.co.valuenet.pisearchdoop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.valuenet.pisearchdoop.common.BrowserChecker;
import jp.co.valuenet.pisearchdoop.common.BrowserChecker.Browser;

public class MainServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String forwardPage = "html/pisearchdoop.html";

		//対応するブラウザを設定する
		List<Browser> browserList = new ArrayList<Browser>();
		browserList.add(Browser.BROWSER_CHROME);
		browserList.add(Browser.BROWSER_FIREFOX);
		browserList.add(Browser.BROWSER_SAFARI);

		//使用するブラウザが対応しているかチェック
		if(!BrowserChecker.checkBrowser(browserList, req)){
			forwardPage = "html/incompatible.html";
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPage);
		dispatcher.forward(req, res);
	}

}
