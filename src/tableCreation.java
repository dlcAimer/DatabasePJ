import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class tableCreation {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/PJ?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Wgb0823@";

    private static final String ownerCreation = "CREATE TABLE owner" +
            "(owner_id varchar(10)," +
            "owner_name varchar(10)," +
            "id_card_num varchar(18) not null," +
            "tel varchar(11)," +
            "primary key (owner_id))";

    private static final String staffCreation = "CREATE TABLE staff" +
            "(staff_id varchar(10)," +
            "staff_name varchar(10)," +
            "primary key (staff_id))";

    private static final String equipmentCreation = "CREATE TABLE equipment" +
            "(em_id varchar(10)," +
            "em_type varchar(20) check(em_type in('streetlamp','fitness_equipment','corridorlight','elevator'))," +
            "em_status varchar(1) default '0' check(em_status in ('0','1'))," +
            "em_address varchar(20)," +
            "inspect_time date default '2000-01-01'," +
            "primary key (em_id))";

    private static final String houseCreation = "CREATE TABLE house" +
            "(house_id varchar(10)," +
            "house_area numeric(4,1) not null," +
            "primary key (house_id))";

    private static final String housebillCreation = "CREATE TABLE housebill" +
            "(bill_id varchar(10)," +
            "bill_type varchar(8) not null," +
            "fee numeric(5,2) not null," +
            "house_id varchar(10) not null," +
            "paytime date," +
            "primary key (bill_id)," +
            "foreign key (house_id) references house (house_id))";

    private static final String parkingSpaceCreation = "CREATE TABLE parkingSpace" +
            "(space_id varchar(10)," +
            "space_type varchar(10) default 'temp_park' not null, check (space_type in ('rent','purchase','temp_park','parking'))," +
            "primary key (space_id))";

    private static final String carCreation = "CREATE TABLE car" +
            "(license_tag varchar(10)," +
            "space_id varchar(10) not null," +
            "owner_id varchar(10) not null," +
            "primary key (license_tag)," +
            "foreign key (owner_id) references owner (owner_id)," +
            "foreign key (space_id) references parkingSpace (space_id))";

    private static final String visitorCarCreation = "CREATE TABLE visitorCar" +
            "(license_tag varchar(10)," +
            "tel varchar(11)," +
            "start_time timestamp," +
            "space_id varchar(10)," +
            "primary key (license_tag)," +
            "foreign key (space_id) references parkingSpace (space_id))";

    private static final String tempOrderCreation = "CREATE TABLE tempOrder" +
            "(to_id varchar(5)," +
            "end_time timestamp not null," +
            "duration numeric(4,0) not null," +
            "fee numeric(4,0) not null default 0," +
            "license_tag varchar(10)," +
            "primary key (to_id)," +
            "foreign key (license_tag) references visitorCar (license_tag))";

    private static final String purchaseOrderCreation = "CREATE TABLE purchaseOrder" +
            "(po_id varchar(5)," +
            "space_id varchar(10) not null," +
            "owner_id varchar(10) not null," +
            "pay_time timestamp not null," +
            "fee numeric(7,0) not null, check(fee in (200000,220000,240000))," +
            "primary key (po_id)," +
            "foreign key (owner_id) references owner (owner_id)," +
            "foreign key (space_id) references parkingSpace (space_id))";

    private static final String rentOrderCreation = "CREATE TABLE rentOrder" +
            "(ro_id varchar(5)," +
            "space_id varchar(10) not null," +
            "owner_id varchar(10) not null," +
            "start_time date not null," +
            "end_time date not null," +
            "fee numeric(6,0) not null," +
            "primary key (ro_id)," +
            "foreign key (owner_id) references owner (owner_id)," +
            "foreign key (space_id) references parkingSpace (space_id))";

    private static final String managementFeeCreation = "CREATE TABLE managementFee" +
            "(bill_id varchar(5)," +
            "fee numeric(4,0) default 600," +
            "pay_time timestamp not null," +
            "last_time numeric(3,0) not null default 12," +
            "end_time timestamp not null," +
            "space_id varchar(10) not null," +
            "owner_id varchar(10) not null," +
            "primary key (bill_id)," +
            "foreign key (owner_id) references owner (owner_id)," +
            "foreign key (space_id) references parkingSpace (space_id))";

    private static final String complaintCreation = "CREATE TABLE complaint" +
            "(cp_id varchar(5)," +
            "cp_type varchar(20), check(cp_type in('noise','resident','security','others'))," +
            "cp_time timestamp," +
            "content varchar(50)," +
            "owner_id varchar(10)," +
            "primary key (cp_id)," +
            "foreign key (owner_id) references owner (owner_id))";

    private static final String complaintSolveCreation = "CREATE TABLE complaintSolve" +
            "(staff_id varchar(10)," +
            "cp_id varchar(5)," +
            "deal_course varchar(50)," +
            "deal_res varchar(10) default 'unsolved'," +
            "primary key (staff_id, cp_id))";

    private static final String staffInspectCreation = "CREATE TABLE staffInspect" +
            "(em_id varchar(5)," +
            "inspect_time date," +
            "staff_id varchar(10)," +
            "em_status varchar(1), check (status in ('0','1'))," +
            "fix_time timestamp," +
            "fee numeric(5,2)," +
            "primary key (em_id,inspect_time, staff_id))";

    private static final String reportCreation = "CREATE TABLE report" +
            "(report_id varchar(5)," +
            "owner_id varchar(10)," +
            "em_id varchar(5)," +
            "re_time timestamp," +
            "status varchar(10) default 'unsolved'," +
            "primary key (report_id)," +
            "foreign key (owner_id) references owner (owner_id)," +
            "foreign key (em_id) references equipment (em_id))";

    private static final String reportSolveCreation = "CREATE TABLE reportSolve" +
            "(rps_id varchar(5)," +
            "staff_id varchar(10)," +
            "report_id varchar(5)," +
            "deal_course varchar(50)," +
            "sdeal_res varchar(10) default 'unsolved'," +
            "fix_time timestamp," +
            "fee numeric(5,2)," +
            "primary key (rps_id)," +
            "foreign key (staff_id) references staff (staff_id)," +
            "foreign key (report_id) references report (report_id))";

    public static void createTables() {
        ArrayList<String> sqlTableCreations = new ArrayList<>();
        sqlTableCreations.add(ownerCreation);
        sqlTableCreations.add(staffCreation);
        sqlTableCreations.add(equipmentCreation);
        sqlTableCreations.add(houseCreation);
        sqlTableCreations.add(housebillCreation);
        sqlTableCreations.add(parkingSpaceCreation);
        sqlTableCreations.add(carCreation);
        sqlTableCreations.add(managementFeeCreation);
        sqlTableCreations.add(visitorCarCreation);
        sqlTableCreations.add(tempOrderCreation);
        sqlTableCreations.add(purchaseOrderCreation);
        sqlTableCreations.add(rentOrderCreation);
        sqlTableCreations.add(complaintCreation);
        sqlTableCreations.add(complaintSolveCreation);
        sqlTableCreations.add(staffInspectCreation);
        sqlTableCreations.add(reportCreation);
        sqlTableCreations.add(reportSolveCreation);

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            for (String sql : sqlTableCreations) {
                stmt.executeUpdate(sql);
            }

            System.out.println("Created table in given database...");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    }

    public static void main(String[] args){
//        createTables();
        initialize.initializeData();
    }

}
