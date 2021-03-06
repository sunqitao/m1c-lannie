package cn.m1c.frame.mongodb;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.DBCollection;

import cn.m1c.frame.page.PageBaseModel;
import cn.m1c.frame.utils.CollectionUtil;
import cn.m1c.frame.utils.StringUtil;

/**
 * 2016年7月27日  mongodb tools
 * @author  phil(s@m1c.cn,m1c softCo.,ltd)
 * @version lannie
 */
public abstract class MongoDaoUtil {


	/**
	 * 仿SQL的Like查询
	 *Criteria.where(field).regex(String.format(REGEX_LIKE, name));
	 */
	//public static final java.lang.String REGEX_LIKE = "/%s/";
	public static final String REGEX_LIKE = "^.*%s.*$";

	/**
	 * 绑定分页
	 */
	public static void bindPaging(Class<?> entityName, MongoOperations mongoOperations, Query query, PageBaseModel page){
		if(page == null){
			return;
		}
		if(page.getTotalCount() == 0){
			page.setTotalCount((int)mongoOperations.count(query, entityName));
		}
		//query.skip(page.getFirstIndex()).limit(page.getPageSize());
		query.skip(page.getStartNum()).limit(page.getPageSize());
	}
	
	public static void bindPaging(DBCollection dbCollection, MongoOperations mongoOperations, Query query, PageBaseModel page){
		if(page == null){
			return;
		}
		if(page.getTotalCount() == 0){
			page.setTotalCount((int)dbCollection.getCount(query.getQueryObject()));
		}
		//query.skip(page.getFirstIndex()).limit(page.getPageSize());
		query.skip(page.getStartNum()).limit(page.getPageSize());
	}


	/**
	 * 绑定排序
	 */
	public static void bindOrders(Query query, OrderBean orderBean){
		if(orderBean == null){
			return;
		}
		LinkedHashMap<String, Boolean> ov = orderBean.getOrderValue();
		for(Map.Entry<String, Boolean> o : ov.entrySet()){
			query.with(new org.springframework.data.domain.Sort(o.getValue() ? org.springframework.data.domain.Sort.Direction.ASC : org.springframework.data.domain.Sort.Direction.DESC, o.getKey()));
			//query.sort().on(o.getKey(), o.getValue() ? Order.ASCENDING : Order.DESCENDING);
		}
	}


	/**
	 * 定制字段   fields 指定的字段，多个须以逗号隔开，支持*号
	 */
	public static void bindFields(Query query, String fields){
		if(StringUtil.hasLengthBytrim(fields) && !"*".equals(fields)){
			String[] fs = fields.split(",");
			for(String f : fs){
				query.fields().include(f);
			}
		}
	}
	
	public static void bindFields(Query query, Set<String> fields){
		if(CollectionUtil.isEmpty(fields) || "*".equals(fields.iterator().next())){
			return;
		}
		
		for(String f : fields){
			query.fields().include(f);
		}
	}
	
	public static void bindExcludeFields(Query query, Set<String> fields){
		if(CollectionUtil.notEmpty(fields) ){
			for(String f : fields){
				query.fields().exclude(f);
			}
		}
		
	}

	public static void bindUpdateFieldValue(Update update, Map<String, Object> values){
		if(values == null || values.size() == 0){
			return;
		}
		for(Map.Entry<String, Object> value : values.entrySet()){
			update.set(value.getKey(), value.getValue());
		}
	}
	
	public static String regex(String name){
		return String.format(REGEX_LIKE, name);
	}
	
	
	/**
	 * 根据主键和值构建查询对象
	 */
	public static Query parseQuery(String id, Object value){
		Criteria critera = Criteria.where(id).is(value);
		Query query = Query.query(critera);
		return query;
	}
}
