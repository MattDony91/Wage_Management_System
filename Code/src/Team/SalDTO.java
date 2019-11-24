package Team;

public class SalDTO {
	private int getSal;
	private int getbasicPay;
	private int getcerPay;
	private int getcarPay;
	public String getGetCERSER() {
		return getCERSER;
	}
	public void setGetCERSER(String getCERSER) {
		this.getCERSER = getCERSER;
	}
	private String getCERSER;
	
	public SalDTO(int getSal, int getbasicPay,int getcerPay,int getcarPay,String getCERSER) {
		this.getSal = getSal;
		this.getbasicPay = getbasicPay;
		this.getcerPay=getcerPay;
		this.getcarPay=getcarPay;
		this.getCERSER=getCERSER;
	}
	public int getGetbasicPay() {
		return getbasicPay;
	}
	public void setGetbasicPay(int getbasicPay) {
		this.getbasicPay = getbasicPay;
	}
	public int getGetcerPay() {
		return getcerPay;
	}
	public void setGetcerPay(int getcerPay) {
		this.getcerPay = getcerPay;
	}
	public int getGetcarPay() {
		return getcarPay;
	}
	public void setGetcarPay(int getcarPay) {
		this.getcarPay = getcarPay;
	}
	public int getGetSal() {
		return getSal;
	}
	public void setGetSal(int getSal) {
		this.getSal = getSal;
	}

	
}
