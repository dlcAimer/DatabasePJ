import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class window {
    static String admin = "admin";
    static String password = "password";

    private static void menu_0(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("请选择需要进行的事项：");
        System.out.println("1. 车位事务");
        System.out.println("2. 房屋事务");
        System.out.println("3. 报修事务");
        System.out.println("4. 投诉事务");
        System.out.println("5. 管理事务");
        System.out.println("输入quit退出系统");
        System.out.println("--------------------------------------------------------------------------");
    }

    private static void menu_0_1(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("请选择需要进行的事项：");
        System.out.println("1. 临时停车");
        System.out.println("2. 临时停车结算");
        System.out.println("3. 购买车位");
        System.out.println("4. 租车位");
        System.out.println("5. 检测是否需要缴纳租金");
        System.out.println("6. 返回上级菜单");
        System.out.println("--------------------------------------------------------------------------");
    }

    private static void menu_0_2(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("请选择需要进行的事项：");
        System.out.println("1. 购买房屋");
        System.out.println("2. 缴纳房屋管理费/水电费");
        System.out.println("3. 查询房屋月账单");
        System.out.println("4. 返回上级菜单");
        System.out.println("--------------------------------------------------------------------------");
    }

    private static void menu_0_3(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("请选择需要进行的事项：");
        System.out.println("1. 业主报修设备");
        System.out.println("2. 修理设备报告");
        System.out.println("3. 返回上级菜单");
        System.out.println("--------------------------------------------------------------------------");
    }

    private static void menu_0_4(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("请选择需要进行的事项：");
        System.out.println("1. 业主投诉");
        System.out.println("2. 处理业主投诉");
        System.out.println("3. 返回上级菜单");
        System.out.println("--------------------------------------------------------------------------");
    }

    private static void menu_0_5(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("请选择需要进行的事项：");
        System.out.println("1. 器材月度检查报告");
        System.out.println("2. 收取车位管理费");
        System.out.println("3. 查询需要催交房屋管理费/水电费名单");
        System.out.println("4. 生成每户本月需缴纳的房屋管理费/水电费");
        System.out.println("5. 生成时间段收支表单");
        System.out.println("6. 查看空闲房屋");
        System.out.println("7. 返回上级菜单");
        System.out.println("--------------------------------------------------------------------------");
    }

    public static void main(String[] args) throws IOException {
        int order = 0;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to property management system!");
        while (!line.equals("quit")) {
            menu_0();
            while (order != 1 && order != 2 && order != 3 && order != 4 && order != 5) {
                line = scanner.nextLine();
                if (line.equals("quit")) {
                    System.out.println("成功退出");
                    return;
                } else if (line.equals("1") || line.equals("2") || line.equals("3") || line.equals("4") || line.equals("5")) {
                    order = Integer.parseInt(line);
                } else {
                    System.out.println("无效输入，请重新输入");
                }
            }
            if (order == 1) {
                while (!line.equals("6")&&!line.equals("quit")) {
                    menu_0_1();
                    line = scanner.nextLine();
                    order = Integer.parseInt(line);
                    if (order == 1) {
                        System.out.println("请输入您所停的小区：");
                        line = scanner.nextLine();
                        String estate = line;
                        System.out.println("请输入您的车牌号：");
                        line = scanner.nextLine();
                        String license_tag = line;
                        System.out.println("请输入您的电话号码：");
                        line = scanner.nextLine();
                        String tel = line;
                        System.out.println(transactionList.temporaryStopCarArrives(estate, license_tag, tel));
                        System.out.println("信息录入成功，请输入quit退出系统或输入back返回上级菜单");
                        line = scanner.nextLine();
                    } else if (order == 2) {
                        System.out.println("请输入您的车牌号：");
                        line = scanner.nextLine();
                        String license_tag = line;
                        System.out.println(transactionList.theTemporarilyParkedCarLeft(license_tag));
                        System.out.println("付款完成，请输入quit退出系统或输入back返回上级菜单");
                        line = scanner.nextLine();
                    } else if (order == 3) {
                        System.out.println("请输入您想要购买的车位所在小区：");
                        line = scanner.nextLine();
                        String estate = line;
                        System.out.println("请输入您想要绑定的车牌号：");
                        line = scanner.nextLine();
                        String license_tag = line;
                        System.out.println("请输入您的业主id：");
                        line = scanner.nextLine();
                        String owner_id = line;
                        System.out.println(transactionList.buyParkingSpace(estate, license_tag, owner_id));
                        System.out.println("购买成功，请输入quit退出系统或输入back返回上级菜单");
                        line = scanner.nextLine();
                    } else if (order == 4) {
                        System.out.println("请输入您想要租的车位所在小区：");
                        line = scanner.nextLine();
                        String estate = line;
                        System.out.println("请输入您想要绑定的车牌号：");
                        line = scanner.nextLine();
                        String license_tag = line;
                        System.out.println("请输入您的业主id：");
                        line = scanner.nextLine();
                        String owner_id = line;
                        System.out.println("请输入您想要租的月份数：");
                        line = scanner.nextLine();
                        int months = Integer.parseInt(line);
                        System.out.println(transactionList.rentParkingSpace( estate, license_tag, owner_id, months));
                        System.out.println("租车位成功，请输入quit退出系统或输入back返回上级菜单");
                        line = scanner.nextLine();
                    } else if (order == 5) {
                        System.out.println("请输入您的业主id：");
                        line = scanner.nextLine();
                        String owner_id = line;
                        ArrayList<String> needToPay = transactionList.findNeedToPay(owner_id);
                        if(needToPay.size() == 0){
                            System.out.println("没有需要缴纳租金的车位");
                        }else {
                            System.out.println("需要缴纳租金的车位如下所示：");
                            for (int count = 0; count < needToPay.size(); count++) {
                                System.out.print(needToPay.get(count) + " ");
                            }
                            System.out.print("\n");
                            System.out.println("如需要续租请输入1，如不需要请输入2：");
                            line = scanner.nextLine();
                            order = Integer.parseInt(line);
                            if (order == 1) {
                                System.out.println("请输入您要续租的车位id：");
                                line = scanner.nextLine();
                                String space_id = line;
                                System.out.println("请输入您要续租的月份数：");
                                line = scanner.nextLine();
                                int months = Integer.parseInt(line);
                                transactionList.rentContinue(Utils.ownerIdSplit(owner_id).get(0), space_id, owner_id, months);
                                System.out.println("续租成功，请输入quit退出系统或输入back返回上级菜单");
                                line = scanner.nextLine();
                            } else {
                                System.out.println("请输入您要放弃续租的车位id：");
                                line = scanner.nextLine();
                                String space_id = line;
                                System.out.println("请输入车位绑定的车牌号：");
                                line = scanner.nextLine();
                                String license_tag = line;
                                transactionList.abondonRent(license_tag, space_id);
                                System.out.println("放弃续租，请输入quit退出系统或输入back返回上级菜单");
                                line = scanner.nextLine();
                            }
                        }
                    }
                }
                if(line.equals("quit")){
                    return;
                }
                order = 0;
            } else if (order == 2) {
                while (!line.equals("4")&&!line.equals("quit")) {
                    menu_0_2();
                    line = scanner.nextLine();
                    order = Integer.parseInt(line);
                    if( order == 1){
                        System.out.println("请输入您想要购买的房屋id: ");
                        line = scanner.nextLine();
                        String owner_id = line;
                        ArrayList<String> owner_ids = new ArrayList<>();
                        owner_ids.add(owner_id);
                        System.out.println("请输入您的名字：");
                        line = scanner.nextLine();
                        String owner_name = line;
                        ArrayList<String> owner_names = new ArrayList<>();
                        owner_names.add(owner_name);
                        System.out.println("请输入您的身份证号码：");
                        line = scanner.nextLine();
                        String owner_id_num = line;
                        ArrayList<String> owner_id_nums = new ArrayList<>();
                        owner_id_nums.add(owner_id_num);
                        System.out.println("请输入您的电话：");
                        line = scanner.nextLine();
                        String tel = line;
                        ArrayList<String> tels = new ArrayList<>();
                        tels.add(tel);
                        if(transactionList.insertOwner(owner_ids, owner_names, owner_id_nums, tels)){
                            System.out.println("购买房屋成功，请输入quit退出系统或输入back返回上级菜单");
                        }else {
                            System.out.println("房屋已被购买，请重新选择，quit退出系统或输入back返回上级菜单");
                        }
                        line = scanner.nextLine();
                    }else if(order == 2){
                        System.out.println("请输入您的房屋id: ");
                        line = scanner.nextLine();
                        String owner_id = line;
                        transactionList.updateHouseBill(owner_id);
                        System.out.println("缴费成功，请输入quit退出系统或输入back返回上级菜单");
                        line = scanner.nextLine();
                    }else if(order == 3){
                        System.out.println("请输入查询的房间号：");
                        String house_id = scanner.nextLine();
                        System.out.println("请输入查询的起始时间(yyyy-mm-dd):");
                        String line1 = scanner.nextLine();
                        System.out.println("请输入查询的结束时间(yyyy-mm-dd):");
                        String line2 = scanner.nextLine();
                        ArrayList<ArrayList<String>> res = transactionList.getTimeTableHouse(house_id,line1,line2);
                    }
                }
                order = 0;
            } else if (order == 3) {
                line = "0";
                while (!line.equals("3")&&!line.equals("quit")) {
                    menu_0_3();
                    line = scanner.nextLine();
                    order = Integer.parseInt(line);
                    if( order == 1){
                        System.out.println("请输入您的业主id: ");
                        line = scanner.nextLine();
                        String owner_id = line;
                        System.out.println("请输入您要报修的设备id：");
                        line = scanner.nextLine();
                        String em_id = line;
                        transactionList.ownerToRepairService(owner_id, em_id);
                        System.out.println("报修成功，请输入quit退出系统或输入back返回上级菜单");
                        line = scanner.nextLine();
                    }else if(order == 2){
                        System.out.println("请输入您的员工id: ");
                        line = scanner.nextLine();
                        String staff_id = line;
                        transactionList.handleOwnersRepairReport(staff_id);
                        System.out.println("维修信息记录成功，请输入quit退出系统或输入back返回上级菜单");
                        line = scanner.nextLine();
                    }
                }
                order = 0;
            } else if (order == 4) {
                while (!line.equals("3")&&!line.equals("quit")) {
                    menu_0_4();
                    line = scanner.nextLine();
                    order = Integer.parseInt(line);
                    if( order == 1){
                        System.out.println("请输入您的投诉类型('noise','resident','security','others'): ");
                        line = scanner.nextLine();
                        String cp_type = line;
                        System.out.println("请输入您的投诉内容：");
                        line = scanner.nextLine();
                        String content = line;
                        System.out.println("请输入您的业主id：");
                        line = scanner.nextLine();
                        String owner_id = line;
                        transactionList.insertComplaint(cp_type, content, owner_id);
                        System.out.println("投诉成功，请输入quit退出系统或输入back返回上级菜单");
                        line = scanner.nextLine();
                    }else if(order == 2){
                        System.out.println("请输入您的员工id：");
                        line = scanner.nextLine();
                        String staff_id = line;
                        transactionList.insertComplaintSolve(staff_id);
                        System.out.println("处理投诉成功，请输入quit退出系统或输入back返回上级菜单");
                        line = scanner.nextLine();
                    }
                }
                order = 0;
            } else {
                System.out.println("请输入管理员账号：");
                line = scanner.nextLine();
                String admin = line;
                System.out.println("请输入管理员密码：");
                line = scanner.nextLine();
                String password = line;
                if(admin.equals("admin") && password.equals("password")){
                    while (!line.equals("7")&&!line.equals("quit")) {
                        menu_0_5();
                        line = scanner.nextLine();
                        order = Integer.parseInt(line);
                        if( order == 1){
                            ArrayList<String> em_ids = transactionList.findEquipment();
                            System.out.println("请输入您的员工id：");
                            line = scanner.nextLine();
                            String staff_id = line;
                            transactionList.insertStaffInspect(transactionList.construct(), staff_id);
                            System.out.println("月度检修完成，请输入quit退出系统或输入back返回上级菜单");
                            line = scanner.nextLine();
                        }else if(order == 2){
                            transactionList.collectManagementFee(6,
                                    transactionList.lookForUsersWhoNeedToPayParkingSpaceManagementFee());
                            System.out.println("收取车位管理费成功，请输入quit退出系统或输入back返回上级菜单");
                            line = scanner.nextLine();
                        }else if(order == 3){
                            System.out.println("输入1查询需缴纳水电费的住户，输入2查询需要缴纳物业费的住户");
                            String temp = scanner.nextLine();
                            String bill_type;
                            if(temp.equals("1")){
                                bill_type = "水电费";
                            }else {
                                bill_type = "物业费";
                            }
                            ArrayList<String> house_ids = transactionList.urgePayBill(bill_type);
                            System.out.println("需要交费的住户id如下：");
                            for(int count = 0 ;count < house_ids.size() ;count ++){
                                System.out.println(house_ids.get(count)+"  ");
                            }
                            System.out.print("\n");
                            System.out.println("请输入quit退出系统或输入back返回上级菜单");
                            line = scanner.nextLine();
                        }else if(order == 4){
                            transactionList.insertHouseBill();
                            System.out.println("账单生成完毕，请输入quit退出系统或输入back返回上级菜单");
                            line = scanner.nextLine();
                        }else if(order == 5){
                            System.out.println("请输入查询的起始时间(yyyy-mm-dd):");
                            String line1 = scanner.nextLine();
                            System.out.println("请输入查询的结束时间(yyyy-mm-dd):");
                            String line2 = scanner.nextLine();
                            ArrayList<ArrayList<String>> res1 = transactionList.getTimeTableInput(line1,line2);
                            ArrayList<ArrayList<String>> res2 = transactionList.getTimeTableOutput(line1,line2);
                        }else if(order == 6){
                            transactionList.findEmptyHouse();
                        }
                    }
                    order = 0;
                }else {
                    System.out.println("账号或密码错误");
                    order = 0;
                }
            }
        }
    }
}
