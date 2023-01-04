package cn.hadoop.yea;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Reduce extends Reducer<Text, LongWritable, Text, Temperature> {
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        double sum_gas = 0.0;
        double temp;
        int count = 0;
        if (values!=null) {
            for (LongWritable value: values) {
                temp = value.get();
                sum_gas += temp;
                count++;
            }
            Temperature tem_sum=new Temperature(sum_gas);
            context.write(key, tem_sum);
        }

    }
}
