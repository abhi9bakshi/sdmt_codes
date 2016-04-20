

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/OddEvenServlet")


public class OddEvenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OddEvenServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//Step 1: Get numbers from InputBox
    	String sInput = request.getParameter("input");
    	
    	//Step 2: Split the numbers by whitespace and store in string array
    	String[] strArray = sInput.split(" ");
    	
    	System.out.println("Split size: " + strArray.length);
    	
    	//Step 3: Convert it into integer array
    	int[] intArray = new int[strArray.length];
    	for(int i=0; i<strArray.length; i++){
    		intArray[i] = Integer.parseInt(strArray[i]);
    	}
    	
    	//Step 4: Pass the array to OddEvenSort and get sorted array
    	OddEvenSort.arr = intArray;
    	int[] intSorted = OddEvenSort.sort();
    	
    	//Step 5: Print the Output
    	PrintWriter pw = response.getWriter();
    	for(int x = 0; x< intSorted.length; x++){
    		pw.print(intSorted[x] + " ");
    	}
    	pw.print(" ");
    }
}
