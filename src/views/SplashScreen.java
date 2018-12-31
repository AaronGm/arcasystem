/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import javax.swing.JFrame;

/**
 *
 * @author aarongmx
 */
public class SplashScreen extends JFrame {
    SocketAddress address = new InetSocketAddress("localhost", 5432);
}
