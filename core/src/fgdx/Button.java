package fgdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Button extends DisplayObject implements TouchListener{
	public Screen scr;
	boolean up = true;
	public Button(Screen s, Vector2 pos, Vector2 dim, Texture t) {
		super(pos, dim, t);
		s.device.input.addListener(this);
		scr = s;
		// TODO Auto-generated constructor stub
	}

	public void dispose(){
		scr.device.input.removeListener(this);
	}
	
	public void btnDown(){
		if(up){
			this.pos=new Vector2(pos).add(0, 5);
			up = false;
		}
		
	}
	
	public void btnUp(){
		if(!up){
			this.pos=new Vector2(pos).add(0, -5);
			up = true;
		}
	}
	
	public void btnHit(){
		
	}
	
	@Override
	public void touchDown(Vector2 pos, int pointer, int button) {
		// TODO Auto-generated method stub
		if(this.collidesWith(pos)){
			btnDown();
		}
		
		//scr.device.setScreen(new OtherScreen(scr.device));
		
	}

	@Override
	public void touchUp(Vector2 pos, int pointer, int button) {
		if(this.collidesWith(pos)){
			btnUp();
			btnHit();
		}
	}

	@Override
	public void touchDrag(Vector2 pos, int pointer) {
		if(this.collidesWith(pos)){
			btnDown();
		}else{
			btnUp();
		}
	}

}
