package Command;

public class ShapeFactory {
	
//	private static final String Error_InvalidPoint = "Error ! Invalid Point";
	private static final String Error_InvalidCommand = "Error ! Invalid Command\n";
	
	public static Shape getShape(String command){
		
		String tok[] = command.split(" ");
		
		if(tok.length == 5){
			String shapeType = tok[0].toUpperCase();
			try{
				int x1 = Integer.parseInt(tok[1]);
				int x2 = Integer.parseInt(tok[2]);
				int y1 = Integer.parseInt(tok[3]);
				int y2 = Integer.parseInt(tok[4]);
				
				//Based Upon The Shape Chosen Line,Rectangle the Factory will return.
				switch(shapeType){
					case "L":
						return new Line(x1,y1,x2,y2);
					case "R":
						return new Rectangle(x1,y1,x2,y2);
					default:
						return null;
				}
			}catch(NumberFormatException e){
				System.out.println(Error_InvalidCommand);
			}
		}else{
			System.out.println(Error_InvalidCommand);
		}
		return null;
		
	}
}
