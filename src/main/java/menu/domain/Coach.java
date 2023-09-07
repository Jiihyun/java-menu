package menu.domain;

import java.util.List;

public final class Coach {

  private final String name;
  private final UneatableMenus uneatableMenus = UneatableMenus.empty();
  private final RecommendedMenus recommendedMenus = RecommendedMenus.empty();


  private Coach(final String name) {
    validateNameLength(name);
    this.name = name;
  }

  public static Coach of(final String name) {
    return new Coach(name);
  }

  private void validateNameLength(final String name) {
    if (name == null || name.length() < 2 || name.length() > 4) {
      throw new IllegalArgumentException("[ERROR] 코치 이름은 최소 2글자, 최대 4글자이다.");
    }
  }

  // 못 먹는 음식 추가
  public void addUneatableMenu(final List<String> uneatableMenuNames) {
    uneatableMenus.register(uneatableMenuNames);
  }

  // 추천 음식 추가
  public void addRecommendedMenu(
      final RandomMenuPicker randomMenuPicker,
      final Category category
  ) {
    recommendedMenus.add(randomMenuPicker, category);
  }
}
