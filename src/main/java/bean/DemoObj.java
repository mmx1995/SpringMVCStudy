package bean;


// jackson 对对象和json 坐转换时，一定需要做空构造
public class DemoObj {
	private Long id;
	private String name;
	
	public DemoObj(){
		super();
	}
	
	public DemoObj(Long id, String name){
		this.id = id ;
		this.name = name ;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
