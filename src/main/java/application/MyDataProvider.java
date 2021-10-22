package application;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> validDataLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"nnoa@gmail.com","Nn12345$"});
        list.add(new Object[]{"noa@gmail.com","Nn12345$"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> invalidDataLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"nnoa@gmail.com","Nn12345$"});
        list.add(new Object[]{"noa@gmail.com","Nn12345$"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataLoginCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new FileReader("src/test/resources/data.csv"));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
