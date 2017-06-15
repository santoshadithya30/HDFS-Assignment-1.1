package Acadgild;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

public class ListFiles {
  public static void main(String[] args) throws IOException, URISyntaxException
  {
    //1. Get the Configuration instance
    Configuration configuration = new Configuration();
    //2. Get the instance of the HDFS
    FileSystem hdfs = FileSystem.get();
    //3. Get the metadata of the desired directory
    FileStatus[] fileStatus = hdfs.listStatus(new Path("home/user/edureka/adithyaws/acadgild"));
    //4. Using FileUtil, getting the Paths for all the FileStatus
    Path[] paths = FileUtil.stat2Paths(fileStatus);
    //5. Iterate through the directory and display the files in it
    System.out.println("***** Contents of the Directory *****");
    for(Path path : paths)
    {
      System.out.println(path);
    }
  }
}