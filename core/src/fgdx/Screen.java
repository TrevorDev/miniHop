package fgdx;

public abstract class Screen{
	public Device device;
	public Screen(Device d){
		device = d;
	}
	
	public void render(){
		
	}
	
	public abstract void dispose();
}
