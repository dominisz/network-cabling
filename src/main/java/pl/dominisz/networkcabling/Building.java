package pl.dominisz.networkcabling;

public class Building {

  private final long x;
  private final long y;

  public Building(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public long getX() {
    return x;
  }

  public long getY() {
    return y;
  }
}
