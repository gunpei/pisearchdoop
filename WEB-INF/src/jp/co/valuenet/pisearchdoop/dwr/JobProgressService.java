package jp.co.valuenet.pisearchdoop.dwr;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import jp.co.valuenet.pisearchdoop.stab.Stab_Answer;
import jp.co.valuenet.pisearchdoop.stab.Stab_JobProgress;

public class JobProgressService {

	//テスト用
	int count;

	Stab_JobProgress jp = new Stab_JobProgress();

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	Random r = new Random();

	public void init(){
		jp.setStatus("検索開始");
		jp.setStartDate(sdf.format(new Date()));
		jp.setFinishDate("");
		jp.setMapPer(0.0);
		jp.setRedPer(0.0);
		count=0;
	}

	public Stab_JobProgress startPiSearch () throws InterruptedException {

		init();

		return jp;
	}

	public Stab_JobProgress getJobProgress () {

		count++;

		if(count<=10){
			jp.setMapPer(count * 10.0);
		}else if(count <= 20){
			jp.setRedPer((count - 10) * 10.0);
		}

		if(count < 20){
			jp.setStatus("検索中");
		}else{
			jp.setStatus("検索終了");
			jp.setFinishDate(sdf.format(new Date()));
		}

		return jp;
	}

	public Stab_JobProgress getAnswer () {

		List<Stab_Answer> ansList = new ArrayList<Stab_Answer>();

		for(int i=0;i<1000;i++){

			String memo;

			if(Math.random()*10 < 3){
				memo = "仮想マシン１が発見！";
			}else if(Math.random()*10 < 7){
				memo = "仮想マシン２が発見！";
			}else{
				memo = "仮想マシン３が発見！";
			}

			ansList.add(new Stab_Answer((int) (Math.random() * 10000), memo));

		}

		jp.setAnswerList(ansList);

		return jp;
	}

}
