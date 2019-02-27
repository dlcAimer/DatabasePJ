import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

public class initialize {
    private static void tryTransaction_insertHouse(){
        ArrayList<String> house_ids = new ArrayList<>();
        ArrayList<BigDecimal> house_areas = new ArrayList<>();
        house_ids.add("A551807");
        house_areas.add(BigDecimal.valueOf(70.6));
        house_ids.add("B180204");
        house_areas.add(BigDecimal.valueOf(88.9));
        house_ids.add("C170305");
        house_areas.add(BigDecimal.valueOf(45.0));
        house_ids.add("A181003");
        house_areas.add(BigDecimal.valueOf(98.4));
        house_ids.add("B114123");
        house_areas.add(BigDecimal.valueOf(94.9));
        house_ids.add("C100831");
        house_areas.add(BigDecimal.valueOf(66.0));
        house_ids.add("A192836");
        house_areas.add(BigDecimal.valueOf(74.4));
        house_ids.add("B102312");
        house_areas.add(BigDecimal.valueOf(47.9));
        house_ids.add("C120822");
        house_areas.add(BigDecimal.valueOf(84.0));
        house_ids.add("C303812");
        house_areas.add(BigDecimal.valueOf(97.0));
        house_ids.add("A831012");
        house_areas.add(BigDecimal.valueOf(84.0));
        house_ids.add("B617002");
        house_areas.add(BigDecimal.valueOf(75.0));
        house_ids.add("A331801");
        house_areas.add(BigDecimal.valueOf(84.0));
        transactionList.insertHouse(house_ids,house_areas);
    }

    private static void tryTransaction_insertStaff(){
        ArrayList<String> staff_ids = new ArrayList<>();
        ArrayList<String> staff_names = new ArrayList<>();
        staff_ids.add("001");
        staff_names.add("赵");
        staff_ids.add("002");
        staff_names.add("钱");
        staff_ids.add("003");
        staff_names.add("孙");
        staff_ids.add("004");
        staff_names.add("李");
        staff_ids.add("005");
        staff_names.add("周");
        staff_ids.add("006");
        staff_names.add("吴");
        staff_ids.add("007");
        staff_names.add("正");
        transactionList.insertStaff(staff_ids,staff_names);
    }

    private static void tryTransaction_insertParkingSpace(){
        ArrayList<String> space_ids = new ArrayList<>();
        space_ids.add("A001");
        space_ids.add("A002");
        space_ids.add("A003");
        space_ids.add("A004");
        space_ids.add("A005");
        space_ids.add("A006");
        space_ids.add("A007");
        space_ids.add("A008");
        space_ids.add("B001");
        space_ids.add("B002");
        space_ids.add("B003");
        space_ids.add("B004");
        space_ids.add("B005");
        space_ids.add("B006");
        space_ids.add("B007");
        space_ids.add("C001");
        space_ids.add("C002");
        space_ids.add("C003");
        space_ids.add("C004");
        space_ids.add("C005");
        space_ids.add("C006");
        space_ids.add("C007");
        transactionList.insertParkingSpace(space_ids);
    }

    private static void tryTransaction_insertEquipment(){
        ArrayList<String> em_ids = new ArrayList<>();
        ArrayList<String> em_types = new ArrayList<>();
        ArrayList<String> em_address = new ArrayList<>();
        em_ids.add("A001");
        em_types.add("streetlamp");
        em_address.add("where?");
        em_ids.add("A002");
        em_types.add("corridorlight");
        em_address.add("where?");
        em_ids.add("A003");
        em_types.add("streetlamp");
        em_address.add("where?");
        em_ids.add("B001");
        em_types.add("fitness_equipment");
        em_address.add("where?");
        em_ids.add("B002");
        em_types.add("corridorlight");
        em_address.add("where?");
        em_ids.add("B003");
        em_types.add("corridorlight");
        em_address.add("where?");
        em_ids.add("C001");
        em_types.add("streetlamp");
        em_address.add("where?");
        em_ids.add("C002");
        em_types.add("streetlamp");
        em_address.add("where?");
        em_ids.add("C003");
        em_types.add("elevator");
        em_address.add("where?");
        em_ids.add("C004");
        em_types.add("corridorlight");
        em_address.add("where?");
        em_ids.add("A004");
        em_types.add("fitness_equipment");
        em_address.add("where?");
        em_ids.add("A005");
        em_types.add("streetlamp");
        em_address.add("where?");
        em_ids.add("B004");
        em_types.add("fitness_equipment");
        em_address.add("where?");
        em_ids.add("A006");
        em_types.add("elevator");
        em_address.add("where?");
        transactionList.insertEquipment(em_ids,em_types,em_address);
    }

    private static void tryTransaction_insertOwner(){
        ArrayList<String> house_ids = new ArrayList<>();
        ArrayList<String> owner_names = new ArrayList<>();
        ArrayList<String> id_card_nums = new ArrayList<>();
        ArrayList<String> tels = new ArrayList<>();
        house_ids.add("A551807");
        owner_names.add("aaa");
        id_card_nums.add("001");
        tels.add("10000000001");
        house_ids.add("B180204");
        owner_names.add("aab");
        id_card_nums.add("002");
        tels.add("10000000002");
        house_ids.add("C170305");
        owner_names.add("aac");
        id_card_nums.add("003");
        tels.add("10000000003");
        house_ids.add("A181003");
        owner_names.add("aad");
        id_card_nums.add("004");
        tels.add("10000000004");
        house_ids.add("B114123");
        owner_names.add("aae");
        id_card_nums.add("005");
        tels.add("10000000005");
        house_ids.add("C100831");
        owner_names.add("aaf");
        id_card_nums.add("006");
        tels.add("10000000006");
        house_ids.add("A192836");
        owner_names.add("aag");
        id_card_nums.add("007");
        tels.add("10000000007");
        house_ids.add("B102312");
        owner_names.add("aah");
        id_card_nums.add("008");
        tels.add("10000000008");
        transactionList.insertOwner(house_ids,owner_names,id_card_nums,tels);
    }

    private static void tryTransaction_insertHouseBill(){
        ArrayList<String> bill_ids = new ArrayList<>();
        ArrayList<String> bill_types = new ArrayList<>();
        ArrayList<BigDecimal> fees = new ArrayList<>();
        ArrayList<String> house_ids = new ArrayList<>();
        bill_ids.add(Utils.billOrderIdConstruct());
        bill_types.add("物业费");
        fees.add(new BigDecimal(188.4));
        house_ids.add("A551807");
        bill_ids.add(Utils.billOrderIdConstruct());
        bill_types.add("物业费");
        fees.add(new BigDecimal(188.4));
        house_ids.add("B180204");
        bill_ids.add(Utils.billOrderIdConstruct());
        bill_types.add("物业费");
        fees.add(new BigDecimal(188.4));
        house_ids.add("C170305");
        bill_ids.add(Utils.billOrderIdConstruct());
        bill_types.add("物业费");
        fees.add(new BigDecimal(188.4));
        house_ids.add("A181003");
        bill_ids.add(Utils.billOrderIdConstruct());
        bill_types.add("物业费");
        fees.add(new BigDecimal(188.4));
        house_ids.add("B114123");
        bill_ids.add(Utils.billOrderIdConstruct());
        bill_types.add("物业费");
        fees.add(new BigDecimal(188.4));
        house_ids.add("C100831");
        bill_ids.add(Utils.billOrderIdConstruct());
        bill_types.add("物业费");
        fees.add(new BigDecimal(188.4));
        house_ids.add("A192836");
        bill_ids.add(Utils.billOrderIdConstruct());
        bill_types.add("物业费");
        fees.add(new BigDecimal(188.4));
        house_ids.add("B102312");
        bill_ids.add(Utils.billOrderIdConstruct());
        bill_types.add("物业费");
        fees.add(new BigDecimal(188.4));
        house_ids.add("C120822");
        bill_ids.add(Utils.billOrderIdConstruct());
        bill_types.add("水电费");
        fees.add(new BigDecimal(12.4));
        house_ids.add("A192836");
        bill_ids.add(Utils.billOrderIdConstruct());
        bill_types.add("水电费");
        fees.add(new BigDecimal(18.4));
        house_ids.add("B102312");
        bill_ids.add(Utils.billOrderIdConstruct());
        bill_types.add("水电费");
        fees.add(new BigDecimal(48.4));
        house_ids.add("C120822");
        transactionList.insertHouseBill(bill_ids,bill_types,fees,house_ids);
    }

    private static void tryTransaction_insertComplaint(){
        ArrayList<String> sp_ids = new ArrayList<>();
        ArrayList<String> cp_types = new ArrayList<>();
        ArrayList<Timestamp> cp_times = new ArrayList<>();
        ArrayList<String> contents = new ArrayList<>();
        ArrayList<String> owner_ids = new ArrayList<>();
        sp_ids.add(Utils.cpIdConstruct());
        sp_ids.add(Utils.cpIdConstruct());
        sp_ids.add(Utils.cpIdConstruct());
        sp_ids.add(Utils.cpIdConstruct());
        sp_ids.add(Utils.cpIdConstruct());
        sp_ids.add(Utils.cpIdConstruct());
        cp_types.add("noise");
        cp_types.add("resident");
        cp_types.add("noise");
        cp_types.add("resident");
        cp_types.add("noise");
        cp_types.add("security");
        cp_times.add(new Timestamp(System.currentTimeMillis()));
        cp_times.add(new Timestamp(System.currentTimeMillis()));
        cp_times.add(new Timestamp(System.currentTimeMillis()));
        cp_times.add(new Timestamp(System.currentTimeMillis()));
        cp_times.add(new Timestamp(System.currentTimeMillis()));
        cp_times.add(new Timestamp(System.currentTimeMillis()));
        owner_ids.add("A181003");
        owner_ids.add("A181003");
        owner_ids.add("A192836");
        owner_ids.add("B114123");
        owner_ids.add("C100831");
        owner_ids.add("C170305");
        contents.add("There is a question.");
        contents.add("There is a question.");
        contents.add("There is a question.");
        contents.add("There is a question.");
        contents.add("There is a question.");
        contents.add("There is a question.");
        transactionList.insertComplaint(sp_ids,cp_types,cp_times,contents,owner_ids);
    }

    private static void tryTransaction_insertStaffInspect(){
        ArrayList<String> em_ids = new ArrayList<>();
        ArrayList<java.util.Date> inspect_times = new ArrayList<>();
        ArrayList<String> staff_ids = new ArrayList<>();
        ArrayList<String> em_statues = new ArrayList<>();
        em_ids.add("A001");
        em_ids.add("C003");
        inspect_times.add(Utils.getRentStartDate());
        inspect_times.add(Utils.getRentStartDate());
        staff_ids.add("001");
        staff_ids.add("001");
        em_statues.add("0");
        em_statues.add("1");
        transactionList.insertStaffInspect(em_ids,inspect_times,staff_ids,em_statues);
    }

    public static void initializeData(){
        tryTransaction_insertHouse();
        tryTransaction_insertStaff();
        tryTransaction_insertParkingSpace();
        tryTransaction_insertEquipment();
        tryTransaction_insertOwner();
        tryTransaction_insertHouseBill();
        tryTransaction_insertComplaint();
        tryTransaction_insertStaffInspect();
    }
}
