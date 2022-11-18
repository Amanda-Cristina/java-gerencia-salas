package client;

import common.GUI;
import common.Utils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import server.Server;

public class Home extends GUI {

    private JLabel title;
    private ServerSocket server;
    private final Socket socket;
    private JSONObject user;
    private JButton jb_get_connected, jb_start_talk;
    private JList jlist;
    private JScrollPane scroll;
    public static Utils utils;

    public Home(Socket socket, JSONObject user, Utils utils) {
        super("Chat - Home");
        this.user = user;
        this.socket = socket;
        this.title.setText("Bem-vindo(a)");
        this.setTitle("Home");
        this.utils = utils;
    }

    @Override
    protected void initComponents() {
        title = new JLabel();
        jb_get_connected = new JButton("Atualizar contatos");
        jlist = new JList();
        scroll = new JScrollPane(jlist);
        jb_start_talk = new JButton("Abrir Conversa");
    }

    @Override
    protected void configComponents() {
        this.setLayout(null);
        this.setMinimumSize(new Dimension(600, 480));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(10, 10, 370, 40);
        title.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        jb_get_connected.setBounds(400, 10, 180, 40);
        jb_get_connected.setFocusable(false);

        jb_start_talk.setBounds(10, 400, 575, 40);
        jb_start_talk.setFocusable(false);

        jlist.setBorder(BorderFactory.createTitledBorder("Usuários online"));
        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scroll.setBounds(10, 60, 575, 335);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(null);
    }

    @Override
    protected void insertComponents() {
        this.add(title);
        this.add(jb_get_connected);
        this.add(scroll);
        this.add(jb_start_talk);
    }

    @Override
    protected void insertActions() {
       this.addWindowListener(new WindowListener() {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			try {
				JSONObject params = new JSONObject();
				params.put("ra", 2328585);
				params.put("senha", 12345);
				
				JSONObject obj = new JSONObject();
				obj.put("operacao", "logout");
				obj.put("parametros", params);
				utils.sendMessage(obj);
				
				JSONObject response = utils.receiveMessage();
				System.out.println(response);
				Integer status = Integer.parseInt(response.get("status").toString());
				
				if(status == 600) {
					System.out.println("ok");
					utils.closeBuffer();
				} else {
					System.out.println("[ERROR LOGOUT]: " + response.get("message").toString());
				}
			} catch (IOException | ParseException ex) {
				System.out.println("[ERROR LOGOUT]: " + ex.getMessage());
			}
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		});
    }

    @Override
    protected void start() {
        this.pack();
        this.setVisible(true);
    }
}