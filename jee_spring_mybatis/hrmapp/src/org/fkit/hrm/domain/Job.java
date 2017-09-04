package org.fkit.hrm.domain;

/**
 * 持久化实体类;
 */
public class Job implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;			// id
	private String name;		// 职位名称
	private String remark;		// 详细描述
	
	public Job() {
		super();
	}
	
	// Getters and Setters;
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return this.remark;
	}
	
	@Override
	public String toString() {
		return "Job [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}

}
