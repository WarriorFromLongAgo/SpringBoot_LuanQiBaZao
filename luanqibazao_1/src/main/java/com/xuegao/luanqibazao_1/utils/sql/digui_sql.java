package com.xuegao.luanqibazao_1.utils.sql;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.sql
 * <br/> @ClassName：digui_sql
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/8/15 11:42
 */
public class digui_sql {

    // public class GetyList {
    //
    //     private GetyList(){}
    //
    //     private static class getGetList{
    //         private static final GetyList getList=new GetyList();
    //     }
    //
    //     public static GetyList getyList(){
    //         return getGetList.getList;
    //     }
    //
    //     public List<Record> finAllLsit(String userId){
    //         List<Record> records = Db.find("select incharge from sys_user where id= ?", userId);
    //
    //         List<Record> list = new ArrayList<>();
    //
    //         if (records != null && records.size()>0){
    //             Integer incharge = records.get(0).get("incharge");
    //             if (incharge==0){
    //                 System.out.println(incharge);
    //             }else if (incharge==1){
    //                 List<Record> powerlist = findPowerlist(userId);
    //                 for (int i=0;i<powerlist.size();i++){
    //                     String id = powerlist.get(i).get("id");
    //                     System.out.println("id-------------------->"+id);
    //                     List<Record> list1 = Db.find("select user_code from sys_user where org_id=?", id);
    //                     if (list1 != null && list1.size()>0){
    //                         for (Record record:
    //                                 list1) {
    //                             String user_code = record.get("user_code");
    //                             List<Record> list2 = Db.find(Db.getSql("customer.user_jurisdiction"), user_code);
    //                             for (Record record1:
    //                                     list2) {
    //                                 list.add(record1);
    //                             }
    //                         }
    //                     }
    //                 }
    //                 System.out.println(list);
    //             }
    //         }
    //         return list;
    //     }
    //
    //
    //     private List<Record>  findPowerlist(String userId) {
    //         List<Record> records = Db.find("select org_id from sys_user where id= ?", userId);
    //         if (records != null && records.size()>0){
    //             String org_id = records.get(0).get("org_id");
    //             List<Record> list=new ArrayList<>();
    //             List<Record> recursion = getRecursion(org_id, list);
    //             return recursion;
    //         }
    //         return null;
    //     }
    //
    //     //    递归查询自己下面所有的部门人员ID
    //     private List<Record> getRecursion(String orgId,List<Record> list){
    //         List<Record> recordList = Db.find("select id from sys_org where parentid=?", orgId);
    //         for (int i=0;i<recordList.size();i++) {
    //             String parentid =  recordList.get(i).get("id");
    //             list.add(recordList.get(i));
    //             if (recordList.get(i) != null && StringUtils.isNotBlank(parentid)){
    //                 getRecursion(parentid,list);
    //             }
    //         }
    //         return list;
    //     }
    // }

}