package db;

public class PlayersDTO extends SMS {

	private int playernumber=0;
	private String hp;
	private int pc;
	private int won;
	private String banned;

	public PlayersDTO(String hp, int pc) {
		this.hp = hp;
		this.pc = pc;
		this.playernumber++;
		this.won = 0;
		this.banned = "N";
	}
	public PlayersDTO(String hp) {

	}
	public PlayersDTO(String hp, String banned) {
		this.hp = hp;
		this.banned = banned;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}

	public void setBanned() {
		this.banned = banned;
	}
	
	public String getBanned() {
		return banned;
	}
	
	public void setPc(int pc) {
		this.pc = pc;
	}

	public String getHp() {
		return hp;
	}

	public int getPc() {
		return pc;
	}
	public int getPlayernumber() {
		return playernumber;
	}
	public int getWon() {
		return won;
	}
	public void setWon(int won) {
		this.won = won;
	}
}
