package fgdx;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

	public class InputCorrector implements InputProcessor {
		private Stage stage;
		private ArrayList<TouchListener> listeners = new ArrayList<TouchListener>();
	    public InputCorrector(Stage s){
	    	stage = s;
	    	InputMultiplexer im = new InputMultiplexer();
	        im.addProcessor(this);
	        Gdx.input.setInputProcessor(im);
	    }
	    
	    public void addListener(TouchListener x){
	    	listeners.add(x);
	    }
	    
	    public void removeListener(TouchListener x){
	    	listeners.remove(x);
	    }
	    
	    public Vector2 adjustXY(int screenX, int screenY){
	    	float x,y;
	    	x=screenX*(stage.getViewport().getWorldWidth()/Gdx.graphics.getWidth())-(stage.getViewport().getWorldWidth()/2);
			y=(-screenY)*(stage.getViewport().getWorldHeight()/Gdx.graphics.getHeight())+(stage.getViewport().getWorldHeight()/2);
			x+=stage.getCamera().position.x;
			y+=stage.getCamera().position.y;
			return new Vector2(x, y);
	    }
	    
	    @Override
	    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
			try{
	    		for(TouchListener i:listeners){
	    			i.touchDown(adjustXY(screenX, screenY), pointer, button);
				}
	    	}catch(Exception e){
	    		
	    	}
	        return true;
	    }

	    @Override
	    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	    	try{
	    		for(TouchListener i:listeners){
					i.touchUp(adjustXY(screenX, screenY), pointer, button);
				}
	    	}catch(Exception e){
	    		
	    	}
	        return false;
	    }
	    
	    @Override
	    public boolean touchDragged(int screenX, int screenY, int pointer) {
	    	try{
	    		for(TouchListener i:listeners){
	    			i.touchDrag(adjustXY(screenX, screenY), pointer);
				}
	    	}catch(Exception e){
	    		
	    	}
	       
	        
	        return false;
	    }
	    
	    //TODO add support for below if needed
	    @Override
	    public boolean keyDown(int keycode) {
	        
	        return true;
	    }

	    @Override
	    public boolean keyUp(int keycode) {
	        
	        return true;
	    }

	    @Override
	    public boolean keyTyped(char character) {
	        
	        return true;
	    }

	    @Override
	    public boolean mouseMoved(int screenX, int screenY) {
	        
	        return false;
	    }

	    @Override
	    public boolean scrolled(int amount) {
	        
	        return false;
	    }

	}

