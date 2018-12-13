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
		
//		p(createUserInfoStr(user));
		String sourceString=createUserInfoStr(user)+"&"+createInspiredTimestamp(user);
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
	
	
	
	public static void main(String[] args) throws Exception {
//		createToken(new User("tom", "pwd123", "ashjdhghkjag",""));
//		p(createToken(new User("tom", "pwd123", "ashjdhghkjag")));
		
//		validUser(new User());
//		validUser(new User("testname", "testpwd", "testid"));
	}
	
	
	
}
