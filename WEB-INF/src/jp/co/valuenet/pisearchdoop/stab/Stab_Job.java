package jp.co.valuenet.pisearchdoop.stab;


public class Stab_Job implements IJob{


	private String jobName;

	public Stab_Job(String jobName){
		this.jobName = jobName;
	}


	@Override
	public String getName() {
		return jobName;
	}

	@Override
	public IJobProgress getProgress() {
		return null;
	}

}
