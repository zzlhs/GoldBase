package com.zzl.myself;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Zzl(isDelete = true)
public class User {
	
	private String name;
	
	private Integer age;
	
	private boolean isDelete;
}
