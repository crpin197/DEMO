package demo;

public class Kiemtra {
	private String[] result;
   // private String chuoi1, chuoi2;
    
	public Kiemtra(String[] result) {
		super();
		this.result = result;
//		this.chuoi1 = chuoi1;
//		this.chuoi2 = chuoi2;
	}
	public String[] getResult() {
		return result;
	}
	public void setResult(String[] result) {
		this.result = result;
	}
    public RELAY kiemtra() {
    	RELAY status = null;
    	for (int i=0;i<result.length;i++) {
    		if (result [i].equals("bat")) {
    			for (int j=0;j<result.length;j++) {
    				if (result[j].equals("quat")) {
    					status = RELAY.RELAY1_ON;
    				}
    				if (result[j].equals("den")) {
    					status = RELAY.RELAY2_ON;
    				}
    			}
    		}
    	}
    	for (int i=0;i<result.length;i++) {
    		if (result [i].equals("tat")) {
    			for (int j=0;j<result.length;j++) {
    				if (result[j].equals("quat")) {
    					status = RELAY.RELAY1_OFF;
    				}
    				if (result[j].equals("den")) {
    					status = RELAY.RELAY2_OFF;
    				}
    			}
    		}
    	}
		return status;
	}
    }

