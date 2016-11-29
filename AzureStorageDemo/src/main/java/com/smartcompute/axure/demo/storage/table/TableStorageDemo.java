package com.smartcompute.axure.demo.storage.table;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.Iterator;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;

public class TableStorageDemo {
	
	public static final String storageConnectionString =
		    "DefaultEndpointsProtocol=https;" +
		    "AccountName=mgmmgb;" +
		    "AccountKey=BR5/NOTErmEHuM5N3xkONvdCB8zxwqzEPYL4/Pb45mD8qBZYwAaTKFrrBnhX6Ik7FjgKqIUiCZ0IcDvjm8/y2w==";
	
	
	private CloudStorageAccount cloudStorageAccount;
	
	/**
	 * 
	 */
	public TableStorageDemo(){
		try {
			this.cloudStorageAccount = CloudStorageAccount.parse(storageConnectionString);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * list all tables
	 */
	public void listAll(){
			CloudTableClient cloudTableClient = this.cloudStorageAccount.createCloudTableClient();
			Iterator<String> listIt = cloudTableClient.listTables().iterator();
			System.out.println("list of all tables:");
			while(listIt.hasNext()){
				System.out.println(listIt.next());
			}
	}
	
	/**
	 * 
	 */
	public void createTable(){
		CloudTableClient cloudClient = this.cloudStorageAccount.createCloudTableClient();
		try {
			CloudTable cloudTable = cloudClient.getTableReference("employee");
			boolean created = cloudTable.createIfNotExists();
			if(created){
				System.out.println("table names \"employee\" is create");
			}else{
				System.out.println("table names \"employee\" exists already");
			}
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
}
	
	
	
	
	
	
	
	
	
	
	

}
