

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProject
 */
@WebServlet("/TestProject")
public class TestProject extends HttpServlet {
/*
 * private static final long serialVersionUID = 1L;
	public KeywordList lst = new KeywordList();
	public ArrayList<WebNode> nodeList = new ArrayList<WebNode>();
	public Ranking rankResult;
 */
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("keyword")== null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}
		GoogleQuery google = new GoogleQuery(request.getParameter("keyword"));
		HashMap<String, String> query = google.query();
		
		String[][] s = new String[query.size()][3];
		request.setAttribute("query", s);
		int num = 0;
		for(Entry<String, String> entry : query.entrySet()) {
		    String title = entry.getKey();
		    String url = entry.getValue();
		    s[num][0] = title;
		    s[num][1] = url;
/*
 * 	    	WebPage rootPage = new WebPage(url, title);
			WebTree tree = new WebTree(rootPage);
			
			WordCounter counter = new WordCounter(url);
//			counter.findWebChild();
			
			for(Entry<String, String> child : counter.findWebChild().entrySet()) {
				String childTitle = child.getKey();
				String childUrl = child.getValue();
				tree.root.addChild(new WebNode(new WebPage(childUrl,childTitle)));
			}
			tree.setPostOrderScore(lst.getKeyword());
			nodeList.add(tree.root);
			rankResult = new Ranking(nodeList);
 */
			
//			for(int i=0; i<counter.findWebChild().size(); i++) {
//				tree.root.addChild(new WebNode(new WebPage(counter.urlList.get(i), counter.nameList.get(i))));
//			}
			
			
			
		    //use word counter
//		    WordCounter counter = new WordCounter(url);
//		    s[num][2] = counter.countKeyword(url);
		    num++;
		}
/*
 * 		for(int i=0 ; i<s.length ; i++) {
				s[i][0] = nodeList.get(i).getTitle();
				s[i][1] = nodeList.get(i).getUrl();
		}
 */
 		

		request.getRequestDispatcher("googleitem.jsp")
		 .forward(request, response); 	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
