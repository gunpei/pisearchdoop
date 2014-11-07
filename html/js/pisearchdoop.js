
//検索開始
function find() {

	//入力チェック
	if($('#key').val() == ""){
		alert("検索する数値を入力してください。");
		return;
	}
	if(!$('#key').val().match(/^[0-9\-]+$/)){
		alert("半角数値以外は入力できません。");
		return;
	}

	$("#findComment").html("検索処理を受け付けました。検索IDは「12345678」です。");

	$('#findId').val("12345678");

//	document.getElementById("findBtn").disabled = true;

}


//クリア
function clear() {

	alert("aa");

	$('#fintId').val("");
	document.getElementById("findBtn").disabled = false;
}

function statusOpen() {

	window.open('about:blank', 'statusWindow', 'width=600, height=600, menubar=no, toolbar=no, scrollbars=yes');

	document.statusForm.submit();
}



/**
 * 画面ロード時に実行する
 */
$(document).ready(function(){

	createTable();

});