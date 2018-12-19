package com.example.demo.model;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import static com.example.demo.util.PassUtil.*;

import static org.springframework.util.StringUtils.*;

import static com.example.demo.util.PrintUtil.*;

public class TokenFactory {
	
	
	public final static  String ANNOTATION_TOKEN_INCLUDE_NAME="TokenInclude";
	public final static long SYS_ADMIN_TOKEN_INSPIRE_TIME=30*60*1000; //管理员token 有效期 30分钟
	public final static long GENERAL_USER_TOKEN_INSPIRE_TIME=12*60*60*1000; //一般用户token 有效期 30分钟
	
	//校验user信息是否满足
	static boolean validUser(User user) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		
		Field[] fields=user.getClass().getDeclaredFields();
		for (Field field : fields) {
//			System.out.println(field.getAnnotations());
			Annotation[] annotations=field.getAnnotations();
			field.getGenericType();
			field.setAccessible(true);
			field.get(user).toString();
//			user.getClass().getDeclaredField(field.getName());
			
			for (Annotation annotation : annotations) {
				String annotationName=annotation.annotationType().getSimpleName();
//				System.out.println(annotation.getClass().getSimpleName());
				p(field.getName()+":"+annotationName);
			}
		}
		
		return false;
	}
	
	public static boolean isExistAnnotation(Annotation[] annotations,String annotationName){
		for (Annotation annotation : annotations) {
			String name=annotation.annotationType().getSimpleName();
			if(name.equals(annotationName)){
				return true;
			}
		}
		return false;
	}
	
//	public static String getFieldName(Field field,Object obj){
//		
//	}
	
	public static Object getFieldValue(Field field,Object obj) throws IllegalArgumentException, IllegalAccessException{
		field.getGenericType();
		field.setAccessible(true);
		Object res=field.get(obj);
		if(res==null){
			throw new IllegalArgumentException();
		}
		return res;
		
	}
	
	public static String createUserInfoStr(User user) throws IllegalArgumentException, IllegalAccessException{
		String res="";
		Field[] fields=user.getClass().getDeclaredFields();
		for (Field field : fields) {
			if(isExistAnnotation(field.getAnnotations(),ANNOTATION_TOKEN_INCLUDE_NAME)){
				res+=(field.getName()+":"+getFieldValue(field, user)+";");
			}
		}
		return res;
	}
	
	
	
	public static String createToken(User user) throws IllegalArgumentException, IllegalAccessException, UnsupportedEncodingException{
		
		//用户信息&有效期的时间戳&口令 = token 明文
		String sourceString=createUserInfoStr(user)+"&"+createInspiredTimestamp(user)+"&"+PASS;
//		encrypt(sourceString, PASS);
		return encrypt(sourceString, PASS);
	}
	
	public static long createInspiredTimestamp(User user){
		String role_id=user.getRole_id();
		long res=0;
			switch (role_id) {
			case "SYS_ADMIN":
				res=System.currentTimeMillis()+
						SYS_ADMIN_TOKEN_INSPIRE_TIME   ;
				break;
			case "GENERAL_USER":
				res=System.currentTimeMillis()+
						GENERAL_USER_TOKEN_INSPIRE_TIME   ;
				break;

			default:
				throw new IllegalArgumentException();
			}
		
		return res;
	}
	
	public static boolean validateToken(String token) throws Exception{
		//TODO  
		token=decrypt(token, PASS);//将token转换为明文
		if(!isInspired(token)){
			throw new AppHttpException(RspStatus.NO_AUTH, "token 已经过期");
		}else if(!isValid(token)){
			throw new AppHttpException(RspStatus.BAD_AUTH, "不合法或无效的 token");
		}
		return true;
	}
	
	// 校验token 有效时间  接受一个解密后的token
	public static boolean isInspired(String token){
		String[] strs=token.split("&");
		//用户信息&有效期的时间戳&口令
		return Long.parseLong(strs[1])>System.currentTimeMillis();
	}
	
	// 校验token 是否有效 接受一个解密后的token
		public static boolean isValid(String token){
			String[] strs=token.split("&");
			//用户信息&有效期的时间戳&口令
			return strs[2].equals(PASS);
		}
	
	
	
	public static void main(String[] args) throws Exception {
//		createToken(new User("tom", "pwd123", "ashjdhghkjag",""));
//		p(createToken(new User("tom", "pwd123", "ashjdhghkjag")));
		
//		validUser(new User());
//		validUser(new User("testname", "testpwd", "testid"));
	}
	
	
	
}
