package pokerGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUI extends Game {
   private JFrame frame, winnerF, setF;
   private JPanel mainP, userCountP, userNameP, gameP, setP;
   private JPanel[] userDeckP;
   private JLabel userCount1, userCount2, winnerLb, winnerLb2, allDeckLb2;
   private JButton enter_main, exit_main, oik, exit;
   private BackCardButton[][] backCards;
   private UserCardButton[][] userCards;
   private JTextField inputUserCount;
   private JTextField[] inputUserName_array;
   private JMenu menu1, menu2, open, hide, menu3;
   private JMenuItem newGame, exitGame, result, set, setArray;
   private JMenuItem[] openItems, hideItems;
   private ButtonGroup openGroup, hideGroup;
   private JMenuBar bar;
   int userCount_button, cardCount_button, cardCount_winner;
   public static int userCount_all, cardCount_all;
   private JPanel winnerP, winnerDeckP, winnerDeckP2, allDeckMainP;
   private JPanel[] allDeckP;
   private JButton winnerB2, allB;
   private JLabel[] winnerCardLb;
   private JLabel mainLB;
   private JLabel gameLB;
   private JButton menuButton1;
   private JButton menuButton2;
   private JButton menuButton3;
   private JButton menuButton4;
   private JButton menuButton5;
   private boolean visible;

   public GUI() {
      frame = new JFrame("PokerGame");
      mainP(frame);
      frame.setBackground(new Color(051, 102, 051));
      frame.setSize(1620, 1000);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // 윈도우 창 최대화
      frame.setVisible(true);
   }

   public void mainP(JFrame frame) {
      mainP = new JPanel() {
         public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image_main = new ImageIcon("images/main.jpg");
            g.drawImage(image_main.getImage(), 0, 0, d.width, d.height, this);
         }
      };
      mainP.setLayout(null);
      mainLB = new JLabel("POKER GAME");
      mainLB.setOpaque(true);
      mainLB.setBackground(new Color(0, 0, 0, 0));
      mainLB.setForeground(new Color(211, 204, 92, 255));
      mainLB.setHorizontalAlignment(JLabel.CENTER);
      mainLB.setFont(new Font("Algerian", Font.BOLD, 120));
      mainLB.setBounds(300, 300, 1000, 120);
      mainP.add(mainLB);
      enter_main = new JButton("입장");
      enter_main.setFont(new Font("bold", Font.BOLD, 30));
      enter_main.setBounds(300, 700, 300, 80); // setBounds(가로위치, 세로위치, 가로크기, 세로크기)
      enter_main.setBackground(new Color(051, 102, 051));
      enter_main.setForeground(Color.white);
      enter_main.setFocusPainted(false);
      enter_main.setBorderPainted(false);
      mainP.add(enter_main);
      exit_main = new JButton("퇴장");
      exit_main.setFont(new Font("bold", Font.BOLD, 30));
      exit_main.setBounds(1000, 700, 300, 80);
      exit_main.setBackground(new Color(051, 102, 051));
      exit_main.setForeground(Color.white);
      exit_main.setFocusPainted(false);
      exit_main.setBorderPainted(false);
      mainP.add(exit_main);

      MainButtonHandler handler = new MainButtonHandler();
      enter_main.addActionListener(handler);
      exit_main.addActionListener(handler);

      frame.add(mainP);
   }

   public void userCountP(JFrame frame) {
      userCountP = new JPanel() {
         public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("images/main.jpg");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, this);
         }
      };
      userCountP.setLayout(null);

      oik = new JButton("확인");
      oik.setFont(new Font("bold", Font.BOLD, 30));
      oik.setBounds(300, 700, 300, 80); // setBounds(가로위치, 세로위치, 가로크기, 세로크기)
      oik.setBackground(new Color(051, 102, 051));
      oik.setForeground(Color.white);
      oik.setFocusPainted(false);
      oik.setBorderPainted(false);
      userCountP.add(oik);

      exit = new JButton("처음화면으로");
      exit.setFont(new Font("bold", Font.BOLD, 30));
      exit.setBounds(1000, 700, 300, 80);
      exit.setBackground(new Color(051, 102, 051));
      exit.setForeground(Color.white);
      exit.setFocusPainted(false);
      exit.setBorderPainted(false);
      userCountP.add(exit);

      UserCountButtonHandler handler = new UserCountButtonHandler();
      oik.addActionListener(handler);
      exit.addActionListener(handler);

      userCount1 = new JLabel("몇명이서 진행하시겠습니까?");
      userCount1.setOpaque(true);
      userCount1.setBackground(new Color(051, 102, 051, 0));
      userCount1.setForeground(Color.white);
      userCount1.setHorizontalAlignment(JLabel.CENTER);
      userCount1.setFont(new Font("bold", Font.BOLD, 40));
      userCount1.setBounds(400, 200, 800, 100);
      userCountP.add(userCount1);

      userCount1 = new JLabel("5명까지 참가 가능합니다.");
      userCount1.setOpaque(true);
      userCount1.setBackground(new Color(051, 102, 051, 0));
      userCount1.setForeground(Color.white);
      userCount1.setHorizontalAlignment(JLabel.CENTER);
      userCount1.setFont(new Font("bold", Font.BOLD, 25));
      userCount1.setBounds(400, 240, 800, 100);
      userCountP.add(userCount1);

      inputUserCount = new JTextField(50);
      inputUserCount.setBounds(600, 320, 400, 40);
      inputUserCount.setFont(new Font("bold", Font.BOLD, 25));
      inputUserCount.setHorizontalAlignment(JLabel.CENTER);
      userCountP.add(inputUserCount);

      frame.add((userCountP));
   }

   public void userNameP(JFrame frame) {
      userNameP = new JPanel() {
         public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("images/main.jpg");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, this);
         }
      };
      userNameP.setLayout(null);

      oik = new JButton("게임 시작");
      oik.setFont(new Font("bold", Font.BOLD, 35));
      oik.setBackground(new Color(051, 102, 051));
      oik.setForeground(Color.white);
      oik.setBounds(300, 700, 300, 80); // setBounds(가로위치, 세로위치, 가로크기, 세로크기)

      oik.setFocusPainted(false);
      oik.setBorderPainted(false);
      userNameP.add(oik);
      userNameP.add(exit);

      UserNameButtonHandler handler = new UserNameButtonHandler();
      oik.addActionListener(handler);
      exit.addActionListener(handler);

      userCount1 = new JLabel("참가자의 이름을 입력하세요.");
      userCount1.setOpaque(true);
      userCount1.setBackground(new Color(051, 102, 0, 0));
      userCount1.setForeground(Color.white);
      userCount1.setHorizontalAlignment(JLabel.CENTER);
      userCount1.setFont(new Font("bold", Font.BOLD, 35));
      userCount1.setBounds(400, 130, 800, 100);
      userNameP.add(userCount1);

      inputUserName_array = new JTextField[userCount];
      for (int i = 0; i < userCount; i++) {
         inputUserName_array[i] = new JTextField(50);
         inputUserName_array[i].setBounds(400, 230 + i * 60, 800, 60);
         inputUserName_array[i].setFont(new Font("bold", Font.BOLD, 30));
         inputUserName_array[i].setHorizontalAlignment(JLabel.CENTER);
         userNameP.add(inputUserName_array[i]);
      }

      frame.add((userNameP));
   }

   public void gameP(JFrame frame) {
      gameP = new JPanel() {
         public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("images/game.jpg");
            g.drawImage(image.getImage(), 0, 0, d.width, 400, this);
         }
      };
      gameP.setLayout(null);
      gameP.setBackground(new Color(051, 102, 051));
      gameLB = new JLabel("! Play Poiker !");
      gameLB.setOpaque(true);
      gameLB.setBackground(new Color(051, 102, 051, 0));
      gameLB.setForeground(new Color(102, 255, 255, 255));
      gameLB.setHorizontalAlignment(JLabel.CENTER);
      gameLB.setFont(new Font("Algerian", Font.BOLD, 120));
      gameLB.setBounds(300, 150, 1000, 120);
      gameP.add(gameLB);
      menu1 = new JMenu("게임");
      menu2 = new JMenu("카드 패");
      menu3 = new JMenu("추가기능");

      menuButton1 = new JButton("새게임");
      menuButton1.setBounds(200, 850, 200, 80);
      menuButton1.setFont(new Font("bold", Font.BOLD, 35));
      menuButton1.setBackground(new Color(45, 55, 96));
      menuButton1.setForeground(Color.white);
      menuButton1.setVisible(true);
      menuButton2 = new JButton("로비");
      menuButton2.setBounds(550, 850, 200, 80);
      menuButton2.setFont(new Font("bold", Font.BOLD, 35));
      menuButton2.setBackground(new Color(45, 55, 96));
      menuButton2.setForeground(Color.white);
      menuButton2.setVisible(true);
      menuButton3 = new JButton("패 공개");
      menuButton3.setBounds(900, 850, 200, 80);
      menuButton3.setFont(new Font("bold", Font.BOLD, 35));
      menuButton3.setBackground(new Color(45, 55, 96));
      menuButton3.setForeground(Color.white);
      menuButton3.setVisible(true);
      menuButton4 = new JButton("결과 확인");
      menuButton4.setBounds(1250, 850, 200, 80);
      menuButton4.setFont(new Font("bold", Font.BOLD, 35));
      menuButton4.setBackground(new Color(45, 55, 96));
      menuButton4.setForeground(Color.white);
      menuButton4.setVisible(true);
      menuButton5 = new JButton("패 덮기");
      menuButton5.setBounds(900, 850, 200, 80);
      menuButton5.setFont(new Font("bold", Font.BOLD, 35));
      menuButton5.setBackground(new Color(45, 55, 96));
      menuButton5.setForeground(Color.white);
      menuButton5.setVisible(false);

      gameP.add(menuButton1);
      gameP.add(menuButton2);
      gameP.add(menuButton3);
      gameP.add(menuButton4);

      bar = new JMenuBar();
      frame.setJMenuBar(bar);
      bar.add(menu1);
      bar.add(menu2);
      bar.add(menu3);

      menuButton1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            gameP.setVisible(false);
            bar.setVisible(false);
            userCountP(frame);
            userCountP.setVisible(true);
         }
      });

      menuButton2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            gameP.setVisible(false);
            bar.setVisible(false);
            mainP(frame);
            mainP.setVisible(true);
         }
      });

      menuButton3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 visible = true;
            gameP.remove(menuButton3);
            menuButton3.setVisible(false);
            menuButton5.setVisible(true);
            gameP.add(menuButton5);

            gameP.revalidate();
            for (int i = 0; i < userCount; i++) {
               for (int j = 0; j < cardCount; j++) {
                  userCards[i][j].setVisible(true);
                  backCards[i][j].setVisible(false);
               }
            }

            gameP.revalidate();
         }
      });
      menuButton5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 visible = false;
            gameP.remove(menuButton5);
            menuButton5.setVisible(false);
            menuButton3.setVisible(true);
            gameP.add(menuButton3);

            gameP.revalidate();
            for (int i = 0; i < userCount; i++) {
               for (int j = 0; j < cardCount; j++) {
                  userCards[i][j].setVisible(false);
                  backCards[i][j].setVisible(true);
               }
            }
            gameP.revalidate();
         }
      });

      menuButton4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            checkWinner();
            winnerF = new JFrame("결과 확인");
            winnerF.setSize(800, 600);
            winnerF.getContentPane().setBackground(new Color(051, 102, 051));
            winnerF.setLocationRelativeTo(null);
            winnerF.setVisible(true);
            winnerF.setLayout(null);

            winnerDeckP = new JPanel();
            winnerDeckP.setBounds(80, 150, 640, 230);
            winnerDeckP.setLayout(new GridLayout(1, 5));

            winnerCardLb = new JLabel[cardCount];
            cardCount_winner = 4;
            for (int j = 0; j < cardCount; j++) {
               winnerCardLb[j] = new WinnerCardLb();
               winnerDeckP.add(winnerCardLb[j]);
               cardCount_winner--;
            }

            winnerDeckP2 = new JPanel();
            winnerDeckP2.setBounds(50, 100, 700, 300);
            winnerDeckP2.setBackground(new Color(051, 102, 051));
            
            TitledBorder title = new TitledBorder(winner.getName() + "님의 덱");
            title.setTitleColor(Color.white);
            title.setTitleFont(new Font("bold", Font.BOLD, 15));
            winnerDeckP2.setBorder(title);

            winnerP = new JPanel();
            winnerP.setBounds(200, 20, 400, 50);
            winnerP.setLayout(null);
            winnerP.setBackground(new Color(051, 102, 051));

            winnerLb = new JLabel(winner.getName() + "님 승리!\n");
            winnerLb.setOpaque(true);
            winnerLb.setBackground(new Color(051, 102, 051));
            winnerLb.setForeground(Color.WHITE);
            winnerLb.setHorizontalAlignment(JLabel.CENTER);
            winnerLb.setFont(new Font("bold", Font.BOLD, 30));
            winnerLb.setBounds(0, 0, 400, 50);
            winnerP.add(winnerLb);


            winnerB2 = new JButton("결과창 종료");
            winnerB2.setFont(new Font("bold", Font.BOLD, 20));
            winnerB2.setBounds(500, 450, 200, 80);
            winnerB2.setBackground(Color.WHITE);
            winnerB2.setFocusPainted(false);
            winnerB2.setBorderPainted(false);

            WinnerButtonHandler handler = new WinnerButtonHandler();
            winnerB2.addActionListener(handler);

            winnerF.add(winnerP);
            winnerF.add(winnerDeckP2);
            winnerF.add(winnerDeckP);
            winnerF.add(winnerB2);

         }
      });

      set = new JMenuItem("족보");
      menu3.add(set);
      setArray = new JMenuItem("패 정렬");
      menu3.add(setArray);
      setArray.addActionListener(new ActionListener() {/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	  public void actionPerformed(ActionEvent e) {
    		  System.out.println("visible : "+visible);
    		  for(int i=0;i<userCount;i++) {
    			  userDeckP[i].setVisible(false);    			  
    		  }
    		  userDeckP = new JPanel[userCount];
    	      for (int i = 0; i < userCount; i++) {
    	         userDeckP[i] = new JPanel();
    	         userDeckP[i].setOpaque(true);
    	         userDeckP[i].setBackground(new Color(051, 102, 051));

    	         TitledBorder title = new TitledBorder(user[i].getName());
    	         title.setTitleColor(Color.WHITE);
    	         title.setTitleFont(new Font("bold", Font.BOLD, 15));

    	         userDeckP[i].setBorder(title);
    	         if (userCount == 1) {
    	            userDeckP[i].setBounds(525, 400, 550, 400);
    	         } else if (userCount == 2)
    	            userDeckP[i].setBounds(225 + (i * 600), 400, 550, 400);
    	         else if (userCount == 3)
    	            userDeckP[i].setBounds(50 + (i * 500), 400, 500, 380);
    	         else if (userCount == 4)
    	            userDeckP[i].setBounds(i * 390, 400, 390, 330);
    	         else {
    	            if (i == 0)
    	               userDeckP[i].setBounds(320, 400, 320, 270);
    	            if (i == 1)
    	               userDeckP[i].setBounds(960, 400, 320, 270);
    	            if (i == 2)
    	               userDeckP[i].setBounds(0, 550, 320, 270);
    	            if (i == 3)
    	               userDeckP[i].setBounds(640, 550, 320, 270);
    	            if (i == 4)
    	               userDeckP[i].setBounds(1280, 550, 315, 270);

    	         }
    	         userDeckP[i].setLayout(new GridLayout(2, 3));
    	         gameP.add(userDeckP[i]);
    	      }
    	      
    	      userCards = new UserCardButton[userCount][cardCount]; // card 앞면
    	      backCards = new BackCardButton[userCount][cardCount]; // card 뒷면
    	      ShowCardHandler showCardHandler = new ShowCardHandler();
    	      HideCardHandler hideCardHandler = new HideCardHandler();
    		  userCount_button = 0;
    	      for (int i = 0; i < userCount; i++) { // userDeck에 cardButton 생성.
    	         cardCount_button = cardCount-1;
    	         for (int j = 0; j < cardCount; j++) {
    	            userCards[i][j] = new UserCardButton();
    	            userCards[i][j].setBorderPainted(false);
    	            userCards[i][j].addActionListener(hideCardHandler);
    	            userDeckP[i].add(userCards[i][j]);
    	            
    	            backCards[i][j] = new BackCardButton();
    	            backCards[i][j].setBorderPainted(false); // 외각선 지움
    	            backCards[i][j].addActionListener(showCardHandler);
    	            userDeckP[i].add(backCards[i][j]);
    	            
    	            if(visible == false) {
    	            	userCards[i][j].setVisible(false);
    	            }else {
    	            	backCards[i][j].setVisible(false);
    	            }
    	            cardCount_button--;
    	         }
    	         userCount_button++;
    	      }
    	      gameP.revalidate();
    	  }
    	 
      });
      set.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            setF = new JFrame("족보");
            setScoreP(setF);
            setF.setSize(550, 800);
            // setF.getContentPane().setBackground(Color.black);
            setF.setLocationRelativeTo(null);
            setF.setVisible(true);
            // setF.setLayout(null);
         }
      });
      set.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  
          }
       });

      newGame = new JMenuItem("새 게임");
      menu1.add(newGame);
      menu1.addSeparator();
      newGame.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            gameP.setVisible(false);
            bar.setVisible(false);
            userCountP(frame);
            userCountP.setVisible(true);
         }
      });

      exitGame = new JMenuItem("로비로");
      menu1.add(exitGame);
      exitGame.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            gameP.setVisible(false);
            bar.setVisible(false);
            mainP(frame);
            mainP.setVisible(true);
         }
      });

      open = new JMenu("패 공개");
      hide = new JMenu("패 숨김");

      openItems = new JMenuItem[userCount + 1];
      menu2.add(open);
      menu2.addSeparator();

      openGroup = new ButtonGroup();
      OpenItemHandler openHandler = new OpenItemHandler();
      for (int i = 0; i < userCount; i++) {
         openItems[i] = new JMenuItem(user[i].getName());
         open.add(openItems[i]);
         open.addSeparator();
         openGroup.add(openItems[i]);
         openItems[i].addActionListener(openHandler);
      }
      openItems[userCount] = new JMenuItem("모두");
      open.add(openItems[userCount]);
      openGroup.add(openItems[userCount]);
      openItems[userCount].addActionListener(openHandler);

      hideItems = new JMenuItem[userCount + 1];
      menu2.add(hide);
      hideGroup = new ButtonGroup();
      HideItemHandler hideHandler = new HideItemHandler();
      for (int i = 0; i < userCount; i++) {
         hideItems[i] = new JMenuItem(user[i].getName());
         hide.add(hideItems[i]);
         hideGroup.add(hideItems[i]);
         hide.addSeparator();
         hideItems[i].addActionListener(hideHandler);
      }
      hideItems[userCount] = new JMenuItem("모두");
      hide.add(hideItems[userCount]);
      hideGroup.add(hideItems[userCount]);
      hideItems[userCount].addActionListener(hideHandler);

      userDeckP = new JPanel[userCount]; // userDeck panel 생성
      for (int i = 0; i < userCount; i++) {
         userDeckP[i] = new JPanel();
         userDeckP[i].setOpaque(true);
         userDeckP[i].setBackground(new Color(051, 102, 051));

         TitledBorder title = new TitledBorder(user[i].getName());
         title.setTitleColor(Color.WHITE);
         title.setTitleFont(new Font("bold", Font.BOLD, 15));

         userDeckP[i].setBorder(title);
         if (userCount == 1) {
            userDeckP[i].setBounds(525, 400, 550, 400);
         } else if (userCount == 2)
            userDeckP[i].setBounds(225 + (i * 600), 400, 550, 400);
         else if (userCount == 3)
            userDeckP[i].setBounds(50 + (i * 500), 400, 500, 380);
         else if (userCount == 4)
            userDeckP[i].setBounds(i * 390, 400, 390, 330);
         else {
            if (i == 0)
               userDeckP[i].setBounds(320, 400, 320, 270);
            if (i == 1)
               userDeckP[i].setBounds(960, 400, 320, 270);
            if (i == 2)
               userDeckP[i].setBounds(0, 550, 320, 270);
            if (i == 3)
               userDeckP[i].setBounds(640, 550, 320, 270);
            if (i == 4)
               userDeckP[i].setBounds(1280, 550, 315, 270);

         }
         userDeckP[i].setLayout(new GridLayout(2, 3));
         gameP.add(userDeckP[i]);

      }

      userCards = new UserCardButton[userCount][cardCount]; // card 앞면
      backCards = new BackCardButton[userCount][cardCount]; // card 뒷면
      ShowCardHandler showCardHandler = new ShowCardHandler();
      HideCardHandler hideCardHandler = new HideCardHandler();

      userCount_button = 0;
      for (int i = 0; i < userCount; i++) { // userDeck에 cardButton 생성.
         cardCount_button = 0;

         for (int j = 0; j < cardCount; j++) {
            userCards[i][j] = new UserCardButton();
            userCards[i][j].setBorderPainted(false);
            userCards[i][j].addActionListener(hideCardHandler);
            userDeckP[i].add(userCards[i][j]);
            userCards[i][j].setVisible(false); // backCard 먼저.
            
            backCards[i][j] = new BackCardButton();
            backCards[i][j].setBorderPainted(false); // 외각선 지움
            backCards[i][j].addActionListener(showCardHandler);
            userDeckP[i].add(backCards[i][j]);
            cardCount_button++;
         }
         userCount_button++;
      }
      frame.add((gameP));
   }

   public void setScoreP(JFrame frame) {
      setP = new JPanel() {
         public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image_main = new ImageIcon("images/more.jpg");
            g.drawImage(image_main.getImage(), 0, 0, d.width, d.height, this);
         }
      };
      setF.add(setP);
   }

   public void allDeckMainP(JFrame frame) {////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      allDeckMainP = new JPanel();
      allDeckP = new JPanel[userCount]; // userDeck panel 생성
      for (int i = 0; i < userCount; i++) {
         allDeckP[i] = new JPanel();
         allDeckP[i].setOpaque(true);
         allDeckP[i].setBackground(new Color(051, 102, 051));
         /*
          * TitledBorder title = new TitledBorder(user[rankedUserIndex[i]].getName());
          * title.setTitleColor(Color.white); allDeckP[i].setBorder(title);
          */
         allDeckP[i].setBounds(i * 100, 0, 100, 100);
         allDeckP[i].setLayout(new GridLayout(1, 5));
         winnerF.add(allDeckP[i]);
      }
      /*
       * userCount_all = 0; for (int i = 0; i < userCount; i++) { // userDeck에
       * cardButton 생성. cardCount_all = 0; for (int j = 0; j < cardCount; j++) {
       * allDeckLb[i][j] = new AllDeckLb(); allDeckP[i].add(allDeckLb[i][j]);
       * //cardCount_all++; } //userCount_all++; }
       */
      for (int i = 0; i < userCount; i++) {
         allDeckMainP.add(userDeckP[i]);
         userDeckP[i].setVisible(true);
         allDeckP[i].add(userDeckP[i]);
      }

      allDeckLb2 = new JLabel("모든 선수의 패 확인");
      userCount1.setOpaque(true);
      userCount1.setBackground(new Color(051, 102, 051));
      userCount1.setForeground(Color.white);
      userCount1.setHorizontalAlignment(JLabel.CENTER);
      userCount1.setFont(new Font("bold", Font.BOLD, 30));
      userCount1.setBounds(100, 0, 600, 50);
      allDeckMainP.add(userCount1);

      allB = new JButton("결과 확인");
      allB.setFont(new Font("bold", Font.BOLD, 20));
      allB.setBounds(100, 450, 200, 80);
      allB.setBackground(Color.gray);
      allB.setFocusPainted(false);
      allB.setBorderPainted(false);
      allB.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            winnerP.setVisible(true);
            winnerDeckP.setVisible(true);
            winnerDeckP2.setVisible(true);
            for (int i = 0; i < userCount; i++) {
               allDeckP[i].setVisible(false);
            }
            allDeckMainP.setVisible(false);
         }
      });


      winnerF.add((allDeckMainP));
   }

   public class ShowCardHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         for (int i = 0; i < userCount; i++) {
            for (int j = 0; j < cardCount; j++) {
               if (e.getSource() == backCards[i][j]) {
                  backCards[i][j].setVisible(false);
                  userCards[i][j].setVisible(true);
               }
            }
         }
      }
   }

   public class HideCardHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         for (int i = 0; i < userCount; i++) {
            for (int j = 0; j < cardCount; j++) {
               if (e.getSource() == userCards[i][j]) {
                  backCards[i][j].setVisible(true);
                  userCards[i][j].setVisible(false);
               }
            }
         }
      }
   }

   private class MainButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (e.getSource() == enter_main) {
            mainP.setVisible(false);
            userCountP(frame);
         }
         if (e.getSource() == exit_main) {
            System.exit(0);
         }
      }
   }

   private class UserCountButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (e.getSource() == oik) { // 확인 눌렀을 때 반응.
            if (Integer.parseInt(inputUserCount.getText()) <= 5
                  && Integer.parseInt(inputUserCount.getText()) >= 1) {
               userCount = Integer.parseInt(inputUserCount.getText());
               user = new User[userCount];
               Deck deck = new Deck(); // user 패 생성.
               for (int i = 0; i < userCount; i++) {
                  user[i] = new User(); // userCount 만큼의 user 생성.
                  deck.pushCard(user[i]); // user에게 카드 나눠줌.
               }

               /*
                * for(int i=0; i<userCount; i++) { System.out.printf("user[%d] : ", i); for(int
                * j=0; j<cardCount; j++) {
                * System.out.print(user[i].getCard(j).getShape()+user[i].getCard(j).getRank()
                * +" "); } System.out.println(); }
                */

               userCountP.setVisible(false);
               userNameP(frame);
            } else {
               JOptionPane.showMessageDialog(null, "1~5명만  참가 가능합니다.", "Error", JOptionPane.ERROR_MESSAGE); // 예외처리.
            }
         }
         if (e.getSource() == exit) {
            mainP.setVisible(true);
            userCountP.setVisible(false);
         }
      }
   }

   private class UserNameButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (e.getSource() == oik) {
            boolean pass = true;
            for (int i = 0; i < userCount; i++) {
               if (inputUserName_array[i].getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "참가자 이름을 입력하세요.", "Error", JOptionPane.ERROR_MESSAGE); // 예외처리.
                  pass = false;
                  break;
               } else {
                  user[i].setName(inputUserName_array[i].getText());
               }
            }

            if (pass == true) {
               userNameP.setVisible(false);
               gameP(frame);
            }
         }
         if (e.getSource() == exit) {
            mainP.setVisible(true);
            userNameP.setVisible(false);
         }
      }
   }

   private class HideItemHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (e.getSource() == hideItems[userCount]) {
        	 visible = false;
            for (int i = 0; i < userCount; i++) {
               for (int j = 0; j < cardCount; j++) {
                  userCards[i][j].setVisible(false);
                  backCards[i][j].setVisible(true);
               }
            }
         } else {
        	 visible = true;
            for (int i = 0; i < userCount; i++) {
               if (e.getSource() == hideItems[i]) {
                  for (int j = 0; j < cardCount; j++) {
                     userCards[i][j].setVisible(false);
                     backCards[i][j].setVisible(true);
                  }
                  break;
               }
            }
         }
      }
   }

   private class OpenItemHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (e.getSource() == openItems[userCount]) {
        	 visible = true;
            for (int i = 0; i < userCount; i++) {
               for (int j = 0; j < cardCount; j++) {
                  userCards[i][j].setVisible(true);
                  backCards[i][j].setVisible(false);
               }
            }
         } else {
        	 visible = false;
            for (int i = 0; i < userCount; i++) {
               if (e.getSource() == openItems[i]) {
                  for (int j = 0; j < cardCount; j++) {
                     userCards[i][j].setVisible(true);
                     backCards[i][j].setVisible(false);
                  }
                  break;
               }
            }
         }
      }
   }

   private class WinnerButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (e.getSource() == winnerB2) {
            winnerF.dispose();
         }
      }
   }

   public class BackCardButton extends JButton {
      @Override
      public void paintComponent(Graphics g) {
         Dimension d = getSize();
         ImageIcon image = new ImageIcon("images/back.jpg");
         g.drawImage(image.getImage(), 0, 0, d.width, d.height, this);
      }
   }

   public class UserCardButton extends JButton {
      int i = userCount_button;
      int j = cardCount_button;
      
      @Override
      public void paintComponent(Graphics g) {
         Dimension d = getSize();
         ImageIcon image = null;
         if (user[i].getCard(j).getShape().equals("♣")) {
            switch (user[i].getCard(j).getRank()) {
            case 2:
               image = new ImageIcon("images/c2.jpg");
               break;
            case 3:
               image = new ImageIcon("images/c3.jpg");
               break;
            case 4:
               image = new ImageIcon("images/c4.jpg");
               break;
            case 5:
               image = new ImageIcon("images/c5.jpg");
               break;
            case 6:
               image = new ImageIcon("images/c6.jpg");
               break;
            case 7:
               image = new ImageIcon("images/c7.jpg");
               break;
            case 8:
               image = new ImageIcon("images/c8.jpg");
               break;
            case 9:
               image = new ImageIcon("images/c9.jpg");
               break;
            case 10:
               image = new ImageIcon("images/c10.jpg");
               break;
            case 11:
               image = new ImageIcon("images/c11.jpg");
               break;
            case 12:
               image = new ImageIcon("images/c12.jpg");
               break;
            case 13:
               image = new ImageIcon("images/c13.jpg");
               break;
            default:
               image = new ImageIcon("images/ca.jpg");
            }
         } else if (user[i].getCard(j).getShape().equals("♥")) {
            switch (user[i].getCard(j).getRank()) {
            case 2:
               image = new ImageIcon("images/h2.jpg");
               break;
            case 3:
               image = new ImageIcon("images/h3.jpg");
               break;
            case 4:
               image = new ImageIcon("images/h4.jpg");
               break;
            case 5:
               image = new ImageIcon("images/h5.jpg");
               break;
            case 6:
               image = new ImageIcon("images/h6.jpg");
               break;
            case 7:
               image = new ImageIcon("images/h7.jpg");
               break;
            case 8:
               image = new ImageIcon("images/h8.jpg");
               break;
            case 9:
               image = new ImageIcon("images/h9.jpg");
               break;
            case 10:
               image = new ImageIcon("images/h10.jpg");
               break;
            case 11:
               image = new ImageIcon("images/h11.jpg");
               break;
            case 12:
               image = new ImageIcon("images/h12.jpg");
               break;
            case 13:
               image = new ImageIcon("images/h13.jpg");
               break;
            default:
               image = new ImageIcon("images/ha.jpg");
            }
         } else if (user[i].getCard(j).getShape().equals("♠")) {
            switch (user[i].getCard(j).getRank()) {
            case 2:
               image = new ImageIcon("images/s2.jpg");
               break;
            case 3:
               image = new ImageIcon("images/s3.jpg");
               break;
            case 4:
               image = new ImageIcon("images/s4.jpg");
               break;
            case 5:
               image = new ImageIcon("images/s5.jpg");
               break;
            case 6:
               image = new ImageIcon("images/s6.jpg");
               break;
            case 7:
               image = new ImageIcon("images/s7.jpg");
               break;
            case 8:
               image = new ImageIcon("images/s8.jpg");
               break;
            case 9:
               image = new ImageIcon("images/s9.jpg");
               break;
            case 10:
               image = new ImageIcon("images/s10.jpg");
               break;
            case 11:
               image = new ImageIcon("images/s11.jpg");
               break;
            case 12:
               image = new ImageIcon("images/s12.jpg");
               break;
            case 13:
               image = new ImageIcon("images/s13.jpg");
               break;
            default:
               image = new ImageIcon("images/sa.jpg");
            }
         } else if (user[i].getCard(j).getShape().equals("◆")) {
            switch (user[i].getCard(j).getRank()) {
            case 2:
               image = new ImageIcon("images/d2.jpg");
               break;
            case 3:
               image = new ImageIcon("images/d3.jpg");
               break;
            case 4:
               image = new ImageIcon("images/d4.jpg");
               break;
            case 5:
               image = new ImageIcon("images/d5.jpg");
               break;
            case 6:
               image = new ImageIcon("images/d6.jpg");
               break;
            case 7:
               image = new ImageIcon("images/d7.jpg");
               break;
            case 8:
               image = new ImageIcon("images/d8.jpg");
               break;
            case 9:
               image = new ImageIcon("images/d9.jpg");
               break;
            case 10:
               image = new ImageIcon("images/d10.jpg");
               break;
            case 11:
               image = new ImageIcon("images/d11.jpg");
               break;
            case 12:
               image = new ImageIcon("images/d12.jpg");
               break;
            case 13:
               image = new ImageIcon("images/d13.jpg");
               break;
            default:
               image = new ImageIcon("images/da.jpg");
            }
         }
         g.drawImage(image.getImage(), 0, 0, d.width, d.height, this);
      }
   }

   public class WinnerCardLb extends JLabel {
      int w = cardCount_winner;

      @Override
      public void paintComponent(Graphics g) {
         ImageIcon image = null;
         Dimension d = getSize();
         if (winner.getCard(w).getShape().equals("♣")) {
            switch (winner.getCard(w).getRank()) {
            case 2:
               image = new ImageIcon("images/c2.jpg");
               break;
            case 3:
               image = new ImageIcon("images/c3.jpg");
               break;
            case 4:
               image = new ImageIcon("images/c4.jpg");
               break;
            case 5:
               image = new ImageIcon("images/c5.jpg");
               break;
            case 6:
               image = new ImageIcon("images/c6.jpg");
               break;
            case 7:
               image = new ImageIcon("images/c7.jpg");
               break;
            case 8:
               image = new ImageIcon("images/c8.jpg");
               break;
            case 9:
               image = new ImageIcon("images/c9.jpg");
               break;
            case 10:
               image = new ImageIcon("images/c10.jpg");
               break;
            case 11:
               image = new ImageIcon("images/c11.jpg");
               break;
            case 12:
               image = new ImageIcon("images/c12.jpg");
               break;
            case 13:
               image = new ImageIcon("images/c13.jpg");
               break;
            default:
               image = new ImageIcon("images/ca.jpg");
            }
         } else if (winner.getCard(w).getShape().equals("♥")) {
            switch (winner.getCard(w).getRank()) {
            case 2:
               image = new ImageIcon("images/h2.jpg");
               break;
            case 3:
               image = new ImageIcon("images/h3.jpg");
               break;
            case 4:
               image = new ImageIcon("images/h4.jpg");
               break;
            case 5:
               image = new ImageIcon("images/h5.jpg");
               break;
            case 6:
               image = new ImageIcon("images/h6.jpg");
               break;
            case 7:
               image = new ImageIcon("images/h7.jpg");
               break;
            case 8:
               image = new ImageIcon("images/h8.jpg");
               break;
            case 9:
               image = new ImageIcon("images/h9.jpg");
               break;
            case 10:
               image = new ImageIcon("images/h10.jpg");
               break;
            case 11:
               image = new ImageIcon("images/h11.jpg");
               break;
            case 12:
               image = new ImageIcon("images/h12.jpg");
               break;
            case 13:
               image = new ImageIcon("images/h13.jpg");
               break;
            default:
               image = new ImageIcon("images/ha.jpg");
            }
         } else if (winner.getCard(w).getShape().equals("♠")) {
            switch (winner.getCard(w).getRank()) {
            case 2:
               image = new ImageIcon("images/s2.jpg");
               break;
            case 3:
               image = new ImageIcon("images/s3.jpg");
               break;
            case 4:
               image = new ImageIcon("images/s4.jpg");
               break;
            case 5:
               image = new ImageIcon("images/s5.jpg");
               break;
            case 6:
               image = new ImageIcon("images/s6.jpg");
               break;
            case 7:
               image = new ImageIcon("images/s7.jpg");
               break;
            case 8:
               image = new ImageIcon("images/s8.jpg");
               break;
            case 9:
               image = new ImageIcon("images/s9.jpg");
               break;
            case 10:
               image = new ImageIcon("images/s10.jpg");
               break;
            case 11:
               image = new ImageIcon("images/s11.jpg");
               break;
            case 12:
               image = new ImageIcon("images/s12.jpg");
               break;
            case 13:
               image = new ImageIcon("images/s13.jpg");
               break;
            default:
               image = new ImageIcon("images/sa.jpg");
            }
         } else if (winner.getCard(w).getShape().equals("◆")) {
            switch (winner.getCard(w).getRank()) {
            case 2:
               image = new ImageIcon("images/d2.jpg");
               break;
            case 3:
               image = new ImageIcon("images/d3.jpg");
               break;
            case 4:
               image = new ImageIcon("images/d4.jpg");
               break;
            case 5:
               image = new ImageIcon("images/d5.jpg");
               break;
            case 6:
               image = new ImageIcon("images/d6.jpg");
               break;
            case 7:
               image = new ImageIcon("images/d7.jpg");
               break;
            case 8:
               image = new ImageIcon("images/d8.jpg");
               break;
            case 9:
               image = new ImageIcon("images/d9.jpg");
               break;
            case 10:
               image = new ImageIcon("images/d10.jpg");
               break;
            case 11:
               image = new ImageIcon("images/d11.jpg");
               break;
            case 12:
               image = new ImageIcon("images/d12.jpg");
               break;
            case 13:
               image = new ImageIcon("images/d13.jpg");
               break;
            default:
               image = new ImageIcon("images/da.jpg");
            }
         }
         g.drawImage(image.getImage(), 0, 0, d.width, d.height, this);
      }
   }
}