package test.com.smartcompute.axure.demo.storage.table;

import org.junit.Test;

import com.smartcompute.axure.demo.storage.table.TableStorageDemo;

public class TableStorageDemoTest {
	
	@Test
	public void createTest(){
		TableStorageDemo tableStorageDemo = new TableStorageDemo();
		tableStorageDemo.createTable();
	}
	
	@Test
	public void listAllTables(){
		TableStorageDemo tableStorageDemo = new TableStorageDemo();
		tableStorageDemo.listAll();
	}
	
	

}
