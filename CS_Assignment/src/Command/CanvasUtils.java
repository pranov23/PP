package Command;

public class CanvasUtils {

	public static void printCanvas(int height,int width,String canvas[][]){
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
					if(canvas[i][j]!=null)
						System.out.print(canvas[i][j]);
					else
						System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	//Util to check if the Width/Height is Valid
	public static boolean isValid(int height,int width){
		return (height>0 && width>0);
	}
	
	public static boolean withInBoundary(int x,int y, int height, int width){
		if(x<width && y<height)
			return true;
		return false;
	}
	public static void initializeCanvasWithBoundary(int height,int width,String canvas[][]){
		
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				
				if(i==0||i==height-1){
					canvas[i][j] = "-";
				}else if(j==0 || j== width-1){
					canvas[i][j] = "|";
				}
			}
		}
	}
}
