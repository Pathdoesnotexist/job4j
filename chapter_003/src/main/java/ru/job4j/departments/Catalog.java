package ru.job4j.departments;

import java.util.*;

public class Catalog {
    /**
     * Справочник департаментов
     */
    public List<String> catalog = new ArrayList<>();
    /**
     * Прямой посимвольный порядок сортировки каталога
     * @param catalog - каталог департаментов до сортировки
     */
    public void abs(List<String> catalog) {
        Comparator<String> absComparator = new CharComparator();
        catalog.sort(absComparator);
    }
    /**
     * Обратный порядок сортировки каталога
     * @param catalog - каталог департаментов до сортировки
     */
    public void desc(List<String> catalog) {
        Comparator<String> descComparator = new DescCharComparator();
        catalog.sort(descComparator);
    }
    /**
     * Заполнение справочника недостающими данными иерархии департаментов
     * @param catalog - каталог департаментов с неполными данныи
     * @return - каталог департаментов с дополненными данныи
     */
    public List<String> fillGaps(List<String> catalog) {
        List<String> unitsToMerge = new ArrayList<>();
        for (String catalogUnit : catalog) {
            List<String> slicedUnit = Arrays.asList(catalogUnit.split("\\\\"));
            String slicedUnitPart = slicedUnit.get(0);
            for (int i = 1; i < slicedUnit.size(); i++) {
                if (catalog.contains(slicedUnitPart) || (unitsToMerge.contains(slicedUnitPart))) {
                    slicedUnitPart += ("\\" + slicedUnit.get(i));
                } else {
                    unitsToMerge.add(slicedUnitPart);
                    slicedUnitPart += ("\\" + slicedUnit.get(i));
                }
            }
        }
        catalog.addAll(unitsToMerge);
        return catalog;
    }
}
