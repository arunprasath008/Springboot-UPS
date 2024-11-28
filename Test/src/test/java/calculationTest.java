import static org.junit.Assert.*;  
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;  
public class calculationTest {
	public Calculation arun;
	@BeforeEach void setup(){
		arun= new Calculation();
	}

	 @Test  
	    public void wa(){  
		 int[] a=new int[] {1,3,5,23};
	        assertEquals(23,Calculation.findMax(a));   
	        assertEquals(-1,Calculation.findMax(new int[] {-1,-3,-2,-5}));
	    }  

}
