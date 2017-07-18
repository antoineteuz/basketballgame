package moc.lab.pages;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.container.List;
import ej.container.Split;
import ej.exit.ExitHandler;
import ej.navigation.desktop.NavigationDesktop;
import ej.navigation.page.*;
import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.listener.OnClickListener;

public class MainPage extends Page {
	
	private Split container;
	
	public MainPage(NavigationDesktop nav) {
		
		container = new Split(false, (float) 0.2);
		
		List btnList = new List(false);
		
		Label title = new Label("MENU");
		title.addClassSelector("TITLE");
		
		Button btn_game = new Button("PLAY");
		Button btn_score = new Button("SCORE");
		Button btn_features = new Button("FEATURES");
		Button exitBTN = new Button("EXIT");
		exitBTN.addClassSelector("BUTTON");
		btn_game.addClassSelector("BUTTON");
		btn_score.addClassSelector("BUTTON");
		btn_features.addClassSelector("BUTTON");
		
		btn_game.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("CLICKED ON BUTTON GO TO GAME PAGE");
				nav.show(new GamePage(nav));
				}
			});
		
		btn_score.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("CLICKED ON BUTTON GO TO SCORE PAGE");
				nav.show(new ScorePage(nav));
			}
		});
		
		btn_features.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("CLICKED ON BUTTON GO TO FEATURES PAGE");
				nav.show(new FeaturesPage(nav));
			}
		});
		
		exitBTN.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				ExitHandler exitHandler = ServiceLoaderFactory.getServiceLoader().getService(ExitHandler.class);
				if (exitHandler != null) {
					exitHandler.exit();
				}
			System.out.println("EXIT");
			}
		});
		
		btnList.add(btn_game);
		btnList.add(btn_score);
		btnList.add(btn_features);
		btnList.add(exitBTN);
		
		container.setFirst(title);
		container.setLast(btnList);
		
		setWidget(container);
	
	}
}
