package cn.hadoop.yea;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.ArrayList;

public class Map extends Mapper<LongWritable, Text,
        Text, LongWritable> {

    private static final long MISSING = -9999;

    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        //Iterable<String> str = Splitter.on(" ").omitEmptyStrings().split(line);
        ArrayList<String> arrayList = new ArrayList<>(16);
        String str[] = line.split(",");
        for (String s : str) {
            arrayList.add(s);
        }
        // 过滤掉字段不足的数据
        if (arrayList.size() >= 6) {
            String temp_date = arrayList.get(2);
            String data[]=temp_date.split("-");
            String year=data[0];
            long quantity = Long.parseLong(arrayList.get(4));
            context.write(new Text(year),
                    new LongWritable((quantity)));
        }
    }

}
