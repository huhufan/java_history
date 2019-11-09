package wuzu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.*;

public class Game extends JFrame implements ActionListener{
    Container ct =getContentPane();
    boolean flag=true;
    String result;
    Button bb;
    Label ll;
    int [][]a=new int[15][15];
    Button b[][]=new Button[15][15];
    Button ff=new Button("返回主菜单");

    public Game() {
        this.Menu();
    }
    public void SoundButton()  {
        try {
            File file=new File("sky.mid");
            Sequence sequence=MidiSystem.getSequence(file);
            Sequencer sequencer=MidiSystem.getSequencer();
            sequencer.setSequence(sequence);
            sequencer.open();
            sequencer.start();

        }catch (Exception e) {}
    }
    public void Sound()  {
        try {
            File file=new File("sky.mid");
            Sequence sequence=MidiSystem.getSequence(file);
            Sequencer sequencer=MidiSystem.getSequencer();
            sequencer.setSequence(sequence);
            sequencer.open();
            sequencer.start();
            //sequencer.

        }catch (Exception e) {}
    }
    public void Help() {
        ct.removeAll();
        this.setIconImage(Toolkit.getDefaultToolkit().createImage("my.png"));
        this.setResizable(false);
        this.setSize(400, 100);
        this.setLayout(new BorderLayout());
        this.setTitle("五子棋");
        ll=new Label("哈哈哈，就不帮助你");
        ct.add(ll,BorderLayout.CENTER);
        ff.addActionListener(this);
        ff.setBackground(Color.magenta);
        ct.add(ff,BorderLayout.EAST);
        this.setVisible(true);
    }
    public void End() {
        ct.removeAll();
        this.setIconImage(Toolkit.getDefaultToolkit().createImage("my.png"));
        this.setResizable(false);
        this.setSize(400, 100);
        this.setLayout(new BorderLayout());
        this.setTitle("五子棋");
        ll=new Label("比赛结果:"+result);
        ct.add(ll,BorderLayout.CENTER);
        ff.addActionListener(this);
        ff.setBackground(Color.magenta);
        ct.add(ff,BorderLayout.EAST);
        this.setVisible(true);
    }

    public void Menu() {
        for(int i=0;i<15;i++) {
            for(int j=0;j<15;j++) {
                a[i][j]=0;
            }
        }
        Sound();
        ct.removeAll();
        this.setIconImage(Toolkit.getDefaultToolkit().createImage("my.png"));
        this.setResizable(false);
        this.setSize(400, 100);
        this.setTitle("五子棋");
        //this.setLayout(new FlowLayout());
        this.setLayout(new GridLayout(1,3));
        Button start =new Button("开始游戏");
        start.addActionListener(this);
        Button help =new Button("帮助");
        help.addActionListener(this);
        Button quit =new Button("退出游戏");
        quit.addActionListener(this);
        ct.add(start);
        ct.add(help);
        ct.add(quit);
        this.setVisible(true);
    }

    public void Start() throws Exception {
        ct.removeAll();
        this.setIconImage(Toolkit.getDefaultToolkit().createImage("my.png"));
        this.setResizable(false);
        this.setSize(700,700);
        this.setTitle("五子棋");
        this.setLayout(new GridLayout(15,15));
        for(int i=0;i<15;i++) {
            for(int j=0;j<15;j++) {
                b[i][j]=new Button(" ");
                ct.add(b[i][j]);
                b[i][j].addActionListener(this);
            }
        }

        this.setVisible(true);

    }

    public String victory() {

        try {
            for(int i=0;i<15;i++) {
                for(int j=0;j<11;j++) {
                    if(a[i][j]==1&a[i][j+1]==1&a[i][j+2]==1&a[i][j+3]==1&a[i][j+4]==1) {

                        return "黑子获胜";

                    }
                    if(a[i][j]==2&a[i][j+1]==2&a[i][j+2]==2&a[i][j+3]==2&a[i][j+4]==2) {
                        return "白子获胜";

                    }

                }

            }
            for(int i=0;i<11;i++) {
                for(int j=0;j<15;j++) {
                    if(a[i][j]==1&a[i+1][j]==1&a[i+2][j]==1&a[i+3][j]==1&a[i+4][j]==1) {
                        return "黑子获胜";

                    }
                    if(a[i][j]==2&a[i+1][j]==2&a[i+2][j]==2&a[i+3][j]==2&a[i+4][j]==2) {
                        return "白子获胜";
                    }

                }

            }
            for(int i=0;i<11;i++) {
                for(int j=0;j<11;j++) {
                    if(a[i][j]==1&a[i+1][j+1]==1&a[i+2][j+2]==1&a[i+3][j+3]==1&a[i+4][j+4]==1) {
                        return "黑子获胜";

                    }
                    if(a[i][j]==2&a[i+1][j+1]==2&a[i+2][j+2]==2&a[i+3][j+3]==2&a[i+4][j+4]==2) {
                        return "白子获胜";
                    }


                }

            }
            for(int i=0;i<11;i++) {
                for(int j=4;j<15;j++) {
                    if(a[i][j]==1&a[i+1][j-1]==1&a[i+2][j-2]==1&a[i+3][j-3]==1&a[i+4][j-4]==1) {
                        return "黑子获胜";

                    }
                    if(a[i][j]==2&a[i+1][j-1]==2&a[i+2][j-2]==2&a[i+3][j-3]==2&a[i+4][j-4]==2) {
                        return "白子获胜";
                    }

                }

            }
        } catch (Exception e) {

        }
        return "0";

    }
    public static void main (String[]args) {
        Game gg=new Game();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        if(arg0.getActionCommand()==" ") {
            for(int i=0;i<15;i++) {

                for(int j=0;j<15;j++) {

                    if(b[i][j]==arg0.getSource()) {
                        if(flag) {
                            a[i][j]=1;
                            b[i][j].setLabel("●");
                            flag=false;
                            if(!victory().equals("0")) {
                                result=victory();
                                End();

                            }
                            break;
                        }

                        if(!flag) {
                            a[i][j]=2;
                            b[i][j].setLabel("○");
                            flag=true;

                            if(!victory().equals("0")) {
                                result=victory();
                                End();
                            }
                            break;
                        }

                    }

                }

            }

        }
        if(arg0.getActionCommand()=="开始游戏") {
            try {
                Start();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        if(arg0.getActionCommand()=="帮助") {
            Help();
        }
        if(arg0.getActionCommand()=="退出游戏") {
            System.exit(0);
        }
        if(arg0.getActionCommand()=="返回主菜单") {
            Menu();
        }


    }
}
