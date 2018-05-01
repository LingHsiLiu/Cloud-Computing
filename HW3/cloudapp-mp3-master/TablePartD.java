import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;

import org.apache.hadoop.hbase.TableName;

import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

import org.apache.hadoop.hbase.util.Bytes;

public class TablePartD{

   private static final String table_name1 = "powers";
    
   public static void main(String[] args) throws IOException {

	
       //Configuration config = HBaseConfiguration.create();
       //HTable hTable = new HTable(config, table_name1);
       
       Configuration config = HBaseConfiguration.create();
       HTable table = new HTable(config, "powers");
       
       for( Integer i = 1;i <= 25;i++){
           
           // Instantiating Get class
           Get g = new Get(Bytes.toBytes("row" + i.toString()));
           Result result = table.get(g);
           
           // Reading values from Result class object
           byte [] hero = result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("hero"));
           byte [] power = result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("power"));
           byte [] name = result.getValue(Bytes.toBytes("professional"),Bytes.toBytes("name"));
           byte [] xp = result.getValue(Bytes.toBytes("professional"),Bytes.toBytes("xp"));
           byte [] color = result.getValue(Bytes.toBytes("custom"),Bytes.toBytes("color"));
           
           
           System.out.println("hero: " + Bytes.toString(hero) + " power: " + Bytes.toString(power) + " name: " + Bytes.toString(name) + " xp: " + Bytes.toString(xp) + " color: " + Bytes.toString(color));
           
       }
       
       //TODO
   }
}

