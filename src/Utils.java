import org.ibex.nestedvm.util.Seekable;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;

public class Utils {
    private static int to_id_count ;
    private static int po_id_count ;
    private static int ro_id_count ;
    private static int bill_id_count ;
    private static int report_id_count ;
    private static int rps_id_count ;
    private static int cp_id_count ;
    private static int management_bill_count ;

    public static void countSave(){
        try {
            File writeName = new File("/Users/Aliez/IdeaProjects/PJDatabase/src/output.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.write(to_id_count+"\r\n"); // \r\n即为换行
                out.write(po_id_count+"\r\n");
                out.write(ro_id_count+"\r\n");
                out.write(bill_id_count+"\r\n");
                out.write(report_id_count+"\r\n");
                out.write(rps_id_count+"\r\n");
                out.write(cp_id_count+"\r\n");
                out.write(management_bill_count+"\r\n");
                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void countRead(){
        String pathname = "/Users/Aliez/IdeaProjects/PJDatabase/src/output.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            ArrayList<Integer> lines = new ArrayList<Integer>();
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                lines.add(Integer.parseInt(line));
            }
            to_id_count = lines.get(0);
            po_id_count = lines.get(1);
            ro_id_count = lines.get(2);
            bill_id_count = lines.get(3);
            report_id_count = lines.get(4);
            rps_id_count = lines.get(5);
            cp_id_count = lines.get(6);
            management_bill_count = lines.get(7);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> ownerIdSplit(String owner_id){
        if(owner_id.length() == 7) {
            ArrayList<String> ownerInformation = new ArrayList<>();
            String estate = owner_id.substring(0, 0);
            ownerInformation.add(estate);
            String buildingNo = owner_id.substring(1, 1);
            ownerInformation.add(buildingNo);
            String unitNo = owner_id.substring(2,2);
            ownerInformation.add(unitNo);
            String roomNo = owner_id.substring(3,6);
            ownerInformation.add(roomNo);
            return ownerInformation;
        }
        else {
            System.out.println("业主id信息错误");
            return null;
        }
    }

    public static ArrayList<String> houseIdSplit(String house_id){
        if(house_id.length() == 7) {
            ArrayList<String> houseInformation = new ArrayList<>();
            String estate = house_id.substring(0, 0);
            String buildingNo = house_id.substring(1, 1);
            String unitNo = house_id.substring(2,2);
            String roomNo = house_id.substring(3,6);
            houseInformation.add(estate);
            houseInformation.add(buildingNo);
            houseInformation.add(unitNo);
            houseInformation.add(roomNo);
            return houseInformation;
        }
        else {
            System.out.println("住宅id信息错误");
            return null;
        }
    }

    public static ArrayList<String> spaceIdSplit(String space_id) {
        ArrayList<String> spaceInformation = new ArrayList<>();
        String estate = space_id.substring(0, 0);
        String spaceNo = space_id.substring(1, 4);
        spaceInformation.add(estate);
        spaceInformation.add(spaceNo);
        return spaceInformation;
    }

    public static String tempOrderIdConstruct(){
        countRead();
        to_id_count++;
        String to_id = Integer.toString(to_id_count);
        countSave();
        return to_id;
    }

    public static String purchaseOrderIdConstruct(){
        countRead();
        po_id_count++;
        String po_id = Integer.toString(po_id_count);
        countSave();
        return po_id;
    }

    public static String rentOrderIdConstruct(){
        countRead();
        ro_id_count++;
        String ro_id = Integer.toString(ro_id_count);
        countSave();
        return ro_id;
    }

    public static String billOrderIdConstruct(){
        countRead();
        bill_id_count++;
        String bill_id = Integer.toString(bill_id_count);
        countSave();
        return bill_id;
    }

    public static String reportIdConstruct(){
        countRead();
        report_id_count++;
        String report_id = Integer.toString(report_id_count);
        countSave();
        return report_id;
    }

    public static String rpsIdConstruct(){
        countRead();
        rps_id_count++;
        String rps_id = Integer.toString(rps_id_count);
        countSave();
        return rps_id;
    }

    public static String cpIdConstruct(){
        countRead();
        cp_id_count++;
        String cp_id = Integer.toString(cp_id_count);
        countSave();
        return cp_id;
    }

    public static String managementBillIdConstruct(){
        countRead();
        management_bill_count++;
        String management_bill = Integer.toString(management_bill_count);
        countSave();
        return management_bill;
    }

    public static BigDecimal calculateTimestampDuration(Timestamp start_time, Timestamp end_Time){
        long duration = (end_Time.getTime() - start_time.getTime())/(1000*60*60);
        BigDecimal result = BigDecimal.valueOf(duration);
        return result;
    }

    public static java.sql.Date getRentStartDate(){
        Date temp_date = new Date();
        java.sql.Date date = new java.sql.Date(temp_date.getTime());
        return date;
    }

    public static java.sql.Date getRentEndDate(int months){
        Date temp_date = new Date();
        java.sql.Date date = new java.sql.Date(temp_date.getTime() + months * 30 * 24 * 60 * 60 * 1000L);
        return date;
    }

    public static BigDecimal tempOrderFee(BigDecimal duration){
        BigDecimal fee = new BigDecimal("0.0");
        if(duration.compareTo(new BigDecimal("1.0")) == -1){
            fee = new BigDecimal("0.0");
        }else if((duration.compareTo(new BigDecimal("1.0")) == 0 ||
                duration.compareTo(new BigDecimal("1.0")) == 1) &&
                duration.compareTo(new BigDecimal("8.0")) == -1 ){
            fee = new BigDecimal("5.0");
        }else if((duration.compareTo(new BigDecimal("8.0")) == 0 ||
                duration.compareTo(new BigDecimal("8.0")) == 1) &&
                duration.compareTo(new BigDecimal("24.0")) == -1 ){
            fee = new BigDecimal("10.0");
        }else {
            fee = (duration.divide(new BigDecimal("24.0"))).multiply(new BigDecimal("10.0"));
        }
        return fee;
    }

    public static BigDecimal purchaseOrderFee(String estate){
        BigDecimal fee = new BigDecimal("0.0");
        if(estate.equals("A")){
            fee = new BigDecimal("200000");
        }else if(estate.equals("B")){
            fee = new BigDecimal("220000");
        }else {
            fee = new BigDecimal("240000");
        }
        return fee;
    }

    public static BigDecimal rentOrderFee(String estate, int months){
        BigDecimal fee = new BigDecimal("0.0");
        String temp_fee = "";
        if(estate.equals("A")){
            temp_fee = "200";
        }else if(estate.equals("B")){
            temp_fee = "250";
        }else {
            temp_fee = "300";
        }
        fee = (new BigDecimal(temp_fee)).multiply(new BigDecimal(Integer.toString(months)));
        return fee;
    }

    public static BigDecimal managementFee(int months){
        BigDecimal fee = (new BigDecimal("50.0")).multiply(new BigDecimal(Integer.toString(months)));
        return fee;
    }

    public static BigDecimal handleReportFee(String em_type){
        BigDecimal fee = new BigDecimal("0.0");
        if(em_type.equals("streetlamp")){
            fee = new BigDecimal("350.00");
        }else if(em_type.equals("fitness_equipment")){
            fee = new BigDecimal("500.00");
        }else if(em_type.equals("corridorlight")){
            fee = new BigDecimal("200.00");
        }else {
            fee = new BigDecimal("800.00");
        }
        return fee;
    }

    public static java.sql.Date getMonthDate(int months){
        Date temp_date = new Date();
        java.sql.Date date = new java.sql.Date(months * 30 * 24 * 60 * 60 * 1000L);
        return date;
    }

    public static java.sql.Timestamp getMonthStamp(int months){
        Timestamp temp = new java.sql.Timestamp(months * 30 * 24 * 60 * 60 * 1000L);
        return temp;
    }

    //timestap运算，随机生成函数
}
