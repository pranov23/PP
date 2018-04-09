package Command;

public class Line implements Shape{
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	private static final String Error_CanvasNotCreated = "Canvas not created yet, first Create Canvas then try drawing the Line \n";
	private static final String Error_InCorrectPoint = "Error ! Incorrect Point\n";
	private static final String Error_InvalidLine = "Error ! A Line cannot be drawn with the given Points\n";
	
	public Line(int x1,int x2,int y1,int y2) {
		// TODO Auto-generated constructor stub
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	@Override
	public void drawShape(Canvas canvas) {
		
		if(canvas.getCanvas()==null){
			System.out.println(Error_CanvasNotCreated);
			return ;
		}
		
		if((x1<=0|| x1>=canvas.getWidth()-1) || (x2<=0||x2>=canvas.getWidth()-1) || (y1<=0 || y1>=canvas.getHeight()-1) || (y2<=0 || y2>=canvas.getHeight()-1)){
			System.out.println(Error_InCorrectPoint);
			return ;
		}
		
		if(x1!=x2&& y1!=y2){
			System.out.println(Error_InvalidLine);
			return ;
		}
			
		String[][] c= canvas.getCanvas();
		
		for(int i=1;i<canvas.getHeight()-1;i++){
			for(int j=1;j<canvas.getWidth()-1;j++){
				if(j>=x1 && j<=x2 && i>=y1 && i<=y2){
					c[i][j] = "X";
				}
			}
		}
		
		CanvasUtils.printCanvas(canvas.getHeight(), canvas.getWidth(), canvas.getCanvas());
	}
	
}
