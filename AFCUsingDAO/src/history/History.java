package history;

public class History {
	private int id;
	private String certificateId;
	private int status;
	private String dayIn;
	private String dayOut;
	private int embarkingStationID;
	private int endingStationID;
	
	public History(int id, String certificateId, int status, String dayIn, String dayOut, int embarkingStationID, int endingStationID) {
		this.id = id;
		this.certificateId = certificateId;
		this.status = status;
		this.dayIn = dayIn;
		this.dayOut = dayOut;
		this.embarkingStationID = embarkingStationID;
		this.endingStationID = endingStationID;
	}

	protected String getCertificateId() {
		return certificateId;
	}

	public int getId() {
		return id;
	}
	public int getStatus() {
		return status;
	}	
	public String getDayIn() {
		return dayIn;
	}
	public String getDayOut() {
		return dayOut;
	}
	public int getEmbarkingStationID() {
		return embarkingStationID;
	}
	public int getEndingStationID() {
		return endingStationID;
	}
	
	@Override
	public String toString() {
		String result = "";
		result = result + "CertificateId: " + this.certificateId + "\n";
		if(this.dayIn != null) result = result + "Day in: " + this.dayIn + "\n";
		if(this.dayOut != null) result = result + "Day out: " + this.dayOut + "\n";
		return result;
	}
}
