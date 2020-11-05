package demo;

public class Kiemtra {
	private String[] result;
	//private RELAY[] status = new RELAY[4];
   // private String chuoi1, chuoi2;
    
	public Kiemtra() {
		super();
	}
	public Kiemtra(String[] result) {
	super();
	this.result = result;
	//this.status = status;
	}
//	public String[] getResult() {
//		return result;
//	}
//	public void setResult(String[] result) {
//		this.result = result;
//	}
	
//    public RELAY[] getStatus() {
//		return status;
//	}
//	public void setStatus(RELAY[] status) {
//		this.status = status;
//	}
	public RELAY[] kiemtra() {
		RELAY[] status = new RELAY[4];
    	for (int i=0;i<result.length;i++) {
    		if (result [i].equals("bat")) {
    			for (int j=0;j<result.length;j++) {
    				if (result[j].equals("quat")) {
    					status[0] = RELAY.RELAY1_ON;
    				}
    				if (result[j].equals("den")) {
    					status[1] = RELAY.RELAY2_ON;
    				}
    			}
    		}
    	}
    	for (int i=0;i<result.length;i++) {
    		if (result [i].equals("tat")) {
    			for (int j=0;j<result.length;j++) {
    				if (result[j].equals("quat")) {
    					status[2] = RELAY.RELAY1_OFF;
    				}
    				if (result[j].equals("den")) {
    					status[3] = RELAY.RELAY2_OFF;
    				}
    			}
    		}
    	}
    	return status;
	}
    }

