package com.host.flyweight;

//Client code
public class TextEditor {
	private FontFactory fontFactory;

	public TextEditor() {
		fontFactory = new FontFactory();
	}

	public void displayCharacter(char c, String fontName) {
		Font font = fontFactory.getFont(fontName);
		font.render(String.valueOf(c));
	}

}