import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;

import org.apache.hadoop.hbase.TableName;

import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

import org.apache.hadoop.hbase.util.Bytes;

private static final String table_name1 = "powers";
private static final String table_name2 = "food";

public class SuperTable{

   public static void main(String[] args) throws IOException {

       Configuration config = HBaseConfiguration.create();
       HBaseAdmin admin = new HBaseAdmin(config);
       
       // create new table if not exists
       if(!admin.tableExists(table_name1)){
           HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(table_name1));
           tableDescriptor.addFamily(new HColumnDescriptor("personal"));
           tableDescriptor.addFamily(new HColumnDescriptor("professional"));
           tableDescriptor.addFamily(new HColumnDescriptor("custom"));
           admin.createTable(tableDescriptor);
       }
       
       if(!admin.tableExists(table_name2)){
           HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(table_name2));
           tableDescriptor.addFamily(new HColumnDescriptor("nutrition"));
           tableDescriptor.addFamily(new HColumnDescriptor("taste"));
           admin.createTable(tableDescriptor);
       }

       
      // Instantiate Configuration class

      // Instaniate HBaseAdmin class
      
      // Instantiate table descriptor class
       

      // Add column families to table descriptor

      // Execute the table through admin

       // Instantiating HTable class
       HTable hTable = new HTable(config, table_name);
     
      // Repeat these steps as many times as necessary

	      // Instantiating Put class
       // Put data
       Put p = new Put(Bytes.toBytes("row1"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("yes"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("fly"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("batman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("100"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("color"),Bytes.toBytes("black"));
       hTable.put(p);
       
       
       Put p = new Put(Bytes.toBytes("row2"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("yes"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("run"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("superman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("10"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("color"),Bytes.toBytes("red"));
       hTable.put(p);
       
       Put p = new Put(Bytes.toBytes("row3"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("no"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("eat"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("bananaman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("30"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("color"),Bytes.toBytes("yellow"));
       hTable.put(p);
       
       Put p = new Put(Bytes.toBytes("row4"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("yes"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("fly"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("spiderman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("45"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("color"),Bytes.toBytes("red"));
       hTable.put(p);
       
       Put p = new Put(Bytes.toBytes("row5"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("yes"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("run"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("superman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("10"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("color"),Bytes.toBytes("red"));
       hTable.put(p);

              // Hint: Accepts a row name

      	      // Add values using add() method
              // Hints: Accepts column family name, qualifier/row name ,value

      // Save the table
	
      // Close table
       hTable.close();

      // Instantiate the Scan class
       Scan scan = new Scan();
     
      // Scan the required columns
       scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("hero"));


      // Get the scan result
       hTable = new HTable(config, table_name);
       ResultScanner scanner = hTable.getScanner(scan);


      // Read values from scan result
       for (Result result = scanner.next(); result != null; result = scanner.next()){
            // Print scan result
           System.out.println(result);
       }

      // Print scan result
       
 
      // Close the scanner
       scanner.close();
   
      // Htable closer
       hTable.close();
   }
}

