package main;

import java.util.Scanner;

import Command.Canvas;
import Command.CanvasFactory;
import Command.Shape;
import Command.ShapeFactory;

public class DriverClass {
	
	private static final String QUIT_COMMAND = "Q";
	private static final String Error_InvalidCommand = "Error ! Invalid Command\n";
	
	private static Canvas obj;
	private static String choice;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		do{	
			 System.out.println("Enter Command : " );
			 choice = sc.nextLine().trim();
			 String[] tok = choice.split(" ");
			 
			//Get the Canvas Object
			obj = CanvasFactory.getCanvas();
			 
			if(choice.startsWith("C") || choice.startsWith("c")){
				
				try{
					if(tok.length == 3){
						int height = Integer.parseInt(tok[1]);
						int width = Integer.parseInt(tok[2]);
						obj.createCanvas(height,width);
					}else{
						System.out.println(Error_InvalidCommand);
					}
				}catch(NumberFormatException num){
					System.out.println(Error_InvalidCommand);
				}
			}else if(choice.startsWith("B")||choice.startsWith("b")){
				try{
					if(tok.length == 4){
						
						int x = Integer.parseInt(tok[1]);
						int y = Integer.parseInt(tok[2]);
						String marker = tok[3];
						obj.bucketFill(x, y, marker);
					}else{
						System.out.println(Error_InvalidCommand);
					}
				}catch(NumberFormatException num){
					System.out.println(Error_InvalidCommand);
				}
			}else if(choice.startsWith("L")||choice.startsWith("R")||choice.startsWith("l")||choice.startsWith("r")){
				
				Shape shape = ShapeFactory.getShape(choice);
				if(shape!=null)
					shape.drawShape(obj);
			}else if(choice.equalsIgnoreCase(QUIT_COMMAND)){
				break;
			}else{
				System.out.println(Error_InvalidCommand);
			}
		}while(!choice.equals(QUIT_COMMAND));
		
		System.out.println("Exiting from Program !\n");
		sc.close();	
	}

}
