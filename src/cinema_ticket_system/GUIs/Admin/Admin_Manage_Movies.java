package cinema_ticket_system.GUIs.Admin;
import cinema_ticket_system.Controllers.*;
import cinema_ticket_system.DataObjects.Movie;
import cinema_ticket_system.DataObjects.MovieCategory;
import cinema_ticket_system.Utils.Utils;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Admin_Manage_Movies extends JPanel implements MovieEditFormDelegate, MovieShowTimeDelegate {
	public static JButton btnLogOut = new JButton("Log Out");
	ButtonHandler buttons = new ButtonHandler();
	static JButton btnAddMovieArt = new JButton("");
	static JButton btnManageUsers = new JButton("Manage Users");
	static JButton btnManageSeatPlan = new JButton("Manage Seat Plan");
	static JButton btnManagemovies = new JButton("Manage Movies");
	static JButton btnAddMovie = new JButton("Add");
	static JButton btnEdit = new JButton("Edit");
	JButton btnDelete = new JButton("Delete");
	static JTextArea txtMovieName = new JTextArea("Movie Name");
	ArrayList<MovieCategory> categories = DataManager.getCategories();
	String strMovieName = "Aquaman";
	String strMovieType = "2D";
	String strTheatreNo = "1 , 2";
	String strMovieTime = "9:00am , 11:30am , 1.30pm , 3:00pm \n , 5:00pm , 7:00pm";
	JLabel lblMovieName = new JLabel(strMovieName);
	JLabel lblMovieType = new JLabel(strMovieType);
	JLabel lblTheatreNo  = new JLabel(strTheatreNo);
	JLabel lblMovieTimes = new JLabel(strMovieTime);
	static String filePath;
	static JComboBox<String> cboTheatreNo = new JComboBox<String>();
	static JRadioButton rdo3D = new JRadioButton("3D" , true);
	JRadioButton rdo2D = new JRadioButton("2D" , false);
	static JComboBox<String> cboCategory = new JComboBox<>();
	static String showtimes = "9:00am , 11:30am , 1.30pm , 3:00pm \n , 5:00pm , 7:00pm";
	static String data[][] = {{"Aquaman" , "1 , 2" , showtimes , "3D"} ,
			{"How To Train Your Dragon \n (The Hidden World)" , "3" , showtimes , "2D"} ,
			{"Oh My Ghost 6" , "4" , showtimes , "2D"} };
	static String numbers[] = {"Movie Name" , "Theatre No." , "Show Times" , "Type"};
	static JTable Jt = new JTable(data , numbers);
	private static DefaultTableModel model ;
	private static Movie movieToAdd = new Movie();
	private Admin_Manage_Movies_Edit_Show_Times mShowTimesDelegate;
	private Admin_Manage_Movies_Edit mEditMovieDelegate;


		public Admin_Manage_Movies()
		{
			//Constructor for JLabels
			//Admin_main label
			JLabel Admin_main = new JLabel("Admin");
			Admin_main.setFont(new Font("Courier" ,Font.PLAIN , 26));
			Admin_main.setForeground(Color.decode("#75CBE6"));
			Admin_main.setBounds(85 , 50 , 100, 50);
			

			//Movie Table

			String[][] Data = {};
			String[] ColumnNames = {"Movie Name" , "Theatre No" , "Show Times" , "Type" , "Category"};
			model = new DefaultTableModel(data , ColumnNames){
				@Override
				public boolean isCellEditable(final int row, final int column) {
					return false;
				}
			};
			Jt = new JTable(model);
			Jt.setPreferredScrollableViewportSize(new Dimension(90 , 300));
			Jt.setFillsViewportHeight(true);
			JScrollPane scrollPane = new JScrollPane(Jt);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBounds(300 ,100 , 867 , 300);
			scrollPane.setViewportView(Jt);
			Jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			Jt.getColumnModel().getColumn(0).setMinWidth(100);
			Jt.setAutoCreateRowSorter(true);
			Jt.getTableHeader().setReorderingAllowed(false);
			Jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Jt.setRowHeight(30);
			Jt.setFont(new Font("Roboto", Font.PLAIN, 15));
			Jt.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					int selectedRow = Jt.getSelectedRow();
					if(selectedRow >= 0)
					{
						lblMovieName.setText(Jt.getValueAt(selectedRow , 0).toString());
						lblTheatreNo.setText(Jt.getValueAt(selectedRow , 1).toString());
						lblMovieTimes.setText(Jt.getValueAt(selectedRow , 2).toString());
						lblMovieType.setText(Jt.getValueAt(selectedRow , 3).toString());
					}
				}
			});

			final Color originColor = new Color(232 , 232 , 232);
			Jt.getTableHeader().setResizingAllowed(false);
			Jt.getColumnModel().getColumn(0).setPreferredWidth((scrollPane.getWidth()*2)/6);
			Jt.getColumnModel().getColumn(1).setPreferredWidth(scrollPane.getWidth()/12);
			Jt.getColumnModel().getColumn(2).setPreferredWidth((scrollPane.getWidth()*3)/6);
			Jt.getColumnModel().getColumn(3).setPreferredWidth(scrollPane.getWidth()*2/5);
			Jt.setBackground(originColor);
			Jt.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

				@Override
				public Component getTableCellRendererComponent(JTable table,
															   Object value, boolean isSelected, boolean hasFocus,
															   int row, int column) {
					Color alternateColor = new Color(164 , 185 , 191);

					Component c = super.getTableCellRendererComponent(table,
							value, isSelected, hasFocus, row, column);
					if(isSelected)
					{
						c.setBackground(Color.decode("#FF6767"));
						c.setForeground(Color.white);
					}
					else {
						c.setBackground(row % 2 == 0 ? originColor : alternateColor);
						c.setForeground(Color.decode("#303030"));
					}
					return c;
				}
			});

			DataManager.refreshMovieData(model);




			//Table's Title Label
	        JLabel Movies_on_screen = new JLabel("Movies On Screen");
			Movies_on_screen.setFont(new Font("Courier" ,Font.PLAIN , 20));
			Movies_on_screen.setForeground(Color.decode("#75CBE6"));
			Movies_on_screen.setBounds(300 , 50 , 200, 50);
			//Cinema Name Label
			JLabel lblCinemaname = new JLabel("Galaxy");
			lblCinemaname.setForeground(Color.decode("#FF6767"));
			lblCinemaname.setBounds(1000 , 620 , 200 , 50);
			lblCinemaname.setFont(new Font("Rockwell" , Font.PLAIN , 18));
			JLabel lblCinemaname1 = new JLabel("Cinemas");
			lblCinemaname1.setForeground(Color.decode("#E3E3E3"));
			lblCinemaname1.setBounds(1080 , 620 , 200 , 50);
			lblCinemaname1.setFont(new Font("Rockwell" , Font.PLAIN , 18));

			//Edit Movie Name Tag Label\
			JLabel lblMovieNameTag = new JLabel("Movie Name - ");
			lblMovieNameTag.setFont(new Font("Courier" , Font.PLAIN , 18));
			lblMovieNameTag.setBounds(720 , 410 , 165 , 50);
			lblMovieNameTag.setForeground(Color.white);
			//Edit Movie Name

			lblMovieName.setForeground(Color.WHITE);
			lblMovieName.setFont(new Font("Courier", Font.PLAIN, 20));
			lblMovieName.setBounds(860, 400, 300, 72);

			lblMovieType.setForeground(new Color(117, 203, 230));
			lblMovieType.setFont(new Font("Courier", Font.PLAIN, 20));
			lblMovieType.setBounds(860, 425, 165, 72);
			//Edit Theatre No
			JLabel lblTheatreNoTag = new JLabel("Theatre No - \n");

			lblTheatreNoTag.setForeground(Color.WHITE);
			lblTheatreNoTag.setFont(new Font("Courier", Font.PLAIN, 18));
			lblTheatreNoTag.setBounds(719, 480, 165, 25);
			//Edit Theatre No. Tag

			lblTheatreNo.setBounds(860 , 470 , 150 , 40);
			lblTheatreNo.setForeground(Color.WHITE);
			lblTheatreNo.setFont(new Font("Courier" , Font.PLAIN , 20));
			//Movie Time Tag

			lblMovieTimes.setBounds(860 , 490 , 300 , 50);
			lblMovieTimes.setFont(new Font("Courier" , Font.PLAIN , 18));
			lblMovieTimes.setForeground(Color.WHITE);

			//Constructor for TextAreas
			//Movie Name

			txtMovieName.setFont(new Font("Nadeem" , Font.PLAIN , 16));
			txtMovieName.setBounds(300 , 425 , 350 , 25);
			txtMovieName.setAlignmentX(1);

			//Constructor for "Edit Movie" Button
			btnEdit.setLayout(new GridBagLayout());
			btnEdit.setBounds(715 , 530 , 100 , 40);
			btnEdit.setBackground(Color.decode("#FF6767"));
			btnEdit.setForeground(Color.WHITE);
			btnEdit.setContentAreaFilled(false);
			btnEdit.setBorder(new LineBorder(Color.decode("#242B40") , 2));
			btnEdit.setOpaque(true);
			btnEdit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					showEditDialog();
				}
			});
			btnEdit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					super.mouseEntered(e);
					btnEdit.setBackground(Color.white);
					btnEdit.setForeground(Color.decode("#FF6767"));
				}
			});
			btnEdit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					super.mouseExited(e);
					btnEdit.setBackground(Color.decode("#FF6767"));
					btnEdit.setForeground(Color.white);
				}
			});
			ImageIcon imgEdit = Utils.scaleImage(new ImageIcon("edit.png") , 20 , 20);
			btnEdit.setIcon(imgEdit);

			//Constructor for "Delete Movie Button"
			btnDelete.setBounds(820 , 530 , 100 , 40);
			btnDelete.setBackground(Color.decode("#FFB031"));
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setContentAreaFilled(false);
			btnDelete.setBorder(new LineBorder(Color.decode("#242B40") , 2));
			btnDelete.setOpaque(true);
			btnDelete.addActionListener(buttons);
			btnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					super.mouseEntered(e);
					btnDelete.setBackground(Color.white);
					btnDelete.setForeground(Color.decode("#FFB031"));
				}
			});
			btnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					super.mouseExited(e);
					btnDelete.setBackground(Color.decode("#FFB031"));
					btnDelete.setForeground(Color.white);
				}
			});
			ImageIcon imgDelete = Utils.scaleImage(new ImageIcon("delete.png") , 20 , 20);
			btnDelete.setIcon(imgDelete);
			//Constructor for "LOG OUT" Button
			
			btnLogOut.setFont(new Font("Courier" , Font.PLAIN , 16));
			btnLogOut.setForeground(Color.WHITE);
			btnLogOut.setBorder(new LineBorder(Color.decode("#FF6767") , 2));
			btnLogOut.setBounds(1080 , 40 , 90, 40);
			btnLogOut.setHorizontalAlignment(SwingConstants.CENTER);
			btnLogOut.addActionListener(buttons);
			btnLogOut.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					super.mouseEntered(e);
					btnLogOut.setBorder(null);
					btnLogOut.setContentAreaFilled(false);
					btnLogOut.setOpaque(true);
					btnLogOut.setBackground(Color.white);
					btnLogOut.setForeground(Color.decode("#FF6767"));
				}
			});
			btnLogOut.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					super.mouseExited(e);
					btnLogOut.setContentAreaFilled(true);
					btnLogOut.setOpaque(false);
					btnLogOut.setBorder(new LineBorder(Color.decode("#FF6767") , 2));
					btnLogOut.setForeground(Color.decode("#FFFFFF"));
				}
			});
			
			//Constructor for Add Movie Art Button
			btnAddMovieArt.setForeground(Color.decode("#FFFFFF"));
			btnAddMovieArt.setBackground(Color.decode("#242B40"));
			//295 , 450 , 250 , 25
			//545 , 450, 105, 105
			btnAddMovieArt.setBounds(300 , 460, 105, 105);
			btnAddMovieArt.setFont(new Font("Nadeem" , Font.BOLD , 100));
			btnAddMovieArt.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF") , 2) );
			btnAddMovieArt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    btnAddMovieArt.setBorder(BorderFactory.createLineBorder(Color.decode("#75CBE6") , 2));
					btnAddMovieArt.setForeground(Color.decode("#75CBE6"));
                }
            });
			btnAddMovieArt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    btnAddMovieArt.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF") , 2));
					btnAddMovieArt.setForeground(Color.decode("#FFFFFF"));
                }
            });

			ImageIcon imgAddMovieArt = Utils.scaleImage(new ImageIcon("image.png") , 65 , 65);
			btnAddMovieArt.setIcon(imgAddMovieArt);

			//Choosing Movie art with JFileChooser
			btnAddMovieArt.addActionListener(buttons);


			


			final JButton btnShowTimes = new JButton("Show Times");
			btnShowTimes.setBackground(new Color(117, 203, 230));
			btnShowTimes.setBounds(410 , 525 , 135 , 40);
			btnShowTimes.setForeground(Color.white);
			btnShowTimes.setContentAreaFilled(false);
			btnShowTimes.setBorder(new LineBorder(Color.decode("#242B40") , 2));
			btnShowTimes.setOpaque(true);
			btnShowTimes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					super.mouseEntered(e);
					btnShowTimes.setBackground(Color.white);
					btnShowTimes.setForeground(new Color(117, 203, 230));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					super.mouseExited(e);
					btnShowTimes.setBackground(new Color(117, 203, 230));
					btnShowTimes.setForeground(Color.white);
				}

			});
			btnShowTimes.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showTimeDialog();
				}
			});
			ImageIcon imgShowTimes = Utils.scaleImage(new ImageIcon("calendar.png") , 20 , 20);
			btnShowTimes.setIcon(imgShowTimes);
			
			//Constructor for Add Area
			//Constructor for Radio Buttons
			//2D and 3D

			ButtonGroup btnGp = new ButtonGroup();
			btnGp.add(rdo2D);
			btnGp.add(rdo3D);
			rdo3D.setBounds(535 , 490 , 75 , 30);
			rdo2D.setBounds(590 , 490 , 72 , 30);
			rdo3D.setForeground(Color.decode("#FFFFFF"));
			rdo2D.setForeground(Color.decode("#FFFFFF"));
			rdo2D.setBackground(Color.decode("#242B40"));
			rdo3D.setBackground(Color.decode("#242B40"));
			rdo3D.setFont(new Font("Nadeem" , Font.PLAIN , 18));
			rdo2D.setFont(new Font("Nadeem" , Font.PLAIN , 18));
			//Constructor for ComboBoxes
			//Theatre No.
			cboTheatreNo.removeAllItems();
			cboTheatreNo.addItem("Theatre 1");
			cboTheatreNo.addItem("Theatre 2");
			cboTheatreNo.addItem("Theatre 3");
			cboTheatreNo.addItem("Theatre 4   ");
			cboTheatreNo.setSelectedIndex(0);
			cboTheatreNo.setBounds(415 , 460 , 240 , 25);




			for(int i = 0 ; i< categories.size() ; i++)
			{
				cboCategory.addItem(categories.get(i).getCategoryName());
			}
			cboCategory.setSelectedIndex(0);
			cboCategory.setBounds(415 , 493 , 115 , 25);

			//Constructor for Add Button

			btnAddMovie.setBounds(550 , 525 , 100 , 40);
			btnAddMovie.setBackground(Color.decode("#FF6767"));
			btnAddMovie.setForeground(Color.WHITE);
			btnAddMovie.setContentAreaFilled(false);
			btnAddMovie.setBorder(new LineBorder(Color.decode("#242B40") , 2));
			btnAddMovie.setOpaque(true);
			btnAddMovie.addActionListener(buttons);
			btnAddMovie.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					super.mouseEntered(e);
					btnAddMovie.setBackground(Color.white);
					btnAddMovie.setForeground(Color.decode("#FF6767"));
				}
			});
			btnAddMovie.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					super.mouseExited(e);
					btnAddMovie.setBackground(Color.decode("#FF6767"));
					btnAddMovie.setForeground(Color.white);
				}
			});
			ImageIcon imgAddMovie = Utils.scaleImage(new ImageIcon("clapperboard.png") , 30 , 30);
			btnAddMovie.setIcon(imgAddMovie);


			//Constructor for JPanel

			setLayout(null);
			setBackground(Color.decode("#181f2e"));
			setBounds(0 , 0 , 1200 , 700);
			add(Admin_main);
			add(scrollPane);
			add(lblCinemaname1);
			add(lblCinemaname);
			add(Movies_on_screen);
			add(txtMovieName);
			add(cboTheatreNo);
			add(cboCategory);
			add(rdo2D);
			add(rdo3D);
			add(btnAddMovieArt);
			add(btnAddMovie);
			add(lblMovieNameTag);
			add(lblMovieType);
			add(lblTheatreNo);
			add(lblMovieName);
			add(lblTheatreNoTag);
			add(lblMovieTimes);
			add(btnEdit);
			add(btnDelete);
			add(btnShowTimes);



		}

	private void showEditDialog() {
			mEditMovieDelegate = Admin_Manage_Movies_Edit.getObjInstance(this);
	}


	public void refresh()
		{
			DataManager.refreshMovieData(model);
		}

	private void showTimeDialog()
	{
		mShowTimesDelegate = Admin_Manage_Movies_Edit_Show_Times.getObjInstance(this);
	}

	/**
	This Method is called when the save button of EDIT FORM is pressed
	* */
	@Override
	public void onSave(JFrame frame) {

			System.out.print(lblMovieName.getText().trim());
			Admin_Manage_Movies_Edit.setMovieId(DataManager.getMovieId(lblMovieName.getText().trim()));
			Movie updateMovieData = Admin_Manage_Movies_Edit.getObjInstance(this).getUpdateData();
			DataManager.updateMovie(updateMovieData);
			DataManager.refreshMovieData(model);
			frame.setVisible(false);
	}


	/**
	 This Method is called when the save button of SHOWTIMES FORM is pressed
	 * */
	@Override
	public void onTapSave(JFrame frame) {
		movieToAdd.setShowTime(mShowTimesDelegate.getShowTimeData());
		String str = mShowTimesDelegate.getShowTimeData();
		System.out.println(str);
		frame.setVisible(false);
	}

	public class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == btnAddMovieArt)
			{
				JFileChooser choosefile = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Images" , "jpg" , "jpeg" , "png");
				choosefile.setFileFilter(filter);

				int result = choosefile.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File file = choosefile.getSelectedFile();
					 filePath = choosefile.getSelectedFile().getPath();
					System.out.println(filePath);
					try {
						btnAddMovieArt.setText("");
						btnAddMovieArt.setIcon(Utils.scaleImage(new ImageIcon(ImageIO.read(file)) , 205 , 205) );

					}catch(IOException err)
					{
						String msg = "Error while fetching file\nPlease make sure you have selected an image file";
						JOptionPane.showMessageDialog(getRootPane() , msg , "Error" , JOptionPane.ERROR_MESSAGE);
					}
				}else
				{
					choosefile.cancelSelection();
				}
			}
			else if(e.getSource() == btnEdit)
			{

			}
			else if(e.getSource() == btnAddMovie)
			{

					movieToAdd.setMovieName(Utils.cleanString(txtMovieName.getText().trim()));
					movieToAdd.setCategoryName(cboCategory.getSelectedItem().toString().trim());
					movieToAdd.setMovieType(rdo3D.isSelected() ? "3D" : "2D");
					movieToAdd.setMoviePosterPath(filePath);
					movieToAdd.setTheatreNo(cboTheatreNo.getSelectedIndex() + 1);
					movieToAdd.setCategoryName(cboCategory.getSelectedItem().toString());
				if(movieToAdd.isDataConsistent(movieToAdd)) {
					System.out.println(movieToAdd.getShowTime());
					DataManager.addMovie(movieToAdd);
					String str = mShowTimesDelegate.getShowTimeData();
					System.out.println(str);
					refresh();
					System.out.println("Movie Added");
				}
				else
				{
					JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
							"Please fill in every required field",
							"Inconsistent Data!" ,JOptionPane.WARNING_MESSAGE);
				}
			}
			else if(e.getSource() == btnDelete)
			{
				try {
					System.out.println("Deleting movie");
					String movieToDelete = Utils.cleanString(lblMovieName.getText().trim());
					UserInteractions.deleteMovie(movieToDelete);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				refresh();
			}

		}

	}
}
