package moc.lab.pages;

import ej.container.Flow;
import ej.container.Split;
import ej.microui.display.Colors;
import ej.navigation.desktop.NavigationDesktop;
import ej.navigation.page.Page;
import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.listener.OnClickListener;
import moc.lab.MyWidget;

public class GamePage extends Page {
	
	private Split container;

	public GamePage (NavigationDesktop nav) {
		
		MyWidget mw = new MyWidget(25, 25, Colors.SILVER);
		System.out.println(mw.score);
		Split s = new Split(false, (float) 0.90);
		s.setFirst(mw);
		s.setLast(new Button("AAA"));
		
		this.setWidget(s);
		repaint();
	}
}