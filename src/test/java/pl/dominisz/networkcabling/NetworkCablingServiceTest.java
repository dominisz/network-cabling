package pl.dominisz.networkcabling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class NetworkCablingServiceTest {

  @ParameterizedTest
  @MethodSource("filenameProvider")
  void readFile(String inputFilename, String outputFilename) throws IOException {
    List<Building> buildings = TestDataReader.readBuildings(inputFilename);
    long expectedLength = TestDataReader.readLength(outputFilename);

    long startTime = System.currentTimeMillis();
    long actualLength = NetworkCablingService.minimumLength(buildings);
    long stopTime = System.currentTimeMillis();

    System.out.println(
        "Filename: " + inputFilename + ", computation time: " + (stopTime - startTime));
    Assertions.assertEquals(expectedLength, actualLength);
  }

  static Stream<Arguments> filenameProvider() {
    return IntStream.rangeClosed(1, 9)
        .mapToObj(i -> arguments("example_" + i + "_input.txt", "example_" + i + "_output.txt"));
  }
}
