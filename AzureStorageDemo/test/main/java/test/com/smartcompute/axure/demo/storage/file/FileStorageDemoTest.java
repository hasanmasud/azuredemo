package test.com.smartcompute.axure.demo.storage.file;

import org.junit.Test;

import com.smartcompute.axure.demo.storage.file.FileStorageDemo;

public class FileStorageDemoTest {
	
	@Test
	public void testLIstAll(){
		FileStorageDemo fileStorageDemo  = new FileStorageDemo();
		fileStorageDemo.listAll();
	}
}
