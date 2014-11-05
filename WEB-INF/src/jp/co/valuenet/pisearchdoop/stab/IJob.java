package jp.co.valuenet.pisearchdoop.stab;

/**
 * Job
 *
 */
public interface IJob {

	/**
	 * Job名を返す。<br>
	 *
	 * @return Job名
	 */
	String getName();

	/**
	 * Jobの進捗を返す。<br>
	 *
	 * @return JobProgress
	 */
	IJobProgress getProgress();

}
