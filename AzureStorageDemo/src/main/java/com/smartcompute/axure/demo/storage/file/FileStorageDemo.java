package com.smartcompute.axure.demo.storage.file;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.file.CloudFileClient;
import com.microsoft.azure.storage.file.CloudFileDirectory;
import com.microsoft.azure.storage.file.CloudFileShare;
import com.microsoft.azure.storage.file.ListFileItem;

public class FileStorageDemo {
	
	public static final String storageConnectionString =
		    "DefaultEndpointsProtocol=https;" +
		    "AccountName=mgmmgb;" +
		    "AccountKey=BR5/NOTErmEHuM5N3xkONvdCB8zxwqzEPYL4/Pb45mD8qBZYwAaTKFrrBnhX6Ik7FjgKqIUiCZ0IcDvjm8/y2w==";
	
	
	private CloudStorageAccount cloudStorageAccount;
	
	/**
	 * 
	 */
	public FileStorageDemo(){
		try {
			this.cloudStorageAccount = CloudStorageAccount.parse(storageConnectionString);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * list all contents
	 */
	public void listAll(){
		try {
			CloudFileClient cloudClient = this.cloudStorageAccount.createCloudFileClient();
			CloudFileShare share = cloudClient.getShareReference("aapldevfileshare");
			//Get a reference to the root directory for the share.
			CloudFileDirectory rootDir = share.getRootDirectoryReference();
			for ( ListFileItem fileItem : rootDir.listFilesAndDirectories() ) {
			    System.out.println(fileItem.getUri());
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (StorageException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	

}
