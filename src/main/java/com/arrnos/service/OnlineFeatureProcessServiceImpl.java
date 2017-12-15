package com.arrnos.service;

import com.arrnos.model.User;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Attribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Field;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class OnlineFeatureProcessServiceImpl implements OnlineFeatureProcessService {
    private Map<String, Integer> jobMap = new HashMap<String, Integer>();
    private Map<String, Integer> maritalMap = new HashMap<String, Integer>();
    private Map<String, Integer> educationMap = new HashMap<String, Integer>();
    private Map<String, Integer> monthMap = new HashMap<String, Integer>();
    private Map<String, Integer> poutcomeMap = new HashMap<String, Integer>();
    private List<String> fieldItems = new ArrayList<String>();

    public OnlineFeatureProcessServiceImpl() {

        jobMap.put("management", 0);
        jobMap.put("retired", 1);
        jobMap.put("self-employed", 2);
        jobMap.put("unknown", 3);
        jobMap.put("unemployed", 4);
        jobMap.put("housemaid", 5);
        jobMap.put("admin.", 6);
        jobMap.put("technician", 7);
        jobMap.put("student", 8);
        jobMap.put("services", 9);
        jobMap.put("entrepreneur", 10);
        jobMap.put("blue-collar", 11);

        maritalMap.put("single", 0);
        maritalMap.put("married", 1);
        maritalMap.put("divorced", 2);

        educationMap.put("unknown", 0);
        educationMap.put("primary", 1);
        educationMap.put("tertiary", 2);
        educationMap.put("secondary", 3);

        monthMap.put("mar", 0);
        monthMap.put("feb", 1);
        monthMap.put("aug", 2);
        monthMap.put("sep", 3);
        monthMap.put("may", 4);
        monthMap.put("jun", 5);
        monthMap.put("jul", 6);
        monthMap.put("jan", 7);
        monthMap.put("apr", 8);
        monthMap.put("nov", 9);
        monthMap.put("dec", 10);
        monthMap.put("oct", 11);

        poutcomeMap.put("unknown", 0);
        poutcomeMap.put("other", 1);
        poutcomeMap.put("success", 2);
        poutcomeMap.put("failure", 3);

        fieldItems.add("age");
        fieldItems.add("job");
        fieldItems.add("marital");
        fieldItems.add("education");
        fieldItems.add("balance");
        fieldItems.add("day");
        fieldItems.add("month");
        fieldItems.add("duration");
        fieldItems.add("campaign");
        fieldItems.add("pdays");
        fieldItems.add("previous");
        fieldItems.add("poutcome");
    }


    @Override
    public String featureProcess(User user) {
//        User user1 = new User("arrnos", 24, "student", "married", "primary", 1000, 4, "aug", 10, 80, 5, 3, "unknown");

        StringBuffer userInformation = new StringBuffer("1");
        for (int i = 0; i < fieldItems.size(); i++) {

            try {
                String fieldName = fieldItems.get(i);
                Field field1 = user.getClass().getDeclaredField(fieldName);
                field1.setAccessible(true);
                String value = field1.get(user).toString();

                if (fieldName == "job") {
                    if (jobMap.get(value) != 0)
                        userInformation.append(" " + i + ":" + jobMap.get(value));
                } else if (fieldName == "marital") {
                    if (maritalMap.get(value) != 0)
                        userInformation.append(" " + i + ":" + maritalMap.get(value));
                } else if (fieldName == "education") {
                    if (educationMap.get(value) != 0)
                        userInformation.append(" " + i + ":" + educationMap.get(value));
                } else if (fieldName == "month") {
                    if (monthMap.get(value) != 0)
                        userInformation.append(" " + i + ":" + monthMap.get(value));
                } else if (fieldName == "poutcome") {
                    if (poutcomeMap.get(value) != 0)
                        userInformation.append(" " + i + ":" + poutcomeMap.get(value));
                } else if (value != "0") {
                    userInformation.append(" " + i + ":" + value);
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
//        System.out.println(userInformation.toString());

        File file = new File("src/main/resources/data", "user_information");
        try {
            if (!file.exists())
                file.createNewFile(); // 创建文件
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 向文件写入内容(输出流)
        String str = userInformation.toString();
        try {
            FileOutputStream in = new FileOutputStream(file);
            try {
                in.write(str.getBytes());
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return userInformation.toString();
    }

}
