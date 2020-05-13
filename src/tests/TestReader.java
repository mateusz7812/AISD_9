package tests;

import com.company.Reader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestReader {
    @Test
    public void TestManual(){
        var reader = new Reader();
        try {
            reader.ReadWordsFromFile("kzyzacy.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.fail();
    }
}
