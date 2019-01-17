package xc.jfinal.unitls;

public final class Preference {

    //每页显示条数
    public static final int PAGE_PER_SIZE = 20;
 
    
	/********************* 各种数据长度的约定 *******************************************/
	/** 用户名长度 */
	public static final int ULTRA_USER_NAME_LEN = 31;
	/** 密码长度 */
	public static final int ULTRA_PASSWORD_LEN = 31;
	/** 手机号长度 */
	public static final int ULTRA_PHONE_LEN = 31;
	/** 邮箱地址长度 */
	public static final int ULTRA_EMAIL_LEN = 128;
	/** 用户名输入最小长度 */
	public static final int ULTRA_USER_NAME_MIN_LEN = 5;
	/** 用户名输入最大长度 */
	public static final int ULTRA_USER_NAME_MAX_LEN = 15;
	/** 密码输入最小长度 */
	public static final int ULTRA_PASSWORD_MIN_LEN = 6;
	/** 用户名输入最大长度 */
	public static final int ULTRA_PASSWORD_MAX_LEN = 30;
	/** 登录错误次数 校验次数 */
	public static final int ULTRA_LOGIN_TIMES = 2;


    /**客户端类型**/ 
	public static final int PC_BROWSER = 0; //PC端浏览器
	public static final int MOBILE_BROWSER = 1; //手机浏览器
	public static final int ANDROID_APP = 2; //android
	public static final int IOS_APP = 3;//IOS浏览器
	
	
    public static String SCHOOL_NAME = "西南科技大学";//学校名称
    public static String DEPARTMENT_NAME = "信息工程学院";
    public static String JOB_PROPERTY = "job.properties"; //quartz任务配置路径

    public static String PRE_TEACHER  ="1"; //教师工号开头设置
	/**文件上传*/
	public  static String[] UPLOADFILE_FILE_EXTENSION = {".gif",".jpg",".jpeg",".png","bmp"};//文件允许类型
    public  static String FILE_TEMPORARY_SVAE_DIR = "webRoot\\upload\\"; // 文件的存储路径
	public static  String UPLOADFILE_PATH = "upLoadImg";//文件保存路径
	
	
	public static String PDF_FONT_PATH = "/download/simsun.ttf";
	
	public static final String UPLOAD_KINDEDTOR_DIR = "upload/kindeditor/"; // 编辑器上传新闻文件路径
	public static final String UPLOAD_NEWS_DIR = "upload/news/"; // 编辑器上传新闻文件路径
	public static final String UPLOAD_AVATAR_DIR = "upload/avatar/"; // 编辑器上传头像文件路径,前面需要加个/	
	public static final String UPLOAD_SPLASH_DIR = "upload/splash/"; // 编辑器上传新闻文件路径
	public static final String UPLOAD_LOGO_DIR = "upload/logo/"; // 用户中心上传logo
	public static final String UPLOAD_MAP_DIR = "upload/map/"; // 用户首页上传平民图
	public static final String UPLOAD_PAPER_DIR = "upload/paper/"; // 用户上传证件图
	public static final String DOWN_EXCEL_DIR = "download/"; // 生成echarts图片 和excel文件路径
	public static final String DOWN_DIR = "download"; // 生成echarts图片 和pdf文件路径
	public static final String UPLOAD_DEVICE_DIR = "upload/excel/"; // 用户批量添加设备上传excel文件路径
	public static final String UPLOAD_CITYIMG_DIR = "upload/"; // 城市首页幻彩图片上传文件路径
	public static final String UPLOAD_EXCEL_DIR = "upload/excel/";
	public static final String UPLOAD_DIR = "upload/";
	public static final String UPLOAD_HARD_WORKING_DIR = "upload/hardwork/"; // 勤工助学图片上传文件路径
	public static final String UPLOAD_FAQ_DIR = "upload/FAQ/";//FAQ封面图片上传路径
	public static final String UPLOAD_SPORTS_DIR = "upload/sports/";//sports封面图片上传路径
	public static final String UPLOAD_VOLUNTEER_DIR = "upload/volunteer/";//volunteer封面图片上传路径
	public static final String UPLOAD_EMOTION_DIR = "upload/emotion/";//emotion封面图片上传路径
	
	
	/*ddpush 参数配置 和 软件更新需要  学校和学院ID*/
	public static  String uploadDIR = "";
	
	public final static String SCHOOL_PRE_NAME = "10619"; //西南科技大学
	public final static String DEPARTMENT_PRE_NAME = "01";//信息学院
	
	public static String locale="zh_CN"; 
	public static String testUrl="";
}
