package jp.co.valuenet.pisearchdoop.stab;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Stab_JobQueue implements IJobQueue{

	private Date date = new Date();
	private List<IJob> currentQueue = new ArrayList<IJob>();
	private List<IJob> oldList = new ArrayList<IJob>();

	public Stab_JobQueue(){


//		return "attempt_201003281328_0001_m_000001_0";


		Random r = new Random();

		Integer counter = 1;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHDD");
		String dateStr = format.format(this.date);

		for(Integer i = -1; i < r.nextInt(50); i++){
			String s = "attempt_" + dateStr + "_" + String.format("%1$04d", counter) + "_m_" + String.format("%1$06d", counter) + "_0";
			oldList.add(new Stab_Job(s));
			counter ++;
		}

		for(Integer i = -1; i < r.nextInt(5); i++){
			String s = "attempt_" + dateStr + "_" + String.format("%1$04d", counter) + "_m_" + String.format("%1$06d", counter) + "_0";
			currentQueue.add(new Stab_Job(s));
			counter ++;
		}


	}

	@Override
	public Date getDate() {
		return this.date;
	}

	@Override
	public List<IJob> getQueue() {
		return this.currentQueue;
	}

	@Override
	public List<IJob> getGarbageJobList() {
		return this.oldList;
	}

}
