package jp.co.valuenet.pisearchdoop.stab;

import java.util.List;


public class Stab_JobProgress {

	/** ステータス */
	private String status;

	/** 開始日時 */
	private String startDate;

	/** 終了日時 */
	private String finishDate;

	/** マップ進捗率 */
	private Double mapPer;

	/** レデュース進捗率 */
	private Double redPer;

	/** 結果のリスト */
	private List<Stab_Answer> answerList;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public Double getMapPer() {
		return mapPer;
	}

	public void setMapPer(Double mapPer) {
		this.mapPer = mapPer;
	}

	public Double getRedPer() {
		return redPer;
	}

	public void setRedPer(Double redPer) {
		this.redPer = redPer;
	}

	public List<Stab_Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Stab_Answer> answerList) {
		this.answerList = answerList;
	}

}
