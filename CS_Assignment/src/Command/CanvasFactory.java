package Command;

public class CanvasFactory {

	public static Canvas getCanvas(){
		return (Canvas)Canvas.getCanvasObject();
	}
}
