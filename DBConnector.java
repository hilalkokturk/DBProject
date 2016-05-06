import java.sql.*;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.util.Scanner;



public class DBConnector{

	public java.sql.Connection con;
	public java.sql.Statement st;
	public ResultSet rs;
	public boolean rs2;
	public int rs3;
	private PreparedStatement adder;
	Scanner sc = new Scanner(System.in);

       
	public DBConnector() {
            
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cinemabooking", "root",
					"2321057");
			st = con.createStatement();
		} catch (Exception ex) {
			System.out.println("Error:" + ex);
		}
	}

	public boolean loginCheckAdmin(String a_id, String password){
	    boolean login = false;
        String dbUsername, dbPassword;


	        String query;

	        try {
	            query = "SELECT a_id, password FROM admin;";
	            st.executeQuery(query);
	            ResultSet rs = st.getResultSet();

	            while(rs.next()){
	                dbUsername = rs.getString("a_id");
	                dbPassword = rs.getString("password");

	                if(dbUsername.equals(a_id) || dbPassword.equals(password)){
	                    System.out.println("OK");
	                    login = true;
	                }
	                else{
	                	login=false;
	                }
	            }
	    } catch (Exception ex) {
			System.out.println("Error :" + ex);
		}
	    return login;
	}

	public boolean loginCheckUser(String mail,String password){
		 boolean login = false;
	        String dbUsername, dbPassword;

	        String query;

	        try {
	            query = "SELECT mail, password FROM customer;";
	            st.executeQuery(query);
	            ResultSet rs = st.getResultSet();

	            while(rs.next()){
	                dbUsername = rs.getString("mail");
	                dbPassword = rs.getString("password");

	                if(dbUsername.equals(mail) || dbPassword.equals(password)){
	                    System.out.println("OK");
	                    login = true;
	                }
	                else{
	                	login=false;
	                }
	            }
	    } catch (Exception ex) {
			System.out.println("Error :" + ex);
		}
	    return login;
	}

	public void getAllDataInCinemaForAdmin() {

		try {

			String query = "select * from Cinema;";
			rs = st.executeQuery(query);
			System.out.println("Details of Cinemas in Ankara ");
			while (rs.next()) {
				String cinema_id = rs.getString("cinema_id");
				String cinema_name = rs.getString("cinema_name");
				String cinema_address = rs.getString("cinema_address");
				String cinema_phone = rs.getString("cinema_phone");
				System.out.println(cinema_id + " " + cinema_name + " "
						+ cinema_address + " " + cinema_phone + " ");

			}

		} catch (Exception ex) {
			System.out.println("Error :" + ex);
		}

	}

	public void deleteDataFromCinemaForAdmin() {
		try {
			System.out.println("What is the cinema_id?");
			String cinema_id = sc.nextLine();
			String query = "delete from cinema where cinema_id =" + cinema_id
					+ "; ";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// execute the preparedstatement
			preparedStmt.execute();

			con.close();
			System.out.println("deleting have complated");

		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}

	}

	public void getAllDataInCinemaForCustomer() {

		try {
			String query = "SELECT * FROM customer_view ORDER BY cinema_name;";

			rs = st.executeQuery(query);
			System.out.println("Details of Cinemas in Ankara ");
			while (rs.next()) {
				String cinema_name = rs.getString("cinema_name");
				String cinema_address = rs.getString("cinema_address");
				String cinema_phone = rs.getString("cinema_phone");
				System.out.println(cinema_name + " " + cinema_address + " "
						+ cinema_phone + " ");

			}

		} catch (Exception ex) {
			System.out.println("Error :" + ex);
		}

	}

	public void getAllDataInMoviesForAdmin() {

		try {

			String query = "select * from Movies;";
			rs = st.executeQuery(query);
			System.out.println("Details of Movies in Cinemas ");
			while (rs.next()) {
				String m_id = rs.getString("m_id");
				String m_name = rs.getString("m_name");
				String m_year = rs.getString("m_year");
				String m_director = rs.getString("m_director");
				String m_actors = rs.getString("m_actors");
				String m_type = rs.getString("m_type");
				String m_country = rs.getString("m_country");
				String m_language = rs.getString("m_language");
				String m_description = rs.getString("m_description");

				System.out.println(m_id + " " + m_name + " " + m_year + " "
						+ m_director + " " + m_actors + " " + m_type + " "
						+ m_country + " " + m_language + " " + m_description
						+ " ");

			}

		} catch (Exception ex) {
			System.out.println("Error :" + ex);
		}

	}

	public void getAllDataInMoviesForCustomer() {

		try {

			String query = "select m_name,m_year,m_director,m_actors,m_type,m_country,m_language,m_description from Movies ORDER BY m_name;";
			rs = st.executeQuery(query);
			System.out.println("Details of Movies in Cinemas ");
			while (rs.next()) {
				String m_name = rs.getString("m_name");
				String m_year = rs.getString("m_year");
				String m_director = rs.getString("m_director");
				String m_actors = rs.getString("m_actors");
				String m_type = rs.getString("m_type");
				String m_country = rs.getString("m_country");
				String m_language = rs.getString("m_language");
				String m_description = rs.getString("m_description");

				System.out.println(m_name + " " + m_year + " " + m_director
						+ " " + m_actors + " " + m_type + " " + m_country + " "
						+ m_language + " " + m_description + " ");

			}

		} catch (Exception ex) {
			System.out.println("Error :" + ex);
		}

	}

	public void putDataintoCinemasForAdmin() {
		try {
			System.out
					.println("Type the info respectively cinema_id,cinema_name,cinema_address,cinema_phone. Press enter to type next value.");
			String cinema_id = sc.nextLine();
			String cinema_name = sc.nextLine();
			String cinema_address = sc.nextLine();
			String cinema_phone = sc.nextLine();
			adder = con
					.prepareStatement("INSERT INTO Cinema(cinema_id,cinema_name,cinema_address,cinema_phone) VALUES ("
							+ cinema_id
							+ ",'"
							+ cinema_name
							+ "','"
							+ cinema_address + "','" + cinema_phone + "');");
			adder.executeUpdate();
			System.out.println("inserting is complated");

		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	public void putDataintoMoviesForAdmin() {

		try {
			System.out
					.println("Type the info respectively m_id,m_name,m_rate,m_director,m_actors,m_type,m_country,m_language,m_description. Press enter to type next value.");
			String m_id = sc.nextLine();
			String m_name = sc.nextLine();
			String m_rate = sc.nextLine();
			String m_director = sc.nextLine();
			String m_actors = sc.nextLine();
			String m_type = sc.nextLine();
			String m_country = sc.nextLine();
			String m_language = sc.nextLine();
			String m_description = sc.nextLine();
			adder = con
					.prepareStatement("INSERT INTO Movies(m_id,m_name,m_rate,m_director,m_actors,m_type,m_country,m_language,m_description) VALUES ("
							+ m_id
							+ ",'"
							+ m_name
							+ "',"
							+ m_rate
							+ ",'"
							+ m_director
							+ "','"
							+ m_actors
							+ "','"
							+ m_type
							+ "','"
							+ m_country
							+ "','"
							+ m_language
							+ "','"
							+ m_description + "');");
			adder.executeUpdate();
			System.out.println("inserting is complated");

		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}

	}

	public void haveNewCustomer() {

		try {
			System.out.println("Social Security Number:");
			String customer_ssn = sc.nextLine();
			System.out.println("Name:");
			String F_name = sc.nextLine();
			System.out.println("Last Name:");
			String L_name = sc.nextLine();
			System.out.println("Phone number");
			String p_number = sc.nextLine();
			System.out.println("E-mail:");
			String mail = sc.nextLine();
			System.out.println("Password:");
			String password = sc.nextLine();

			adder = con
					.prepareStatement("INSERT INTO customer(customer_ssn,F_name,L_name,p_number,mail,password) VALUES ("
							+ customer_ssn
							+ ",'"
							+ F_name
							+ "','"
							+ L_name
							+ "','"
							+ p_number
							+ "','"
							+ mail
							+ "','"
							+ password + "');");
			adder.executeUpdate();
			System.out.println("inserting is complated");

		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}

	}

	public void deleteDataFromMoviesForAdmin() {
		try {
			System.out.println("Give me the movie id(m_id)");
			String m_id = sc.nextLine();
			String query = "delete from Movies where m_id =" + m_id + "; ";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.execute();

			con.close();
			System.out.println("deleting is complated");

		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}

	}

	public void searchForMovieonCinema() {

		try {

			String query = "SELECT Cinema.cinema_name , Movies.m_name FROM Cinema, Movies INNER JOIN Session ON Session.m_id=Movies.m_id ORDER BY Movies.m_name;";
			rs = st.executeQuery(query);
			while (rs.next()) {
				String m_name = rs.getString(1);
				String cinema_name = rs.getString(2);
				System.out.println("    " + m_name + ", " + cinema_name);
			}

			st.close();
			con.close();

		} catch (Exception ex) {
			System.out.println("Error :" + ex);
		}

	}

	public void searchForMovieInfo(String a) {

		try {

			String query = "SELECT m_year,m_rate,m_director,m_actors,m_type,m_country,m_language,m_description from movies where m_name = '"
					+ a + "';";
			rs = st.executeQuery(query);

			while (rs.next()) {
				String m_year = rs.getString("m_year");
				String m_director = rs.getString("m_director");
				String m_actors = rs.getString("m_actors");
				String m_type = rs.getString("m_type");
				String m_country = rs.getString("m_country");
				String m_language = rs.getString("m_language");
				String m_description = rs.getString("m_description");

				System.out.println(m_year + " " + m_director + " " + m_actors
						+ " " + m_type + " " + m_country + " " + m_language
						+ " " + m_description + " ");

			}
		} catch (Exception ex) {
			System.out.println("Error :" + ex);
		}
	}

	public void searchForSession() {

		try {

			String query = "SELECT Session.start_time, Movies.m_name FROM Session INNER JOIN Movies ON Session.c_id=Movies.m_id ORDER BY Movies.m_name;";
			rs = st.executeQuery(query);
			while (rs.next()) {
				String start_time = rs.getString(1);
				String m_name = rs.getString(2);
				System.out.println("    " + m_name + ", " + start_time);
			}

			st.close();
			con.close();

		} catch (Exception ex) {
			System.out.println("Error :" + ex);
		}

	}
}
