package jp.co.valuenet.pisearchdoop.stab;


public class Stab_Answer{

	private int index;

	private String coment;

	public Stab_Answer(int index,String coment){
		this.index = index;
		this.coment = coment;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}


}
