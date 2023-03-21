package com.bricks;

import com.bricks.gui.ExitConfirmPane;
import com.bricks.gui.GamePanel;
import com.bricks.gui.Gui;
import com.bricks.gui.StartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class BrickBreakerApp {

    public static void main(String[] args) {
        EventQueue.invokeLater(BrickBreakerApp::new);
    }

    public BrickBreakerApp() {
        Controller controller = new Controller();
        Game game = new Game(controller);
        Gui gui = new Gui(controller);
        controller.setGame(game);
        controller.setGui(gui);
    }










}