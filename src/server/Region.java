package server;

import java.util.HashSet;


public class Region implements Comparable<Region> {

  // Nodes in the region.
  private HashSet<Node> nodes;
  // Distortion value of the region.
  private double distortionValue;
  // Radius of the region.
  private int radius;
  // Number of nodes in the region.
  private int regionSize;

  /**
   * Get radius of the region.
   * 
   * @return radius of the region.
   */
  public int getRadius() {
    return radius;
  }

  /**
   * Set radius of the region.
   * 
   * @param radius of the region.
   */
  public void setRadius(int radius) {
    this.radius = radius;
  }

  /**
   * Get region size.
   * 
   * @return region size.
   */
  public int getRegionSize() {
    return regionSize;
  }

  /**
   * set region size.
   * 
   * @param regionSize the region size.
   */
  public void setRegionSize(int regionSize) {
    this.regionSize = regionSize;
  }

  /**
   * Set the region nodes and distortion values.
   * 
   * @param nodes of the region.
   * @param distortionValue of the region.
   * @param radius of the region.
   * @param regionSize size of the region.
   */
  public Region(HashSet<Node> nodes, double distortionValue, int radius, int regionSize) {
    this.nodes = nodes;
    this.distortionValue = distortionValue;
    this.radius = radius;
    this.regionSize = regionSize;
  }

  /**
   * Get the nodes of the region.
   * 
   * @return nodes of the region.
   */
  public HashSet<Node> getNodes() {
    return nodes;
  }

  /**
   * Set the nodes of the region.
   * 
   * @param nodes of the region.
   */
  public void setNodes(HashSet<Node> nodes) {
    this.nodes = nodes;
  }

  /**
   * Get the distortion value of the region.
   * 
   * @return the distortion value of the region.
   */
  public double getDistortionValues() {
    return distortionValue;
  }

  /**
   * Set the distortion value of the region.
   * 
   * @param distortionValues of the region.
   */
  public void setDistortionValues(double distortionValues) {
    this.distortionValue = distortionValues;
  }

  /**
   * Compare two regions. It is used for sorting.
   */
  public int compareTo(Region region) {
    if (this.distortionValue > region.distortionValue) {
      return -1;
    } else if (this.distortionValue == region.distortionValue) {
      return 0;
    } else {
      return 1;
    }
  }



}
