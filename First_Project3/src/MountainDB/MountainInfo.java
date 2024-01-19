package MountainDB;

public class MountainInfo {
	private String MountainName; //산 이름
	private String level;		 //난이도
	private String place; 	 	 //산 위치
	private String placeUrl;	 //지도
	private String imageUrl;	 //이미지 Url
	private String explanation;	 //산 설명
	private String doname;
	public MountainInfo(String MountainName, String level, String place, String placeUrl, String explanation, String imageUrl, String doname) {
		this.MountainName = MountainName;
		this.level = level;
		this.place = place;
		this.placeUrl = placeUrl;
		this.explanation = explanation;
		this.imageUrl = imageUrl;
		this.doname =doname;
	}

	public String getMountainName() {
		return MountainName;
	}

	public String getLevel() {
		return level;
	}

	public String getPlace() {
		return place;
	}

	public String getDoname() {
		return doname;
	}

	public void setDoname(String doname) {
		this.doname = doname;
	}

	public String getPlaceUrl() {
		return placeUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getExplanation() {
		return explanation;
	}
	/*
	 * public void infoFullPrint() { String printPlaceName=("| 산 이름 : " +
	 * MountainName); String printCategoryName=("| 난이도 : " + level ); String
	 * printRoadAddressName=("| 위치 : " + place); String printPlaceBest=("|지도  : " +
	 * placeUrl); String printPhone=("| 설명 : " + explanation);
	 * 
	 * }
	 */
	
}
