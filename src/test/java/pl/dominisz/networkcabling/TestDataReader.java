package pl.dominisz.networkcabling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

class TestDataReader {

  static List<Building> readBuildings(String filename) throws IOException {
    return Files.readAllLines(getPathToFile(filename)).stream()
        .map(
            line -> {
              String[] tokens = line.split(" ");
              return new Building(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
            })
        .collect(Collectors.toList());
  }

  static long readLength(String filename) throws IOException {
    return Long.parseLong(Files.readString(getPathToFile(filename)));
  }

  private static Path getPathToFile(String filename) {
    return new File(TestDataReader.class.getClassLoader().getResource(filename).getFile()).toPath();
  }
}
