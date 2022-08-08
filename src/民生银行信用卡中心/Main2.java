package 民生银行信用卡中心;

import java.util.*;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/7 15:08
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> merSet = new HashSet<>();   // 创建门店

//        Map<String, String> managerMap = new HashMap<>();   // 店长入职
        Map<String, String> managerMap = new HashMap<>();   // 店长入职
        Map<String, String> salesMap = new HashMap<>();   // 店员入职
        Map<String, String[]> managerAlloMap = new HashMap<>();   // 店长权限
        Map<String, String[]> roleAlloMap = new HashMap<>();   // 角色权限

        while (sc.hasNext()) {
            String strs = sc.next();
            if (strs.equals("-1")) break;
            String[] str = strs.split(",");
            String flag = str[0];
            if (flag.equals("0")) {
                String mer = str[1];
                if (merSet.contains(str[1])) System.out.println("创建门店" + str[1] + "失败");
                else {
                    merSet.add(str[1]);
                    System.out.println("创建门店" + str[1]);
                }
            } else if (flag.equals("1")) {   // if else里面的变量不冲突，因为都是在while循环里面新建的
                String manager = str[1];
                String mer = str[2];
                if (!managerMap.containsKey(manager)) {
                    if (merSet.contains(mer)) {
                        managerMap.put(manager, mer);
                        System.out.println("店长" + manager + "入职门店" + mer);
                    } else System.out.println("店长" + manager + "入职门店" + mer + "失败");
                } else if (managerMap.get(manager).equals(mer)) System.out.println("店长" + manager + "入职门店" + mer);
                else System.out.println("店长" + manager + "入职门店" + mer + "失败");
            } else if (flag.equals("2")) {
                String sale = str[1];
                String mer = str[2];
                if (!merSet.contains(mer)) {
                    System.out.println("店员" + sale + "入职门店" + mer + "失败");
                } else if (!salesMap.containsKey(sale)) {
                    salesMap.put(sale, mer);
                    System.out.println("店员" + sale + "入职门店" + mer);
                } else if (salesMap.get(sale).equals(mer)) {
                    System.out.println("店员" + sale + "入职门店" + mer);
                } else System.out.println("店员" + sale + "入职门店" + mer + "失败");
            } else if (flag.equals("3")) {
                String manager = str[1];
                String mer = str[2];
                int n = Integer.parseInt(str[3]);
                String[] allo = new String[n];
                String out = "";
                for (int i = 0; i < n; i++) {
                    allo[i] = str[3 + i + 1];
                    if (i == n - 1) {
                        out = out + allo[i];
                    } else out = out + allo[i] + ",";
                }
                if (!managerMap.containsKey(manager)) {
                    System.out.println("店长" + manager + "在门店"+mer+"的权限为" +out+ "失败");
                } else if (managerMap.get(manager).equals(mer)) {
                    managerAlloMap.put(manager, allo);
                    System.out.println("店长" + manager + "在门店"+mer+"的权限为" +out);
                } else System.out.println("店长" + manager + "在门店"+mer+"的权限为" +out+ "失败");
            } else if (flag.equals("4")) {
                String manager = str[1];
                String role = str[2];
                int n = Integer.parseInt(str[3]);
                String[] allo = new String[n];
                String out = "";
                for (int i = 0; i < allo.length; i++) {
                    allo[i] = str[3 + i + 1];
                    if (i == allo.length - 1) {
                        out = out + allo[i];
                    } else out = out + allo[i] + ",";
                }
                if (!managerAlloMap.containsKey(manager)) {
                    System.out.println("店长" + manager + "创建角色" + role +"失败");
                } else if (managerAlloMap.containsKey(manager)) {
                    String[] managerAllo = managerAlloMap.get(manager);
                    String allStr = "";
                    for (int i = 0; i < managerAllo.length; i++) {
                        if (i == managerAllo.length - 1) {
                            allStr = allStr + managerAllo[i];
                        } else allStr = allStr + managerAllo[i] + ",";
                    }
                    boolean f = true;
                    for (int i = 0; i < allo.length; i++) {
                        if (allStr.contains(allo[i]));
                        else f = false;
                    }
                    if (f) {
                        if (roleAlloMap.containsKey(role)) {
                            System.out.println("店长" + manager + "创建角色" + role +"失败");
                        } else {
                            roleAlloMap.put(role, allo);
                            System.out.println("店长" + manager + "创建角色" + role);
                        }
                    }
                    else System.out.println("店长" + manager + "创建角色" + role +"失败");
                }
            } else if (flag.equals("5")) {
                String manager = str[1];
                String mer = str[2];
                String role = str[3];
                String sale = str[4];
                if (!managerMap.containsKey(manager)) System.out.println("店长"+manager+"向店员"+sale+"赋予角色"+role+"失败");
                else if (!salesMap.containsKey(sale)) System.out.println("店长"+manager+"向店员"+sale+"赋予角色"+role+"失败");
                else if (!managerAlloMap.containsKey(manager)) System.out.println("店长"+manager+"向店员"+sale+"赋予角色"+role+"失败");
                else if (managerMap.containsKey(manager)) {
                    String managerMer = managerMap.get(manager);
                    String saleMer = salesMap.get(sale);
                    if (!managerMer.equals(saleMer)) {
                        System.out.println("店长"+manager+"向店员"+sale+"赋予角色"+role+"失败");
                    } else {
                        String[] allo = managerAlloMap.get(manager);
                        if (allo == null) {
                            System.out.println("店长"+manager+"向店员"+sale+"赋予角色"+role+"失败");
                        } else {
                            String allStr = "";
                            for (int i = 0; i < allo.length; i++) {
                                if (i == allo.length - 1) {
                                    allStr = allStr + allo[i];
                                } else allStr = allStr + allo[i] + ",";
                            }
                            String[] roleAll = roleAlloMap.get(role);
                            boolean f = true;
                            for (int j = 0; j < roleAll.length; j++) {
                                if (allStr.contains(roleAll[j]));
                                else f = false;
                            }
                            if (f) {
                                System.out.println("店长"+manager+"向店员"+sale+"赋予角色"+role);
                            }else {
                                System.out.println("店长"+manager+"向店员"+sale+"赋予角色"+role+"失败");
                            }

                        }

                    }
                }
            }
        }
    }
}
