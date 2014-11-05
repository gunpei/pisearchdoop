
//タイマー
var refreshTimer;

//検索開始
function findBtn() {

	//入力チェック
	if($('#key').val() == ""){
		alert("検索する数値を入力してください。");
		return;
	}
	if(!$('#key').val().match(/^[0-9\-]+$/)){
		alert("半角数値以外は入力できません。");
		return;
	}

	abortRefresh();


	//リモートオブジェクトの実行（第二引数はコールバック関数）
	JobProgressService.startPiSearch({
		callback: setProgress,
		errorHandler: onError
	});

	$("#loading").attr('src', 'img/loading.gif');

	document.getElementById("findBtn").disabled = true;

}

//検索状況取得
function load() {

	abortRefresh();

	// リモートオブジェクトの実行（第二引数はコールバック関数）
	JobProgressService.getJobProgress({
		callback: setProgress,
		errorHandler: onError
	});
}

//進捗状況を画面に表示
//コールバック関数の引数でリモートオブジェクトのreturn値を取得
function setProgress(bean) {

	// HTMLへデータを設定
	dwr.util.setValue("status", bean.status);
	dwr.util.setValue("startDate", bean.startDate);
	dwr.util.setValue("finishDate", bean.finishDate);

	if(bean.finishDate==""){
		refreshTimer = setTimeout(load, 500);
	}else{
		JobProgressService.getAnswer({
			callback: setAnswer,
			errorHandler: onError
		});
	}

}

//検索結果表示する
function setAnswer(bean){

	//行を全て削除
	$("#tablesorter > tbody").empty();

	var ansList = bean.answerList;

	for ( var i = tablebody.rows.length, len = ansList.length; i < len; i++) {
		var ans = ansList[i];
		printData(ans,i);
	}

	//ソート機能を削除
	$('#tablesorter th').unbind();
	//ソート機能付きテーブルを再生成
	$("#tablesorter").tablesorter({
		widgets: ['zebra']
	});
	//キャッシュ対策
	$('#tablesorter').trigger("update");

	$("#loading").attr('src', 'img/loading_blank.png');
}



//取得したデータを反映させる
function printData(ans,no) {

	var table = document.getElementById("tablebody");

	var row = table.insertRow(-1);

	var cell1 = row.insertCell(-1);
	var cell2 = row.insertCell(-1);
	var cell3 = row.insertCell(-1);

	cell1.appendChild(document.createTextNode(no+1));
	cell2.appendChild(document.createTextNode(ans.index));
	cell3.appendChild(document.createTextNode(ans.coment));

}

//エラーが発生した際呼び出される関数
function onError(errMsg) {
	abortRefresh();
	alert(errMsg);
	alert("サーバー側でエラーが発生しました。");
	clearBtn();
}

//リフレッシュを中止する
function abortRefresh() {
	if (refreshTimer) {
		clearTimeout(refreshTimer);
		refreshTimer = null;
	}
}

//クリア
function clearBtn() {

	abortRefresh();

	$('#key').val("");
	$('#status').empty();
	$('#startDate').empty();
	$('#finishDate').empty();
	document.getElementById("findBtn").disabled = false;
	$("#loading").attr('src', 'img/loading_blank.png');
	createTable();
}

//初期表示のテーブルを生成する。
function createTable(){

	//行を全て削除
	$("#tablesorter > tbody").empty();
	$('#tablesorter th').unbind();

	for(var i = 0 , len = 16; i < len; i++){

		var table = document.getElementById("tablebody");
		var row = table.insertRow(-1);
		var cell1 = row.insertCell(-1);
		var cell2 = row.insertCell(-1);
		var cell3 = row.insertCell(-1);

		cell1.appendChild(document.createTextNode("　"));
		cell2.appendChild(document.createTextNode("　"));
		cell3.appendChild(document.createTextNode("　"));
	}

	//ソート機能付きテーブルを生成
	$("#tablesorter").tablesorter({
		widgets: ['zebra']
	});

}

/**
 * 画面ロード時に実行する
 */
$(document).ready(function(){

	if(isSupported(['chrome','firefox','safari'])){
		alert("対応している")
	}else{
		alert("対応していない")
		history.back();
	}

	createTable();

});


/**
 *  ブラウザ名を取得
 *
 *  @return     ブラウザ名(ie6、ie7、ie8、ie9、ie10、ie11、chrome、safari、opera、firefox、unknown)
 *
 */
var getBrowser = function(){
    var ua = window.navigator.userAgent.toLowerCase();
    var ver = window.navigator.appVersion.toLowerCase();
    var name = 'unknown';

    if (ua.indexOf("msie") != -1){
        if (ver.indexOf("msie 6.") != -1){
            name = 'ie6';
        }else if (ver.indexOf("msie 7.") != -1){
            name = 'ie7';
        }else if (ver.indexOf("msie 8.") != -1){
            name = 'ie8';
        }else if (ver.indexOf("msie 9.") != -1){
            name = 'ie9';
        }else if (ver.indexOf("msie 10.") != -1){
            name = 'ie10';
        }else{
            name = 'ie';
        }
    }else if(ua.indexOf('trident/7') != -1){
        name = 'ie11';
    }else if (ua.indexOf('chrome') != -1){
        name = 'chrome';
    }else if (ua.indexOf('safari') != -1){
        name = 'safari';
    }else if (ua.indexOf('opera') != -1){
        name = 'opera';
    }else if (ua.indexOf('firefox') != -1){
        name = 'firefox';
    }
    return name;
};


/**
 *  対応ブラウザかどうか判定
 *
 *  @param  browsers    対応ブラウザ名を配列で渡す(ie6、ie7、ie8、ie9、ie10、ie11、chrome、safari、opera、firefox)
 *  @return             サポートしてるかどうかをtrue/falseで返す
 *
 */
var isSupported = function(browsers){
    var thusBrowser = getBrowser();
    for(var i=0; i<browsers.length; i++){
        if(browsers[i] == thusBrowser){
            return true;
            exit;
        }
    }
    return false;
};