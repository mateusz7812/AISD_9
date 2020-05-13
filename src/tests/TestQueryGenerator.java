package tests;

import com.company.QueryGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestQueryGenerator {
    @Test
    public void Test1(){
        var generator = new QueryGenerator(new String[]{"a"});
        String[] generate = generator.Generate(1);
        Assert.assertEquals("a", generate[0]);
    }

    @Test
    public void Test2(){
        String[] words = {"a", "b"};
        var generator = new QueryGenerator(words);
        String[] generate = generator.Generate(1);
        Assert.assertTrue(List.of(words).contains(generate[0]));
    }
}
