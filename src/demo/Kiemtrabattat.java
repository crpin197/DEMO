package demo;


public class Kiemtrabattat extends Kiemtra {
	protected String chuoi;
	protected RELAY status;
	
	public Kiemtrabattat(String[] result, String chuoi, RELAY status) {
		super(result);
		this.chuoi = chuoi;
		this.status = status;
	}
	
	public String getChuoi() {
		return chuoi;
	}

	public void setChuoi(String chuoi) {
		this.chuoi = chuoi;
	}

	public RELAY getStatus() {
		return status;
	}

	public void setStatus(RELAY status) {
		this.status = status;
	}

	@Override
	public String Kiemtrahanhdong() {
		// TODO Auto-generated method stub
		for (int i=0;i<getResult().length;i++) {
			if (getResult()[i].equals("bat"))
				chuoi = getResult()[i];
			if (getResult()[i].equals("tat"))
				chuoi = getResult()[i];
		}
		
		return chuoi;
	}

	@Override
	public RELAY Kiemtrathutu() {
		// TODO Auto-generated method stub
		String device1 = "den";
		String device2 = "quat";
		
		for (int i=0;i<getResult().length;i++) {
			if (getResult()[i].equals(device1)) {
				switch(chuoi) {
				case "bat":
					status =RELAY.RELAY1_ON;
					break;
				case "tat":
					status = RELAY.RELAY1_OFF;
					break;
				}
			}
			if (getResult()[i].equals(device2)) {
				switch(chuoi) {
				case "bat":
					status =RELAY.RELAY2_ON;
					break;
				case "tat":
					status = RELAY.RELAY2_OFF;
					break;
				}
			}
		}
		return status;
	}

}
