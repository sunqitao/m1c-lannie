package cn.m1c.frame.lannie.test.mongo;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
/**
 * @date 2016年7月31日
 * @description example 在mongo中 通过空间索引来查询一个坐标点一个半径内的数据
 * @author  phil --> E-mail: s@m1c.cn
 * @corp m1c soft Co.,ltd
 * @since lannie
 */
public class QueryCoordinateFromMongo {
	/**
	 * mongo中查询圆内合同列表
	 * description:  put 增加过滤条件，  BasicDBObject 定义过滤条件，  $gt 大于，  $in 在什么里[数组]
	 * @param longitude  经度
	 * @param latitude  维度
	 * @param radius    半径
	 * @param locationField   mongodb中坐标字段名称
	 * @return
	 */
//	public List<DBObject> getContractsWithCoordinates(String locationField,double longitude,double latitude ,
//            Float radius) {
//		LinkedList<Object> circle = new LinkedList<>();
//		circle.addLast(new double[]{longitude, latitude});
//		circle.addLast(radius/6378137.0);
//     	DBObject query = new BasicDBObject();
//     	String[] states = {ContractStateEnum.PUBLISH.toString(),ContractStateEnum.DOING.toString(),ContractStateEnum.FINISH.toString()};
//     	//当前日期减一天
//     	Date date = new Date();
//     	Calendar cal = Calendar.getInstance();
//     	cal.setTime(date);
//     	cal.set(Calendar.HOUR_OF_DAY, 0);
//     	cal.set(Calendar.MINUTE, 0);
//     	cal.set(Calendar.SECOND, 0);     	
//     	cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);    	
//     	Date d2 = cal.getTime();    	
//     	BasicDBObject cond1 = new BasicDBObject();
//     	cond1.put("$in",states);
//        BasicDBObject cond2 = new BasicDBObject();
//        cond2.put("$gt",0);
//        BasicDBObject cond3 = new BasicDBObject();
//        cond3.put("$ne", null);
//        //装车截止日期小于当前日期加一天
//        BasicDBObject cond4 = new BasicDBObject();
//        cond4.put("$gt",d2);
//        query.put("loadEndDate", cond4);
//        query.put("companyId", cond3);
//        query.put("state", cond1);
//        //query.put("countWait",cond2);
//		query.put(locationField, new BasicDBObject("$geoWithin", new BasicDBObject("$centerSphere", circle)));
//		return wDao.getCollection("tb_contract").find(query).toArray();
//	}
}
