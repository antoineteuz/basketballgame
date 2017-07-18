package moc.lab.pages;

import ej.container.Split;
import ej.microui.display.Colors;
import ej.navigation.desktop.NavigationDesktop;
import ej.navigation.page.Page;
import ej.widget.composed.Button;
import moc.lab.MyWidget;

public class GamePage extends Page {
	
	private Split container;

	public GamePage (NavigationDesktop nav) {
		
		MyWidget mw = new MyWidget(50, 50, Colors.RED);
		System.out.println(mw.score);
		container = new Split(false, (float) 0.90);
		container.setFirst(mw);
	
		container.setLast(new Button("Back"));
		
		this.setWidget(container);
		repaint();
	}
}