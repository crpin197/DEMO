package demo;

public abstract class Kiemtra {
	private String[] result; 
	public Kiemtra() {
		super();
	}
	public Kiemtra(String[] result) {
	super();
	this.result = result;
	}
	public String[] getResult() {
		return result;
	}
	public void setResult(String[] result) {
		this.result = result;
	}
	public abstract String Kiemtrahanhdong();
	public abstract RELAY Kiemtrathutu();
    }

