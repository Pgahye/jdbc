package dao.test;

import java.util.List;

import dao.AuthorDao;
import jdbc.AuthorVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//insertTest();
		selectTest();
		//selectTest(1L);
		//deleteTest(1L);	
		//updateTest();
		
	}
	
	
	public static void insertTest(){
		
		AuthorVo authorVo=new AuthorVo();
		authorVo.setName("rovert3");
		authorVo.setBio("blah~~~3");
		
		new AuthorDao().insert(authorVo);
		
	}
	
public static void selectTest(){
		
		List<AuthorVo> list=new AuthorDao().getList();
		
		for( AuthorVo vo  : list ) { 
			
			System.out.println(vo);
			
			
		}
		
	}
	public static void selectTest(Long no){
		
		AuthorVo list=new AuthorDao().get(no);
		
	
			
			System.out.println(list);
			
			
		
		
	}
	public static void deleteTest(Long no){
		
		new AuthorDao().delete( no ); 
		
		
	}
	public static void updateTest(){
		
		AuthorVo authorVo=new AuthorVo();
		authorVo.setNo(2L);
		authorVo.setName("rovert22");
		authorVo.setBio("blah~~~22");
		
		new AuthorDao().update(authorVo);
		
	}
	

}
