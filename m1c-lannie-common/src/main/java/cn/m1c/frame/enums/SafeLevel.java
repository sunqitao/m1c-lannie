package cn.m1c.frame.enums;


/**
 * @date 2016年7月27日
 * @description  安全级别
 * @author  phil --> E-mail: s@m1c.cn
 * @corp m1c softCo.,ltd
 * @since lannie
 */
public enum SafeLevel implements BaseEnum<SafeLevel> {
	LOW("低"),
    NORMAL("一般"),
    HIGH("高"),
    ERROR("非正常")
    ;
    
    private String chineseName;

    private SafeLevel(String chineseName){
        this.chineseName = chineseName;
    }
    
    @Override
    public String getName() {return name();}
    
    @Override
    public int getOrdinal() {return ordinal();}
    
    @Override
    public String getChineseName() {
        return chineseName;
    }

    
    @Override
    public SafeLevel parsing(String element) {
        try {
            return SafeLevel.valueOf(element.toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
