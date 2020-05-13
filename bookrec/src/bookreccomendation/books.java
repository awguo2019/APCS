package bookreccomendation;

public class books {
	private String bname;
	private String author;
	private int score;
	
	public books(String s) {
		String[] parts = s.split(",");
		author = parts[0];
		bname = parts[1];
	}
	
	public void setscore(int x) {
		score = x;
	}
	
	public String toString(){
		return (author + ", " +bname);
	}
	
	public String getscorestring() {
		String s = "" + score;
		return s;
	}
	public int getscore() {
		return score;
	}
	
}
