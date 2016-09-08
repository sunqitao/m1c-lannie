package cn.m1c.frame.lannie.test.mongo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.redis.connection.Message;

import cn.m1c.frame.mongodb.AbstractConditions;
import cn.m1c.frame.mongodb.MongoDbUtil;
/**
 * @date 2016年7月31日
 * @description 通过传入的条件查询mongo中的数据
 * @author  phil --> E-mail: s@m1c.cn
 * @corp m1c soft Co.,ltd
 * @since lannie
 */
public class QueryByConditionFromMongo {
//	public void queryList(){
//		Query query = clientAppCondition.buildQuery();
//		//定制查询返回字段
//		MongoDbUtil.bindFields(query, null);//null指定要查询的字段可以不哟过
//		//绑定分页
//		MongoDbUtil.bindPaging(ClientApp.class, wDao, query, page);
//		//绑定排序
//		MongoDbUtil.bindOrders(query, clientAppCondition.getOrderBean());
//		//返回查询列表
//		return wDao.find(query, ClientApp.class);
//	}
}
//－－－－－－－－－－－华丽分割线－－－－－－－－－－－－－－－
/**
 * 客户端APP版本查询条件类
 */
//class ClientAppCondition extends AbstractConditions {
//	
//
//	private static final long serialVersionUID = -9138337238753159379L;
//
//	private Set<Long> ids;
//	
//	private String key;
//	
//	/** 版本号 **/
//	private Long versionNumber;
//	
//	/** 更新包对应APP不同应用 **/
//	private Long agentId;//0:物流端  1:司机端 2:货主端
//	
//	/** APP ID **/
//	private Long appId;//1:android/0:IOS
//	
//	/** user ID **/
//	private Long userId;
//	
//	private boolean deleted;
//	
//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
//
//	@Override
//	public Set<? extends Serializable> getIds() {
//		return this.ids;
//	}
//
//	@Override
//	public Criteria buildCriteria() {
//		List<Criteria> criteras = new ArrayList<Criteria>(1);
//
//		if(Collections.notEmpty(this.ids)){
//			if(this.ids.size() == 1){
//				criteras.add(Criteria.where("_id").is(this.ids.iterator().next()));
//			}else{
//				criteras.add(Criteria.where("_id").in(this.ids));
//			}
//		}
//		
//		criteras.add(Criteria.where("state").ne(2));//更新状态不为2，即：不是非必须更新的版本号
//		
//		if(this.versionNumber!=null){
//			criteras.add(Criteria.where("versionNumber").gt(versionNumber));
//		}
//		
//		if(this.agentId!=null){
//			criteras.add(Criteria.where("agentId").is(agentId));
//		}
//		
//		if(this.appId!=null){
//			criteras.add(Criteria.where("appId").is(appId));
//		}
//		
//		if(this.userId!=null){
//			criteras.add(Criteria.where("userId").is(userId));
//		}
//		
////		if(this.versionNumber!=null){
////			criteras.add(Criteria.where("versionNumber").gt(versionNumber));
////		}
//		
//		if (this.deleted ) {
//			criteras.add(Criteria.where("deleted").is(true));
//		}else{
//			Criteria a = Criteria.where("deleted").is(false);
//			Criteria b = Criteria.where("deleted").exists(false);
//			criteras.add(new Criteria().orOperator(a,b));
//		}
//		
//		if(criteras.size() == 1){
//			return criteras.get(0);
//		}
//		
//		Criteria criteria = new Criteria();
//		if(criteras.size() > 1){
//			criteria.andOperator(criteras.toArray(new Criteria[]{}));
//		}
//		
//		return criteria;
//	}
//
//	public void addId(long id){
//		if(this.ids == null){
//			this.ids = new HashSet<>(1);
//		}
//		this.ids.add(id);
//	}
//	public String getKey() {
//		return key;
//	}
//
//	public void setKey(String key) {
//		this.key = key;
//	}
//
//	public boolean isDeleted() {
//		return deleted;
//	}
//
//	public void setDeleted(boolean deleted) {
//		this.deleted = deleted;
//	}
//
//	public void setIds(Set<Long> ids) {
//		this.ids = ids;
//	}
//
//	public Long getVersionNumber() {
//		return versionNumber;
//	}
//
//	public void setVersionNumber(Long versionNumber) {
//		this.versionNumber = versionNumber;
//	}
//
//	public Long getAgentId() {
//		return agentId;
//	}
//
//	public void setAgentId(Long agentId) {
//		this.agentId = agentId;
//	}
//
//	public Long getAppId() {
//		return appId;
//	}
//
//	public void setAppId(Long appId) {
//		this.appId = appId;
//	}
//
//}
