package fgdx;

import com.badlogic.gdx.math.Vector2;

public interface TouchListener {
	public void touchDown(Vector2 pos, int pointer, int button);
	
	public void touchUp(Vector2 pos, int pointer, int button);
	
	public void touchDrag(Vector2 pos, int pointer);
}
