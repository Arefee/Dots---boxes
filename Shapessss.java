import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import javax.swing.Timer;
import javax.swing.border.StrokeBorder;

public class Shapessss extends JPanel implements MouseListener {

	private boolean flag = true;
	private int k1; // mokhtasat y noghte aval
	private int h1; // mokhtasat x noghte aval
	private int k2; // mokhtasat y noghte dovom
	private int h2; // mokhtasat x noghte dovom
	private int x1; // mokhtasat x bar hasbe pixel noghte aval
	private int x2; // mokhtasat x bar hasbe pixel noghte dovom
	private int y1; // mokhtasat y bar hasbe pixel noghte aval
	private int y2; // mokhtasat y bar hasbe pixel noghte dovom
	private float l; // fasele beine do noghte
	Point point1; // noghte aval
	Point point2; // noghte dovom
	Line2D line2d; // khate beine do noghte
	Rectangle2D rectangle2d; // morabe sakhte shode beine chahar khat
	Graphics gg;
	Graphics2D ggg2d;
	private int tedadNoghte;
	private int faseleNoghte;
	private boolean[][][] arr; // noghtehaye safhe bazi
	private int tedadBazikon;
	private int player = 0; // shomarande nobat bazikonha
	Color color;
	private int[][] square; // morbahaye ijad shode

	public Shapessss(int x, int n) {
		super();
		addMouseListener(this);
		tedadNoghte = x;
		tedadBazikon = n;
		arr = new boolean[tedadNoghte + 1][tedadNoghte + 1][4];
		square = new int[tedadNoghte - 1][tedadNoghte - 1];
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				square[i][j] = -1;
			} // payane for
		} // payane for

	}// payane constructor Shapessss

	// reset kardan bazi
	public void resetGame() {
		Graphics gggg = getGraphics();
		gggg.setColor(Color.WHITE);
		gggg.fillRect(0, 0, 450, 480);
		gggg.setColor(Color.RED);

		// sakhte dobare safhe
		int x = 0, y = 0;
		for (int i = 0; i < tedadNoghte; i++) {

			x = 0;
			y += faseleNoghte;

			for (int j = 0; j < tedadNoghte; j++) {
				gggg.fillOval(x += faseleNoghte, y, 8, 8);

			} // payan for

		} // payan for

		// arzash gozari morabaha
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				square[i][j] = -1;
			} // payan for
		} // payan for

		// arzesh gozari noghat
		for (int i = 0; i < (tedadNoghte + 1); i++) {
			for (int j = 0; j < (tedadNoghte + 1); j++) {
				for (int j2 = 0; j2 < 4; j2++) {
					arr[i][j][j2] = false;
				} // payan for
			} // payan for
		} // payan for

	}// payan resetGame

	// sakhte safahe bazi
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 450, 480);
		g.setColor(Color.RED);

		// ijade noghate bazi
		int x = 0, y = 0;
		faseleNoghte = (450 / (tedadNoghte + 1));
		for (int i = 0; i < tedadNoghte; i++) {

			x = 0;
			y += faseleNoghte;

			for (int j = 0; j < tedadNoghte; j++) {
				g.fillOval(x += faseleNoghte, y, 8, 8);

			} // payane for

		} // payane for

	} // payane paintComponent

	// ijade khatha va morabaha
	@Override
	public void mouseClicked(MouseEvent e) {

		if (flag == true) { // noghte aval

			point1 = e.getPoint();
			x1 = (int) point1.getX();
			y1 = (int) point1.getY();
			flag = false;

		} else { // noghte dovom

			point2 = e.getPoint();
			x2 = (int) point2.getX();
			y2 = (int) point2.getY();

			// bedast avardane mokhtasate do noghte bar hasbe x va y
			if (x1 % faseleNoghte < 7 && y1 % faseleNoghte < 7) {
				l = (float) Math.sqrt((Math.pow((x1 - x2), 2)) + Math.pow((y1 - y2), 2)); // mohasebe
																							// andaze
																							// khate
																							// beine
																							// do
																							// noghte

				// baresi andaze khat va ijade khat
				if (l <= (faseleNoghte + 7) && l >= (faseleNoghte - 7)) {

					if (x1 % faseleNoghte < 8)
						h1 = x1 / faseleNoghte;
					else {
						h1 = ((x1 / faseleNoghte) + 1);
					}
					if (y1 % faseleNoghte < 8)
						k1 = y1 / faseleNoghte;
					else {
						k1 = ((y1 / faseleNoghte) + 1);
					}

					if (x2 % faseleNoghte < 8)
						h2 = x2 / faseleNoghte;
					else {
						h2 = ((x2 / faseleNoghte) + 1);
					}
					if (y2 % faseleNoghte < 8)
						k2 = y2 / faseleNoghte;
					else {
						k2 = ((y2 / faseleNoghte) + 1);
					}
					line2d = new Line2D.Double(point1, point2);
					Graphics g = getGraphics();
					ggg2d = (Graphics2D) g;

					// baresi nobate bazikonha va gharar dadan har rang baraie
					// yek nafar
					if (player == 0) {
						ggg2d.setColor(Color.YELLOW);
						color = Color.YELLOW;
					} else if (player == 1) {
						ggg2d.setColor(Color.PINK);
						color = Color.PINK;
					} else if (player == 2) {
						ggg2d.setColor(Color.GREEN);
						color = Color.GREEN;
					} else if (player == 3) {
						ggg2d.setColor(Color.CYAN);
						color = Color.CYAN;
					} else if (player == 4) {
						ggg2d.setColor(Color.GRAY);
						color = Color.GRAY;
					} else if (player == 5) {
						ggg2d.setColor(Color.BLUE);
						color = Color.BLUE;
					} else if (player == 6) {
						ggg2d.setColor(Color.ORANGE);
						color = Color.ORANGE;
					} else if (player == 7) {
						ggg2d.setColor(Color.MAGENTA);
						color = Color.MAGENTA;
					} else if (player == 8) {
						ggg2d.setColor(Color.RED);
						color = Color.RED;
					} else if (player == 9) {
						ggg2d.setColor(Color.BLACK);
						color = Color.BLACK;
					}

					if (player == (tedadBazikon - 1)) {
						player = 0;
					} else {
						player++;
					}

					ggg2d.drawLine(point1.x, point1.y, point2.x, point2.y); // ijade
																			// khat

					// barresi sharayete sakhte moraba
					if (k1 == k2) { // khat ofeghi
						if (h1 > h2) { // khat az rast be chap
							arr[h1][k1][0] = true;
							arr[h2][k2][2] = true;

							if (k1 > 1) {
								if (arr[h2][k2 - 1][3] == true && arr[h2][k2 - 1][2] == true
										&& arr[h1][k1 - 1][3] == true) {
									ggg2d = (Graphics2D) getGraphics();
									ggg2d.setColor(color);
									ggg2d.fill(new Rectangle2D.Double((h2 * faseleNoghte) + 5,
											((k1 - 1) * faseleNoghte) + 5, faseleNoghte, faseleNoghte));
									if (player == 0) {
										player = (tedadBazikon - 1);
									} else {
										player--;
									}
									square[h2 - 1][k1 - 2] = player;

								}

							}
							if (k1 < tedadNoghte) {
								if (arr[h2][k2 + 1][1] == true && arr[h2][k2 + 1][2] == true
										&& arr[h1][k1 + 1][1] == true) {
									rectangle2d = new Rectangle2D.Double((h2 * faseleNoghte) + 5,
											(k2 * faseleNoghte) + 5, faseleNoghte, faseleNoghte);
									ggg2d = (Graphics2D) getGraphics();
									ggg2d.setColor(color);
									ggg2d.fill(rectangle2d);
									if (player == 0) {
										player = (tedadBazikon - 1);
									} else {
										player--;
									}
									square[h2 - 1][k2 - 1] = player;
								}
							}

						} else { // khat az ghap be rast
							arr[h2][k2][0] = true;
							arr[h1][k1][2] = true;

							if (k1 > 1) {
								if (arr[h1][k1 - 1][3] == true && arr[h1][k1 - 1][2] == true
										&& arr[h2][k2 - 1][3] == true) {
									rectangle2d = new Rectangle2D.Double((h1 * faseleNoghte) + 5,
											((k1 - 1) * faseleNoghte) + 5, faseleNoghte, faseleNoghte);
									ggg2d = (Graphics2D) getGraphics();
									ggg2d.setColor(color);
									ggg2d.fill(rectangle2d);
									if (player == 0) {
										player = (tedadBazikon - 1);
									} else {
										player--;
									}
									square[h1 - 1][k1 - 2] = player;
								}

							}
							if (k1 < tedadNoghte) {
								if (arr[h1][k1][3] == true && arr[h1][k1 + 1][1] == true && arr[h1][k1 + 1][2] == true
										&& arr[h2][k2 + 1][0] == true && arr[h2][k2 + 1][1] == true
										&& arr[h2][k2][3] == true) {
									rectangle2d = new Rectangle2D.Double((h1 * faseleNoghte) + 5,
											(k1 * faseleNoghte) + 5, faseleNoghte, faseleNoghte);
									ggg2d = (Graphics2D) getGraphics();
									ggg2d.setColor(color);
									ggg2d.fill(rectangle2d);
									if (player == 0) {
										player = (tedadBazikon - 1);
									} else {
										player--;
									}
									square[h1 - 1][k1 - 1] = player;
								}
							}
						} // payane if va else barresi konnede jahate khat
					} else { // khate amodi
						if (k2 > k1) { // khat az bala be payen
							arr[h1][k1][3] = true;
							arr[h2][k2][1] = true;
							if (h1 > 1) {
								if (arr[h1][k1][0] == true && arr[h1 - 1][k1][2] == true && arr[h1 - 1][k1][3] == true
										&& arr[h2 - 1][k2][1] == true && arr[h2 - 1][k2][2] == true
										&& arr[h2][k2][0] == true) {
									rectangle2d = new Rectangle2D.Double(((h1 - 1) * faseleNoghte) + 5,
											(k1 * faseleNoghte) + 5, faseleNoghte, faseleNoghte);
									ggg2d = (Graphics2D) getGraphics();
									ggg2d.setColor(color);
									ggg2d.fill(rectangle2d);
									if (player == 0) {
										player = (tedadBazikon - 1);
									} else {
										player--;
									}
									square[h1 - 2][k1 - 1] = player;
								}

							}
							if (h1 < tedadNoghte) {
								if (arr[h1][k1][2] == true && arr[h1 + 1][k1][0] == true && arr[h1 + 1][k1][3] == true
										&& arr[h2 + 1][k2][1] == true && arr[h2 + 1][k2][0] == true
										&& arr[h2][k2][2] == true) {
									rectangle2d = new Rectangle2D.Double((h1 * faseleNoghte) + 5,
											(k1 * faseleNoghte) + 5, faseleNoghte, faseleNoghte);
									ggg2d = (Graphics2D) getGraphics();
									ggg2d.setColor(color);
									ggg2d.fill(rectangle2d);
									if (player == 0) {
										player = (tedadBazikon - 1);
									} else {
										player--;
									}
									square[h1 - 1][k1 - 1] = player;
								}
							}

						} else { // khat az payen be bala
							arr[h2][k2][3] = true;
							arr[h1][k1][1] = true;
							if (h1 > 1) {
								if (arr[h2][k2][0] == true && arr[h2 - 1][k2][2] == true && arr[h2 - 1][k2][3] == true
										&& arr[h1 - 1][k1][1] == true && arr[h1 - 1][k1][2] == true
										&& arr[h1][k1][0] == true) {
									rectangle2d = new Rectangle2D.Double(((h2 - 1) * faseleNoghte) + 5,
											(k2 * faseleNoghte) + 5, faseleNoghte, faseleNoghte);
									ggg2d = (Graphics2D) getGraphics();
									ggg2d.setColor(color);
									ggg2d.fill(rectangle2d);
									if (player == 0) {
										player = (tedadBazikon - 1);
									} else {
										player--;
									}
									square[h2 - 2][k2 - 1] = player;
								}

							}
							if (h1 < tedadNoghte) {
								if (arr[h2][k2][2] == true && arr[h2 + 1][k2][0] == true && arr[h2 + 1][k2][3] == true
										&& arr[h1 + 1][k1][1] == true && arr[h1 + 1][k1][0] == true
										&& arr[h1][k1][2] == true) {
									rectangle2d = new Rectangle2D.Double((h2 * faseleNoghte) + 5,
											(k2 * faseleNoghte) + 5, faseleNoghte, faseleNoghte);
									ggg2d = (Graphics2D) getGraphics();
									ggg2d.setColor(color);
									ggg2d.fill(rectangle2d);
									if (player == 0) {
										player = (tedadBazikon - 1);
									} else {
										player--;
									}
									square[h2 - 1][k2 - 1] = player;
								}
							}

						} // payane if barrsi konnade jahate khat

					} // payan if va else khate ofoghi va amodi

				} // payan if barresi konnade andaze khat
			} // payan if ijad khat

			flag = true;

		} // payan if va else yek joft noghte

		// shomarande tadad morbahaie ijad shode tavasote har bazi kon
		int a = 0, b = 0, c = 0, d = 0, ee = 0, f = 0, g = 0, h = 0, ii = 0, jj = 0, k = 0;
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				if (square[i][j] == 0)
					a++;
				else if (square[i][j] == 1)
					b++;
				else if (square[i][j] == 2)
					c++;
				else if (square[i][j] == 3)
					d++;
				else if (square[i][j] == 4)
					ee++;
				else if (square[i][j] == 5)
					f++;
				else if (square[i][j] == 6)
					g++;
				else if (square[i][j] == 7)
					h++;
				else if (square[i][j] == 8)
					ii++;
				else if (square[i][j] == 9)
					jj++;
				else if (square[i][j] == -1) {
					k++;
				}

			}
		}
		// por bodan hameye khane haye jadval va taeen barande
		if (k == 0) {
			int max = a;
			for (int i = 0; i < 10; i++) {
				if (max < b)
					max = b;
				else if (max < c)
					max = c;
				else if (max < d)
					max = d;
				else if (max < ee)
					max = ee;
				else if (max < f)
					max = f;
				else if (max < g)
					max = g;
				else if (max < h)
					max = h;
				else if (max < ii)
					max = ii;
				else if (max < jj)
					max = jj;
			}
			if (max == a) {
				JOptionPane.showMessageDialog(null, "player 1");
				resetGame();
			} else if (max == b) {
				JOptionPane.showMessageDialog(null, "player 2");
				resetGame();
			} else if (max == c) {
				JOptionPane.showMessageDialog(null, "player 3");
				resetGame();
			} else if (max == d) {
				JOptionPane.showMessageDialog(null, "player 4");
				resetGame();
			} else if (max == ee) {
				JOptionPane.showMessageDialog(null, "player 5");
				resetGame();
			} else if (max == f) {
				JOptionPane.showMessageDialog(null, "player 6");
				resetGame();
			} else if (max == g) {
				JOptionPane.showMessageDialog(null, "player 7");
				resetGame();
			} else if (max == h) {
				JOptionPane.showMessageDialog(null, "player 8");
				resetGame();
			} else if (max == ii) {
				JOptionPane.showMessageDialog(null, "player 9");
				resetGame();
			} else if (max == jj) {
				JOptionPane.showMessageDialog(null, "player 10");
				resetGame();
			}

		}

	} // payan mouseClicked

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

} // payan class Shapesssss
