import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Case extends Component{
	public Case ()
	{
		super();
		cost = 0.0;
		imagePath = "cases";
	}
	
	//Processor(String man, String mod, String img, String price){
	Case(String specs[])
	{
		super(specs[0],specs[1],specs[2],specs[3]);
		imagePath = "cases";

	}
		
		public static ArrayList<Case> genCASES(String filepath) throws FileNotFoundException
		{
			ArrayList<Case> CASES = new ArrayList<Case>();
			for (String s : Component.getInventoryList(filepath)) 
			{
				CASES.add(new Case(s.split(",")));
			}	
		return CASES;
		}
}
