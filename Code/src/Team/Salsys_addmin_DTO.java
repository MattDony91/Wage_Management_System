package Team;

public class Salsys_addmin_DTO {
	private int EMP_NO;
	private String EMP_NAME;
	private String EMP_REGNO; 
	private String PHONE;
	private String ADOPT_TYPE;
	private String SAL_CLASS;
	private String HIRE_DATE; 
	private String EMP_GRAD;
	private String EMAIL;
	private String ADDR;
	private String DEPT_NO;
	private int comboBoxindex;
	
	
	public Salsys_addmin_DTO(String EMP_NAME,int EMP_NO,String get_DEPT_NO,/*¾÷¹«,*/String PHONE,String get_HIRE_DATE
			,String EMAIL, String SAL_CLASS,String ADOPT_TYPE) {
		this.EMP_NAME=EMP_NAME;
		this.EMP_NO=EMP_NO;
		this.DEPT_NO=get_DEPT_NO;
		this.PHONE=PHONE;
		this.HIRE_DATE=get_HIRE_DATE;
		this.EMAIL=EMAIL;
		this.SAL_CLASS=SAL_CLASS;
		this.comboBoxindex=comboBoxindex;
		this.ADOPT_TYPE=ADOPT_TYPE;
	}

	public int getcomboBoxindex() {
		return comboBoxindex;
	}

	public void setcomboBoxindex(int comboBoxindex) {
		this.comboBoxindex = comboBoxindex;
	}

	public String getSAL_CLASS() {
		return SAL_CLASS;
	}

	public void setSAL_CLASS(String SAL_CLASS) {
		this.SAL_CLASS = SAL_CLASS;
	}

	public int getEMP_NO() {
		return EMP_NO;
	}

	public void setEMP_NO(int eMP_NO) {
		EMP_NO = eMP_NO;
	}

	public String getEMP_NAME() {
		return EMP_NAME;
	}

	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}

	public String getEMP_REGNO() {
		return EMP_REGNO;
	}

	public void setEMP_REGNO(String eMP_REGNO) {
		EMP_REGNO = eMP_REGNO;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getADOPT_TYPE() {
		return ADOPT_TYPE;
	}

	public void setADOPT_TYPE(String aDOPT_TYPE) {
		ADOPT_TYPE = aDOPT_TYPE;
	}


	public String getHIRE_DATE() {
		return HIRE_DATE;
	}

	public void setHIRE_DATE(String hIRE_DATE) {
		HIRE_DATE = hIRE_DATE;
	}

	public String getEMP_GRAD() {
		return EMP_GRAD;
	}

	public void setEMP_GRAD(String eMP_GRAD) {
		EMP_GRAD = eMP_GRAD;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getADDR() {
		return ADDR;
	}

	public void setADDR(String aDDR) {
		ADDR = aDDR;
	}

	public String getDEPT_NO() {
		return DEPT_NO;
	}

	public void setDEPT_NO(String dEPT_NO) {
		DEPT_NO = dEPT_NO;
	}
	
}
