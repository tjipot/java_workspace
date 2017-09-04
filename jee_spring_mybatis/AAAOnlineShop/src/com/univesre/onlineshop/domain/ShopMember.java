package com.univesre.onlineshop.domain;


public class ShopMember implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer memberId;
	private String memberRegisterEmail;
	private String memberNickname;
	private String memberAddress;
	private String memberPassword;
	private String memberCreateTime;
	
	public ShopMember() {
		super();
	}

	// Getters and Setters;
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberRegisterEmail() {
		return memberRegisterEmail;
	}

	public void setMemberRegisterEmail(String memberRegisterEmail) {
		this.memberRegisterEmail = memberRegisterEmail;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberCreateTime() {
		return memberCreateTime;
	}

	public void setMemberCreateTime(String memberCreateTime) {
		this.memberCreateTime = memberCreateTime;
	}
	
	@Override
	public String toString() {
		return "This Is ShopMember";
	}

}
