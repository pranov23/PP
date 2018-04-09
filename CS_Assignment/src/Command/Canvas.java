package Command;

public class Canvas{
	
	private static Canvas canvasObj;
	private String canvas[][];
	private int width;
	private int height;
	
	private static final String Error_CanvasNotCreated = "Canvas not created yet, first Create Canvas then try drawing the Line\n";
	private static final String Error_CanvasInvalidWH = "Error ! Invalid values\n";
	private static final String Error_CanvasInvalidpoint = "Error ! Invalid Point\n";
	
	private Canvas(){
		// TODO Auto-generated constructor stub	
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public String[][] getCanvas() {
		return this.canvas;
	}

	public static Canvas getCanvasObject(){
		if(canvasObj == null){
			 canvasObj = new Canvas();
		}
		return canvasObj;
	}
	
	public void createCanvas(int width,int height){
		
		if(!CanvasUtils.isValid(height, width)){
			System.out.println(Error_CanvasInvalidWH);
			return;
		}
			
		canvasObj = Canvas.getCanvasObject();
		canvasObj.canvas = new String[height+2][width+2];
		canvasObj.width = width+2;
		canvasObj.height = height+2;
		
		CanvasUtils.initializeCanvasWithBoundary(canvasObj.getHeight(),canvasObj.getWidth(),canvas);
		CanvasUtils.printCanvas(canvasObj.getHeight(), canvasObj.getWidth(), canvas);
		
	}

	private boolean isSafe(int x,int y,String[][] canvas, boolean [][]visited){

		// row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (x >= 0) && (x < width) &&
               (y >= 0) && (y < height) &&
               (canvas[y][x]!="X" && !visited[y][x]
               && canvas[y][x]!="-"&& canvas[y][x]!="|");
	}

	private void DFS(int x, int y,String[][]canvas,boolean [][]visited,String marker){
		
		int[] xArray ={-1,-1,-1,0,0,1,1,1};
		int[] yArray ={-1,1,0,-1,1,-1,1,0};
		
		//When the Marker lies at the boundary of an already drawn structure
		if(canvas[y][x]!="X"){
			
			visited[y][x] = true;
			canvas[y][x] = marker;
			
			for(int k=0;k<8;k++){
				if(isSafe(x+xArray[k], y+yArray[k] ,canvas,visited)){
					DFS(x+xArray[k],y+yArray[k],canvas,visited,marker);
				}
			}
		}
	}
	
	public void bucketFill(int x,int y,String marker){
		
		boolean [][] visited = new boolean[height][width];
		
		if(canvas==null){
			System.out.println(Error_CanvasNotCreated);
			return ;
		}
		
		if(CanvasUtils.withInBoundary(x, y, height-1, width-1)){
			
			//Performs the DFS on the Matrix 
			DFS(x,y,canvas,visited,marker);
			
			CanvasUtils.printCanvas(height, width, canvas);
		}else{
			System.out.println(Error_CanvasInvalidpoint);
		}
	}
}
