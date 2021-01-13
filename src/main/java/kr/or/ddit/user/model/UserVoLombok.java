package kr.or.ddit.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserVoLombok {
	private String userid;
	private String usernm;
	private String pass;
	private Date reg_dt;
	private String alias;
	private String addr1;
	private String addr2;
	private String zipcode;
	private String filename;
	private String realfilename;
}
