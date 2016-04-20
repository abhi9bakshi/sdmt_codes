import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OddEvenServlet
 */
public class OddEvenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OddEvenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */


    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	
    	AccountHolder ac1 = new AccountHolder("123456","1234");
    	AccountHolder ac2 = new AccountHolder("654321", "4321");
    	AccountHolder ac3 = new AccountHolder("098765", "9876");
    	AccountHolder ac4 = new AccountHolder("567890", "6789");
    	
        Map<AccountHolder,String> account = new HashMap();
        account.put(ac1,"43231");
        account.put(ac2,"34325");
        account.put(ac3,"43655467");
        account.put(ac4,"123");
        
        String accountNo = request.getParameter("accountNo");
        String pin = request.getParameter("pin");

        
        // System.out.println(count);
        String balance= null;
        for(Map.Entry<AccountHolder, String> entry : account.entrySet()){
        	AccountHolder ac = entry.getKey();
        	if(ac.accountNo.equals(accountNo) && ac.pin.equals(pin)){
        		balance = entry.getValue(); 
        		break;
        	}
        }
        PrintWriter pw = response.getWriter();
        
        if(balance != null){
        	pw.print(balance);
        	pw.print("");
		}else{
			pw.print("Invalid Account details");
			pw.print("");
		}

    }
    
}

class AccountHolder {
	String accountNo;
	String pin;
	
	public AccountHolder(String a,String p){
		accountNo = a;
		pin = p;
	}
}
