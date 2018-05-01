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

public class TablePartA{

    private static final String table_name1 = "powers";
    private static final String table_name2 = "food";
    
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
            //TODO
            System.out.println("Created table powers");
        }
        
        if(!admin.tableExists(table_name2)){
            HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(table_name2));
            tableDescriptor.addFamily(new HColumnDescriptor("nutrition"));
            tableDescriptor.addFamily(new HColumnDescriptor("taste"));
            admin.createTable(tableDescriptor);
            //TODO
            System.out.println("Created table food");
        }

   }
}

