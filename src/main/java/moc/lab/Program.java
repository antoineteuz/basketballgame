package moc.lab;

import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.navigation.desktop.NavigationDesktop;
import ej.style.Stylesheet;
import ej.style.background.SimpleRoundedPlainBackground;
import ej.style.outline.SimpleOutline;
import ej.style.selector.ClassSelector;
import ej.style.util.EditableStyle;
import ej.style.util.StyleHelper;
import ej.wadapps.app.Activity;
import moc.lab.pages.MainPage;

public class Program implements Activity {

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRestart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart() {
		
		MicroUI.start();
		NavigationDesktop dskt = new NavigationDesktop();
		
//		//StyleSheet
		Stylesheet styleSheet = StyleHelper.getStylesheet();

		// EditableStyle for the Label
		
		EditableStyle titleStyle = new EditableStyle();
		SimpleOutline titleMargin = new SimpleOutline(5);
		titleStyle.setMargin(titleMargin);
		titleStyle.setPadding(titleMargin);
		titleStyle.setBackgroundColor(Colors.WHITE);
		titleStyle.setForegroundColor(Colors.BLACK);
		titleStyle.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		
		//EditableStyle for the Buttons
		
		EditableStyle btnStyle = new EditableStyle();
		SimpleOutline btnMargin = new SimpleOutline(5);
		btnStyle.setMargin(btnMargin);
		btnStyle.setPadding(btnMargin);
		SimpleRoundedPlainBackground myBackground = new SimpleRoundedPlainBackground(20);
		btnStyle.setBackground(myBackground);
		btnStyle.setBackgroundColor(Colors.YELLOW);
		btnStyle.setForegroundColor(Colors.BLUE);
		btnStyle.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		
		// Add the style to a Class Selector
		
		ClassSelector titleSelector = new ClassSelector("TITLE");
		ClassSelector buttonSelector = new ClassSelector("BUTTON");
		
		// Add rules to the StyleSheet
		
		styleSheet.addRule(buttonSelector, btnStyle);
		styleSheet.addRule(titleSelector, titleStyle);
	
		
		dskt.show(new MainPage(dskt));
		
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub

	}

}
