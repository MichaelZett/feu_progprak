package de.feu.javafxdemo;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyCircle extends Circle implements SelectableNode {
	public MyCircle(double centerX, double centerY, double radius) {
		super(centerX, centerY, radius);
	}

	@Override
	public boolean requestSelection(boolean select) {
		return true;
	}

	@Override
	public void notifySelection(boolean select) {
		if(select)
			this.setFill(Color.RED);
		else
			this.setFill(Color.BLACK);
	}
}