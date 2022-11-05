
public class Processor extends Component {
	public Double clockSpeed;
	public Integer coreCount;
	public Integer socketPinCount;
	
	Processor(){
		super();
		cost = 0.0;
		clockSpeed = 1.0;
		coreCount = 8;
		socketPinCount = 775;
	}
	
	//Processor(String man, String mod, String img, String price, String clock, String cores, String pins){
	Processor(String specs[]){
		super(specs[0],specs[1],specs[2],specs[3]);
		clockSpeed = Double.valueOf(specs[4]);
		coreCount = Integer.valueOf(specs[5]);
		socketPinCount = Integer.valueOf(specs[6]);
	}
}
