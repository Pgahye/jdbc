package dao.test;

import java.util.List;

import dao.AuthorDao;
import dao.BookDao;
import jdbc.AuthorVo;
import jdbc.BookVo;

public class BookDaoTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//insertTest();
		selectTest();
		//selectTest(3L);
		//deleteTest(3L);	
		//updateTest();
		
	}
	
	
	public static void insertTest(){
		
		BookVo BookVo=new BookVo();
		BookVo.setTitle("title 2");
		BookVo.setPrice(20000);
		BookVo.setAuthor_no(2);
		
		new BookDao().insert(BookVo);
		
	}
	
public static void selectTest(){
		
		List<BookVo> list=new BookDao().getList();
		
		for( BookVo vo  : list ) { 
			
			System.out.println(vo);
			
			
		}
		
	}
	public static void selectTest(Long no){
		
		BookVo list=new BookDao().get(no);
		
	
			
			System.out.println(list);
			
			
		
		
	}
	public static void deleteTest(Long no){
		
		new BookDao().delete( no ); 
		
		
	}
	public static void updateTest(){
		
		BookVo BookVo=new BookVo();
		BookVo.setNo(4L);
		BookVo.setTitle("title 22");
		BookVo.setPrice(1000022);
		BookVo.setAuthor_no(2);
		
		new BookDao().update(BookVo);
		
	}
	
}
