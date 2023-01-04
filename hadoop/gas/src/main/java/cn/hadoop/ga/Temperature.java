package cn.hadoop.ga;


import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Temperature implements Writable {

    private double sum_temperature;

    public Temperature(double max_temperature) {
        this.sum_temperature = max_temperature;

    }

    public double getMax_temperature() {
        return sum_temperature;
    }

    public void setMax_temperature(double max_temperature) {
        this.sum_temperature = max_temperature;
    }


    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeDouble(sum_temperature);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.sum_temperature = dataInput.readDouble();
    }

    @Override
    public String toString() {
        return sum_temperature + "\t";
    }
}
