

import java.util.ArrayList;

public class KeywordList {
	
	public ArrayList<Keyword> lst = new ArrayList<Keyword>();
	
	public KeywordList() {
		lst.add(new Keyword("影城", 20));
		lst.add(new Keyword("上映日期", 3));
		lst.add(new Keyword("訂票", 10));
		lst.add(new Keyword("主演", 1));
		lst.add(new Keyword("數位", 10));
		lst.add(new Keyword("2D", 5));
		lst.add(new Keyword("3D", 5));
	}
	public ArrayList<Keyword> getKeyword(){
		return lst;
	}
}
