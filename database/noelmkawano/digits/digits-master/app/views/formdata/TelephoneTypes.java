package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to support manipulation of Telephone Type maps.
 */
public class TelephoneTypes {

  private static String[] types = {"Home", "Work", "Mobile"};

  /**
   * Builds a new map of telephone types, initialized to false.
   * @return The new telephone type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<String, Boolean>();
    for (String type : types) {
      typeMap.put(type, false);
    }
    return typeMap;
  }

  /**
   * Returns true if type is a valid telephone type.
   * @param type The type is set to true.
   * @return True if valid.
   */
  public static boolean isType(String type) {
    return getTypes().containsKey(type);
  }

  /**
   * Builds a new type of map of telephone types, where map entry with type is set to true.
   * @param type The type to set to true.
   * @return The map of telephone types.
   */
  public static Map<String, Boolean> getTypes(String type) {
    Map<String, Boolean> typeMap = getTypes();
    if (isType(type)) {
      typeMap.put(type, true);
    }
    return typeMap;
  }
}
