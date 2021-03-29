package com.climedo.test.utils;

import com.climedo.test.model.DataPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public Boolean getValidDataPoint(String dataPoint) {
        String[] validPoints = Constants.VALID_POINTS;
        List<String> nameList = new ArrayList<>(Arrays.asList(validPoints));
        return nameList.contains(dataPoint);
    }
    public List<DataPoint> setValidDataPoints(List<DataPoint> dataPoint) {
       List<DataPoint> dataPoints = new ArrayList<>();
        for(DataPoint d : dataPoint){
            if (getValidDataPoint(d.getDataType())) {
                dataPoints.add(d);
            }
        }
        return dataPoints;
    }


}
