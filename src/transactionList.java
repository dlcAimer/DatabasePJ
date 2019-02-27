import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class transactionList {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/PJ?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Wgb0823@";

    public static void insertHouse(ArrayList<String> house_ids, ArrayList<BigDecimal> house_areas){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to insert into house...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO house VALUES(?,?)";

            stmt = conn.prepareStatement(sql);

            for (int count = 0; count < house_ids.size(); count++) {
                try {
                    stmt.setString(1, house_ids.get(count));
                    stmt.setBigDecimal(2, house_areas.get(count));
                    stmt.execute();
                    sp = conn.setSavepoint();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp);
                        stmt.setString(1, house_ids.get(count));
                        stmt.setBigDecimal(2, house_areas.get(count));
                        stmt.execute();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to insert into house!!!");
                    }
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static void insertStaff(ArrayList<String> staff_ids, ArrayList<String> staff_names){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to insert into staff...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO staff VALUES(?,?)";

            stmt = conn.prepareStatement(sql);

            for (int count = 0; count < staff_ids.size(); count++) {
                try {
                    stmt.setString(1, staff_ids.get(count));
                    stmt.setString(2, staff_names.get(count));
                    stmt.execute();
                    sp = conn.setSavepoint();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp);
                        stmt.setString(1, staff_ids.get(count));
                        stmt.setString(2, staff_names.get(count));
                        stmt.execute();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to insert into staff!!!");
                    }
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static void insertParkingSpace(ArrayList<String> space_ids){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to insert into parkingSpace...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO parkingSpace(space_id) VALUES(?)";

            stmt = conn.prepareStatement(sql);

            for (int count = 0; count < space_ids.size(); count++) {
                try {
                    stmt.setString(1, space_ids.get(count));
                    stmt.execute();
                    sp = conn.setSavepoint();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp);
                        stmt.setString(1, space_ids.get(count));
                        stmt.execute();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to insert into parkingSpace!!!");
                    }
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static void insertEquipment(ArrayList<String> em_ids, ArrayList<String> em_types,
                                       ArrayList<String> em_addresses){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to insert into equipment...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO equipment(em_id, em_type, em_address) VALUES(?,?,?)";

            stmt = conn.prepareStatement(sql);

            for (int count = 0; count < em_ids.size(); count++) {
                try {
                    stmt.setString(1, em_ids.get(count));
                    stmt.setString(3, em_addresses.get(count));
                    stmt.setString(2, em_types.get(count));
                    stmt.execute();
                    sp = conn.setSavepoint();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp);
                        stmt.setString(1, em_ids.get(count));
                        stmt.setString(2, em_types.get(count));
                        stmt.setString(3, em_addresses.get(count));
                        stmt.execute();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to insert into equipment!!!");
                    }
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static String temporaryStopCarArrives(String estate, String license_tag, String tel){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to deal a temporary stop car arrives...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);
            try {

                String sql = "SELECT space_id FROM car WHERE license_tag = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, license_tag);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                if (!rs.next()) {
                    rs.close();
                    sql = "SELECT space_id FROM parkingSpace WHERE space_type = 'temp_park' AND space_id LIKE ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, estate + "%");
                    ResultSet rs1 = stmt.executeQuery();
                    sp = conn.setSavepoint();
                    if(!rs1.next()){
                        return "车位已满";
                    }else {
                        String space_id = rs1.getString("space_id");
                        rs1.close();
                        sql = "INSERT INTO visitorCar VALUES (?,?,?,?)";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, license_tag);
                        stmt.setString(2, tel);
                        stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                        stmt.setString(4, space_id);
                        stmt.execute();
                        sp = conn.setSavepoint();

                        sql = "UPDATE parkingSpace SET space_type = 'parking' WHERE space_id = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, space_id);
                        stmt.executeUpdate();
                        sp = conn.setSavepoint();

                    }
                }
                else {
                    rs.close();
                    return "欢迎"+license_tag+"回家";
                }
            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail to deal a temporary stop car arrives!!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to deal a temporary stop car arrives!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return "";
    }

    public static String theTemporarilyParkedCarLeft(String license_tag){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to deal the temporarily parked car left...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);
            try {

                String sql = "SELECT start_time,space_id FROM visitorCar WHERE license_tag = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, license_tag);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                if (rs.next()) {
                    Timestamp start_time = rs.getTimestamp("start_time");
                    String space_id = rs.getString("space_id");
                    rs.close();

                    sql = "INSERT INTO tempOrder VALUES(?,?,?,?,?)";
                    stmt = conn.prepareStatement(sql);

                    Timestamp end_time = new Timestamp(System.currentTimeMillis());
                    stmt.setString(1, Utils.tempOrderIdConstruct());
                    stmt.setTimestamp(2, end_time);
                    BigDecimal duration = Utils.calculateTimestampDuration(start_time,end_time);
                    stmt.setBigDecimal(3, duration);
                    stmt.setBigDecimal(4, Utils.tempOrderFee(duration));
                    stmt.setString(5, license_tag);
                    stmt.execute();
                    sp = conn.setSavepoint();

                    sql = "UPDATE parkingSpace SET space_type = 'temp_park' WHERE space_id = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, space_id);
                    stmt.executeUpdate();
                    sp = conn.setSavepoint();

                } else {
                    return "离开的车" + license_tag + "查询不到停车详情";
                }
            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail to deal the temporarily parked car left!!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to deal the temporarily parked car left!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return "";
    }

    public static String buyParkingSpace(String estate, String license_tag, String owner_id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to buy parking space...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);
            try {

                String sql = "SELECT space_id FROM parkingSpace WHERE space_type = 'temp_park' AND space_id LIKE ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, estate + "%");
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                if (rs.next()) {

                    String space_id = rs.getString("space_id");
                    rs.close();

                    sql = "INSERT INTO car(license_tag, space_id, owner_id) VALUES(?,?,?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, license_tag);
                    stmt.setString(2, space_id);
                    stmt.setString(3, owner_id);
                    stmt.execute();
                    sp = conn.setSavepoint();

                    sql = "INSERT INTO purchaseOrder VALUES(?,?,?,?,?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, Utils.purchaseOrderIdConstruct());
                    stmt.setString(2, space_id);
                    stmt.setString(3, owner_id);
                    stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                    stmt.setBigDecimal(5, Utils.purchaseOrderFee(estate));
                    stmt.execute();
                    sp = conn.setSavepoint();

                    sql = "UPDATE parkingSpace SET space_type = 'purchase' WHERE space_id = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, space_id);
                    stmt.executeUpdate();
                    sp = conn.setSavepoint();

                } else {
                    return "车位已满";
                }
            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail to buy parking space!!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to buy parking space!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return "";
    }

    public static String rentParkingSpace(String estate, String license_tag, String owner_id, int months){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to rent parking space...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);
            try {

                String sql = "SELECT space_id FROM parkingSpace WHERE space_type = 'temp_park' AND space_id LIKE ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, estate + "%");
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                if (rs.next()) {

                    String space_id = rs.getString("space_id");
                    rs.close();

                    sql = "INSERT INTO car VALUES(?,?,?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, license_tag);
                    stmt.setString(2, space_id);
                    stmt.setString(3, owner_id);
                    stmt.execute();
                    sp = conn.setSavepoint();

                    sql = "INSERT INTO rentOrder VALUES(?,?,?,?,?,?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, Utils.rentOrderIdConstruct());
                    stmt.setString(2, space_id);
                    stmt.setString(3, owner_id);
                    stmt.setDate(4, Utils.getRentStartDate());
                    stmt.setDate(5, Utils.getRentEndDate(months));
                    stmt.setBigDecimal(6, Utils.rentOrderFee(estate,months));
                    stmt.execute();
                    sp = conn.setSavepoint();

                    sql = "UPDATE parkingSpace SET space_type = 'rent' WHERE space_id = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, space_id);
                    stmt.executeUpdate();
                    sp = conn.setSavepoint();



                } else {
                    return "车位已满";
                }
            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail to rent parking space!!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to rent parking space!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return "";
    }

    //检测车位是否到达租期
    public static ArrayList<String> findParkingSpace(){
        //estate记得变成匹配值的形式
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;
        ArrayList<String> space_ids = new ArrayList<>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to find parking_space...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);
            try {
                String sql = "SELECT space_id FROM rentOrder as R WHERE 'rent' = (SELECT space_type FROM parkingSpace as P WHERE R.space_id = P.space_id)" +
                        "AND ? > ALL(SELECT end_time FROM rentOrder as F WHERE F.space_id = R.space_id)";
//                String sql = "SELECT owner_id,space_id FROM rentOrder WHERE ? = (SELECT DISTINCT space_id FROM parkingSpace as T " +
//                        "WHERE T.space_type = 'rent' AND ? > ALL(SELECT end_time FROM rentOrder as F WHERE T.space_id = F.space_id))";
                stmt = conn.prepareStatement(sql);
                stmt.setTimestamp(1,new Timestamp(System.currentTimeMillis()));
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                int count = 0;
                while(rs.next()){
                    count++;
                    String space_id = rs.getString("space_id");
//                    System.out.println(space_id);
                    space_ids.add(space_id);
                }
                if (count == 0) {
                    return null;
                }

                rs.close();
            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail to find a parkingspace which need to remind!!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to find a parkingspace which need to remind!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return space_ids;
    }

    //搜索车位主人
    public static String findSpaceOwner(String space_id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to find the owner...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);
            try {

                String sql = "SELECT space_type FROM parkingSpace WHERE space_id = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, space_id);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                if(rs.next()){
                    String space_type = rs.getString("space_type");
                    if(space_type.equals("rent")) {
                        sql = "SELECT owner_id FROM rentOrder as T WHERE T.space_id = ? AND " +
                                "end_time >= all (SELECT end_time FROM rentOrder as R WHERE R.space_id = ?)";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, space_id);
                        stmt.setString(2, space_id);
                        rs = stmt.executeQuery();
                        sp = conn.setSavepoint();
                        rs.next();
                        String owner_id = rs.getString("owner_id");
                        return owner_id;
                    }
                    else if(space_type.equals("purchase")){
                        sql = "SELECT owner_id FROM purchaseOrder as T WHERE T.space_id = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, space_id);
                        rs = stmt.executeQuery();
                        sp = conn.setSavepoint();
                        rs.next();
                        String owner_id = rs.getString("owner_id");
                        return owner_id;
                    }
                    else{
                        return null;
                    }
                }


            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail to find the owner!!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to find the owner!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return null;
    }

    public static ArrayList<String> findNeedToPay(String owner_id){
        ArrayList<String> space_ids = findParkingSpace();
        ArrayList<String> needToPay = new ArrayList<>();
        if(space_ids != null) {
            for (int count = 0; count < space_ids.size(); count++) {
                if (findSpaceOwner(space_ids.get(count)).equals(owner_id)) {
                    needToPay.add(space_ids.get(count));
                }
            }
        }
        return needToPay;
    }

    // 用户续租
    public static void rentContinue(String estate, String space_id, String owner_id, int months){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to rent parking space...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);
            try {

                String sql = "INSERT INTO rentOrder VALUES(?,?,?,?,?,?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, Utils.rentOrderIdConstruct());
                stmt.setString(2, space_id);
                stmt.setString(3,owner_id);
                stmt.setDate(4, Utils.getRentStartDate());
                stmt.setDate(5, Utils.getRentEndDate(months));
                stmt.setBigDecimal(6, Utils.rentOrderFee(estate,months));
                stmt.execute();
                sp = conn.setSavepoint();


            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail to rent parking space!!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to rent parking space!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    // 放弃续租
    public static void abondonRent(String license_tag, String space_id){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to rent parking space...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);
            try {

                String sql = "DELETE FROM car WHERE license_tag = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, license_tag);
                stmt.executeUpdate();
                sp = conn.setSavepoint();

                sql = "UPDATE parkingSpace SET space_type = 'temp_park' WHERE space_id = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, space_id);
                stmt.executeUpdate();
                sp = conn.setSavepoint();

            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail to rent parking space!!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to rent parking space!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static ArrayList<ArrayList<String>> lookForUsersWhoNeedToPayParkingSpaceManagementFee(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;

        ArrayList<String> temp_result = new ArrayList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to " +
                    "look for users who need to pay parking space management fee...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);
            try {

                String sql = "SELECT space_id FROM parkingSpace WHERE space_type = 'purchase' OR space_type = 'rent'";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();
                int count = 0;
                while(rs.next()) {
                    count++;
                    String space_id_found = rs.getString("space_id");
                    String owner_id = findSpaceOwner(space_id_found);
                    temp_result.add(owner_id);
                    temp_result.add(space_id_found);
                    result.add(temp_result);
                    temp_result = new ArrayList<>();
                }
                if(count == 0)
                    return null;
                rs.close();
                return result;
            } catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail to look for users who need to pay parking space management fee!!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to look for users who need to pay parking space management fee!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return null;
    }

    public static String collectManagementFee(int months, ArrayList<ArrayList<String>> owner_space_ids){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to collect management fee...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO managementFee VALUES(?,?,?,?,?,?,?)";

            stmt = conn.prepareStatement(sql);

            for(int count = 0; count < owner_space_ids.size() ; count ++) {
                try {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    stmt.setString(1, Utils.managementBillIdConstruct());
                    stmt.setBigDecimal(2, Utils.managementFee(months));
                    stmt.setTimestamp(3, timestamp);
                    stmt.setBigDecimal(4, new BigDecimal(Integer.toString(months)));
                    stmt.setTimestamp(5, new Timestamp(timestamp.getTime()
                            + months * 30 * 24 * 60 * 60 * 1000L));
                    stmt.setString(6, owner_space_ids.get(count).get(1));
                    stmt.setString(7, owner_space_ids.get(count).get(0));
                    stmt.execute();
                    sp = conn.setSavepoint();
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp);
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        stmt.setString(1, Utils.managementBillIdConstruct());
                        stmt.setBigDecimal(2, Utils.managementFee(months));
                        stmt.setTimestamp(3, timestamp);
                        stmt.setBigDecimal(4, new BigDecimal(Integer.toString(months)));
                        stmt.setTimestamp(5, new Timestamp(timestamp.getTime()
                                + months * 30 * 24 * 60 * 60 * 1000L));
                        stmt.setString(6, owner_space_ids.get(count).get(1));
                        stmt.setString(7, owner_space_ids.get(count).get(0));
                        stmt.execute();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to collect management fee!!!");
                    }
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return "";
    }

    public static void insertComplaint(String cp_type, String content, String owner_id){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to insert into complaint...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO complaint VALUES(?,?,?,?,?)";

            stmt = conn.prepareStatement(sql);

            try {
                stmt.setString(1, Utils.cpIdConstruct());
                stmt.setString(2, cp_type);
                stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                stmt.setString(4, content);
                stmt.setString(5, owner_id);

                stmt.execute();
                sp = conn.setSavepoint();
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
                try {
                    conn.rollback(sp);
                    stmt.setString(1, Utils.cpIdConstruct());
                    stmt.setString(2, cp_type);
                    stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                    stmt.setString(4, content);
                    stmt.setString(5, owner_id);
                    stmt.execute();
                    conn.commit();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to insert into complaint!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }


    //用于初始化插入数据
    public static void insertComplaint(ArrayList<String> sp_ids, ArrayList<String> cp_types,
                                       ArrayList<Timestamp> cp_times, ArrayList<String> contents,
                                       ArrayList<String> owner_ids){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to insert into complaint...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO complaint VALUES(?,?,?,?,?)";

            stmt = conn.prepareStatement(sql);

            for (int count = 0; count < sp_ids.size(); count++) {
                try {
                    stmt.setString(1, sp_ids.get(count));
                    stmt.setString(2,cp_types.get(count));
                    stmt.setTimestamp(3,cp_times.get(count));
                    stmt.setString(4,contents.get(count));
                    stmt.setString(5,owner_ids.get(count));

                    stmt.execute();
                    sp = conn.setSavepoint();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp);
                        stmt.setString(1, sp_ids.get(count));
                        stmt.setString(2,cp_types.get(count));
                        stmt.setTimestamp(3,cp_times.get(count));
                        stmt.setString(4,contents.get(count));
                        stmt.setString(5,owner_ids.get(count));
                        stmt.execute();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to insert into complaint!!!");
                    }
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static void insertComplaintSolve(String staff_id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to insert into complaintSolve...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "SELECT cp_id FROM complaint WHERE cp_id NOT IN (SELECT cp_id FROM complaintSolve)";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String cp_id = rs.getString("cp_id");

                sql = "INSERT INTO complaintSolve(staff_id, cp_id) VALUES(?,?)";

                stmt = conn.prepareStatement(sql);

                try {
                    stmt.setString(1, staff_id);
                    stmt.setString(2, cp_id);
                    stmt.execute();
                    sp = conn.setSavepoint();
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp);
                        stmt.setString(1, staff_id);
                        stmt.setString(2, cp_id);
                        stmt.execute();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to insert into complaintSolve!!!");
                    }
                }
                conn.commit();
                updateComplaintSolve("正常处理","处理成功", staff_id, cp_id);
            }

            conn.commit();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    //用于初始化插入数据
    public static void insertComplaintSolve(String staff_id, String cp_id){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to insert into complaintSolve...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO complaintSolve(staff_id, cp_id) VALUES(?,?)";

            stmt = conn.prepareStatement(sql);

            try {
                stmt.setString(1, staff_id);
                stmt.setString(2, cp_id);
                stmt.execute();
                sp = conn.setSavepoint();
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
                try {
                    conn.rollback(sp);
                    stmt.setString(1, staff_id);
                    stmt.setString(2, cp_id);
                    stmt.execute();
                    conn.commit();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to insert into complaintSolve!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static void updateComplaintSolve(String deal_course, String deal_res, String staff_id, String cp_id){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to update complaintSolve...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "UPDATE complaintSolve SET deal_course = ? ,deal_res = ? WHERE staff_id = ? and cp_id = ?";

            stmt = conn.prepareStatement(sql);

            try {
                stmt.setString(1, deal_course);
                stmt.setString(2, deal_res);
                stmt.setString(3, staff_id);
                stmt.setString(4, cp_id);

                stmt.executeUpdate();
                sp = conn.setSavepoint();

            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
                try {
                    conn.rollback(sp);
                    stmt.setString(1, deal_course);
                    stmt.setString(2, deal_res);
                    stmt.setString(3, staff_id);
                    stmt.setString(4, cp_id);
                    stmt.execute();
                    conn.commit();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to insert into complaintSolve!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static boolean insertOwner(ArrayList<String> house_ids, ArrayList<String> owner_names,
                                   ArrayList<String> id_card_nums, ArrayList<String> tels){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to insert into owner...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO owner VALUES(?,?,?,?)";

            stmt = conn.prepareStatement(sql);

            for (int count = 0; count < house_ids.size(); count++) {
                try {
                    stmt.setString(2, owner_names.get(count));
                    stmt.setString(1, house_ids.get(count));
                    stmt.setString(3, id_card_nums.get(count));
                    stmt.setString(4,tels.get(count));
                    stmt.execute();
                    sp = conn.setSavepoint();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp);
                        stmt.setString(2, owner_names.get(count));
                        stmt.setString(1, house_ids.get(count));
                        stmt.setString(3, id_card_nums.get(count));
                        stmt.setString(4,tels.get(count));
                        stmt.execute();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to insert into owner!!!");
                    }
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return true;
    }

    public static void insertHouseBill(){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;
        ArrayList<String> bill_types = new ArrayList<>();
        bill_types.add("水电费");
        bill_types.add("物业费");

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to insert into housebill...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sqlbill = "SELECT owner_id FROM owner";
            stmt = conn.prepareStatement(sqlbill);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String house_id = resultSet.getString("owner_id");

                String sql = "INSERT INTO housebill(bill_id, bill_type, fee, house_id) VALUES(?,?,?,?)";

                stmt = conn.prepareStatement(sql);

                for (int count = 0; count < bill_types.size(); count++) {
                    try {
                        stmt.setString(1, Utils.billOrderIdConstruct());
                        stmt.setString(2, bill_types.get(count));
                        if (bill_types.get(count).equals("水电费")) {
                            stmt.setBigDecimal(3, new BigDecimal("200"));
                        } else {
                            String sql1 = "SELECT house_area FROM house WHERE house_id = ?";
                            PreparedStatement stmt1 = conn.prepareStatement(sql1);
                            stmt1.setString(1, house_id);
                            ResultSet rs1 = stmt1.executeQuery();
                            rs1.next();
                            BigDecimal house_area = rs1.getBigDecimal("house_area");
                            BigDecimal temp_fee = new BigDecimal("0.0");
                            if (Utils.houseIdSplit(house_id).get(0).equals("A")) {
                                temp_fee = house_area.multiply(new BigDecimal("1.0"));
                            } else if (Utils.houseIdSplit(house_id).get(0).equals("B")) {
                                temp_fee = house_area.multiply(new BigDecimal("1.5"));
                            } else {
                                temp_fee = house_area.multiply(new BigDecimal("2.0"));
                            }
                            stmt.setBigDecimal(3, temp_fee);
                            rs1.close();
                        }
                        stmt.setString(4, house_id);
                        stmt.execute();
                        sp = conn.setSavepoint();
                    } catch (SQLException se) {
                        //Handle errors for JDBC
                        se.printStackTrace();
                        try {
                            conn.rollback(sp);
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                            System.out.println("fail to insert into housebill!!!");
                        }
                    }
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    //用于初始化插入数据
    public static void insertHouseBill(ArrayList<String> bill_ids, ArrayList<String> bill_types,
                                       ArrayList<BigDecimal> fee, ArrayList<String> house_ids){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to insert into housebill...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO housebill(bill_id, bill_type, fee, house_id) VALUES(?,?,?,?)";

            stmt = conn.prepareStatement(sql);

            for (int count = 0; count < bill_ids.size(); count++) {
                try {
                    stmt.setString(1, bill_ids.get(count));
                    stmt.setString(2, bill_types.get(count));
                    stmt.setBigDecimal(3, fee.get(count));
                    stmt.setString(4, house_ids.get(count));
                    stmt.execute();
                    sp = conn.setSavepoint();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp);
                        stmt.setString(1, bill_ids.get(count));
                        stmt.setString(2, bill_types.get(count));
                        stmt.setBigDecimal(3, fee.get(count));
                        stmt.setString(4, house_ids.get(count));
                        stmt.execute();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to insert into housebill!!!");
                    }
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static void updateHouseBill(String owner_id){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to update housebill...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql0 = "SELECT bill_id FROM housebill WHERE house_id = ?";
            PreparedStatement stmt0 = conn.prepareStatement(sql0);
            stmt0.setString(1, owner_id);
            ResultSet resultSet = stmt0.executeQuery();

            while (resultSet.next()) {
                String bill_id = resultSet.getString("bill_id");
                String sql = "UPDATE housebill SET paytime = ? WHERE bill_id = ?";

                stmt = conn.prepareStatement(sql);

                try {
                    stmt.setDate(1, new Date(new Timestamp(System.currentTimeMillis()).getTime()));
                    stmt.setString(2, bill_id);
                    stmt.executeUpdate();
                    sp = conn.setSavepoint();
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp);
                        stmt.setDate(1, new Date(new Timestamp(System.currentTimeMillis()).getTime()));
                        stmt.setString(2, bill_id);
                        stmt.executeUpdate();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to update housebill!!!");
                    }

                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static ArrayList<String> urgePayBill(String bill_type){
        //estate记得变成匹配值的形式
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;
        ArrayList<String> house_ids = new ArrayList<>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to urge owners to pay bill...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);
            try {

                String sql = "SELECT DISTINCT house_id FROM housebill AS A WHERE " +
                        "bill_type = ? AND (paytime is null or ? > ALL(SELECT ? + paytime FROM housebill as B WHERE A.house_id = B.house_id))" +
                        "ORDER BY house_id";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, bill_type);
                stmt.setDate(2, Utils.getRentStartDate());
                stmt.setDate(3, Utils.getMonthDate(1));
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                int count = 0;
                while (rs.next()) {
                    count++;
                    String house_id = rs.getString("house_id");
                    house_ids.add(house_id);
                }
                if (count == 0) {
                    System.out.println("No user need to remind.");
                    return null;
                }

                rs.close();
            } catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail to deal a urge owner to pay bill!!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to deal a urge owner to pay bill!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return house_ids;
    }

    public static ArrayList<String> findEquipment(){
        //estate记得变成匹配值的形式
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;
        ArrayList<String> em_ids = new ArrayList<>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to find equipments...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);
            try {

                String sql = "SELECT em_id FROM equipment WHERE ? > (inspect_time)";
                stmt = conn.prepareStatement(sql);
                stmt.setTimestamp(1,new Timestamp(System.currentTimeMillis()-30*24*60*60));
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                int count = 0;
                while(rs.next()){
                    count++;
                    String em_id = rs.getString("em_id");
                    em_ids.add(em_id);
                }
                if (count == 0) {
                    System.out.println("No equipment need to fix.");
                    return null;
                }
                rs.close();
            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail to find a equipment which need to inspect!!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to find a equipment which need to inspect!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return em_ids;
    }

    public static ArrayList<ArrayList<String>> construct(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;

        ArrayList<ArrayList<String>> em_id_statuses = new ArrayList<>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to find equipments...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);
            try {

                String sql = "SELECT em_id FROM equipment ";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                int count = 0;
                while(rs.next()){
                    count++;
                    String em_id = rs.getString("em_id");
                    String em_status;
                    if(count%2==1) {
                        em_status = "1";
                    }else {
                        em_status = "0";
                    }
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(em_id);
                    temp.add(em_status);
                    em_id_statuses.add(temp);
                }
                rs.close();
            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return em_id_statuses;
    }

    public static void insertStaffInspect(ArrayList<ArrayList<String>> em_id_statuses, String staff_id){
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        Savepoint sp = null;
        Savepoint sp2 = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to insert into staffInspect...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO staffInspect(em_id, inspect_time,staff_id,em_status) VALUES(?,?,?,?)";
            String sql2 = "UPDATE equipment SET em_status = ? WHERE em_id = ?";
            String sql3 = "UPDATE equipment SET inspect_time = ? WHERE em_id = ?";

            stmt = conn.prepareStatement(sql);
            stmt2 = conn.prepareStatement(sql2);
            stmt3 = conn.prepareStatement(sql3);

            for (int count = 0; count < em_id_statuses.size(); count++) {
                try {
                    stmt.setString(1, em_id_statuses.get(count).get(0));
                    stmt.setDate(2, new Date(System.currentTimeMillis()));
                    stmt.setString(3, staff_id);
                    stmt.setString(4, em_id_statuses.get(count).get(1));
                    stmt.execute();
                    sp = conn.setSavepoint();
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp);
                        stmt.setString(1, em_id_statuses.get(count).get(0));
                        stmt.setDate(2, new Date(System.currentTimeMillis()));
                        stmt.setString(3, staff_id);
                        stmt.setString(4, em_id_statuses.get(count).get(1));
                        stmt.execute();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to insert into house!!!");
                    }
                }
                try {
//                        stmt2.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
                    stmt2.setString(1, em_id_statuses.get(count).get(1));
                    stmt2.setString(2, em_id_statuses.get(count).get(0));
                    stmt2.execute();
                    stmt3.setTimestamp(1,new Timestamp(System.currentTimeMillis()));
                    stmt3.setString(2, em_id_statuses.get(count).get(0));
                    stmt3.execute();
                    sp2 = conn.setSavepoint();
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp2);
                        stmt2.setString(1, em_id_statuses.get(count).get(1));
                        stmt2.setString(2, em_id_statuses.get(count).get(0));
                        stmt2.execute();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to update equipment!!!");
                    }
                }
                conn.commit();
                updateStaffInspect(em_id_statuses.get(count).get(0), new BigDecimal("50"));
            }


            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null || stmt2!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    //用于初始化插入数据
    public static void insertStaffInspect(ArrayList<String> em_ids, ArrayList<java.util.Date> inspect_times,
                                          ArrayList<String> staff_ids, ArrayList<String> em_statuses ){
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        Savepoint sp = null;
        Savepoint sp2 = null;

        ArrayList<Date> inspect_times_real = new ArrayList<>();

        for (java.util.Date date : inspect_times) {
            Date date2 = new Date(date.getTime());
            inspect_times_real.add(date2);
        }

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to insert into staffInspect...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO staffInspect(em_id, inspect_time,staff_id,em_status) VALUES(?,?,?,?)";
            String sql2 = "UPDATE equipment SET em_status = ? WHERE em_id = ?";
            String sql3 = "UPDATE equipment SET inspect_time = ? WHERE em_id = ?";

            stmt = conn.prepareStatement(sql);
            stmt2 = conn.prepareStatement(sql2);
            stmt3 = conn.prepareStatement(sql3);

            for (int count = 0; count < em_ids.size(); count++) {
                try {
                    stmt.setString(1, em_ids.get(count));
                    stmt.setDate(2, inspect_times_real.get(count));
                    stmt.setString(3, staff_ids.get(count));
                    stmt.setString(4, em_statuses.get(count));
                    stmt.execute();
                    sp = conn.setSavepoint();
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp);
                        stmt.setString(1, em_ids.get(count));
                        stmt.setDate(2, inspect_times_real.get(count));
                        stmt.setString(3, staff_ids.get(count));
                        stmt.setString(4, em_statuses.get(count));
                        stmt.execute();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to insert into house!!!");
                    }
                }
                try {
//                        stmt2.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
                    stmt2.setString(1, em_statuses.get(count));
                    stmt2.setString(2, em_ids.get(count));
                    stmt2.execute();
                    stmt3.setTimestamp(1,new Timestamp(System.currentTimeMillis()));
                    stmt3.setString(2, em_ids.get(count));
                    stmt3.execute();
                    sp2 = conn.setSavepoint();
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    try {
                        conn.rollback(sp2);
//                            stmt2.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
                        stmt2.setString(1, em_statuses.get(count));
                        stmt2.setString(2, em_ids.get(count));
                        stmt2.execute();
                        conn.commit();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fail to update equipment!!!");
                    }
                }
            }


            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null || stmt2!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static void updateStaffInspect(String em_id,BigDecimal fee){
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            conn.setAutoCommit(false);

            String sql = "UPDATE staffInspect SET fix_time = ? WHERE em_id = ?";

            stmt = conn.prepareStatement(sql);

            try {
                stmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                stmt.setString(2, em_id);
//                   stmt.setBigDecimal(2,fee);
                stmt.executeUpdate();
                sp = conn.setSavepoint();
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
                try {
                    conn.rollback(sp);
                    stmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                    stmt.setString(2, em_id);
//                       stmt.setBigDecimal(2,fee);
                    stmt.executeUpdate();
                    conn.commit();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to update staffinspect!!!");
                }
            }

            sql = "UPDATE staffInspect SET fee = ? WHERE em_id = ?";

            stmt = conn.prepareStatement(sql);

            try {
                stmt.setBigDecimal(1, fee);
                stmt.setString(2, em_id);
                stmt.executeUpdate();
                sp = conn.setSavepoint();
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
                try {
                    conn.rollback(sp);
                    stmt.setBigDecimal(1, fee);
                    stmt.setString(2, em_id);
                    stmt.executeUpdate();
                    conn.commit();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to update staffinspect!!!");
                }
            }

            sql = "UPDATE equipment SET inspect_time = ?, em_status = ? WHERE em_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            stmt.setString(2, "0");
            stmt.setString(3, em_id);
            stmt.executeUpdate();
            sp = conn.setSavepoint();

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static void ownerToRepairService(String owner_id, String em_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to report...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO report(report_id, owner_id, em_id, re_time) VALUES(?,?,?,?)";
            String sql2 = "UPDATE equipment SET em_status = '1' WHERE em_id = ?";

            stmt = conn.prepareStatement(sql);
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            try {
                stmt.setString(1, Utils.reportIdConstruct());
                stmt.setString(2, owner_id);
                stmt.setString(3, em_id);
                stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                stmt.execute();
                sp = conn.setSavepoint();
                stmt2.setString(1,em_id);
                stmt2.executeUpdate();
                sp = conn.setSavepoint();
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
                try {
                    conn.rollback(sp);
                    stmt.setString(1, Utils.reportIdConstruct());
                    stmt.setString(2, owner_id);
                    stmt.setString(3, em_id);
                    stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                    stmt.execute();
                    stmt2.setString(1,em_id);
                    stmt2.executeUpdate();
                    sp = conn.setSavepoint();
                    conn.commit();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to report!!!");
                }
            }

            conn.commit();

        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException ignored) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static void handleOwnersRepairReport(String staff_id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database to handle owner's repair report...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            conn.setAutoCommit(false);
            try {

                String sql = "SELECT em_id, report_id FROM report WHERE status = 'unsolved'";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                while (rs.next()) {
                    String em_id = rs.getString("em_id");
                    String report_id = rs.getString("report_id");

                    sql = "UPDATE report SET status = 'solving' WHERE report_id = ? AND STATUS = 'unsolved'";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, report_id);
                    stmt.executeUpdate();
                    sp = conn.setSavepoint();

                    sql = "SELECT em_type FROM equipment WHERE em_id = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, em_id);
                    ResultSet rs1 = stmt.executeQuery();
                    sp = conn.setSavepoint();

                    rs1.next();
                    String em_type = rs1.getString("em_type");

                    sql = "INSERT INTO reportSolve VALUES(?,?,?,?,?,?,?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, Utils.rpsIdConstruct());
                    stmt.setString(2, staff_id);
                    stmt.setString(3, report_id);
                    stmt.setString(4, "维修完毕");
                    stmt.setString(5, "solved");
                    stmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
                    stmt.setBigDecimal(7, Utils.handleReportFee(em_type));
                    stmt.execute();
                    sp = conn.setSavepoint();

                    sql = "UPDATE report SET status = 'solved' WHERE report_id = ? AND STATUS = 'solving'";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, report_id);
                    stmt.executeUpdate();
                    sp = conn.setSavepoint();

                    sql = "UPDATE equipment SET inspect_time = ?, em_status = ? WHERE em_id = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                    stmt.setString(2, "0");
                    stmt.setString(3, em_id);
                    stmt.executeUpdate();
                    sp = conn.setSavepoint();
                }
                rs.close();
            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail to handle owner's repair report!!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to Handle owner's repair report!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static ArrayList<ArrayList<String>> getTimeTableInput(String begin_str,String end_str){
        java.sql.Date begin_date = java.sql.Date.valueOf(begin_str);
        java.sql.Date end_date = java.sql.Date.valueOf(end_str);
        Timestamp begin = new Timestamp(begin_date.getTime());
        Timestamp end = new Timestamp(end_date.getTime());
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> res_temp = new ArrayList<>();
        BigDecimal sum = new BigDecimal(0);

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            conn.setAutoCommit(false);
            try {
                String sql = "SELECT fee,pay_time FROM managementFee WHERE pay_time < ? AND pay_time > ?";
                stmt = conn.prepareStatement(sql);
                stmt.setTimestamp(1,end);
                stmt.setTimestamp(2,begin);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                while(rs.next()){
                    String pay_time = rs.getString("pay_time");
                    res_temp.add(pay_time);
                    BigDecimal fee = rs.getBigDecimal("fee");
                    sum = sum.add(fee);
//                    String fee = rs.getBigDecimal("fee").toString();
                    String fee_str = fee.toString();
                    res_temp.add(fee_str);
                    res_temp.add("management_fee");
                    res.add(res_temp);
                    System.out.println(pay_time+" "+fee+" "+"management_fee");
                    res_temp = new ArrayList<>();
                }
                sql = "SELECT fee,pay_time FROM purchaseOrder WHERE pay_time < ? AND pay_time > ?";
                stmt = conn.prepareStatement(sql);
                stmt.setTimestamp(1,end);
                stmt.setTimestamp(2,begin);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                while(rs.next()){
                    String pay_time = rs.getString("pay_time");
                    res_temp.add(pay_time);
                    BigDecimal fee = rs.getBigDecimal("fee");
                    sum = sum.add(fee);
//                    String fee = rs.getBigDecimal("fee").toString();
                    String fee_str = fee.toString();
                    res_temp.add(fee_str);
                    res_temp.add("purchase_fee");
                    res.add(res_temp);
                    System.out.println(pay_time+" "+fee+" "+"purchase_fee");
                    res_temp = new ArrayList<>();
                }
                sql = "SELECT fee,start_time FROM rentOrder WHERE start_time < ? AND start_time > ?";
                stmt = conn.prepareStatement(sql);
                stmt.setTimestamp(1,end);
                stmt.setTimestamp(2,begin);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                while(rs.next()){
                    String pay_time = rs.getString("start_time");
                    res_temp.add(pay_time);
                    BigDecimal fee = rs.getBigDecimal("fee");
                    sum = sum.add(fee);
//                    String fee = rs.getBigDecimal("fee").toString();
                    String fee_str = fee.toString();
                    res_temp.add(fee_str);
                    res_temp.add("rent_fee");
                    res.add(res_temp);
                    System.out.println(pay_time+" "+fee+" "+"rent_fee");
                    res_temp = new ArrayList<>();
                }
                sql = "SELECT fee,end_time FROM tempOrder WHERE end_time < ? AND end_time > ?";
                stmt = conn.prepareStatement(sql);
                stmt.setTimestamp(1,end);
                stmt.setTimestamp(2,begin);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                while(rs.next()){
                    String pay_time = rs.getString("end_time");
                    res_temp.add(pay_time);
                    BigDecimal fee = rs.getBigDecimal("fee");
                    sum = sum.add(fee);
//                    String fee = rs.getBigDecimal("fee").toString();
                    String fee_str = fee.toString();
                    res_temp.add(fee_str);
                    res_temp.add("park_fee");
                    res.add(res_temp);
                    System.out.println(pay_time+" "+fee+" "+"park_fee");
                    res_temp = new ArrayList<>();
                }
                sql = "SELECT fee,paytime FROM housebill WHERE paytime < ? AND paytime > ? AND bill_type = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setTimestamp(1,end);
                stmt.setTimestamp(2,begin);
                stmt.setString(3,"物业费");
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                while(rs.next()){
                    String pay_time = rs.getString("paytime");
                    res_temp.add(pay_time);
                    BigDecimal fee = rs.getBigDecimal("fee");
                    sum = sum.add(fee);
//                    String fee = rs.getBigDecimal("fee").toString();
                    String fee_str = fee.toString();
                    res_temp.add(fee_str);
                    res_temp.add("物业费");
                    res.add(res_temp);
                    System.out.println(pay_time+" "+fee+" "+"物业费");
                    res_temp = new ArrayList<>();
                }

                rs.close();
            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail !!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("总收入为："+ sum);
        System.out.println("------------------------------------");
        return res;
    }

    public static ArrayList<ArrayList<String>> getTimeTableOutput(String begin_str,String end_str){
        java.sql.Date begin_date = java.sql.Date.valueOf(begin_str);
        java.sql.Date end_date = java.sql.Date.valueOf(end_str);
        Timestamp begin = new Timestamp(begin_date.getTime());
        Timestamp end = new Timestamp(end_date.getTime());
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> res_temp = new ArrayList<>();
        BigDecimal sum = new BigDecimal(0);

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            conn.setAutoCommit(false);
            try {
                String sql = "SELECT fee,fix_time FROM reportSolve WHERE fix_time < ? AND fix_time > ?";
                stmt = conn.prepareStatement(sql);
                stmt.setTimestamp(1,end);
                stmt.setTimestamp(2,begin);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                while(rs.next()){
                    String pay_time = rs.getString("fix_time");
                    res_temp.add(pay_time);
                    BigDecimal fee = rs.getBigDecimal("fee");
                    sum = sum.add(fee);
//                    String fee = rs.getBigDecimal("fee").toString();
                    String fee_str = fee.toString();
                    res_temp.add(fee_str);
                    res_temp.add("fix_fee");
                    res.add(res_temp);
                    System.out.println(pay_time+" "+fee+" "+"fix_fee");
                    res_temp = new ArrayList<>();
                }
                sql = "SELECT fee,fix_time FROM staffInspect WHERE fix_time < ? AND fix_time > ?";
                stmt = conn.prepareStatement(sql);
                stmt.setTimestamp(1,end);
                stmt.setTimestamp(2,begin);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                while(rs.next()){
                    String pay_time = rs.getString("fix_time");
                    res_temp.add(pay_time);
                    BigDecimal fee = rs.getBigDecimal("fee");
                    sum = sum.add(fee);
//                    String fee = rs.getBigDecimal("fee").toString();
                    String fee_str = fee.toString();
                    res_temp.add(fee_str);
                    res_temp.add("fix_fee");
                    res.add(res_temp);
                    System.out.println(pay_time+" "+fee+" "+"fix_fee");
                    res_temp = new ArrayList<>();
                }

                rs.close();
            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail !!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("总支出为" + "-" + sum);
        System.out.println("------------------------------------");
        return res;
    }

    public static ArrayList<ArrayList<String>> getTimeTableHouse(String house_id,String begin_str,String end_str){
        java.sql.Date begin_date = java.sql.Date.valueOf(begin_str);
        java.sql.Date end_date = java.sql.Date.valueOf(end_str);
        Timestamp begin = new Timestamp(begin_date.getTime());
        Timestamp end = new Timestamp(end_date.getTime());
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> res_temp = new ArrayList<>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            conn.setAutoCommit(false);
            try {
                String sql = "SELECT fee,bill_type,paytime FROM housebill WHERE house_id = ? AND (paytime < ? AND paytime > ?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1,house_id);
                stmt.setTimestamp(2,end);
                stmt.setTimestamp(3,begin);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                while(rs.next()){
                    BigDecimal fee = rs.getBigDecimal("fee");
                    String bill_type = rs.getString("bill_type");
                    String paytime = rs.getString("paytime");
                    String fee_str = fee.toString();
                    res_temp.add(paytime);
                    res_temp.add(fee_str);
                    res_temp.add(bill_type);
                    res.add(res_temp);
                    System.out.println(paytime+" "+fee_str+" "+bill_type);
                    res_temp = new ArrayList<>();
                }
                sql = "SELECT fee,bill_type FROM housebill WHERE house_id = ? AND paytime is null ";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1,house_id);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                while(rs.next()){
                    BigDecimal fee = rs.getBigDecimal("fee");
                    String bill_type = rs.getString("bill_type");
                    String fee_str = fee.toString();
                    res_temp.add("");
                    res_temp.add(fee_str);
                    res_temp.add(bill_type);
                    res.add(res_temp);
                    System.out.println("pending" +  " "+fee+" "+bill_type);
                    res_temp = new ArrayList<>();
                }


                rs.close();
            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail !!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("------------------------------------");
        return res;
    }

    public static ArrayList<String> findEmptyHouse(){
        //estate记得变成匹配值的形式
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Savepoint sp = null;
        ArrayList<String> house_ids = new ArrayList<>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            conn.setAutoCommit(false);
            try {

                String sql = "SELECT house_id FROM house WHERE house_id not in (select owner_id from owner)";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                sp = conn.setSavepoint();

                int count = 0;
                while(rs.next()){
                    count++;
                    String house_id = rs.getString("house_id");
                    System.out.println(house_id);
                    house_ids.add(house_id);
                }
                if (count == 0) {
                    System.out.println("No house empty.");
                    return null;
                }
                rs.close();
            }catch (SQLException se) {
                try {
                    conn.rollback(sp);
                    System.out.println("fail to find a house!!!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("fail to find a house!!!");
                }
            }

            conn.commit();

        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("------------------------------------");
        return house_ids;
    }

}
