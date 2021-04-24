package com.theaemogie.learnmod.util.imGui;

import imgui.app.Application;

/**
 * @author <a href="mailto:theaemogie@gmail.com"> Aemogie. </a>
 */
public class ImGuiThread extends Thread{
	@Override
	public void run() {
		ImGuiLayer imGuiLayer = new ImGuiLayer();
		Application.launch(imGuiLayer);
	}
}
