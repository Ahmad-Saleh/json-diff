package com.progressoft.induction;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.stream.Stream;

public class JsonDiffTest {

    private JsonDiff jsonDiff = null;// update this by adding your implementation

    @ParameterizedTest
    @MethodSource("getTestData")
    public void givenJson_whenCompare_thenDiffShouldBeCalculated(String original, String updated, String expectedDiff) throws JSONException {
        String diff = jsonDiff.compare(original, updated);

        JSONAssert.assertEquals(expectedDiff, diff, false);
    }

    private static Stream<Arguments> getTestData() throws IOException {
        return Stream.of(
                getArguments("example1"),
                getArguments("example2"),
                getArguments("example3"),
                getArguments("example4"),
                getArguments("example5"));
    }

    private static Arguments getArguments(String directory) throws IOException {
        return Arguments.of(
                readFile(directory + "/original.json"),
                readFile("example1/updated.json"),
                readFile("example1/expected-diff.json"));
    }

    private static String readFile(String filePath) throws IOException {
        URL url = JsonDiffTest.class.getClassLoader().getResource(filePath);
        return IOUtils.toString(url, Charset.forName("UTF-8"));
    }

}